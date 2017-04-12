package com.sava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "\"blackBook\"")
public class BlackBook extends BaseModel implements Serializable {

    @JsonIgnore
    private static final long serialVersionUID = 6534751544232619891L;

    @Column
    private String name;

    @Column
    private String clientMac;

    public BlackBook() {
    }

    public BlackBook(String name, String clientMac) {
        this.name = name;
        this.clientMac = clientMac;
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

    public String getClientMac() {
        return clientMac;
    }

    public void setClientMac(String clientMac) {
        this.clientMac = clientMac;
    }
}
