package com.desafio.controle.financeiro.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transaction {

    private double valor;
    private OffsetDateTime dataHora;
}
