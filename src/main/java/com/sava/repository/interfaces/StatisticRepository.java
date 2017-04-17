package com.sava.repository.interfaces;

import com.sava.model.Observation;
import com.sava.model.jsonModel.StatisticOptions;

import java.util.List;

public interface StatisticRepository {

    List<Observation> getUniqueEventVisitors(StatisticOptions options);

    List<Observation> getUniqueStoreVisitorsByEventDateFrom(StatisticOptions options);


}
