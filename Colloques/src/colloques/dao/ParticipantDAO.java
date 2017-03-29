/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colloques.dao;

import colloques.classesMetier.Evenement;
import colloques.classesMetier.Participant;
import colloques.utilitaire.SingletonConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pgm
 */
public class ParticipantDAO extends DAO<Participant> {

    Connection connexion;
    // Requêtes SQL.
    final String insert = "INSERT INTO gestionColloques.participants(nom,prenom,email,date_naiss,organisation,observation) VALUES(?, ?, ?, ?, ?, ?);";
    final String update = "UPDATE gestionColloques.participants set nom = ?, prenom = ?, email = ?, date_naiss = ?, organisation = ?, observation = ?  WHERE num_pers = ?;";
    final String delete = "DELETE FROM gestionColloques.participants WHERE num_pers = ?;";
    final String select = "SELECT * FROM gestionColloques.participants ORDER BY num_pers;";
    final String insertPart = "INSERT INTO gestionColloques.participe_a_evenement(num_event,num_pers,hebergement,restauration) VALUES(?, ?, ?, ?)";
    final String verifePart = "SELECT * FROM gestionColloques.participe_a_evenement WHERE num_event = ? AND num_pers = ?";
    final String veriifeQuantEven = "SELECT COUNT(num_pers) as nbpart FROM gestionColloques.participe_a_evenement WHERE num_event = ?";
    final String veriifeQuantSalle = "SELECT nb_participant_max FROM gestioncolloques.evenement WHERE num_event = ?";
    
    public ParticipantDAO() {
        connexion = SingletonConnexion.getInstance();
    }

    @Override
    public boolean create(Participant part) {
        PreparedStatement instruction = null;
        try {
            instruction = connexion.prepareStatement(insert, ResultSet.TYPE_SCROLL_SENSITIVE);
            instruction.setString(1, part.getNom());
            instruction.setString(2, part.getPrenom());
            instruction.setString(3, part.getEmail());
            java.util.Date date = part.getDate_naiss().getTime();
            java.sql.Date dateSQL = new Date(date.getTime());
            instruction.setDate(4, dateSQL);
            instruction.setString(5, part.getOrganisation());
            instruction.setString(6, part.getObservation());
            instruction.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try {
                instruction.close();

            } catch (SQLException e) {
                Logger.getLogger(ParticipantDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    @Override
    public boolean delete(Participant part) {
        PreparedStatement instruction = null;
        try {
            instruction = connexion.prepareStatement(delete, ResultSet.TYPE_SCROLL_SENSITIVE);
            instruction.setInt(1, part.getNum_pers());
            instruction.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("erreur");
            return false;
        } finally {
            try {
                instruction.close();
            } catch (SQLException e) {
                Logger.getLogger(ParticipantDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }

    @Override
    public boolean update(Participant part) {
        PreparedStatement instruction = null;
        try {
            instruction = connexion.prepareStatement(update, ResultSet.TYPE_SCROLL_SENSITIVE);
            instruction.setString(1, part.getNom());
            instruction.setString(2, part.getPrenom());
            instruction.setString(3, part.getEmail());
            instruction.setDate(4, new java.sql.Date(part.getDate_naiss().getTimeInMillis()));
            instruction.setString(5, part.getOrganisation());
            instruction.setString(6, part.getObservation());
            instruction.setInt(7, part.getNum_pers());
            instruction.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("erreur");
            return false;
        } finally {
            try {
                instruction.close();
            } catch (SQLException e) {
                Logger.getLogger(ParticipantDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    @Override
    public List<Participant> getALL() {
        List<Participant> alParticipants = new ArrayList<Participant>();
        Statement instruction = null;
        try {
            instruction = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            instruction.executeQuery(select);

            ResultSet rs = instruction.getResultSet();

            while (rs.next()) {
                GregorianCalendar date_naiss = new GregorianCalendar();
                date_naiss.setTime(rs.getDate("date_naiss"));

                alParticipants.add(new Participant(rs.getInt("num_pers"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("organisation"), rs.getString("observation"), date_naiss));
            }
        } catch (SQLException e) {
        } finally {
            try {
                instruction.close();
            } catch (SQLException e) {
                Logger.getLogger(ParticipantDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return alParticipants;
    }
    
    

      public boolean verifieParticipantEven(Evenement even, Participant p){
         PreparedStatement instruction = null;
         boolean valide = false;
         
        try {
            instruction = connexion.prepareStatement(verifePart);
            instruction.setInt(1, even.getNum_event());
            instruction.setInt(2, p.getNum_pers());     
            instruction.executeQuery();
            System.out.println(instruction.toString());
            
            ResultSet rs = instruction.getResultSet();
            
            if(rs.next()) valide = true;
       
        } catch (SQLException e) {
             System.out.println(instruction.toString());
           e.printStackTrace();
        } finally {
            try {
                instruction.close();
            } catch (SQLException e) {
                Logger.getLogger(ParticipantDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return valide;
    }
      
      public boolean insertParticipantEven(Evenement even, Participant p, boolean restauration, boolean hebergement){
         PreparedStatement instruction = null;
        try {
            instruction = connexion.prepareStatement(insertPart, ResultSet.TYPE_SCROLL_SENSITIVE);
            instruction.setInt(1, even.getNum_event());
            instruction.setInt(2, p.getNum_pers());
            instruction.setBoolean(3, restauration);
            instruction.setBoolean(4, hebergement);           
            instruction.executeUpdate();
            System.out.println(instruction.toString());
            return true;
        } catch (SQLException e) {
             System.out.println(instruction.toString());
           e.printStackTrace();
            return false;
        } finally {
            try {
                instruction.close();
            } catch (SQLException e) {
                Logger.getLogger(ParticipantDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
      
      public boolean verifienbParticipantEven(Evenement even){
         PreparedStatement instruction = null;
         boolean valide = false;
         
        try {
            instruction = connexion.prepareStatement(veriifeQuantEven);
            instruction.setInt(1, even.getNum_event());
            instruction.executeQuery();
            System.out.println(instruction.toString());
            
            ResultSet rs = instruction.getResultSet();
            int nbParticipant = 0;
            while(rs.next()){
                nbParticipant = rs.getInt("nbpart");
            }
            
            instruction = connexion.prepareStatement(veriifeQuantSalle);
            instruction.setInt(1, even.getNum_event());
            instruction.executeQuery();
            System.out.println(instruction.toString());
            
            ResultSet rs2 = instruction.getResultSet();
            int nbPart = 0;
            while(rs.next()){
                nbPart = rs.getInt("nb_participant");
               
            }
            
            if(nbPart == nbParticipant){
                 valide = true;
            }
       
        } catch (SQLException e) {
             System.out.println(instruction.toString());
           e.printStackTrace();
        } finally {
            try {
                instruction.close();
            } catch (SQLException e) {
                Logger.getLogger(ParticipantDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return valide;
    }
}
