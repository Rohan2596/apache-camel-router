package com.ganitian.camelrouter.router;

import com.ganitian.camelrouter.model.Transaction;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

/*
* STEP 1 : Creating basic File transfer for input to output file.
* STEP 2 : Reading From File Using JAXB / Jackson file
* STEP 3 : Establishing Communication with api endpoint.
* STEP 4 : Sending Data to Api from file
*
* NOTE :-
* 1) Organise the import according to the requirements of Project
* 2) Follow the SOLID Principle as much as possible
* 3) Import the jar/ dependencies which are required ( DON'T do the dumping of unwanted dependencies)
*
* */



@Component
public class FileTransferRouterBuilder extends RouteBuilder{
    // JSON Data Format
    JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Transaction.class);


    @Override
    public void configure() throws Exception {

        restConfiguration().host("localhost")
                .port(8081);

        from("file:dropbox/inputs")
                .log("${body}")
                .unmarshal(jsonDataFormat)
                .log("${body}")
               // .to("log:Exchange")
        .to("rest:get:/transaction/all")
        .to("log:Exchange From Url");

         }
}
