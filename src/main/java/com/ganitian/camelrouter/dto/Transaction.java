package com.ganitian.camelrouter.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
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
/*
* {
  "id": 1000,
  "from": "USD",
  "to": "INR",
  "conversionMultiple": 70
}
* */