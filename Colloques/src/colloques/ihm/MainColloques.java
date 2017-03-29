/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colloques.ihm;


import javax.swing.UIManager;

/**
 *
 * @author florent
 */
public class MainColloques {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // <editor-fold defaultstate="collapsed" desc="Theme">     
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch(Exception e){
            System.out.println("Une erreur est survenue lors du chargement du thème de la fenêtre.");
            e.printStackTrace();
        }
        // </editor-fold>    
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConnexionFrame().setVisible(true);
                    
            }
        });
    }
    
}
