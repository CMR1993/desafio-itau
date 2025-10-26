package com.desafio.controle.financeiro.service;

import com.desafio.controle.financeiro.dto.TransactionDTO;
import com.desafio.controle.financeiro.model.Transaction;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {
    private final List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(@Valid TransactionDTO transactionDTO) {
        Transaction transaction = transactionDTO.toEntity();
        transactionSafe(transaction);
        transactions.add(transaction);
    }

    public List<TransactionDTO> getAllTransactions(){
        List<TransactionDTO> dtos = new ArrayList<>();
        for (Transaction transaction : transactions){
            dtos.add(TransactionDTO.fromEntity(transaction));
        }
        return dtos;
    }

    public void transactionSafe (Transaction transacao) {
        transacao.setDataHoraRegistro(OffsetDateTime.now());
    }

    public List<Transaction> getRecentTransactions(){
        OffsetDateTime agora = OffsetDateTime.now();
        return transactions.stream()
                .filter(t -> t.getDataHoraRegistro().isAfter(agora.minusSeconds(60)))
                .toList();
    }

    public void deleteTransactions() {
        transactions.clear();
    }
}

