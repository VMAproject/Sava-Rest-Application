//package com.sava.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name = "\"router\"")
//public class Router extends BaseModel implements Serializable {
//
//    @JsonIgnore
//    private static final long serialVersionUID = 6534751544232619891L;
//
//
//    @Column
//    private String apMac;
//
//    @Column
//    private String routerName;
//
//    @ManyToOne()
//    @JoinColumn(name = "id")
//    private Event event;
//
//    @ManyToOne()
//    @JoinColumn(name = "id")
//    private Store store;
//
//    @OneToMany(mappedBy = "router")
//    private Set<Observation> observations = new HashSet<>();
//
////    @OneToMany(mappedBy = "router")
////    private Set<ApTag> apTags = new HashSet<>();
////
////    @OneToMany(mappedBy = "router")
////    private Set<ApFloor> apFloors = new HashSet<>();
//
//
//    public Router() {
//    }
//
//    public Router(String apMac, String routerName, Event event, Store store, Set<Observation> observations) {
//        this.apMac = apMac;
//        this.routerName = routerName;
//        this.event = event;
//        this.store = store;
//        this.observations = observations;
//    }
//
//    public String getApMac() {
//        return apMac;
//    }
//
//    public void setApMac(String apMac) {
//        this.apMac = apMac;
//    }
//
//    public String getRouterName() {
//        return routerName;
//    }
//
//    public void setRouterName(String routerName) {
//        this.routerName = routerName;
//    }
//
//    public Event getEvent() {
//        return event;
//    }
//
//    public void setEvent(Event event) {
//        this.event = event;
//    }
//
//    public Store getStore() {
//        return store;
//    }
//
//    public void setStore(Store store) {
//        this.store = store;
//    }
//
//    public Set<Observation> getObservations() {
//        return observations;
//    }
//
//    public void setObservations(Set<Observation> observations) {
//        this.observations = observations;
//    }
//}
