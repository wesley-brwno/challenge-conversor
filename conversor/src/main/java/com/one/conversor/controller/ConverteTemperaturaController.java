package com.one.conversor.controller;

import com.one.conversor.model.TemperaturaConversor;
import com.one.conversor.service.TemperaturaConversorService;
import com.one.conversor.util.Util;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/temperaturas")
public class ConverteTemperaturaController {
    private TemperaturaConversor temperaturaConversor;
    private final TemperaturaConversorService temperaturaConversorService;
    private final Util formataNumerosUtil;
    private List<String> errors = new ArrayList<>();

    public ConverteTemperaturaController(TemperaturaConversorService temperaturaConversorService, Util formataNumerosUtil) {
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
        model.addAttribute("errors", errors);
        return "converteTemperatura";
    }

    @PostMapping("/converter")
    public String converterTemperaturas(@Valid @ModelAttribute TemperaturaConversor temperaturaConversor, Errors errors) {
        this.errors.clear();
        if (errors.hasErrors()) {
            for (ObjectError allError : errors.getAllErrors()) {
                this.errors.add(allError.getDefaultMessage());
            }
            this.temperaturaConversor = temperaturaConversor;
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
