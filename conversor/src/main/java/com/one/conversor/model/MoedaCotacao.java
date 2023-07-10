package com.one.conversor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MoedaCotacao {
    private String code;
    private String codein;
    private String name;
    private String high;
    private String low;
    private String varBid;
    private String pctChange;
    private String bid;
    private String ask;
    private String timestamp;
    private String create_date;
}
