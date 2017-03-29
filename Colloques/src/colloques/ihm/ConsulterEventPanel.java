/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colloques.ihm;

import colloques.classesMetier.Evenement;
import colloques.dao.EvenementDAO;
import colloques.dao.SalleDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moreira
 */
public class ConsulterEventPanel extends javax.swing.JPanel {
    
    /**
     * Creates new panel ConsulterEventPanel 
     */
    public ConsulterEventPanel() {
        initComponents();
        chargerDonnees();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(900, 442));
        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                formAncestorResized(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 3, 24)); // NOI18N
        jLabel1.setText("Liste des événements");

        jScrollPane1.setToolTipText("");

        jTable.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        int nbCol = -1;
        jTable.setRowHeight(24);
        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addGap(80, 80, 80))
        );
    }// </editor-fold>//GEN-END:initComponents
        
    public void chargerDonnees() {
        EvenementDAO eventDAO = new EvenementDAO();
        SalleDAO salle = new SalleDAO();

        ArrayList<Evenement> lesEvents = new ArrayList<>(eventDAO.getALL());
        
        String[] lesEntetes = {"Libellé", "Thème", "Date de début", "Date de fin", "Durée", "Personnes max", 
            "Description", "Organisateur", "Type d'évènement", "Etat", "Nom de Salle"};
        
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        for(String entete : lesEntetes) {
            model.addColumn(entete);
        }

        for (int i = 0; i < lesEvents.size(); i++) {
            model.addRow(new Object[]{
                lesEvents.get(i).getLibelle(),
                lesEvents.get(i).getTheme(),
                sdf.format(lesEvents.get(i).getDate_debut().getTime()),
                sdf.format(lesEvents.get(i).getDate_fin().getTime()),
                lesEvents.get(i).getDuree(),
                lesEvents.get(i).getNb_participant_max(),
                lesEvents.get(i).getDescription(),
                lesEvents.get(i).getOrganisateur(),
                lesEvents.get(i).getType_event(),
                lesEvents.get(i).getEtat(),
                salle.recupNomSalle(lesEvents.get(i).getNum_salle())
                });
        }
        jTable.setModel(model);
        
        // Permet de désactiver la modification des données.
        jTable.setDefaultEditor(Object.class, null);
    }

    private void formAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorResized
        this.setSize(this.getParent().getSize());
    }//GEN-LAST:event_formAncestorResized

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}