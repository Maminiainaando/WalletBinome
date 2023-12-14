package com.prog3.WalletTd.repository;

import com.prog3.WalletTd.model.Compte;
import com.prog3.WalletTd.model.CurrencyModel;

import java.sql.*;
import java.util.List;

public class CurrencyDAO implements CurrencyInterface{
        private Connection connection;
        public CurrencyDAO(Connection connection){this.connection=connection;}
        @Override
        public CurrencyModel insert(CurrencyModel devise) {
            String resultat;
            /** private int id ;
             private String nom;
             private BigDecimal solde_montant;
             private Timestamp solde_date_maj;
             private String type;*/
            String sql="INSERT INTO account(id,nom,solde_montant,solde_date_maj,type) VALUES (?,?,?,?,?)";
            try (PreparedStatement statement=connection.prepareStatement(sql)){
                statement.setInt(1,devise.getId());
                statement.setString(2,devise.getNom());
                statement.setString(3,devise.getCode());
                statement.executeQuery();
                System.out.println("Insertion reussit");
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
            return devise;
        }

        @Override
        public List<CurrencyModel> findAll() {
            Statement statement;
            ResultSet result=null;
            try{
                String query=String.format("select * from currency");
                statement=connection.createStatement();
                result=statement.executeQuery(query);
                while(result.next()){
                    System.out.print(result.getInt("id"));
                    System.out.print(result.getString("nom"));
                    System.out.print(result.getBigDecimal("code"));
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
            return null;
        }
}
