package com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage;

import java.util.Random;

/**
 * Created by Pierre on 02/12/2017.
 */

////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////// CLASSE USER : CONTIENT LES INFORMATIONS DE L'UTILISATEUR //////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////


public class User {


    //////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////VARIABLES DE CLASSES///////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////

    private String adresseMail;
    private String userID;
    private Boolean estDansUnChampionnat;
    private String keyChampionnat;
    private String nom;

    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////CONSTRUCTEURS//////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////


    // Constructeur vide
    public User() {
    }


    // Constructeur avec paramètres
    public User(String adresseMail, String userID, Boolean estDansUnChampionnat,String keyChampionnat){
        this.adresseMail = adresseMail;
        this.userID = userID;
        this.estDansUnChampionnat = estDansUnChampionnat;
        this.keyChampionnat = keyChampionnat;

        Random r = new Random();
        int valeur = 1 + r.nextInt(100 - 1);
        this.nom = "Player" + valeur;

    }

    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////GETTER & SETTER///////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////


    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public String getUserID() {
        return userID;

    }

    public User setUserID(String userID) {
        this.userID = userID;
        return this;
    }


    public Boolean getEstDansUnChampionnat() {
        return estDansUnChampionnat;
    }

    public void setEstDansUnChampionnat(Boolean estDansUnChampionnat) {
        this.estDansUnChampionnat = estDansUnChampionnat;
    }

    public String getKeyChampionnat() {
        return keyChampionnat;
    }

    public void setKeyChampionnat(String keyChampionnat) {
        this.keyChampionnat = keyChampionnat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


}
