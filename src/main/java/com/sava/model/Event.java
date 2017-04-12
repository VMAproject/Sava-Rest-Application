//package com.sava.model;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.time.LocalDateTime;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name = "\"event\"")
//public class Event extends BaseModel implements Serializable {
//
//    @Column
//    private String name;
//
//    @Column
//    private String location;
//
//    @Column
//    private LocalDateTime dateFrom;
//
//    @Column
//    private LocalDateTime dateTo;
//
//    @OneToMany(mappedBy = "event")
//    private Set<Router> routers = new HashSet<>();
//
//    public Event() {
//    }
//
//
//    public Event(String name, String location, LocalDateTime dateFrom, LocalDateTime dateTo, Set<Router> routers) {
//        this.name = name;
//        this.location = location;
//        this.dateFrom = dateFrom;
//        this.dateTo = dateTo;
//        this.routers = routers;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public LocalDateTime getDateFrom() {
//        return dateFrom;
//    }
//
//    public void setDateFrom(LocalDateTime dateFrom) {
//        this.dateFrom = dateFrom;
//    }
//
//    public LocalDateTime getDateTo() {
//        return dateTo;
//    }
//
//    public void setDateTo(LocalDateTime dateTo) {
//        this.dateTo = dateTo;
//    }
//
//    public Set<Router> getRouters() {
//        return routers;
//    }
//
//    public void setRouters(Set<Router> routers) {
//        this.routers = routers;
//    }
//}
