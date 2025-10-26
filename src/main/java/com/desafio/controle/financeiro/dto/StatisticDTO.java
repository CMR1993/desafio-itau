package com.desafio.controle.financeiro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StatisticDTO {

    private long cont;
    private double sum;
    private double avg;
    private double min;
    private double max;
}
