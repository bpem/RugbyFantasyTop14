package com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage;

/**
 * Created by Pierre on 02/12/2017.
 */

////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////// CLASSE USER : CONTIENT LES INFORMATIONS DE L'UTILISATEUR //////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////


public class User {

    String adresseMail;
    String userID;


    // Constructeur vide
    public User() {
    }


    // Constructeur avec paramètres
    public User(String adresseMail, String userID){
        this.adresseMail = adresseMail;
        this.userID = userID;
    }



















    /////////////////          METTRE LES GETTER ET SETTER ICI             ///////////////////////////////


    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }


    /////////////////                   FIN GETTER ET SETTER              ///////////////////////////////

}
