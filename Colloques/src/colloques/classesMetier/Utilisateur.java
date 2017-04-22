/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colloques.classesMetier;

import java.io.Serializable;

/**
 * Classe Utilisateur
 * @author moreira
 */
public class Utilisateur implements Serializable{
    
    /**
     * Attributs de la classe.
     */
    private int id, rang;
    private String identifiant, pass;

    /**
     * Constructeur : Utilisateur
     * @param id
     * @param identifiant
     * @param pass
     * @param rang 
     */
    public Utilisateur(int id, String identifiant, String pass, int rang) {
        this.id = id;
        this.identifiant = identifiant;
        this.pass = pass;
        this.rang = rang;
    }
    
    /**
     * Constructeur Utilisateur
     */
    public Utilisateur() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", identifiant=" + identifiant + ", pass=" + pass + ", rang=" + rang + '}';
    }
    
}
