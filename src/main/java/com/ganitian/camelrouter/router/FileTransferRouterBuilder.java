package com.ganitian.camelrouter.router;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileTransferRouterBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
       from("file:files/input")
               .to("log:${body}");
    }
}
