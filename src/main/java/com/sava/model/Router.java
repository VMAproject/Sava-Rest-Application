package com.sava.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "router")
public class Router implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "router_id")
    private Long id;

    @Column(name = "apMac")
    private String apMac;

    @Column(name = "name")
    private String routerName;

    @ManyToOne()
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne()
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "router")
    private Set<Observation> observations = new HashSet<>();

//    @OneToMany(mappedBy = "router")
//    private Set<ApTag> apTags = new HashSet<>();
//
//    @OneToMany(mappedBy = "router")
//    private Set<ApFloor> apFloors = new HashSet<>();


    @ManyToOne()
    @JoinColumn(name = "network_id")
    private Network network;

    public Router() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApMac() {
        return apMac;
    }

    public void setApMac(String apMac) {
        this.apMac = apMac;
    }

    public String getRouterName() {
        return routerName;
    }

    public void setRouterName(String routerName) {
        this.routerName = routerName;
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

    public Set<Observation> getObservations() {
        return observations;
    }

    public void setObservations(Set<Observation> observations) {
        this.observations = observations;
    }
}
