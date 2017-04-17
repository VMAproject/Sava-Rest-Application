package com.sava.service;

import com.sava.model.Observation;
import com.sava.model.jsonModel.StatisticOptions;
import com.sava.repository.interfaces.StatisticRepository;
import com.sava.service.interfaces.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    private StatisticRepository statisticRepository;

    @Autowired
    public void setStatisticRepository(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    @Override
    public List<Observation> getStoreVisitorsFromEvent(StatisticOptions options) {
        List<Observation> uniqueEventVisitors = statisticRepository.getUniqueEventVisitors(options);
        List<Observation> uniqueStoreVisitorsByEventDateFrom = statisticRepository.getUniqueStoreVisitorsByEventDateFrom(options);
        List<Observation> resultList = new ArrayList<>(uniqueStoreVisitorsByEventDateFrom);
        resultList.retainAll(uniqueEventVisitors);

        return resultList;
    }
}
