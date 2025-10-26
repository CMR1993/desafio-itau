package com.desafio.controle.financeiro.controller;

import com.desafio.controle.financeiro.dto.TransactionDTO;
import com.desafio.controle.financeiro.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/transacao")
public class TransactionController {

    @Autowired
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionDTO> receivedTransaction(@Valid @RequestBody TransactionDTO transactionDTO) {
       if (!transactionDTO.isValid()){
           return ResponseEntity.unprocessableEntity().build();
       }
       transactionService.addTransaction(transactionDTO);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping
    public ResponseEntity<TransactionDTO> deleteTransactions(){
        transactionService.deleteTransactions();
        return ResponseEntity.ok().build();
    }
}
