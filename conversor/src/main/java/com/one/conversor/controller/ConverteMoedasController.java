package com.one.conversor.controller;

import com.one.conversor.model.MoedaConversor;
import com.one.conversor.model.MoedaCotacao;
import com.one.conversor.service.MoedaConversorService;
import com.one.conversor.client.MoedaCotacaoApi;
import com.one.conversor.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/moedas")
public class ConverteMoedasController {
    private final MoedaConversorService moedaConversorService;
    private final MoedaCotacaoApi moedaCotacaoApi;
    private MoedaConversor moedaConversor;
    private final Util util;
    private List<String> errors = new ArrayList<>();

    public ConverteMoedasController(MoedaConversorService moedaConversorService, MoedaCotacaoApi moedaCotacaoApi, Util util) {
        this.moedaConversorService = moedaConversorService;
        this.moedaCotacaoApi = moedaCotacaoApi;
        this.util = util;
    }

    @GetMapping("/form")
    public String exibirForm(Model model) {

        if (moedaConversor == null) {
            moedaConversor = new MoedaConversor();
        }

        model.addAttribute("moedaConversor", moedaConversor);
        model.addAttribute("moedas", MoedaConversor.moedas.values());
        model.addAttribute("errors", errors);

        return "converteMoeda";
    }

    @PostMapping("/converter")
    public String converterMoedas(@ModelAttribute MoedaConversor moedaConversor) {
        String api_url = "https://economia.awesomeapi.com.br/json/last/" + moedaConversor.getMoedaOrigem() + "-" + moedaConversor.getMoedaDestino();

        errors.clear();

        errors = util.moedaConversorValidaEntradas(moedaConversor);

        if (errors.isEmpty()) {
            try {
                MoedaCotacao moedaCotacao = moedaCotacaoApi.obtemCotacao(api_url, moedaConversor.getMoedaOrigem() + moedaConversor.getMoedaDestino());
                this.moedaConversor = moedaConversorService.converter(moedaConversor, moedaCotacao);
            } catch (Exception e) {
                e.printStackTrace();
                errors.add("Não foi possível realizar a conversão das moedas de " + moedaConversor.getMoedaOrigem() + " para " + moedaConversor.getMoedaDestino() + ".");
                this.moedaConversor = moedaConversor;
            }
        } else {
            this.moedaConversor = moedaConversor;
        }

        return "redirect:/moedas/form";
    }
}

