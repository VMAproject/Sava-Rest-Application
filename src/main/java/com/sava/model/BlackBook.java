package com.sava.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "blackBook")
public class BlackBook extends BaseModel implements Serializable {

    @Column(name = "name")
    private String name;

    @Column(name = "clientMac")
    private String clientMac;

    public BlackBook() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClientMac() {
        return clientMac;
    }

    public void setClientMac(String clientMac) {
        this.clientMac = clientMac;
    }
}
