package com.jevgenij.dbconf.domain;

import com.jevgenij.dbconf.processor.CronProcessor;
import com.jevgenij.dbconf.processor.XmlProcessor;
import org.apache.camel.builder.RouteBuilder;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

public class GameBulder extends RouteBuilder {
    private final Iterable<Conf> routeConfig;
    private XmlProcessor xmlProcessor;
    private CronProcessor cronProcessor;


    public GameBulder(Iterable<Conf> routeConfig, XmlProcessor xmlProcessor) {
        this.routeConfig = routeConfig;
        this.xmlProcessor = xmlProcessor;
    }

    @Override
    public void configure() throws Exception {

        List<Conf> httpEndpoints = StreamSupport.stream(routeConfig.spliterator(), false).filter(conf -> conf.getDestination().startsWith("netty4-http")).collect(toList());
        List<Conf> cron =
                StreamSupport.stream(routeConfig.spliterator(), false).filter(conf -> conf.getDestination().startsWith("cron")).collect(toList());


        httpEndpoints.forEach(conf -> {
                    from(conf.getDestination())
                            .setHeader("game_name", simple(conf.getGameName()))
                            .process(xmlProcessor);
                    System.out.println("http route with  port " + conf.getDuration() + " initialised ");
                }
        );
//
//        cron.forEach(conf -> {
//                    from(conf.getDestination())
//                            .setHeader("game_name", simple(conf.getGameName()))
//                            .process(cronProcessor);
//                    System.out.println("http route with  port " + conf.getDuration() + " initialised ");
//                }
//        );



    }
}
