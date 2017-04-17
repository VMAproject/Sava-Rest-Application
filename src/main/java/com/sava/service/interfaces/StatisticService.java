package com.sava.service.interfaces;

import com.sava.model.Observation;
import com.sava.model.jsonModel.StatisticOptions;

import java.util.List;

public interface StatisticService {

    List<Observation> compareOneEventToOneStore(StatisticOptions options);

    List<Observation> compareOneEventToMoreStores(StatisticOptions options);

    List<Observation> compareMoreEventsToOneStore(StatisticOptions options);

    List<Observation> compareMoreEventsToMoreStores(StatisticOptions options);

}
