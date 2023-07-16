package com.one.conversor.service;

import com.one.conversor.model.TemperaturaConversor;
import org.springframework.stereotype.Service;

@Service
public class TemperaturaConversorService {

    public Double converteTemperatura(TemperaturaConversor temperaturaConversor) {
        Double valorConvetido = null;

        if (temperaturaConversor.getTemperaturaBase().equals(TemperaturaConversor.Temperatura.CELSIUS)) {
            switch (temperaturaConversor.getTemperaturaDestino()) {
                case FAHRENHEIT:
                    valorConvetido = celsiusParaFahrenheit(temperaturaConversor.getValorEntrada());
                    break;
                case KELVIN:
                    valorConvetido = celsiusParaKelvin(temperaturaConversor.getValorEntrada());
                    break;
            }
        }

        if (temperaturaConversor.getTemperaturaBase().equals(TemperaturaConversor.Temperatura.FAHRENHEIT)) {
            switch (temperaturaConversor.getTemperaturaDestino()) {
                case CELSIUS:
                    valorConvetido = fahrenheitParaCelsius(temperaturaConversor.getValorEntrada());
                    System.out.println(fahrenheitParaCelsius(temperaturaConversor.getValorEntrada()));
                    break;
                case KELVIN:
                    valorConvetido = fahrenheitParaKelvin(temperaturaConversor.getValorEntrada());
                    break;
            }
        }

        if (temperaturaConversor.getTemperaturaBase().equals(TemperaturaConversor.Temperatura.KELVIN)) {
            switch (temperaturaConversor.getTemperaturaDestino()) {
                case CELSIUS:
                    valorConvetido = kelvinParaCelsius(temperaturaConversor.getValorEntrada());
                    break;
                case FAHRENHEIT:
                    valorConvetido = kelvinParaFahrenheit(temperaturaConversor.getValorEntrada());
                    break;
            }
        }

        return valorConvetido;
    }

    private Double celsiusParaFahrenheit(Double vlrCel) {
        return vlrCel * (9.0 / 5.0) + 32;
    }

    private Double celsiusParaKelvin(Double vlrCel) {
        return vlrCel + 273.15;
    }

    private Double fahrenheitParaCelsius(Double vlrFah) {
        return (vlrFah - 32) * (5.0 / 9.0);
    }

    private Double fahrenheitParaKelvin(Double vlrFah) {
        return fahrenheitParaCelsius(vlrFah) + 273.15;
    }

    private Double kelvinParaCelsius(Double vlrKel) {
        return vlrKel - 273.15;
    }

    private Double kelvinParaFahrenheit(Double vlrKel) {
        return celsiusParaFahrenheit(kelvinParaCelsius(vlrKel));
    }
}
