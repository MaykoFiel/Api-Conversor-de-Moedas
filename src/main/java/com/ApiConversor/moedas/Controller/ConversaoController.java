package com.ApiConversor.moedas.Controller;

import com.ApiConversor.moedas.DTO.ConversaoRequest;
import com.ApiConversor.moedas.DTO.ConversaoResponse;
import com.ApiConversor.moedas.Service.ConversaoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/conversao")
public class ConversaoController {

    private final ConversaoService conversaoService;

    public ConversaoController(ConversaoService conversaoService) {
        this.conversaoService = conversaoService;
    }

    @PostMapping
    public ConversaoResponse conversao(@RequestBody ConversaoRequest request) {
        return conversaoService.converter(request);
    }
}
