package com.ganitian.camelrouter.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Transaction {

    private int id;
    private String from;
    private String to;
    private int conversionMultiple;
}
