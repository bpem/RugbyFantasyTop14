package com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage;

import java.util.List;

/**
 * Created by bastienpemeja on 03/12/2017.
 */

public class Equipe {
    String keyEquipe, keyUser;
    List<Joueur> listJoueur;


    public Equipe(){};

    public Equipe(String keyEquipe, String keyUser, List<Joueur> listJoueur) {
        this.keyEquipe = keyEquipe;
        this.keyUser = keyUser;
        this.listJoueur = listJoueur;
    }

    public String getKeyEquipe() {
        return keyEquipe;
    }

    public void setKeyEquipe(String keyEquipe) {
        this.keyEquipe = keyEquipe;
    }
}
