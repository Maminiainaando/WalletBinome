package com.prog3.WalletTd.repository;

import com.prog3.WalletTd.model.Compte;
import com.prog3.WalletTd.model.Devise;

import java.util.List;
import java.util.Optional;

public interface CompteInterface {
        Compte insert(Compte compte);
        List<Compte> findAll();
        Compte modifiNomCompte(String nouveaucompte,String nomcompte);
        Compte modifiNomDeviseCompte(Devise newdevise, Devise devise);
    }

