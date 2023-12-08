package com.prog3.WalletTd.repository;

import com.prog3.WalletTd.model.Compte;
import com.prog3.WalletTd.model.Devise;

import java.sql.*;
import java.util.List;

public class CompteDAO implements CompteInterface{
    private Connection connection;
    public CompteDAO(Connection connection){this.connection=connection;}
    @Override
    public Compte insert(Compte compte) {
        String resultat;
        String sql="INSERT INTO compte(id,nom,solde_montant,solde_date_maj,nomdevise) VALUES (?,?,?,?,?)";
        try (PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setInt(1,compte.getId());
            statement.setString(2,compte.getNom());
            statement.setBigDecimal(3,compte.getSolde_montant());
            statement.setTimestamp(4,compte.getSolde_date_maj());
            statement.setObject(5,compte.getNomdevise());
            statement.executeQuery();
            System.out.println("Insertion reussit");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return compte;
    }

    @Override
    public List<Compte> findAll() {
        Statement statement;
        ResultSet result=null;
        try{
            String query=String.format("select * from compte");
            statement=connection.createStatement();
            result=statement.executeQuery(query);
            while(result.next()){
                System.out.print(result.getInt("id"));
                System.out.print(result.getString("nom"));
                System.out.print(result.getBigDecimal("solde_montant"));
                System.out.print(result.getTimestamp("solde_date_maj"));
                System.out.print(result.getString("nomdevise"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Compte modifiNomCompte(String nouveaucompte, String nomcompte) {
        Statement statement;
        try{
            String sql=String.format("update compte set nom='%s' where phonenumber='%s'",nouveaucompte,nomcompte);
            statement=connection.createStatement();
            statement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Compte modifiNomDeviseCompte(Devise nouveaudevise, Devise devise) {
        Statement statement;
        try{
            String sql=String.format("update compte set devise='%s' where phonenumber='%s'",nouveaudevise,devise);
            statement=connection.createStatement();
            statement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
