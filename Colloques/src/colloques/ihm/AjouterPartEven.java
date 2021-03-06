/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colloques.ihm;

import colloques.classesMetier.Evenement;
import colloques.classesMetier.Participant;
import colloques.dao.EvenementDAO;
import colloques.dao.ParticipantDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author lukom
 */
public class AjouterPartEven extends javax.swing.JPanel {

    /**
     * Creates new form AjouterPartEven
     */
    public AjouterPartEven() {
        initComponents();

        ParticipantDAO pDao = new ParticipantDAO();
        ComboPart.removeAllItems();
        for (Participant p : pDao.getALL()) {
            ComboPart.addItem(p.getNum_pers() + " - " + p.getNom() + " - " + p.getPrenom());
        }

        EvenementDAO eDao = new EvenementDAO();
        comboEven.removeAllItems();
        for (Evenement e : eDao.getALL()) {
            comboEven.addItem(e.getNum_event() + " - " + e.getLibelle());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitre = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblEven = new javax.swing.JLabel();
        comboEven = new javax.swing.JComboBox<>();
        lblPart = new javax.swing.JLabel();
        ComboPart = new javax.swing.JComboBox<>();
        jchebergement = new javax.swing.JCheckBox();
        jRestauration = new javax.swing.JCheckBox();
        btnValider = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setToolTipText("");

        lblTitre.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        lblTitre.setText("Ajout d'un participant à un événement");
        jPanel1.add(lblTitre);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        lblEven.setText("Evénement");
        jPanel3.add(lblEven);

        comboEven.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboEven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEvenActionPerformed(evt);
            }
        });
        jPanel3.add(comboEven);

        lblPart.setText("Participant");
        jPanel3.add(lblPart);

        ComboPart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(ComboPart);

        jchebergement.setText("Hébergement");
        jPanel3.add(jchebergement);

        jRestauration.setText("Restauration");
        jPanel3.add(jRestauration);

        btnValider.setText("Valider");
        btnValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValiderActionPerformed(evt);
            }
        });
        jPanel3.add(btnValider);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Séléctionner le participant à ajouter à un événement");
        jPanel4.add(jLabel1);

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void comboEvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEvenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboEvenActionPerformed

    private void btnValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValiderActionPerformed
        // Récupération des données
        String participant = !ComboPart.getSelectedItem().toString().isEmpty() ? ComboPart.getSelectedItem().toString() : null;
        String evenement = !comboEven.getSelectedItem().toString().isEmpty() ? comboEven.getSelectedItem().toString() : null;
        boolean  restauration = jRestauration.isSelected() == true ? true: false;
        boolean hebergement = jRestauration.isSelected() == true ?  true: false;

        ParticipantDAO pDao = new ParticipantDAO();
        Participant p = new Participant();
        p.setNum_pers(getIdParticipant(separerChaine(1, participant), separerChaine(2, participant)));

        EvenementDAO eDao = new EvenementDAO();
        Evenement e = new Evenement();
        e.setNum_event(Integer.parseInt(separerChaine(0, evenement).trim()));
        if(pDao.verifienbParticipantEven(e)){
            JOptionPane.showMessageDialog(this, "L'événement est plein.");
        }
        else if(pDao.verifieParticipantEven(e, p)){
            JOptionPane.showMessageDialog(this, "Le participant participe déjà à cet événement.");
         }        
        else if(pDao.insertParticipantEven(e, p, restauration, hebergement)){
          JOptionPane.showMessageDialog(this, "Participant ajouté à l'événement.");
        }
        else{
            JOptionPane.showMessageDialog(this, "Une erreur est survenue lors de l'ajout du participant");
        }
    }//GEN-LAST:event_btnValiderActionPerformed
    
    /**
     * Méthode permettant de retourner l'id du Participant.
     * @param nom
     * @param prenom
     * @return int
     */
    public int getIdParticipant(String nom, String prenom) {
        ParticipantDAO pDao = new ParticipantDAO();
        int id = -1;
        for (Participant p : pDao.getALL()) {
            if (p.getNom().equals(nom.trim()) && p.getPrenom().equals(prenom.trim())) {
                id = p.getNum_pers();
                 break;
            }
           
        }
        return id;

    }

    public String separerChaine(int i, String chaine) {
        String tab[] = chaine.split("-");
        return tab[i].trim();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboPart;
    private javax.swing.JButton btnValider;
    private javax.swing.JComboBox<String> comboEven;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JCheckBox jRestauration;
    private javax.swing.JCheckBox jchebergement;
    private javax.swing.JLabel lblEven;
    private javax.swing.JLabel lblPart;
    private javax.swing.JLabel lblTitre;
    // End of variables declaration//GEN-END:variables
}
