package com.prog3.WalletTd.repository;

import com.prog3.WalletTd.model.Account;
import com.prog3.WalletTd.model.Transaction;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class TransactionDAO implements TransactionInterface{
    private Connection connection;
    public TransactionDAO(Connection connection){this.connection=connection;}
    @Override
    public Transaction insert(Transaction transaction) {
        String resultat;
        String sql="INSERT INTO transaction(id,label,montant,type ,date) VALUES (?,?,?,?,?)";
        try (PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setInt(1,transaction.getId());
            statement.setString(2,transaction.getLabel());
            statement.setBigDecimal(3,transaction.getMontant());
            statement.setTimestamp(5,transaction.getDate());
            statement.setString(4,transaction.getType());
            statement.executeQuery();
            System.out.println("Insertion reussit");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return transaction;
    }

    @Override
    public List<Transaction> findAll() {
        Statement statement;
        ResultSet result=null;
        try{
            String query=String.format("select * from transaction");
            statement=connection.createStatement();
            result=statement.executeQuery(query);
            while(result.next()){
                System.out.print(result.getInt("id"));
                System.out.print(result.getString("label"));
                System.out.print(result.getBigDecimal("montant"));
                System.out.print(result.getTimestamp("date"));
                System.out.print(result.getString("type"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;

    }

    @Override
    public Account execute(Transaction transaction) {
        Transaction newTransaction = this.insert(transaction);
        Account affectedAccount = newTransaction.getAccount();
        Statement statement;
        BigDecimal newSolde = affectedAccount.getSolde();

        if (newTransaction.getType().equals("Débit")) {
            newSolde = affectedAccount.getSolde().subtract(transaction.getMontant());
        } else if (newTransaction.getType().equals("Crédit")) {
            newSolde = affectedAccount.getSolde().add(transaction.getMontant());
        }

        try{
            String sql=String.format("update account set solde='%s' where id='%s'", newSolde, affectedAccount.getId());
            statement=connection.createStatement();
            statement.executeUpdate(sql);

            affectedAccount = newTransaction.getAccount();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return affectedAccount;
    }
}
