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
//@Table(name = "\"store\"")
//public class Store extends BaseModel  implements Serializable {
//    @JsonIgnore
//    private static final long serialVersionUID = 1L;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "location")
//    private String location;
//
//    @OneToMany(mappedBy = "store")
//    private Set<Router> routers = new HashSet<>();
//
//    public Store() {
//    }
//
//    public Store(String name, String location, Set<Router> routers) {
//        this.name = name;
//        this.location = location;
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
//    public Set<Router> getRouters() {
//        return routers;
//    }
//
//    public void setRouters(Set<Router> routers) {
//        this.routers = routers;
//    }
//}
