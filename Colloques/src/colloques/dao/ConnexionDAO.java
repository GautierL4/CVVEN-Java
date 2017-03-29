/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colloques.dao;

import colloques.classesMetier.Utilisateur;
import colloques.utilitaire.SingletonConnexion;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author moreira
 */
public class ConnexionDAO extends DAO<Utilisateur> {

    Connection connexion;
    final String select = "SELECT * FROM gestionColloques.utilisateur WHERE identifiant = ? AND pass = ?";

    @Override
    public boolean create(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Utilisateur> getALL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ConnexionDAO() {
        connexion = SingletonConnexion.getInstance();
    }

    public boolean SeConnecter(Utilisateur user) {
        PreparedStatement instruction = null;
        try {
            instruction = connexion.prepareStatement(select);
            instruction.setString(1, user.getIdentifiant());
            instruction.setString(2, DatatypeConverter.printHexBinary(MessageDigest.getInstance("MD5").digest(user.getPass().getBytes("UTF-8"))).toLowerCase());

            instruction.executeQuery();
            ResultSet rs = instruction.getResultSet();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL");
        } catch (Exception e) {
            System.err.println("Erreur");
        } finally {
            try {
                instruction.close();

            } catch (SQLException e) {
                Logger.getLogger(ConnexionDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return false;
    }

}
