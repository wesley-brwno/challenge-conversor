package com.one.conversor.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.one.conversor.model.MoedaCotacao;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MoedaCotacaoApi {
    public MoedaCotacao obtemCotacao(String api_url, String moedaPar) {
        RestTemplate restTemplate = new RestTemplate();
        String jsonResponse = restTemplate.getForObject(api_url, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode root = objectMapper.readTree(jsonResponse);
            JsonNode moedaCotacaoNode = root.get(moedaPar);
            MoedaCotacao moedaCotacao = objectMapper.treeToValue(moedaCotacaoNode, MoedaCotacao.class);
            return moedaCotacao;
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the error appropriately
        }

        return null;
    }

}
