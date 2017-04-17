package com.sava.repository.interfaces;

import com.sava.model.Observation;
import com.sava.model.jsonModel.StatisticOptions;

import java.util.List;

public interface StatisticRepository {

    List<Observation> getUniqueVisitorsFromOneEvent(StatisticOptions options);

    List<Observation> getUniqueVisitorsFromMoreEvents(StatisticOptions options);

    List<Observation> getUniqueVisitorsFromOneStoreByEventDateFrom(StatisticOptions options);

    List<Observation> getUniqueVisitorsFromMoreStoresByEventDateFrom(StatisticOptions options);

}
