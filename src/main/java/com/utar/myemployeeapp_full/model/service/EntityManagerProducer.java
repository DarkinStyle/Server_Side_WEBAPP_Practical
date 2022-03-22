package com.utar.myemployeeapp_full.model.service;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerProducer {
    @Produces
    @PersistenceContext(unitName = "default")
    @PostGresDatabase
    private EntityManager em;

    public EntityManagerProducer() {
        super();
// TODO Auto-generated constructor stub
    }

}