package com.desafio.controle.financeiro.dto;

import com.desafio.controle.financeiro.model.Transaction;
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

    //@NotNull(message = "O valor não pode ser nulo ")
    //@PositiveOrZero(message = "O valor só pode ser zero ou positivo")
    private Double valor;
    //@NotNull(message = "A data/hora não pode ser nula")
    private OffsetDateTime dataHora;

    public Transaction toEntity(){
        return new Transaction(valor,dataHora);
    }

    public static TransactionDTO fromEntity(Transaction transaction) {
        return new TransactionDTO(transaction.getValor(),transaction.getDataHora());
    }

    public boolean isValid() {
        if(valor == null || dataHora == null){
            return false;
        }
        if (valor < 0){
            return false;
        }
        if (dataHora.isAfter(OffsetDateTime.now())){
            return false;
        } else {
            return true;
        }
    }
}
