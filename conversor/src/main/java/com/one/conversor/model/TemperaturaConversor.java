package com.one.conversor.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TemperaturaConversor {
    @NotNull(message = "O valor da temperatura não pode ser nulo. Por favor, insira um valor válido.")
    private Double valorEntrada;
    private Double valorSaida;
    @NotNull(message = "Por favor, selecione a unidade de origem!")
    private Temperatura temperaturaBase;
    @NotNull(message = "Por favor, selecione a unidade de destino!")
    private Temperatura temperaturaDestino;

    public enum Temperatura {
        CELSIUS ("°C"), FAHRENHEIT("°F"), KELVIN("K");

        final String unidadeMedia;
        Temperatura(String unidadeMedida) {
            this.unidadeMedia = unidadeMedida;
        }

        public String getUnidadeMedida() {
            return unidadeMedia;
        }
    }

}
