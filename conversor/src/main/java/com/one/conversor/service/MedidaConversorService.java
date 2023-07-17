package com.one.conversor.service;

import com.one.conversor.model.MedidaConversor;
import org.springframework.stereotype.Service;

@Service
public class MedidaConversorService {

    public Double converteMedida(MedidaConversor medidaConversor) {
        Double medidaConvertida = null;

        if (medidaConversor.getMedidaOrigem().equals(MedidaConversor.Medidas.M)) {
            switch (medidaConversor.getMedidaDestino()) {
                case MM -> medidaConvertida = metrosParaMelimetros(medidaConversor.getValorEntrada());
                case CM -> medidaConvertida = metrosParaCentimetros(medidaConversor.getValorEntrada());
                case KM -> medidaConvertida = metrosParaQuilometros(medidaConversor.getValorEntrada());
                case IN -> medidaConvertida = metrosParaPolegadas(medidaConversor.getValorEntrada());
                case FT -> medidaConvertida = metrosParaPes(medidaConversor.getValorEntrada());
                case MI -> medidaConvertida = metrosParaMilhas(medidaConversor.getValorEntrada());
            }
        }

        if (medidaConversor.getMedidaOrigem().equals(MedidaConversor.Medidas.MM)) {
            switch (medidaConversor.getMedidaDestino()) {
                case CM -> medidaConvertida = metrosParaCentimetros(melimetrosParaMetros(medidaConversor.getValorEntrada()));
                case M -> medidaConvertida = melimetrosParaMetros(medidaConversor.getValorEntrada());
                case KM -> medidaConvertida = metrosParaQuilometros(melimetrosParaMetros(medidaConversor.getValorEntrada()));
                case IN -> medidaConvertida = metrosParaPolegadas(melimetrosParaMetros(medidaConversor.getValorEntrada()));
                case FT -> medidaConvertida = metrosParaPes(melimetrosParaMetros(medidaConversor.getValorEntrada()));
                case MI -> medidaConvertida = metrosParaMilhas(melimetrosParaMetros(medidaConversor.getValorEntrada()));
            }
        }

        if (medidaConversor.getMedidaOrigem().equals(MedidaConversor.Medidas.CM)) {
            switch (medidaConversor.getMedidaDestino()) {
                case MM -> medidaConvertida = metrosParaMelimetros(centimetrosParaMetros(medidaConversor.getValorEntrada()));
                case CM -> medidaConvertida = metrosParaCentimetros(centimetrosParaMetros(medidaConversor.getValorEntrada()));
                case M -> medidaConvertida = centimetrosParaMetros(medidaConversor.getValorEntrada());
                case KM -> medidaConvertida = metrosParaQuilometros(centimetrosParaMetros(medidaConversor.getValorEntrada()));
                case IN -> medidaConvertida = metrosParaPolegadas(centimetrosParaMetros(medidaConversor.getValorEntrada()));
                case FT -> medidaConvertida = metrosParaPes(centimetrosParaMetros(medidaConversor.getValorEntrada()));
                case MI -> medidaConvertida = metrosParaMilhas(centimetrosParaMetros(medidaConversor.getValorEntrada()));
            }
        }

        if (medidaConversor.getMedidaOrigem().equals(MedidaConversor.Medidas.KM)) {
            switch (medidaConversor.getMedidaDestino()) {
                case MM -> medidaConvertida = metrosParaMelimetros(quilometrosParaMetros(medidaConversor.getValorEntrada()));
                case CM -> medidaConvertida = metrosParaCentimetros(quilometrosParaMetros(medidaConversor.getValorEntrada()));
                case M -> medidaConvertida = quilometrosParaMetros(medidaConversor.getValorEntrada());
                case IN -> medidaConvertida = metrosParaPolegadas(quilometrosParaMetros(medidaConversor.getValorEntrada()));
                case FT -> medidaConvertida = metrosParaPes(quilometrosParaMetros(medidaConversor.getValorEntrada()));
                case MI -> medidaConvertida = metrosParaMilhas(quilometrosParaMetros(medidaConversor.getValorEntrada()));
            }
        }

        if (medidaConversor.getMedidaOrigem().equals(MedidaConversor.Medidas.IN)) {
            switch (medidaConversor.getMedidaDestino()) {
                case MM -> medidaConvertida = metrosParaMelimetros(polegadasParaMetros(medidaConversor.getValorEntrada()));
                case CM -> medidaConvertida = metrosParaCentimetros(polegadasParaMetros(medidaConversor.getValorEntrada()));
                case M -> medidaConvertida = polegadasParaMetros(medidaConversor.getValorEntrada());
                case KM -> medidaConvertida = metrosParaQuilometros(polegadasParaMetros(medidaConversor.getValorEntrada()));
                case FT -> medidaConvertida = metrosParaPes(polegadasParaMetros(medidaConversor.getValorEntrada()));
                case MI -> medidaConvertida = metrosParaMilhas(polegadasParaMetros(medidaConversor.getValorEntrada()));
            }
        }

        if (medidaConversor.getMedidaOrigem().equals(MedidaConversor.Medidas.FT)) {
            switch (medidaConversor.getMedidaDestino()) {
                case MM -> medidaConvertida = metrosParaMelimetros(pesParaMetros(medidaConversor.getValorEntrada()));
                case CM -> medidaConvertida = metrosParaCentimetros(pesParaMetros(medidaConversor.getValorEntrada()));
                case M -> medidaConvertida = pesParaMetros(medidaConversor.getValorEntrada());
                case KM -> medidaConvertida = metrosParaQuilometros(pesParaMetros(medidaConversor.getValorEntrada()));
                case IN -> medidaConvertida = metrosParaPolegadas(pesParaMetros(medidaConversor.getValorEntrada()));
                case MI -> medidaConvertida = metrosParaMilhas(pesParaMetros(medidaConversor.getValorEntrada()));
            }
        }

        if (medidaConversor.getMedidaOrigem().equals(MedidaConversor.Medidas.MI)) {
            switch (medidaConversor.getMedidaDestino()) {
                case MM -> medidaConvertida = metrosParaMelimetros(milhasParaMetros(medidaConversor.getValorEntrada()));
                case CM -> medidaConvertida = metrosParaCentimetros(milhasParaMetros(medidaConversor.getValorEntrada()));
                case M -> medidaConvertida = milhasParaMetros(medidaConversor.getValorEntrada());
                case KM -> medidaConvertida = metrosParaQuilometros(milhasParaMetros(medidaConversor.getValorEntrada()));
                case IN -> medidaConvertida = metrosParaPolegadas(milhasParaMetros(medidaConversor.getValorEntrada()));
                case FT -> medidaConvertida = metrosParaPes(milhasParaMetros(medidaConversor.getValorEntrada()));
            }
        }

        return medidaConvertida;
    }

