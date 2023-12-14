package com.prog3.WalletTd.model;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Transaction {
 /* id SERIAL PRIMARY KEY,
    label VARCHAR(50),
    montant DECIMAL(15, 2),
    date_transaction TIMESTAMP,
    type_transaction VARCHAR(10) CHECK (type_transaction IN ('Débit', 'Crédit')),
    compte_id INT REFERENCES account(id)*/

    private int id;
    private String label;
    private BigDecimal montant;
    private  String type_transaction;

    private Timestamp Date_transaction;

    public Transaction(int id, String label, BigDecimal montant, String type_transaction, Timestamp date_transaction) {
        this.id = id;
        this.label = label;
        this.montant = montant;
        this.type_transaction = type_transaction;
        Date_transaction = date_transaction;
    }

    public Timestamp getDate_transaction() {
        return Date_transaction;
    }

    public void setDate_transaction(Timestamp date_transaction) {
        Date_transaction = date_transaction;
    }

    public Transaction(int id, String label, BigDecimal montant, String type_transaction) {
        this.id = id;
        this.label = label;
        this.montant = montant;
        this.type_transaction = type_transaction;
    }

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

    public String getType_transaction() {
        return type_transaction;
    }

    public void setType_transaction(String type_transaction) {
        this.type_transaction = type_transaction;
    }
}
