//package com.sava.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "\"observation\"")
////@NamedQueries({
////        @NamedQuery(name = "getUniqueEventVisitors", query = "select o from Observation o " +
////                "left join fetch o.router r left join fetch r.event e " +
////                "where o.rssi >= 15 and e.id = (:id) and o.seenTime between (:dateFrom) and (:dateTo) group by o.clientMac"),
////        @NamedQuery(name = "getUniqueStoreVisitors", query = "select o from Observation o left join fetch o.router r left join fetch r.store s " +
////                "where s.id in (:id) and o.rssi >= 15 and o.seenTime >= (:dateFrom) group by o.clientMac")
////})
//public class Observation extends BaseModel implements Serializable {
//
//    @JsonIgnore
//    private static final long serialVersionUID = 6534751544232619891L;
//
//    @Column
//    private String clientMac;
//
//    @Column
//    private String ipv4;
//
//    @Column
//    private String ipv6;
//
//    @Column
//    private String ssid;
//
//    @Column
//    private String os;
//
//    @Column
//    private String manufacturer;
//
//    @Column
//    private int rssi;
//
//    @Column
//    private int seenEpoch;
//
//    @Column
//    private LocalDateTime seenTime;
//
//    @ManyToOne()
//    @JoinColumn(name = "id")
//    private Router router;
//
//    public Observation() {
//    }
//
//    public Observation(String clientMac, String ipv4, String ipv6, String ssid, String os, String manufacturer, int rssi, int seenEpoch, LocalDateTime seenTime, Router router) {
//        this.clientMac = clientMac;
//        this.ipv4 = ipv4;
//        this.ipv6 = ipv6;
//        this.ssid = ssid;
//        this.os = os;
//        this.manufacturer = manufacturer;
//        this.rssi = rssi;
//        this.seenEpoch = seenEpoch;
//        this.seenTime = seenTime;
//        this.router = router;
//    }
//
//    public String getClientMac() {
//        return clientMac;
//    }
//
//    public void setClientMac(String clientMac) {
//        this.clientMac = clientMac;
//    }
//
//    public String getIpv4() {
//        return ipv4;
//    }
//
//    public void setIpv4(String ipv4) {
//        this.ipv4 = ipv4;
//    }
//
//    public String getIpv6() {
//        return ipv6;
//    }
//
//    public void setIpv6(String ipv6) {
//        this.ipv6 = ipv6;
//    }
//
//    public String getSsid() {
//        return ssid;
//    }
//
//    public void setSsid(String ssid) {
//        this.ssid = ssid;
//    }
//
//    public String getOs() {
//        return os;
//    }
//
//    public void setOs(String os) {
//        this.os = os;
//    }
//
//    public String getManufacturer() {
//        return manufacturer;
//    }
//
//    public void setManufacturer(String manufacturer) {
//        this.manufacturer = manufacturer;
//    }
//
//    public int getRssi() {
//        return rssi;
//    }
//
//    public void setRssi(int rssi) {
//        this.rssi = rssi;
//    }
//
//    public int getSeenEpoch() {
//        return seenEpoch;
//    }
//
//    public void setSeenEpoch(int seenEpoch) {
//        this.seenEpoch = seenEpoch;
//    }
//
//    public LocalDateTime getSeenTime() {
//        return seenTime;
//    }
//
//    public void setSeenTime(LocalDateTime seenTime) {
//        this.seenTime = seenTime;
//    }
//
//    public Router getRouter() {
//        return router;
//    }
//
//    public void setRouter(Router router) {
//        this.router = router;
//    }
//}
