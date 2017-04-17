package com.sava.controller;

import com.sava.model.Observation;
import com.sava.model.jsonModel.StatisticOptions;
import com.sava.repository.StatisticRepositoryImpl;
import com.sava.service.interfaces.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StatisticController {

    private StatisticService statisticService;

    @Autowired
    public void setStatisticService(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @RequestMapping(value = "/statistic", method = RequestMethod.POST)
    public List<Observation> getStoreVisitorsFromEvent(@RequestBody StatisticOptions options) {
        return statisticService.getStoreVisitorsFromEvent(options);
    }

}
