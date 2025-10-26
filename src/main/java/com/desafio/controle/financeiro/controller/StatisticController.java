package com.desafio.controle.financeiro.controller;

import com.desafio.controle.financeiro.dto.StatisticDTO;
import com.desafio.controle.financeiro.service.StatisticService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/estatistica")
public class StatisticController {

    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping
    public ResponseEntity<StatisticDTO> getStatistic() {
        StatisticDTO statisticDTO = statisticService.getStatistic();
        return ResponseEntity.ok(statisticDTO);
    }
}

