package com.sava.controller;

import com.sava.model.Observation;
import com.sava.model.jsonModel.StatisticOptions;
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

    @RequestMapping(value = "/statistic/compare/one_event_to_one_store", method = RequestMethod.POST)
    public List<Observation> getComparisonOneEventToOneStore(@RequestBody StatisticOptions options) {
        return statisticService.compareOneEventToOneStore(options);
    }

    @RequestMapping(value = "/statistic/compare/one_event_to_more_stores", method = RequestMethod.POST)
    public List<Observation> getComparisonOneEventToMoreStores(@RequestBody StatisticOptions options) {
        return statisticService.compareOneEventToMoreStores(options);
    }

    @RequestMapping(value = "/statistic/compare/more_events_to_one_store", method = RequestMethod.POST)
    public List<Observation> getComparisonMoreEventsToOneStore(@RequestBody StatisticOptions options) {
        return statisticService.compareMoreEventsToOneStore(options);
    }

    @RequestMapping(value = "/statistic/compare/more_events_to_more_stores", method = RequestMethod.POST)
    public List<Observation> getComparisonMoreEventsToMoreStores(@RequestBody StatisticOptions options) {
        return statisticService.compareMoreEventsToMoreStores(options);
    }


}
