package com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage;

/**
 * Created by bastienpemeja on 03/12/2017.
 */

public class Joueur {
    String keyJoueur, nomJoueur, prenomJoueur, keyEquipe, posteJoueur, nationaliteJoueur;
    int ageJoueur;

    public Joueur(){}

    public Joueur(String keyJoueur, String nomJoueur, String prenomJoueur, String keyEquipe, String posteJoueur, String nationaliteJoueur, int ageJoueur) {
        this.keyJoueur = keyJoueur;
        this.nomJoueur = nomJoueur;
        this.prenomJoueur = prenomJoueur;
        this.keyEquipe = keyEquipe;
        this.posteJoueur = posteJoueur;
        this.nationaliteJoueur = nationaliteJoueur;
        this.ageJoueur = ageJoueur;
    }

    public String getKeyJoueur() {
        return keyJoueur;
    }

    public void setKeyJoueur(String keyJoueur) {
        this.keyJoueur = keyJoueur;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public String getPrenomJoueur() {
        return prenomJoueur;
    }

    public void setPrenomJoueur(String prenomJoueur) {
        this.prenomJoueur = prenomJoueur;
    }

    public String getKeyEquipe() {
        return keyEquipe;
    }

    public void setKeyEquipe(String keyEquipe) {
        this.keyEquipe = keyEquipe;
    }

    public String getPosteJoueur() {
        return posteJoueur;
    }

    public void setPosteJoueur(String posteJoueur) {
        this.posteJoueur = posteJoueur;
    }

    public String getNationaliteJoueur() {
        return nationaliteJoueur;
    }

    public void setNationaliteJoueur(String nationaliteJoueur) {
        this.nationaliteJoueur = nationaliteJoueur;
    }

    public int getAgeJoueur() {
        return ageJoueur;
    }

    public void setAgeJoueur(int ageJoueur) {
        this.ageJoueur = ageJoueur;
    }
}
