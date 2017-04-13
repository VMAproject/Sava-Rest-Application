package com.sava.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "network")
public class Network {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "network_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne()
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @OneToMany(mappedBy = "network")
    private Set<AccessPoint> routerts;

}
