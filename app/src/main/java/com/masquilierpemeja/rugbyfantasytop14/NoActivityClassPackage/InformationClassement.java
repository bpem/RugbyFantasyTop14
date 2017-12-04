package com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Random;

/**
 * Created by Pierre on 03/12/2017.
 */

public class InformationClassement {


    //////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////VARIABLES DE CLASSES///////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////

    private String user_ID = " ";
    private String classement_ID = " ";
    private int nbVictoire = 0;
    private int nbDefaite = 0;
    private int nbEgalite = 0;
    private int ptsTerrainPris = 0;
    private int ptsTerrainMis = 0;
    private int difference = 0;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    private String nom = " ";
    private int ptsTotal = 0;
    private DatabaseManagerInformationClassement dbInfoClassement;


    private String keyChampionnat;



/////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////CONSTRUCTEURS//////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////

    public InformationClassement() {
    }

    public InformationClassement(String user_ID, String keyChampionnat){

        this.user_ID = user_ID;
        this.keyChampionnat = keyChampionnat;



        Random r = new Random();
        int valeur = 1 + r.nextInt(100 - 1);
        this.nom = "Player" + valeur;

    }


    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////GETTER & SETTER///////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////

    public DatabaseManagerInformationClassement getDbInfoClassement() {
        return dbInfoClassement;
    }

    public void setDbInfoClassement(DatabaseManagerInformationClassement dbInfoClassement) {
        this.dbInfoClassement = dbInfoClassement;
    }

    public String getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }

    public String getClassement_ID() {
        return classement_ID;
    }

    public InformationClassement setClassement_ID(String classement_ID) {
        this.classement_ID = classement_ID;
        return this;
    }

    public int getNbVictoire() {
        return nbVictoire;
    }

    public void setNbVictoire(int nbVictoire) {
        this.nbVictoire = nbVictoire;
    }

    public int getNbDefaite() {
        return nbDefaite;
    }

    public void setNbDefaite(int nbDefaite) {
        this.nbDefaite = nbDefaite;
    }

    public int getNbEgalite() {
        return nbEgalite;
    }

    public void setNbEgalite(int nbEgalite) {
        this.nbEgalite = nbEgalite;
    }

    public int getPtsTerrainPris() {
        return ptsTerrainPris;
    }

    public void setPtsTerrainPris(int ptsTerrainPris) {
        this.ptsTerrainPris = ptsTerrainPris;
    }

    public int getPtsTerrainMis() {
        return ptsTerrainMis;
    }

    public void setPtsTerrainMis(int ptsTerrainMis) {
        this.ptsTerrainMis = ptsTerrainMis;
    }

    public int getDifference() {
        return difference;
    }

    public void setDifference(int difference) {
        this.difference = difference;
    }

    public int getPtsTotal() {
        return ptsTotal;
    }

    public void setPtsTotal(int ptsTotal) {
        this.ptsTotal = ptsTotal;
    }

    public String getKeyChampionnat() {
        return keyChampionnat;
    }

    public void setKeyChampionnat(String keyChampionnat) {
        this.keyChampionnat = keyChampionnat;
    }





}
