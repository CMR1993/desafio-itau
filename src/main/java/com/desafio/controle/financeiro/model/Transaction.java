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
    private OffsetDateTime dataHoraRegistro;

    public Transaction(double valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }
}
