/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colloques.utilitaire;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Classe SingletonConnexion
 * @author moreira
 */
public class SingletonConnexion {
    
    /**
     * Attributs permettant la connexion à la base de données.
     */
//    private String url = "jdbc:postgresql://172.17.122.122:5432/gestioncolloques";
    //private String url = "jdbc:postgresql://192.168.0.18:5432/gestioncolloques";
    private String url = "jdbc:postgresql://109.12.191.106:5432/gestioncolloques";
    private String user = "mmoreira";
    private String password = "infinity";
    
    private static Connection connect;

    /**
     * Constructeur : SingletonConnexion
     */
    private SingletonConnexion() {
        try {
            DriverManager.setLoginTimeout(5);
            connect = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Fonction qui retourne l'instance connection ou la créer si elle n'existe pas.
     * @return connection
     */
   public static Connection getInstance() {
        if(connect == null){
            new SingletonConnexion();
        }
        return connect;   
    }  
    
    
}