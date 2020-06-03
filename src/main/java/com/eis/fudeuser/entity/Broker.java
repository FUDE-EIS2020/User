package com.eis.fudeuser.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Table
public class Broker {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String token;

//  @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity=FuturesProduct.class, mappedBy = "broker")
//  @JoinTable
//  private ArrayList<FuturesProduct> products;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

//  public ArrayList<FuturesProduct> getProducts() {
//    return products;
//  }
//
//  public void setProducts(ArrayList<FuturesProduct> products) {
//    this.products = products;
//  }
}
