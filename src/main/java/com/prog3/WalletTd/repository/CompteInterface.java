package com.prog3.WalletTd.repository;

import com.prog3.WalletTd.model.Compte;

import java.util.List;

public interface CompteInterface {
        Compte insert(Compte compte);
        List<Compte> findAll();
        Compte modifiNomCompte(String nouveaucompte,String nomcompte);
        Compte modifiNomDeviseCompte(String newdevise, String devise);
    }

