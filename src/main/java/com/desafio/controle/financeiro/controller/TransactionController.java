package com.desafio.controle.financeiro.controller;

import com.desafio.controle.financeiro.dto.TransactionDTO;
import com.desafio.controle.financeiro.model.Transaction;
import com.desafio.controle.financeiro.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transacao")
public class TransactionController {

    @Autowired
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionDTO> insert(@Valid @RequestBody TransactionDTO transactionDTO) {
        transactionService.addTransaction(transactionDTO);
        return ResponseEntity.status(201).build();
    }
}
