/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colloques.classesMetier;

import java.io.Serializable;

/**
 * Classe Salle
 * @author moreira
 */
public class Salle implements Serializable{
    
    /**
     * Attributs de la classe.
     */
    private int num_salle, capacite;
    private String nom, description;

    /**
     * Constructeur : Salle
     * @param num_salle
     * @param capacite
     * @param nom
     * @param description 
     */
    public Salle(int num_salle, int capacite, String nom, String description) {
        this.num_salle = num_salle;
        this.capacite = capacite;
        this.nom = nom;
        this.description = description;
    }

    public int getNum_salle() {
        return num_salle;
    }

    public void setNum_salle(int num_salle) {
        this.num_salle = num_salle;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Salle{" + "num_salle=" + num_salle + ", capacite=" + capacite + ", nom=" + nom + ", description=" + description + '}';
    }
    
}
