package com.one.conversor.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
public class MoedaConversor {
    private String moedaOrigem;
    private String moedaDestino;
    private BigDecimal valor;
    private BigDecimal valorConvertido;
    private moedas moedas;
    private String valorFormadato;
    private String valorConvertidoFormadato;
    public enum moedas {
        PESO_ARGENTINO("ARS"),
        REAL("BRL"),
        PESO_CHILENO("CLP"),
        YUAN("CNY"),
        EURO("EUR"),
        LIBRA_ESTERLINA("GBP"),
        IENE("JPY"),
        WON("KRW"),
        DOLAR("USD"),
        PESO_URUGUAIO("UYU");

        private String moeda;
        moedas(String moeda) {
            this.moeda = moeda;
        }

        public String getMoeda() {
            return moeda;
        }
    }

}
