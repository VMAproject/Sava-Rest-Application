package com.sava.repository;

import com.sava.model.Observation;
import com.sava.model.jsonModel.StatisticOptions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class StatisticRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Observation> getUniqueStoreVisitorsByEventDateFrom(StatisticOptions options) {
        LocalDateTime eventDateFrom = options.getEvent().getDateFrom();
        Long storeId = options.getStore().getId();
        Integer rssi = options.getRssi();

        return entityManager.createQuery("select o from Observation o " +
                "left join fetch o.accessPoint ap left join fetch ap.store s " +
                "where o.seenTime = :date and s.id = :id and o.rssi >= :rssi", Observation.class)
                .setParameter("date", eventDateFrom)
                .setParameter("id", storeId)
                .setParameter("rssi", rssi)
                .getResultList();
    }

}
