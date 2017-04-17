package com.sava.service;

import com.sava.model.Observation;
import com.sava.model.jsonModel.StatisticOptions;
import com.sava.repository.interfaces.StatisticRepository;
import com.sava.service.interfaces.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StatisticServiceImpl implements StatisticService {

    private StatisticRepository statisticRepository;

    @Autowired
    public void setStatisticRepository(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Observation> compareOneEventToOneStore(StatisticOptions options) {
        List<Observation> uniqueVisitorsFromOneEvent = statisticRepository.getUniqueVisitorsFromOneEvent(options);
        List<Observation> uniqueVisitorsFromOneStoreByEventDateFrom = statisticRepository.getUniqueVisitorsFromOneStoreByEventDateFrom(options);
        List<Observation> resultList = new ArrayList<>(uniqueVisitorsFromOneStoreByEventDateFrom);
        resultList.retainAll(uniqueVisitorsFromOneEvent);

        return resultList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Observation> compareOneEventToMoreStores(StatisticOptions options) {
        List<Observation> uniqueVisitorsFromOneEvent = statisticRepository.getUniqueVisitorsFromOneEvent(options);
        List<Observation> uniqueVisitorsFromMoreStoresByEventDateFrom = statisticRepository.getUniqueVisitorsFromMoreStoresByEventDateFrom(options);
        List<Observation> resultList = new ArrayList<>(uniqueVisitorsFromMoreStoresByEventDateFrom);
        resultList.retainAll(uniqueVisitorsFromOneEvent);

        return resultList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Observation> compareMoreEventsToOneStore(StatisticOptions options) {
        List<Observation> uniqueVisitorsFromMoreEvents = statisticRepository.getUniqueVisitorsFromMoreEvents(options);
        List<Observation> uniqueVisitorsFromOneStoreByEventDateFrom = statisticRepository.getUniqueVisitorsFromOneStoreByEventDateFrom(options);
        List<Observation> resultList = new ArrayList<>(uniqueVisitorsFromOneStoreByEventDateFrom);
        resultList.retainAll(uniqueVisitorsFromMoreEvents);

        return resultList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Observation> compareMoreEventsToMoreStores(StatisticOptions options) {
        List<Observation> uniqueVisitorsFromMoreEvents = statisticRepository.getUniqueVisitorsFromMoreEvents(options);
        List<Observation> uniqueVisitorsFromMoreStoresByEventDateFrom = statisticRepository.getUniqueVisitorsFromMoreStoresByEventDateFrom(options);
        List<Observation> resultList = new ArrayList<>(uniqueVisitorsFromMoreStoresByEventDateFrom);
        resultList.retainAll(uniqueVisitorsFromMoreEvents);

        return resultList;
    }

}
