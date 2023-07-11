package com.one.conversor.service;

import com.one.conversor.model.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

@Service
public class MoedaConversorService {

    public MoedaConversor converter(MoedaConversor moedaConversor, MoedaCotacao moedaCotacao) {
        String askString = moedaCotacao.getAsk();
        BigDecimal askBigDecimal = new BigDecimal(askString);

        if (!(moedaConversor.getMoedaOrigem().equals(moedaConversor.getMoedaDestino())))
            switch (moedaConversor.getMoedaDestino()) {
                case "ARS", "BRL", "CLP", "CNY", "EUR", "GBP", "JPY", "KRW", "USD", "UYU"->
                        moedaConversor.setValorConvertido(moedaConversor.getValor().multiply(askBigDecimal));
            }
        moedaConversor.setValorFormadato(moedaFormata(moedaConversor.getMoedaOrigem() ,moedaConversor.getValor()));
        moedaConversor.setValorConvertidoFormadato(moedaFormata(moedaConversor.getMoedaDestino() ,moedaConversor.getValorConvertido()));
        return moedaConversor;
    }

    private String moedaFormata(String moedaSigla, BigDecimal valor) {
        NumberFormat numberFormat;
        String moedaFormatada;

        switch (moedaSigla) {
            case "ARS":
                numberFormat = NumberFormat.getCurrencyInstance(new Locale("es", "AR"));
                numberFormat.setCurrency(Currency.getInstance("ARS"));
                moedaFormatada = numberFormat.format(valor);
                break;
            case "BRL":
                numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                numberFormat.setCurrency(Currency.getInstance("BRL"));
                moedaFormatada = numberFormat.format(valor);
                break;
            case "CLP":
                numberFormat = NumberFormat.getCurrencyInstance(new Locale("es", "CL"));
                numberFormat.setCurrency(Currency.getInstance("CLP"));
                moedaFormatada = numberFormat.format(valor);
                break;
            case "CNY":
                numberFormat = NumberFormat.getCurrencyInstance(new Locale("zh", "CN"));
                numberFormat.setCurrency(Currency.getInstance("CNY"));
                moedaFormatada = numberFormat.format(valor);
                break;
            case "EUR":
                numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "PT"));
                numberFormat.setCurrency(Currency.getInstance("EUR"));
                moedaFormatada = numberFormat.format(valor);
                break;
            case "GBP":
                numberFormat = NumberFormat.getCurrencyInstance(new Locale("en", "GB"));
                numberFormat.setCurrency(Currency.getInstance("GBP"));
                moedaFormatada = numberFormat.format(valor);
                break;
            case "JPY":
                numberFormat = NumberFormat.getCurrencyInstance(new Locale("ja", "JP"));
                numberFormat.setCurrency(Currency.getInstance("JPY"));
                moedaFormatada = numberFormat.format(valor);
                break;
            case "KRW":
                numberFormat = NumberFormat.getCurrencyInstance(new Locale("ko", "KR"));
                numberFormat.setCurrency(Currency.getInstance("KRW"));
                moedaFormatada = numberFormat.format(valor);
                break;
            case "USD":
                numberFormat = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
                numberFormat.setCurrency(Currency.getInstance("USD"));
                moedaFormatada = numberFormat.format(valor);
                break;
            case "UYU":
                numberFormat = NumberFormat.getCurrencyInstance(new Locale("en", "UY"));
                numberFormat.setCurrency(Currency.getInstance("UYU"));
                moedaFormatada = numberFormat.format(valor);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + moedaSigla);
        }
        return moedaFormatada;
    }
}
