package com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage;

/**
 * Created by bastienpemeja on 03/12/2017.
 */

public class Equipe {
    String keyEquipe, nomEquipe;
    int couleur1Equipe, couleur2Equipe;


    public Equipe(){}

    public Equipe(String keyEquipe, String nomEquipe, int couleur1Equipe, int couleur2Equipe) {
        this.keyEquipe = keyEquipe;
        this.nomEquipe = nomEquipe;
        this.couleur1Equipe = couleur1Equipe;
        this.couleur2Equipe = couleur2Equipe;
    }

    public String getKeyEquipe() {
        return keyEquipe;
    }

    public void setKeyEquipe(String keyEquipe) {
        this.keyEquipe = keyEquipe;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public int getCouleur1Equipe() {
        return couleur1Equipe;
    }

    public void setCouleur1Equipe(int couleur1Equipe) {
        this.couleur1Equipe = couleur1Equipe;
    }

    public int getCouleur2Equipe() {
        return couleur2Equipe;
    }

    public void setCouleur2Equipe(int couleur2Equipe) {
        this.couleur2Equipe = couleur2Equipe;
    }
}
