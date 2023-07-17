package com.one.conversor.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MedidaConversor {
    @NotNull(message = "O valor da medida não pode ser nulo. Por favor, insira um valor válido.")
    private Double valorEntrada;
    private Double valorSaida;
    @NotNull(message = "Por favor, escolha a medida de origem!")
    private Medidas medidaOrigem;
    @NotNull(message = "Por favor, escolha a medida de destino!")
    private Medidas medidaDestino;


    public enum Medidas {
        MM("milímetros"),
        CM("centímetros"),
        M("metros"),
        KM("quilômetros"),
        IN("polegadas"),
        FT("pés"),
        MI("milhas");

        private final String descricao;

        Medidas(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

}
