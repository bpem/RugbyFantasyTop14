package com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage;

/**
 * Created by bastienpemeja on 02/12/2017.
 */

public class Championnat {

    private String keyChamp;
    private String nomChamp;
    private String mdpChamp;
    private Boolean estPrive;
    private int nbMaxChamp;


    public Championnat(){

    }

    public Championnat(String keyChamp, String nomChamp, String mdpChamp, Boolean estPrive, int nbMaxChamp) {
        this.keyChamp = keyChamp;
        this.nomChamp = nomChamp;
        this.mdpChamp = mdpChamp;
        this.estPrive = estPrive;
        this.nbMaxChamp = nbMaxChamp;
    }

    /** public Championnat getChampionnatById(String keyChamp){
        Championnat championnat = new Championnat();


        return championnat;
    } **/

    public String getKeyChamp() {
        return keyChamp;
    }

    public Championnat setKeyChamp(String keyChamp) {
        this.keyChamp = keyChamp;
        return this;
    }

    public String getNomChamp() {
        return nomChamp;
    }

    public Championnat setNomChamp(String nomChamp) {
        this.nomChamp = nomChamp;
        return this;
    }

    public String getMdpChamp() {
        return mdpChamp;
    }

    public Championnat setMdpChamp(String mdpChamp) {
        this.mdpChamp = mdpChamp;
        return this;
    }

    public Boolean getEstPrive() {
        return estPrive;
    }

    public Championnat setEstPrive(Boolean estPrive) {
        this.estPrive = estPrive;
        return this;
    }

    public int getNbMaxChamp() {
        return nbMaxChamp;
    }

    public Championnat setNbMaxChamp(int nbMaxChamp) {
        this.nbMaxChamp = nbMaxChamp;
        return this;
    }

    @Override
    public String toString(){
        if(estPrive){
            return this.nomChamp + " - privé";
        }
        else{
            return this.nomChamp + " - public";
        }
    }
}
