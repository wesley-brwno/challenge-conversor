package com.one.conversor.util;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
public class FormataNumerosUtil {
    public Double formataSaida(Double formataNumero) {
        DecimalFormat decimalFormat = new DecimalFormat("0.000");
        String valorFormatado = decimalFormat.format(formataNumero);
        return Double.parseDouble(valorFormatado.replace(',','.'));
    }
}
