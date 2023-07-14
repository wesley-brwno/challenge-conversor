package com.one.conversor.controller;

import com.one.conversor.model.TemperaturaConversor;
import com.one.conversor.service.TemperaturaConversorService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private TemperaturaConversorService temperaturaConversorService;

    public ConverteTemperaturaController(TemperaturaConversorService temperaturaConversorService) {
        this.temperaturaConversorService = temperaturaConversorService;
    }

    @GetMapping("/form")
    public String exibeFormulario(Model model) {
        if (temperaturaConversor == null) {
            temperaturaConversor = new TemperaturaConversor();
        }

        model.addAttribute("temperaturaConversor", temperaturaConversor);
        model.addAttribute("temperaturas", TemperaturaConversor.Temperatura.values());
        return "converteTemperatura";
    }

    @PostMapping("/converter")
    public String converterTemperaturas(@ModelAttribute TemperaturaConversor temperaturaConversor) {
        System.out.println(temperaturaConversor.toString());

        this.temperaturaConversor.setValorSaida(temperaturaConversorService.converteTemperatura(temperaturaConversor));
        System.out.println("teste conversor de temperaturas");
        return "redirect:/temperaturas/form";
    }
}
