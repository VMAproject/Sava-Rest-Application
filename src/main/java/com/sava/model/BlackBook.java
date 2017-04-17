package com.sava.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

@Data
@Entity
@Table(name = "blackBook")
public class BlackBook extends BaseModel implements Serializable {

    @Column(name = "name")
    private String name;

    @Column(name = "clientMac")
    private String clientMac;

    public BlackBook() {
    }

    public BlackBook(String name, String clientMac) {
        this.name = name;
        this.clientMac = clientMac;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlackBook that = (BlackBook) o;

        return Objects.equals(this.clientMac, that.clientMac) &&
                Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientMac, id, name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("clientMac = " + clientMac)
                .add("id = " + id)
                .add("name = " + name)
                .toString();
    }
}
