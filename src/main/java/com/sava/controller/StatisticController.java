package com.sava.controller;

import com.sava.model.Observation;
import com.sava.model.jsonModel.StatisticOptions;
import com.sava.repository.StatisticRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
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
