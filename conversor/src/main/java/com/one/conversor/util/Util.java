package com.one.conversor.util;

import com.one.conversor.model.MoedaConversor;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class Util {
    public Double formataSaida(Double formataNumero) {
        DecimalFormat decimalFormat = new DecimalFormat("0.000");
        String valorFormatado = decimalFormat.format(formataNumero);
        return Double.parseDouble(valorFormatado.replace(',','.'));
    }

    public List<String> moedaConversorValidaEntradas(MoedaConversor moedaConversor) {
        List<String> errors = new ArrayList<>();

        if (moedaConversor.getMoedaOrigem().isEmpty() || moedaConversor.getMoedaDestino().isEmpty()) {
            errors.add("Por favor, escolha as moedas de origem e destino!");
        } else if (moedaConversor.getMoedaOrigem().equals(moedaConversor.getMoedaDestino())) {
            errors.add("As moedas selecionadas são as mesmas. Por favor, escolha moedas diferentes para origem e destino.");
        }

        if (moedaConversor.getValor() == null) {
            errors.add("O valor da moeda não pode ser nulo. Por favor, insira um valor válido.");
        }

        return errors;
    }

}
