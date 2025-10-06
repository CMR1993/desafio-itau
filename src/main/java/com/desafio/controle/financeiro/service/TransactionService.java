package com.desafio.controle.financeiro.service;

import com.desafio.controle.financeiro.dto.TransactionDTO;
import com.desafio.controle.financeiro.model.Transaction;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {
    private final List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(@Valid TransactionDTO transactionDTO) {
        Transaction transaction = transactionDTO.toEntity();
        transactions.add(transaction);
    }

    public List<TransactionDTO> getAllTransactions(){
        List<TransactionDTO> dtos = new ArrayList<>();
        for (Transaction transaction : transactions){
            dtos.add(TransactionDTO.fromEntity(transaction));
        }
        return dtos;
    }

    public void deleteTransactions() {
        transactions.clear();
    }
}

