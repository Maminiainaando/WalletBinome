package com.prog3.WalletTd.repository;

import com.prog3.WalletTd.model.Account;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public interface AccountInterface {
        Account insert(Account account);

        Account find(Integer account_id);
        List<Account> findAll();
        Account modifiNomCompte(String nouveaucompte, String nomcompte);
        Account modifiDeviseCompte(Integer newdevise, Integer devise);

        BigDecimal getSoldeOnDate(Integer account_id, Timestamp timestamp);
}

