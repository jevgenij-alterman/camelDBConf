package com.jevgenij.dbconf.service;


import com.jevgenij.dbconf.domain.Conf;
import com.jevgenij.dbconf.domain.GameBulder;
import com.jevgenij.dbconf.processor.XmlProcessor;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cron.CronComponent;
import org.apache.camel.component.http4.HttpComponent;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DbService {
    public DbService(XmlProcessor xmlProcessor, CamelContext camelContext) {
        this.xmlProcessor = xmlProcessor;
        this.camelContext = camelContext;
    }

    @PostConstruct
    private void setUpComponents(){
        HttpComponent httpComponent = new HttpComponent();
//        CronComponent cronComponent = new CronComponent();

        camelContext.addComponent("http", httpComponent);

//        camelContext.addComponent("cron", cronComponent);
    }


    private XmlProcessor xmlProcessor;
    private CamelContext camelContext;

    public void createCamelRoute(Iterable<Conf> all) throws Exception {
        RouteBuilder game = new GameBulder(all, xmlProcessor);
        camelContext.addRoutes(game);

    }
}
