package com.prog3.WalletTd.repository;

import com.prog3.WalletTd.model.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class TransactionDAO implements TransactionInterface{
    private Connection connection;
    public TransactionDAO(Connection connection){this.connection=connection;}
    @Override
    public Transaction insert(Transaction transaction) {
        String resultat;
        String sql="INSERT INTO transaction(id,label,montant,date_transaction,type_transaction) VALUES (?,?,?,?,?)";
        try (PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setInt(1,transaction.getId());
            statement.setString(2,transaction.getLabel());
            statement.setBigDecimal(3,transaction.getMontant());
            statement.setTimestamp(4,transaction.getDate_transaction());
            statement.setString(5,transaction.getType_transaction());
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
                System.out.print(result.getTimestamp("date_transaction"));
                System.out.print(result.getString("type_transaction"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;

    }



}
