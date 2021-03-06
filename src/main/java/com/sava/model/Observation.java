package com.sava.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "observation")
//@NamedQueries({
//        @NamedQuery(name = "getUniqueEventVisitors", query = "select o from Observation o " +
//                "left join fetch o.accessPoint r left join fetch r.event e " +
//                "where o.rssi >= 15 and e.id = (:id) and o.seenTime between (:dateFrom) and (:dateTo) group by o.clientMac"),
//        @NamedQuery(name = "getUniqueStoreVisitors", query = "select o from Observation o left join fetch o.accessPoint r left join fetch r.store s " +
//                "where s.id in (:id) and o.rssi >= 15 and o.seenTime >= (:dateFrom) group by o.clientMac")
//})
public class Observation extends BaseModel {

    @Column(name = "clientMac")
    private String clientMac;

    @Column(name = "ipv4")
    private String ipv4;

    @Column(name = "ipv6")
    private String ipv6;

    @Column(name = "ssid")
    private String ssid;

    @Column(name = "os")
    private String os;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "rssi")
    private int rssi;

    @Column(name = "seenEpoch")
    private int seenEpoch;

    @Column(name = "seenTime")
    private LocalDateTime seenTime;

    @ManyToOne()
    @JoinColumn(name = "access_point_id")
    private AccessPoint accessPoint;

    public Observation() {
    }

    public String getClientMac() {
        return clientMac;
    }

    public void setClientMac(String clientMac) {
        this.clientMac = clientMac;
    }

    public String getIpv4() {
        return ipv4;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    public String getIpv6() {
        return ipv6;
    }

    public void setIpv6(String ipv6) {
        this.ipv6 = ipv6;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public int getSeenEpoch() {
        return seenEpoch;
    }

    public void setSeenEpoch(int seenEpoch) {
        this.seenEpoch = seenEpoch;
    }

    public LocalDateTime getSeenTime() {
        return seenTime;
    }

    public void setSeenTime(LocalDateTime seenTime) {
        this.seenTime = seenTime;
    }

    public AccessPoint getAccessPoint() {
        return accessPoint;
    }

    public void setAccessPoint(AccessPoint accessPoint) {
        this.accessPoint = accessPoint;
    }
}
