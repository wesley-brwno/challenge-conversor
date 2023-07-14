package com.one.conversor.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TemperaturaConversor {
    private double valorEntrada;
    private double valorSaida;
    private Temperatura temperaturaBase;
    private Temperatura temperaturaDestino;

    public enum Temperatura {
        CELSIUS ("°C"), FAHRENHEIT("°F"), KELVIN("K");

        String unidadeMedia;
        Temperatura(String unidadeMedida) {
            this.unidadeMedia = unidadeMedida;
        }

        public String getUnidadeMedia() {
            return unidadeMedia;
        }
    }

}
