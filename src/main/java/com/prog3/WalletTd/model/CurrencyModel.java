package com.prog3.WalletTd.model;

public class CurrencyModel {
    private int id;

    private String nom;

    private String code;

    public CurrencyModel(int id, String nom, String code) {
        this.id = id;
        this.nom = nom;
        this.code = code;
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

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
