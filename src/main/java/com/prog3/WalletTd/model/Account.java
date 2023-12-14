package com.prog3.WalletTd.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Account {
    private int id ;
    private String nom;
    private BigDecimal solde;
    private String type;

    public Account(int id, String nom, BigDecimal solde, String type) {
        this.id = id;
        this.nom = nom;
        this.solde = solde;
        this.type = type;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public BigDecimal getSolde() {
        return this.solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}