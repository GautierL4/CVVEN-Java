/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package colloques.classesMetier;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Classe Evenement
 * @author moreira
 */
public class Evenement implements Serializable{
    
    /**
     * Attributs de la classe.
     */
    private int num_event;
    private String libelle;
    private String theme;
    private GregorianCalendar date_debut;
    private GregorianCalendar date_fin;
    private int duree;
    private int nb_participant_max;
    private String description;
    private String organisateur;
    private String type_event;
    private String etat;
    private int num_salle;
    
     /**
     * Constructeur Evenement.
     * @param num_event
     * @param libelle
     * @param theme
     * @param date_debut
     * @param date_fin
     * @param duree
     * @param nb_participant_max
     * @param description
     * @param organisateur
     * @param type_event
     * @param etat
     * @param num_salle 
     */
    public Evenement(int num_event, String libelle, String theme, GregorianCalendar date_debut, GregorianCalendar date_fin, int duree, int nb_participant_max, String description, String organisateur, String type_event, String etat, int num_salle) {
        this.num_event = num_event;
        this.libelle = libelle;
        this.theme = theme;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.duree = duree;
        this.nb_participant_max = nb_participant_max;
        this.description = description;
        this.organisateur = organisateur;
        this.type_event = type_event;
        this.etat = etat;
        this.num_salle = num_salle;
    }
    
    /**
     * Constructeur Evenement
     * @param libelle
     * @param theme
     * @param date_debut
     * @param date_fin
     * @param duree
     * @param nb_participant_max
     * @param description
     * @param organisateur
     * @param type_event
     * @param etat
     * @param num_salle 
     */
    public Evenement(String libelle, String theme, GregorianCalendar date_debut, GregorianCalendar date_fin, int duree, int nb_participant_max, String description, String organisateur, String type_event, String etat, int num_salle) {
        this.libelle = libelle;
        this.theme = theme;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.duree = duree;
        this.nb_participant_max = nb_participant_max;
        this.description = description;
        this.organisateur = organisateur;
        this.type_event = type_event;
        this.etat = etat;
        this.num_salle = num_salle;
    }
    
    /**
     * Constructeur Evenement
     */
    public Evenement(){ }
    
    public int getNum_event() {
        return num_event;
    }

    public void setNum_event(int num_event) {
        this.num_event = num_event;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public GregorianCalendar getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(GregorianCalendar date_debut) {
        this.date_debut = date_debut;
    }

    public GregorianCalendar getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(GregorianCalendar date_fin) {
        this.date_fin = date_fin;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getNb_participant_max() {
        return nb_participant_max;
    }

    public void setNb_participant_max(int nb_participant_max) {
        this.nb_participant_max = nb_participant_max;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(String organisateur) {
        this.organisateur = organisateur;
    }

    public String getType_event() {
        return type_event;
    }

    public void setType_event(String type_event) {
        this.type_event = type_event;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getNum_salle() {
        return num_salle;
    }

    public void setNum_salle(int num_salle) {
        this.num_salle = num_salle;
    }
    
    @Override
    public String toString() {
        return "Evenement{" + "num_event=" + num_event + ", libelle=" + libelle + ", theme=" + theme + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", duree=" + duree + ", nb_participant_max=" + nb_participant_max + ", description=" + description + ", organisateur=" + organisateur + ", type_event=" + type_event + ", etat=" + etat + ", num_salle=" + num_salle + '}';
    }
}
