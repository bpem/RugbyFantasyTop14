package com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage;

/**
 * Created by bastienpemeja on 03/12/2017.
 */

public class Joueur {
    private String keyJoueur, nom, prenom, keyEquipe, poste, nationalite;

    public Joueur(){}

    public Joueur(String keyJoueur, String nom, String prenom, String keyEquipe, String poste, String nationalite) {
        this.keyJoueur = keyJoueur;
        this.nom = nom;
        this.prenom = prenom;
        this.keyEquipe = keyEquipe;
        this.poste = poste;
        this.nationalite = nationalite;
    }

    public String getKeyJoueur() {
        return keyJoueur;
    }

    public Joueur setKeyJoueur(String keyJoueur) {
        this.keyJoueur = keyJoueur;
        return this;
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

    public String getKeyEquipe() {
        return keyEquipe;
    }

    public void setKeyEquipe(String keyEquipe) {
        this.keyEquipe = keyEquipe;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }
}
