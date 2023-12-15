package com.prog3.WalletTd.repository;

import com.prog3.WalletTd.model.Account;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

public class AccountDAO implements AccountInterface {
    private Connection connection;
    public AccountDAO(Connection connection){this.connection=connection;}
    @Override
    public Account insert(Account account) {
        String resultat;
        String sql="INSERT INTO account(id,nom,solde,type) VALUES (?,?,?,?)";
        try (PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setInt(1, account.getId());
            statement.setString(2, account.getNom());
            statement.setBigDecimal(3, account.getSolde());
            statement.setString(4, account.getType());
            statement.executeQuery();
            System.out.println("Insertion reussit");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return account;
    }

    @Override
    public Account find(Integer account_id) {
        String resultat;
        /** private int id ;
         private String nom;
         private BigDecimal solde;
         private String type;*/
        String sql="SELECT * FROM ACCOUNT WHERE id=?";
        try (PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setInt(1, account_id);
            ResultSet data = statement.executeQuery();
            return new Account(data.getInt("id"), data.getString("nom"), data.getBigDecimal("solde"), data.getString("type"));
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Account> findAll() {
        Statement statement;
        ResultSet result=null;
        try{
            String query=String.format("select * from account");
            statement=connection.createStatement();
            result=statement.executeQuery(query);
            while(result.next()){
                System.out.print(result.getInt("id"));
                System.out.print(result.getString("nom"));
                System.out.print(result.getBigDecimal("solde"));
                System.out.print(result.getString("type"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Account modifiNomCompte(String nouveaucompte, String nomcompte) {
        Statement statement;
        try{
            String sql=String.format("update compte set nom='%s' where nom='%s'",nouveaucompte,nomcompte);
            statement=connection.createStatement();
            statement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Account modifiDeviseCompte(Integer nouveaudevise, Integer devise) {
        Statement statement;
        try{
            String sql=String.format("update compte set currency_id='%s' where currency_id='%s'",nouveaudevise,devise);
            statement=connection.createStatement();
            statement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public BigDecimal getSoldeOnDate(Integer account_id, Timestamp timestamp) {
        String resultat;
        BigDecimal soldeOnDate = BigDecimal.valueOf(0);
      
        String sql="SELECT * FROM TRANSACTION WHERE account_id=? and date<=? order by date";
        try (PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setInt(1, account_id);
            statement.setTimestamp(2, timestamp);
            ResultSet data = statement.executeQuery();
            while(data.next()) {
                if (data.getString("type").equals("Débit")) {
                    soldeOnDate = soldeOnDate.subtract(data.getBigDecimal("montant"));
                } else if (data.getString("type").equals("Crédit")) {
                    soldeOnDate = soldeOnDate.add(data.getBigDecimal("montant"));
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return soldeOnDate;
    }
}
