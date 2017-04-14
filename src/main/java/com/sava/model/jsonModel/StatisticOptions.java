package com.sava.model.jsonModel;

import com.sava.model.Event;
import com.sava.model.Store;

import java.util.List;

public class StatisticOptions {

    private Event event;
    private Store store;
    private List<Event> eventList;
    private List<Store> storeList;
    private Integer rssi = 15;

    public StatisticOptions() {
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public List<Store> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList = storeList;
    }

    public Integer getRssi() {
        return rssi;
    }

    public void setRssi(Integer rssi) {
        this.rssi = rssi;
    }
}
