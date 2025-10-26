package com.desafio.controle.financeiro.service;

import com.desafio.controle.financeiro.dto.StatisticDTO;
import com.desafio.controle.financeiro.model.Transaction;
import org.springframework.stereotype.Service;
import java.util.DoubleSummaryStatistics;
import java.util.List;
@Service
public class StatisticService {

    private final TransactionService transactionService;

    public StatisticService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public StatisticDTO getStatistic(){

        List<Transaction> recentTransactions = transactionService.getRecentTransactions();

        if (recentTransactions.isEmpty()){
            return new StatisticDTO(0,0,0,0,0);
        }

        DoubleSummaryStatistics statistics = recentTransactions.stream()
                .mapToDouble(Transaction::getValor)
                .summaryStatistics();

        return new StatisticDTO(
                statistics.getCount(),
                statistics.getSum(),
                statistics.getAverage(),
                statistics.getMin(),
                statistics.getMax()
        );
    }
}
