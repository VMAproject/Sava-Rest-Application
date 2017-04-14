package com.sava.controller;

import com.sava.model.Observation;
import com.sava.model.jsonModel.StatisticOptions;
import com.sava.repository.StatisticRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class StatisticController {

    private StatisticRepositoryImpl statisticRepository;

    @Autowired
    public void setStatisticRepository(StatisticRepositoryImpl statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    @RequestMapping(value = "/statistic", method = RequestMethod.POST)
    public List<Observation> getUniqueStoreVisitors(@RequestBody StatisticOptions options) {
        return statisticRepository.getUniqueStoreVisitorsByEventDateFrom(options);
    }

}