    private Double metrosParaMelimetros(Double valorEmMetros) {
        return valorEmMetros * 1_000;
    }

    private Double metrosParaCentimetros(Double valorEmMetros) {
        return valorEmMetros * 100;
    }

    private Double metrosParaQuilometros(Double valorEmMetros) {
        return valorEmMetros / 1_000;
    }

    private Double metrosParaPolegadas(Double valorEmMetros) {
        return valorEmMetros * 39.37;
    }

    private Double metrosParaPes(Double valorEmMetros) {
        return valorEmMetros * 3.2808;
    }

    private Double metrosParaMilhas(Double valorEmMetros) {
        return valorEmMetros / 1609.0;
    }

    // converte outras unidades de medidas para metros
    private Double melimetrosParaMetros(Double valorEmMelimetros) {
        return valorEmMelimetros / 1_000.0;
    }

    private Double centimetrosParaMetros(Double valorEmCentimetros) {
        return valorEmCentimetros / 100;
    }

    private Double quilometrosParaMetros(Double valorEmQuilometros) {
        return valorEmQuilometros * 1_000;
    }

    private Double polegadasParaMetros(Double valorEmPolegadas) {
        return valorEmPolegadas / 39.37;
    }

    private Double pesParaMetros(Double valorEmPes) {
        return valorEmPes / 3.281;
    }

    private Double milhasParaMetros(Double valorEmMilhas) {
        return valorEmMilhas * 1609;
    }
}
