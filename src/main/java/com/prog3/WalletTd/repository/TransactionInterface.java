package com.prog3.WalletTd.repository;

import com.prog3.WalletTd.model.Transaction;

import java.util.List;

public interface TransactionInterface {
    Transaction insert(Transaction transaction);
    List<Transaction> findAll();
}
