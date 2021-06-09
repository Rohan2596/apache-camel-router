package com.ganitian.camelrouter.processor;

import com.ganitian.camelrouter.model.Transaction;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.springframework.stereotype.Component;

@Component
public class DataTransferProcessor  implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Transaction transaction=exchange.getIn().getBody(Transaction.class);
        transaction.setFrom("USD-USA");
        exchange.getIn().setHeader(Exchange.CONTENT_TYPE,"application/json");
        exchange.getIn().setHeader(Exchange.ACCEPT_CONTENT_TYPE,"application/json");
        exchange.getIn().setBody(transaction);

    }
}
