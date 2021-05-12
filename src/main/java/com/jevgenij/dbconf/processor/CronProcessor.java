package com.jevgenij.dbconf.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class CronProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Cron is running for "+ exchange.getIn().getHeader("game_name"));
    }
}