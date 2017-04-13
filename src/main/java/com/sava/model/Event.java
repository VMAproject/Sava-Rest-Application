package com.sava.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    @Column(name = "date_from")
    private LocalDateTime dateFrom;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    @Column(name = "date_to")
    private LocalDateTime dateTo;

    @OneToMany(mappedBy = "event")
    private Set<AccessPoint> accessPoints = new HashSet<>();

    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDateTime dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDateTime getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDateTime dateTo) {
        this.dateTo = dateTo;
    }

    public Set<AccessPoint> getAccessPoints() {
        return accessPoints;
    }

    public void setAccessPoints(Set<AccessPoint> accessPoints) {
        this.accessPoints = accessPoints;
    }
}
