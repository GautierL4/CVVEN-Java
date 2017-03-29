/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colloques.classesMetier;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Classe Participant
 * @author moreira
 */
public class Participant implements Serializable{
    
    /**
     * Attributs de la classe.
     */
    private int num_pers;
    private String nom, prenom, email, organisation, observation;
    private GregorianCalendar date_naiss;

    /**
     * Constructeur : Participant
     * @param num_pers
     * @param nom
     * @param prenom
     * @param email
     * @param organisation
     * @param observation
     * @param date_naiss 
     */
    public Participant(int num_pers, String nom, String prenom, String email, String organisation, String observation, GregorianCalendar date_naiss) {
        this.num_pers = num_pers;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.organisation = organisation;
        this.observation = observation;
        this.date_naiss = date_naiss;
    }
    
    /**
     * Constructeur : Participant
     * @param nom
     * @param prenom
     * @param email
     * @param organisation
     * @param observation
     * @param date_naiss 
     */
    public Participant(String nom, String prenom, String email, String organisation, String observation, GregorianCalendar date_naiss){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.organisation = organisation;
        this.observation = observation;
        this.date_naiss = date_naiss;
    }
    
    public Participant(){ }

    public int getNum_pers() {
        return num_pers;
    }

    public void setNum_pers(int num_pers) {
        this.num_pers = num_pers;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public GregorianCalendar getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(GregorianCalendar date_naiss) {
        this.date_naiss = date_naiss;
    }

    @Override
    public String toString() {
        return "Participant{" + "num_pers=" + num_pers + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", organisation=" + organisation + ", observation=" + observation + ", date_naiss=" + date_naiss + '}';
    }
    
}
