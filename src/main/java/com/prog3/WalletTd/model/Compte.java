package com.prog3.WalletTd.model;

import java.io.Serial;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Compte {
    private int id ;
    private String nom;
    private BigDecimal solde_montant;
    private Timestamp solde_date_maj;
    private String type;

    public Compte(int id, String nom, BigDecimal solde_montant, Timestamp solde_date_maj, String type) {
        this.id = id;
        this.nom = nom;
        this.solde_montant = solde_montant;
        this.solde_date_maj = solde_date_maj;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public BigDecimal getSolde_montant() {
        return solde_montant;
    }

    public void setSolde_montant(BigDecimal solde_montant) {
        this.solde_montant = solde_montant;
    }

    public Timestamp getSolde_date_maj() {
        return solde_date_maj;
    }

    public void setSolde_date_maj(Timestamp solde_date_maj) {
        this.solde_date_maj = solde_date_maj;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}