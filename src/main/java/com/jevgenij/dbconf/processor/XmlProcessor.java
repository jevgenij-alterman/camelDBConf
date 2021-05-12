package com.jevgenij.dbconf.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class XmlProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("xml processed"+ exchange.getIn().getHeader("game_name"));
        exchange.getOut().setBody("xml processed"+ exchange.getIn().getHeader("game_name"));
    }
}
