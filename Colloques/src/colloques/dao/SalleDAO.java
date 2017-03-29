/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colloques.dao;

import colloques.classesMetier.Salle;
import colloques.utilitaire.SingletonConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;


/**
 *
 * @author pgm
 */
public class SalleDAO extends DAO<Salle>{
    Connection connexion;
    // Requêtes SQL.
    final String insert = " INSERT INTO gestionColloques.salle(num_salle,nom,capacite,description) VALUES(DEFAULT, ?, ?, ?);";
    final String update = "UPDATE gestionColloques.salle set nom = ?, capacite = ?, description = ?  WHERE num_salle = ?;";
    final String delete = "DELETE FROM gestionColloques.salle WHERE num_salle = ?;";
    final String select = "SELECT * FROM gestionColloques.salle ORDER BY num_salle;";
    final String selectNum = "Select num_salle FROM gestionColloques.salle WHERE nom = ? ORDER BY num_salle;";
    final String selectNom = "SELECT nom FROM gestionColloques.salle WHERE num_salle = ? ORDER BY num_salle;";
    
    public SalleDAO() {
        connexion = SingletonConnexion.getInstance();
    }

    @Override
    public boolean create(Salle salle) {
        try {
            PreparedStatement instruction = connexion.prepareStatement(insert, ResultSet.TYPE_SCROLL_SENSITIVE);
            instruction.setString(1, salle.getNom());
            instruction.setInt(2, salle.getCapacite());
            instruction.setString(3, salle.getDescription());
            instruction.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("erreur");
            return false;
        }
    }

    @Override
    public boolean delete(Salle salle) {
        try{
            PreparedStatement instruction = connexion.prepareStatement(delete, ResultSet.TYPE_SCROLL_SENSITIVE);
            instruction.setInt(1, salle.getNum_salle());
            instruction.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("erreur");
            return false;
        }
    }

    @Override
    public boolean update(Salle salle) {
        try{
            PreparedStatement instruction = connexion.prepareStatement(update,ResultSet.TYPE_SCROLL_SENSITIVE);
            instruction.setString(1, salle.getNom());
            instruction.setInt(2,salle.getCapacite());
            instruction.setString(3,salle.getDescription());
            return true;
        }
        catch(SQLException e){
            System.err.println("erreur");
            return false;
        }
    }
    
    public int recupNumSalle(String nom_salle){
	int num_salle=-1;
        try{
            PreparedStatement instruction = connexion.prepareStatement(selectNum);
            instruction.setString(1, nom_salle);
            instruction.executeQuery();
            
            ResultSet rs = instruction.getResultSet();
            
            if(rs.next()) num_salle = rs.getInt("num_salle");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
	return num_salle;
    }
    
    public String recupNomSalle(int num_salle) {
        String nom = "";
        try{
            PreparedStatement instruction = connexion.prepareStatement(selectNom);
            instruction.setInt(1, num_salle);
            instruction.executeQuery();
            ResultSet rs = instruction.getResultSet();
            
            if(rs.next()) nom = rs.getString("nom");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return nom;
    }

    @Override
    public List<Salle> getALL() {
        List<Salle> alSalles = new ArrayList<Salle>();
        try {
            Statement instruction = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            instruction.executeQuery(select);
            
            ResultSet rs = instruction.getResultSet();
            
            while(rs.next()){

               alSalles.add(new Salle(rs.getInt("num_salle"), rs.getInt("capacite"),rs.getString("nom"), rs.getString("description")));
            }
        } catch (SQLException e) { 
        }
        
        return alSalles;
    }
    }
    
