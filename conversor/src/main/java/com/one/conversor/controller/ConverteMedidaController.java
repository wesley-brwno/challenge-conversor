package com.one.conversor.controller;

import com.one.conversor.model.MedidaConversor;
import com.one.conversor.service.MedidaConversorService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/medidas")
public class ConverteMedidaController {
    private final MedidaConversorService medidaConversorService;
    private MedidaConversor medidaConversor;
    private final List<String> errors = new ArrayList<>();

    public ConverteMedidaController(MedidaConversorService medidaConversorService) {
        this.medidaConversorService = medidaConversorService;
    }

    @GetMapping("/form")
    public String exibeForm(Model model){
        if (medidaConversor == null) {
            medidaConversor = new MedidaConversor();
        }

        model.addAttribute("medidaConversor", medidaConversor);
        model.addAttribute("medidas", MedidaConversor.Medidas.values());
        model.addAttribute("errors", errors);

        return "converteMedida";
    }

    @PostMapping("/converter")
    public String converteMedidas(@Valid @ModelAttribute MedidaConversor medidaConversor, Errors errors) {
        this.errors.clear();

        if (errors.hasErrors()) {
            for (ObjectError allError : errors.getAllErrors()) {
                this.errors.add(allError.getDefaultMessage());
            }
            this.medidaConversor = medidaConversor;
            return "redirect:/medidas/form";
        }

        if (!medidaConversor.getMedidaOrigem().equals(medidaConversor.getMedidaDestino())) {
            medidaConversor.setValorSaida(medidaConversorService.converteMedida(medidaConversor));
        } else {
            this.errors.add("As medidas selecionadas são as mesmas. Por favor, escolha medidas diferentes para origem e destino.");
        }

        this.medidaConversor = medidaConversor;
        return "redirect:/medidas/form";
    }
}
