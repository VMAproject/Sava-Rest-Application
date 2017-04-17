package com.sava.repository;

import com.sava.model.Event;
import com.sava.model.Observation;
import com.sava.model.Store;
import com.sava.model.jsonModel.StatisticOptions;
import com.sava.repository.interfaces.StatisticRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class StatisticRepositoryImpl implements StatisticRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Observation> getUniqueVisitorsFromOneEvent(StatisticOptions options) {
        Integer rssi = options.getRssi();
        Long eventId = options.getEvent().getId();
        Date eventDateFrom = options.getEvent().getDateFrom();
        Date eventDateTo = options.getEvent().getDateTo();

        return entityManager.createQuery("select o from Observation o " +
                "left join fetch o.accessPoint ap left join fetch ap.event e " +
                "where o.seenTime >= :eventDateFrom and o.seenTime <= :eventDateTo and e.id = :eventId and o.rssi >= :rssi " +
                "group by o.id, o.clientMac, ap.id, e.id", Observation.class)
                .setParameter("eventDateFrom", eventDateFrom)
                .setParameter("eventDateTo", eventDateTo)
                .setParameter("eventId", eventId)
                .setParameter("rssi", rssi)
                .getResultList();
    }

    @Override
    public List<Observation> getUniqueVisitorsFromMoreEvents(StatisticOptions options) {
        List<Observation> resultList = new ArrayList<>();
        Integer rssi = options.getRssi();
        List<Event> eventList = options.getEventList();

        for (Event event : eventList) {
            Long eventId = event.getId();
            Date eventDateFrom = event.getDateFrom();
            Date eventDateTo = event.getDateTo();

            List<Observation> tempList = entityManager
                    .createQuery("select o from Observation o " +
                            "left join fetch o.accessPoint ap left join fetch ap.event e " +
                            "where o.rssi >= :rssi and e.id = :id and o.seenTime >= :dateFrom and o.seenTime <= :dateTo " +
                            "group by o.id, o.clientMac, ap.id, e.id", Observation.class)
                    .setParameter("rssi", rssi)
                    .setParameter("id", eventId)
                    .setParameter("dateFrom", eventDateFrom)
                    .setParameter("dateTo", eventDateTo)
                    .getResultList();

            resultList.addAll(tempList);
        }

        return resultList;
    }

    @Override
    public List<Observation> getUniqueVisitorsFromOneStoreByEventDateFrom(StatisticOptions options) {
        Integer rssi = options.getRssi();
        Long storeId = options.getStore().getId();
        Date eventDateFrom = null;

        if (options.getEvent() != null) {
            eventDateFrom = options.getEvent().getDateFrom();
        }
        if (options.getEventList() != null) {
            eventDateFrom = findFirstDateFrom(options.getEventList());
        }

        return entityManager.createQuery("select o from Observation o " +
                "left join fetch o.accessPoint ap left join fetch ap.store s " +
                "where o.seenTime >= :dateFrom and s.id = :id and o.rssi >= :rssi " +
                "group by o.id, o.clientMac, ap.id, s.id", Observation.class)
                .setParameter("dateFrom", eventDateFrom)
                .setParameter("id", storeId)
                .setParameter("rssi", rssi)
                .getResultList();
    }

    @Override
    public List<Observation> getUniqueVisitorsFromMoreStoresByEventDateFrom(StatisticOptions options) {
        List<Observation> resultList = new ArrayList<>();
        Integer rssi = options.getRssi();
        List<Store> storeList = options.getStoreList();
        Date eventDateFrom = null;

        if (options.getEvent() != null) {
            eventDateFrom = options.getEvent().getDateFrom();
        }
        if (options.getEventList() != null) {
            eventDateFrom = findFirstDateFrom(options.getEventList());
        }

        for (Store store : storeList) {
            Long storeId = store.getId();

            List<Observation> tempList = entityManager.createQuery("select o from Observation o " +
                    "left join fetch o.accessPoint ap left join fetch ap.store s " +
                    "where o.seenTime >= :dateFrom and s.id = :id and o.rssi >= :rssi " +
                    "group by o.id, o.clientMac, ap.id, s.id", Observation.class)
                    .setParameter("dateFrom", eventDateFrom)
                    .setParameter("id", storeId)
                    .setParameter("rssi", rssi)
                    .getResultList();

            resultList.addAll(tempList);
        }

        return resultList;
    }

    private Date findFirstDateFrom(List<Event> eventList) {
        Date result = eventList.get(0).getDateFrom();
        for (Event event : eventList) {
            Date tempDateFrom = event.getDateFrom();
            if (tempDateFrom.getTime() < result.getTime()) {
                result = tempDateFrom;
            }
        }

        return result;
    }

}
