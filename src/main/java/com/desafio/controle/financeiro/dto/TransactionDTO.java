package com.desafio.controle.financeiro.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionDTO {

    @NotNull(message = "O valor não pode ser nulo ")
    @PositiveOrZero(message = "O valor só pode ser zero ou positivo")
    private Double valor;
    @NotNull(message = "A data/hora não pode ser nula")
    private OffsetDateTime dataHora;

}
