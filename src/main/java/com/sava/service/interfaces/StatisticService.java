package com.sava.service.interfaces;

import com.sava.model.Observation;
import com.sava.model.jsonModel.StatisticOptions;

import java.util.List;

public interface StatisticService {

    List<Observation> getStoreVisitorsFromEvent(StatisticOptions options);

}
