package com.one.conversor.service;

import com.one.conversor.model.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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
        return moedaConversor;
    }
}
