package com.prog3.WalletTd.model;

import java.io.Serial;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;

public class Transaction {
 /* id SERIAL PRIMARY KEY,
    label VARCHAR(50),
    montant DECIMAL(15, 2),
    date_transaction TIMESTAMP,
    type_transaction VARCHAR(10) CHECK (type_transaction IN ('Débit', 'Crédit')),
    compte_id INT REFERENCES account(id)*/

    private Serial id;
    private String label;
    private BigDecimal montant;
    private  String type_transaction;

    public Transaction(Serial id, String label, BigDecimal montant, String type_transaction) {
        this.id = id;
        this.label = label;
        this.montant = montant;
        this.type_transaction = type_transaction;
    }

    public Serial getId() {
        return id;
    }

    public void setId(Serial id) {
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
