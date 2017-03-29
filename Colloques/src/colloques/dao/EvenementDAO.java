/**
 * Classe EvenementDAO
 */
package colloques.dao;

import colloques.classesMetier.Evenement;
import colloques.utilitaire.SingletonConnexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lukombochristopher
 */
public class EvenementDAO extends DAO<Evenement> {

    Connection connexion;
    // Requêtes SQL.
    final String insert = "INSERT INTO gestionColloques.evenement(libelle, theme, date_debut, date_fin, duree, nb_participant_max, description, organisateur, type_event, etat, num_salle) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    final String update = "UPDATE gestionColloques.evenement set libelle = ?, theme = ?, date_debut = ?, date_fin = ?, duree = ?, nb_participant_max = ?, description = ?, organisateur = ?, type_event = ?, etat = ?, num_salle = ?  WHERE num_event = ?;";
    final String delete = "DELETE FROM gestionColloques.evenement WHERE num_event = ?;";
    final String select = "SELECT * FROM gestionColloques.evenement ORDER BY num_event;";
     final String selectAvenirs = "SELECT * FROM gestionColloques.evenement WHERE etat = ? ORDER BY num_event;";

    public EvenementDAO() {
        connexion = SingletonConnexion.getInstance();
    }

    // Méthode permettant d'insérer un événement.
    @Override
    public boolean create(Evenement even) {
        PreparedStatement instruction = null;
        try {
            instruction = connexion.prepareStatement(insert, ResultSet.TYPE_SCROLL_SENSITIVE);
            instruction.setString(1, even.getLibelle());
            instruction.setString(2, even.getTheme());
            java.util.Date dateDebut = even.getDate_debut().getTime();
            java.sql.Date dateDebutSQL = new Date(dateDebut.getTime());

            instruction.setDate(3, dateDebutSQL);

            java.util.Date dateFin = even.getDate_fin().getTime();
            java.sql.Date dateFinSQL = new Date(dateFin.getTime());

            instruction.setDate(4, dateFinSQL);
            instruction.setInt(5, even.getDuree());
            instruction.setInt(6, even.getNb_participant_max());
            instruction.setString(7, even.getDescription());
            instruction.setString(8, even.getOrganisateur());
            instruction.setString(9, even.getType_event());
            instruction.setString(10, even.getEtat());
            instruction.setInt(11, even.getNum_salle());
            instruction.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.err.println("erreur");
            Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            try {
                instruction.close();
            } catch (SQLException e) {
                Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    /**
     * Méthode permettant de supprimer un événement.
     *
     * @param even
     * @return boolean
     */
    @Override
    public boolean delete(Evenement even) {
        PreparedStatement instruction = null;
        try {
            instruction = connexion.prepareStatement(delete, ResultSet.TYPE_SCROLL_SENSITIVE);
            instruction.setInt(1, even.getNum_event());
            instruction.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("erreur");
            Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            try {
                instruction.close();
            } catch (SQLException e) {
                Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    // Méthode permettant de mettre à jour un événement.
    @Override
    public boolean update(Evenement even) {
        PreparedStatement instruction = null;
        try {
            instruction = connexion.prepareStatement(update, ResultSet.TYPE_SCROLL_SENSITIVE);
            instruction.setString(1, even.getLibelle());
            instruction.setString(2, even.getTheme());
            instruction.setDate(3, new java.sql.Date(even.getDate_debut().getTimeInMillis()));
            instruction.setDate(4, new java.sql.Date(even.getDate_fin().getTimeInMillis()));
            instruction.setInt(5, even.getDuree());
            instruction.setInt(6, even.getNb_participant_max());
            instruction.setString(7, even.getDescription());
            instruction.setString(8, even.getOrganisateur());
            instruction.setString(9, even.getType_event());
            instruction.setString(10, even.getEtat());
            instruction.setInt(11, even.getNum_salle());
            instruction.setInt(12, even.getNum_event());
            instruction.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("erreur");
            return false;
        } finally {
            try {
                instruction.close();
            } catch (SQLException e) {
                Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    /**
     * Méthode permettant de retourner l'ensemble des événements.
     *
     * @return
     */
    @Override
    public List<Evenement> getALL() {
        List<Evenement> alEvenement = new ArrayList<>();
        Statement instruction = null;
        try {
            instruction = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            instruction.executeQuery(select);

            ResultSet rs = instruction.getResultSet();

            while (rs.next()) {

                GregorianCalendar dateDebut = new GregorianCalendar();
                dateDebut.setTime(rs.getDate("date_debut"));

                GregorianCalendar dateFin = new GregorianCalendar();
                dateFin.setTime(rs.getDate("date_fin"));

                alEvenement.add(new Evenement(rs.getInt("num_event"), rs.getString("libelle"), rs.getString("theme"), dateDebut, dateFin, rs.getInt("duree"), rs.getInt("nb_participant_max"), rs.getString("description"), rs.getString("organisateur"), rs.getString("type_event"), rs.getString("etat"), rs.getInt("num_salle")));
            }
        } catch (SQLException e) {
            Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                instruction.close();
            } catch (SQLException e) {
                Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return alEvenement;
    }
    
     /**
     * Méthode permettant de retourner l'ensemble des événements avenirs
     *
     * @return
     */
    public List<Evenement> getALLAvenirs() {
        List<Evenement> alEvenement = new ArrayList<>();
        PreparedStatement instruction = null;
        try {
            instruction = connexion.prepareStatement(selectAvenirs);
            instruction.setString(1, "À venir");
            instruction.executeQuery();

            ResultSet rs = instruction.getResultSet();

            while (rs.next()) {

                GregorianCalendar dateDebut = new GregorianCalendar();
                dateDebut.setTime(rs.getDate("date_debut"));

                GregorianCalendar dateFin = new GregorianCalendar();
                dateFin.setTime(rs.getDate("date_fin"));

                alEvenement.add(new Evenement(rs.getInt("num_event"), rs.getString("libelle"), rs.getString("theme"), dateDebut, dateFin, rs.getInt("duree"), rs.getInt("nb_participant_max"), rs.getString("description"), rs.getString("organisateur"), rs.getString("type_event"), rs.getString("etat"), rs.getInt("num_salle")));
            }
        } catch (SQLException e) {
            Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                instruction.close();
            } catch (SQLException e) {
                Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return alEvenement;
    }
}
