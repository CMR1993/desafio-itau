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
        Transaction transaction = new Transaction();
        transaction.setValor(transactionDTO.getValor());
        transaction.setDataHora(transactionDTO.getDataHora());
        transactions.add(transaction);
    }

    public List<Transaction> getAllTransactions(){
        return transactions;
    }

    public void deleteTransactions() {
        transactions.clear();
    }
}

