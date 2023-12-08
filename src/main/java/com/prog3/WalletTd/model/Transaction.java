package com.prog3.WalletTd.model;

import java.sql.Timestamp;
import java.text.DecimalFormat;

public class Transaction {
    int id;
    String label;
    DecimalFormat montant;
    Timestamp date_transaction;
    String type_transaction;
}
