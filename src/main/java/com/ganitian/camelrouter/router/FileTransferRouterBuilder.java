package com.ganitian.camelrouter.router;

import com.ganitian.camelrouter.dto.Transaction;
import com.google.gson.Gson;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import static org.apache.camel.main.DefaultConfigurationConfigurer.LOG;

@Component
public class FileTransferRouterBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {


        from("file:files/input")
               .log("${body}")
               .process(new Processor() {
                   @Override
                   public void process(Exchange exchange) throws Exception {

                       File file = exchange.getIn().getBody(File.class);
                       LOG.info("Processing file: " + file.toString());
                       System.out.println(file.getPath());
                       Gson gson =new Gson();
                   try(Reader reader = new FileReader(file.getPath())){
                       Transaction transaction =gson.fromJson(reader,Transaction.class);
                       exchange.getIn().setBody(transaction);
                       System.out.println(transaction);
                   }catch (IOException ioException){
                       ioException.getMessage();
                   }
                   }

               })
                .log("${body}")
                .to("log:body");

    }
}
