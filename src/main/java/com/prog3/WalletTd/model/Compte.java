package com.prog3.WalletTd.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Compte {
    private int id ;
    private String nom;
    private BigDecimal solde_montant;
    private Timestamp solde_date_maj;
    private Devise nomdevise;

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

    public Devise getNomdevise() {
        return nomdevise;
    }

    public void setNomdevise(Devise nomdevise) {
        this.nomdevise = nomdevise;
    }
}