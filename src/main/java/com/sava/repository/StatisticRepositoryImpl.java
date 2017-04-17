package com.sava.repository;

import com.sava.model.Observation;
import com.sava.model.Store;
import com.sava.model.jsonModel.StatisticOptions;
import com.sava.repository.interfaces.StatisticRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StatisticRepositoryImpl implements StatisticRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Observation> getUniqueEventVisitors(StatisticOptions options) {
        Integer rssi = options.getRssi();
        Long id = null;
        LocalDateTime dateFrom = null;
        LocalDateTime dateTo = null;
        if (options.getEvent().getId() != null) {
            id = options.getEvent().getId();
        } else {
            if (options.getEvent().getDateFrom() != null) {
                dateFrom = options.getEvent().getDateFrom();
            } else if (options.getEvent().getDateTo() != null) {
                dateTo = options.getEvent().getDateTo();
            } else {
                return new ArrayList<>();
            }
        }

        return entityManager.createQuery("select o from Observation o " +
                "left join fetch o.accessPoint ap left join fetch ap.event e " +
                "where o.seenTime >= :dateFrom and o.seenTime <= :dateTo and e.id = :id and o.rssi >= :rssi", Observation.class)
                .setParameter("dateFrom", dateFrom)
                .setParameter("dateTo", dateTo)
                .setParameter("id", id)
                .setParameter("rssi", rssi)
                .getResultList();
    }

    @Override
    public List<Observation> getUniqueStoreVisitorsByEventDateFrom(StatisticOptions options) {
        Integer rssi = options.getRssi();
        LocalDateTime dateFrom = null;
        Long[] storeId = null;
        if (options.getEvent().getDateFrom() != null) {
            dateFrom = options.getEvent().getDateFrom();
        } else if (options.getStore().getId() != null) {
            storeId = new Long[]{options.getStore().getId()};
        } else if (options.getStoreList() != null) {
            List<Store> storeList = options.getStoreList();
            storeId = new Long[storeList.size()];
            for (int i = 0; i < storeId.length; i++) {
                storeId[i] = storeList.get(i).getId();
            }
        } else {
            return new ArrayList<>();
        }

        return entityManager.createQuery("select o from Observation o " +
                "left join fetch o.accessPoint ap left join fetch ap.store s " +
                "where o.seenTime >= :date and s.id in :id and o.rssi >= :rssi", Observation.class)
                .setParameter("date", dateFrom)
                .setParameter("id", storeId)
                .setParameter("rssi", rssi)
                .getResultList();
    }

}
