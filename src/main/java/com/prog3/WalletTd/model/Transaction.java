package com.prog3.WalletTd.model;

import com.prog3.WalletTd.DatabaseConfiguration;
import com.prog3.WalletTd.repository.AccountDAO;
import com.prog3.WalletTd.repository.AccountInterface;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Transaction {
    private int id;
    private String label;
    private BigDecimal montant;
    private  String type;

    private Timestamp date;

    private Integer account_id;
    private Categorie categorie;

    public Transaction(int id, String label, BigDecimal montant, String type, Timestamp date, Integer account_id, Categorie categorie) {
        this.id = id;
        this.label = label;
        this.montant = montant;
        this.type = type;
        this.date = date;
        this.account_id = account_id;
        this.categorie = categorie;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }


    public Timestamp getDate() {
        return this.date;
    }

    public void setDate(Timestamp date_transaction) {
        this.date = date_transaction;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public BigDecimal getMontant() {
        return this.montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Account getAccount() {
        AccountDAO accountDAO = new AccountDAO(DatabaseConfiguration.getConnection());
        return accountDAO.find(this.account_id);
    }
}
