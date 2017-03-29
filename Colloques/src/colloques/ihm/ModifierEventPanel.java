/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colloques.ihm;

import colloques.classesMetier.Evenement;
import colloques.dao.EvenementDAO;
import colloques.dao.SalleDAO;
import datechooser.beans.DateChooserPanel;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moreira
 */
public class ModifierEventPanel extends javax.swing.JPanel {
    
    ArrayList<Evenement> lesEvents;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DateChooserPanel dateChooser = new DateChooserPanel();
    GregorianCalendar dateDebut = new GregorianCalendar();
    GregorianCalendar dateFin = new GregorianCalendar();  
    
    /**
     * Creates new panel ConsulterEventPanel 
     */
    public ModifierEventPanel() {
        initComponents();
        chargerDonnees();
        actionModifierDate();
        
        // Limite la selection de lignes à une seule.
        jTable.setSelectionMode(SINGLE_SELECTION);
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
        jTable = new javax.swing.JTable() { 
            public boolean isCellEditable(int row, int column) {
                if(column == 2 || column == 3) {
                    return false;
                }
                return true;
            }
        }
        ;
        jLabel2 = new javax.swing.JLabel();

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

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel2.setText("Pour modifier un événement, il suffit de faire un double clic sur l'élément désiré.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                        .addGap(75, 75, 75))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(58, 58, 58))
        );
    }// </editor-fold>//GEN-END:initComponents
        
    public void chargerDonnees() {
        
        EvenementDAO eventDAO = new EvenementDAO();
        SalleDAO salle = new SalleDAO();
        
        lesEvents = new ArrayList<>(eventDAO.getALL());
        
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
                salle.recupNomSalle(lesEvents.get(i).getNum_salle()),
                });
        }
        jTable.setModel(model);

        jTable.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {

                int numEvent = lesEvents.get((int) e.getFirstRow()).getNum_event();

                try {
                    dateDebut.setTime(sdf.parse((String) jTable.getValueAt(e.getFirstRow(), 2)));
                    dateFin.setTime(sdf.parse((String) jTable.getValueAt(e.getFirstRow(), 3)));
                } catch (Exception e1) {}

                Evenement evt = new Evenement(
                        numEvent,
                        (String) jTable.getValueAt(e.getFirstRow(), 0),
                        (String) jTable.getValueAt(e.getFirstRow(), 1),
                        dateDebut,
                        dateFin,   
                        Integer.parseInt(jTable.getValueAt(e.getFirstRow(), 4).toString()),
                        Integer.parseInt(jTable.getValueAt(e.getFirstRow(), 5).toString()),
                        (String) jTable.getValueAt(e.getFirstRow(), 6),
                        (String) jTable.getValueAt(e.getFirstRow(), 7),
                        (String) jTable.getValueAt(e.getFirstRow(), 8),
                        (String) jTable.getValueAt(e.getFirstRow(), 9),
                        salle.recupNumSalle((String) jTable.getValueAt(e.getFirstRow(), 10))
                );
                if(!eventDAO.update(evt)) {
                    JOptionPane.showMessageDialog(jTable, "L'événement n'a pas pu ètre modifié.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    public void actionModifierDate() {
        jTable.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent e1) {

                if (jTable.columnAtPoint(e1.getPoint()) == 2 || jTable.columnAtPoint(e1.getPoint()) == 3) {
                    if (e1.getClickCount() == 2) {
                        
                        dateChooser.setPreferredSize(new Dimension(350, 200));

                        // Date sélectionnée par défaut.   
                        if (jTable.getSelectedColumn() == 2) {
                            dateChooser.setSelectedDate(lesEvents.get(jTable.getSelectedRow()).getDate_debut());
                        } else {
                            dateChooser.setSelectedDate(lesEvents.get(jTable.getSelectedRow()).getDate_fin());
                        }
                        JOptionPane.showMessageDialog(null, dateChooser, "Choisir une date", JOptionPane.PLAIN_MESSAGE);

                        if (dateChooser.getSelectedDate() != null) {
                            jTable.setValueAt(sdf.format(dateChooser.getSelectedDate().getTime()), jTable.getSelectedRow(), jTable.getSelectedColumn());
                        }
                    }
                }
            }
        });
    }

    private void formAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorResized
        this.setSize(this.getParent().getSize());
    }//GEN-LAST:event_formAncestorResized

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
