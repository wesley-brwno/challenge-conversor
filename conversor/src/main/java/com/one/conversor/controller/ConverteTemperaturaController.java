package com.one.conversor.controller;

import com.one.conversor.model.TemperaturaConversor;
import com.one.conversor.service.TemperaturaConversorService;
import com.one.conversor.util.FormataNumerosUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/temperaturas")
public class ConverteTemperaturaController {
    private TemperaturaConversor temperaturaConversor;
    private final TemperaturaConversorService temperaturaConversorService;
    private final FormataNumerosUtil formataNumerosUtil;
    private String error;

    public ConverteTemperaturaController(TemperaturaConversorService temperaturaConversorService, FormataNumerosUtil formataNumerosUtil) {
        this.temperaturaConversorService = temperaturaConversorService;
        this.formataNumerosUtil = formataNumerosUtil;
    }

    @GetMapping("/form")
    public String exibeFormulario(Model model) {
        if (temperaturaConversor == null) {
            temperaturaConversor = new TemperaturaConversor();
        }

        model.addAttribute("temperaturaConversor", temperaturaConversor);
        model.addAttribute("temperaturas", TemperaturaConversor.Temperatura.values());
        model.addAttribute("error", error);
        error = null;
        return "converteTemperatura";
    }

    @PostMapping("/converter")
    public String converterTemperaturas(@ModelAttribute TemperaturaConversor temperaturaConversor) {
        if (temperaturaConversor.getTemperaturaBase() == null || temperaturaConversor.getTemperaturaDestino() == null) {
            error = "Por favor, selecione as unidades de origem e destino!";
            return "redirect:/temperaturas/form";
        }

        if (!temperaturaConversor.getTemperaturaBase().equals(temperaturaConversor.getTemperaturaDestino())) {
            Double temperaturaFormatada = formataNumerosUtil.formataSaida(temperaturaConversorService.converteTemperatura(temperaturaConversor));
            temperaturaConversor.setValorSaida(temperaturaFormatada);
        } else {
            temperaturaConversor.setValorSaida(temperaturaConversor.getValorEntrada());
        }

        this.temperaturaConversor = temperaturaConversor;

        return "redirect:/temperaturas/form";
    }
}
