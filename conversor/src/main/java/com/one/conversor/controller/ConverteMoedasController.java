package com.one.conversor.controller;

import com.one.conversor.model.MoedaConversor;
import com.one.conversor.model.MoedaCotacao;
import com.one.conversor.service.MoedaConversorService;
import com.one.conversor.service.MoedaCotacaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/moedas")
public class ConverteMoedasController {
    private final MoedaConversorService moedaConversorService;
    private final MoedaCotacaoService moedaCotacaoService;
    private MoedaConversor moedaConversor;

    public ConverteMoedasController(MoedaConversorService moedaConversorService, MoedaCotacaoService moedaCotacaoService) {
        this.moedaConversorService = moedaConversorService;
        this.moedaCotacaoService = moedaCotacaoService;
    }

    @GetMapping("/form")
    public String exibirForm(Model model) {

        if (moedaConversor == null) {
            moedaConversor = new MoedaConversor();
        }

        model.addAttribute("moedaConversor", moedaConversor);
        model.addAttribute("moedas", MoedaConversor.moedas.values());

        return "converteMoeda";
    }

    @PostMapping("/converter")
    public String converterMoedas(@ModelAttribute MoedaConversor moedaConversor) {
        System.out.println(moedaConversor.toString());
        String api_url = "https://economia.awesomeapi.com.br/json/last/" + moedaConversor.getMoedaOrigem() + "-" + moedaConversor.getMoedaDestino();
        System.out.println(api_url);
        MoedaCotacao moedaCotacao = moedaCotacaoService.obterCotacao(api_url, moedaConversor.getMoedaOrigem() + moedaConversor.getMoedaDestino());

        System.out.println(moedaCotacao.toString());

        this.moedaConversor = moedaConversorService.converter(moedaConversor, moedaCotacao);

        System.out.println(this.moedaConversor.toString());
        return "redirect:/moedas/form";
    }
}

