package colloques.ihm;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
import colloques.classesMetier.Participant;
import colloques.dao.ParticipantDAO;
import java.awt.Dimension;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author pgm
 */
public class SaisieParticipantPanel extends javax.swing.JPanel {
    
    /**
     * Creates new form SaisieParticipantPanel
     */
    public SaisieParticipantPanel() {
        initComponents();
        
        ComboDateNaiss.setSelectedDate(null);
        ComboDateNaiss.setCalendarPreferredSize(new Dimension(350,240));
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelTitre = new javax.swing.JLabel();
        LabelPrenom = new javax.swing.JLabel();
        LabelEmail = new javax.swing.JLabel();
        LabelDateDeNaissance = new javax.swing.JLabel();
        LabelOrganisation = new javax.swing.JLabel();
        LabelObservation = new javax.swing.JLabel();
        txtPrenom = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtOrganisation = new javax.swing.JTextField();
        txtObservation = new javax.swing.JTextField();
        BoutonConfirmation = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        LabelNom = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        ComboDateNaiss = new datechooser.beans.DateChooserCombo();

        setPreferredSize(new java.awt.Dimension(900, 402));

        LabelTitre.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        LabelTitre.setText("Création d'un participant");
        LabelTitre.setToolTipText("");

        LabelPrenom.setText("Prenom");

        LabelEmail.setText("Email");

        LabelDateDeNaissance.setText("Date de Naissance");

        LabelOrganisation.setText("Organisation");

        LabelObservation.setText("Observation");

        BoutonConfirmation.setText("Confirmation");
        BoutonConfirmation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonConfirmationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 175, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        LabelNom.setText("Nom");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(182, Short.MAX_VALUE)
                .addComponent(LabelNom)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 82, Short.MAX_VALUE)
                .addComponent(LabelNom))
        );

        ComboDateNaiss.setCalendarPreferredSize(new java.awt.Dimension(340, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelPrenom)
                            .addComponent(LabelEmail))
                        .addGap(10, 10, 10)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(LabelTitre))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPrenom, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                .addComponent(txtNom))
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelOrganisation)
                                    .addComponent(LabelObservation))
                                .addGap(46, 46, 46))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LabelDateDeNaissance)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboDateNaiss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtObservation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                .addComponent(txtOrganisation, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
            .addGroup(layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(BoutonConfirmation)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(LabelTitre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LabelDateDeNaissance))
                            .addComponent(ComboDateNaiss, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPrenom)
                    .addComponent(txtPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelOrganisation)
                    .addComponent(txtOrganisation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelEmail)
                    .addComponent(LabelObservation)
                    .addComponent(txtObservation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(BoutonConfirmation)
                .addContainerGap(133, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void BoutonConfirmationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonConfirmationActionPerformed
        
        String nom = !txtNom.getText().trim().isEmpty() ? txtNom.getText().trim() : null;
        String prenom = !txtPrenom.getText().trim().isEmpty() ? txtPrenom.getText().trim() : null;
        String organisation = !txtOrganisation.getText().trim().isEmpty() ? txtOrganisation.getText().trim() : null;
        String observation = !txtObservation.getText().trim().isEmpty() ? txtObservation.getText().trim() : null;
        String email = !txtEmail.getText().trim().isEmpty() ? txtEmail.getText().trim() : null;
        GregorianCalendar date_naiss = (GregorianCalendar) ComboDateNaiss.getSelectedDate();
        int anneeCourante = Calendar.getInstance().get(Calendar.YEAR);
        
        if (nom == null) {
            JOptionPane.showMessageDialog(this, "Saisir un nom", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else if (prenom == null) {
            JOptionPane.showMessageDialog(this, "Saisir un prénom", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else if (organisation == null) {
            JOptionPane.showMessageDialog(this, "Saisir une organisation", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        else if (observation == null) {
            JOptionPane.showMessageDialog(this, "Saisir une observation", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        else if (email == null) {
            JOptionPane.showMessageDialog(this, "Saisir une adresse email", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else if (!verifierEmail(email)) {
            JOptionPane.showMessageDialog(this, "L'adresse mail n'est pas valide, veuillez corriger l'adresse mail", "Message", JOptionPane.ERROR_MESSAGE);
            System.err.println("L'adresse mail n'est pas valide, veuillez corriger l'adresse mail");
        } else if (!controlerExistenceEmail(email)) {
            JOptionPane.showMessageDialog(this, "L'adresse mail existe déjà dans la base de données, veuillez en entrez une autre", "Message", JOptionPane.ERROR_MESSAGE);
            System.err.println("L'adresse mail existe déjà, veuillez corriger l'adresse mail");
        }
        else if((anneeCourante - date_naiss.get(Calendar.YEAR))  < 18){
            JOptionPane.showMessageDialog(this, "Vous devez avoir au moins 18 ans.", "Message", JOptionPane.ERROR_MESSAGE);
        }
        else {
            ParticipantDAO pDAO = new ParticipantDAO();
            if (pDAO.create(new Participant(nom, prenom, email, organisation, observation, date_naiss))) {
                JOptionPane.showMessageDialog(this, "Le participant a été ajouté.");
            } else {
                JOptionPane.showMessageDialog(this, "Une erreur est survenue.", "Message", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_BoutonConfirmationActionPerformed
    
    /**
     * Retourne false si l'adresse email en paramètre n'est pas valide.
     *
     * @param email
     * @return boolean
     */
    
    public boolean verifierEmail(String email) {
        boolean valide = true;
        String checkmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(checkmail);
        
        Matcher matcher = pattern.matcher(email);
        
        
        if (matcher.matches() == false) {
            
            valide = false;
        }
        return valide;
    }
    
    /**
     * Retourne false si l'adresse email n'est pas présente dans la base de données.
     * @param email
     * @return boolean
     */
    public boolean controlerExistenceEmail(String email) {
        boolean valide = true;
        List<Participant> alLesParticipants = new ParticipantDAO().getALL();
        
        for (Participant p : alLesParticipants) {
            if (p.getEmail().equals(email)) {
                valide = false;
                break;
            }
        }
        return valide;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonConfirmation;
    private datechooser.beans.DateChooserCombo ComboDateNaiss;
    private javax.swing.JLabel LabelDateDeNaissance;
    private javax.swing.JLabel LabelEmail;
    private javax.swing.JLabel LabelNom;
    private javax.swing.JLabel LabelObservation;
    private javax.swing.JLabel LabelOrganisation;
    private javax.swing.JLabel LabelPrenom;
    private javax.swing.JLabel LabelTitre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtObservation;
    private javax.swing.JTextField txtOrganisation;
    private javax.swing.JTextField txtPrenom;
    // End of variables declaration//GEN-END:variables
}
