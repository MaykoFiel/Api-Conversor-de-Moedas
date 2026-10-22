package com.ApiConversor.moedas.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Data
public class ConversaoRequest {

    private String moedaOrigem;
    private String moedaDestino;
    private BigDecimal moedaValor;

}
