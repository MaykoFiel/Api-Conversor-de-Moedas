package com.ApiConversor.moedas.Service;

import com.ApiConversor.moedas.DTO.ConversaoRequest;
import com.ApiConversor.moedas.DTO.ConversaoResponse;
import lombok.AccessLevel;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

@Service
public class ConversaoService {

    public ConversaoResponse converter(ConversaoRequest request) {
     RestTemplate restTemplate = new RestTemplate();

       String origem = request.getMoedaOrigem();
       String destino = request.getMoedaDestino();


       String url = String.format("https://economia.awesomeapi.com.br/json/last/%s-%s", origem, destino);

       RestTemplate restTemplate2 = new RestTemplate();
       Map<String, Object> respostaApi = restTemplate.getForObject(url, Map.class);

       String chaveDinamica = origem + destino;

       Map<String, String> dadosMoeda = (Map<String, String>) respostaApi.get(chaveDinamica);

       String bid = dadosMoeda.get("bid");
       BigDecimal taxaDeCambio = new BigDecimal(bid);

       BigDecimal valorConvertido = request.getMoedaValor().multiply(taxaDeCambio);

       ConversaoResponse response = new ConversaoResponse();
       response.setValorConvertido(valorConvertido);
       response.setTaxa(taxaDeCambio);

       return response;

    }
}
