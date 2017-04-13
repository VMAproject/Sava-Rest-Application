package com.sava.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @Column(name = "organization_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "organization")
    private Set<Network> networks;

}
