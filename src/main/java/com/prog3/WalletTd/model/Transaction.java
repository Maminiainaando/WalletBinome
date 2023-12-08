package com.prog3.WalletTd.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;

public class Transaction {
   private int id;
   private String label;
   private BigDecimal montant;
  private  Timestamp date_transaction;
   private String type_transaction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Timestamp getDate_transaction() {
        return date_transaction;
    }

    public void setDate_transaction(Timestamp date_transaction) {
        this.date_transaction = date_transaction;
    }

    public String getType_transaction() {
        return type_transaction;
    }

    public void setType_transaction(String type_transaction) {
        this.type_transaction = type_transaction;
    }
}
