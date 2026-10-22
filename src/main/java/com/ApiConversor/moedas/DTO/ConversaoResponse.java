package com.ApiConversor.moedas.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class ConversaoResponse {

    private BigDecimal valorConvertido;
    private BigDecimal taxa;

}
