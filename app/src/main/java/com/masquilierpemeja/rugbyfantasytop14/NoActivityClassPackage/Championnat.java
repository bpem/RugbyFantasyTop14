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

    public Championnat(String keyChamp, String nomChamp, String mdpChamp, Boolean estPrive, int nbMaxChamp) {
        this.keyChamp = keyChamp;
        this.nomChamp = nomChamp;
        this.mdpChamp = mdpChamp;
        this.estPrive = estPrive;
        this.nbMaxChamp = nbMaxChamp;
    }

    public String getKeyChamp() {
        return keyChamp;
    }

    public void setKeyChamp(String keyChamp) {
        this.keyChamp = keyChamp;
    }

    public String getNomChamp() {
        return nomChamp;
    }

    public void setNomChamp(String nomChamp) {
        this.nomChamp = nomChamp;
    }

    public String getMdpChamp() {
        return mdpChamp;
    }

    public void setMdpChamp(String mdpChamp) {
        this.mdpChamp = mdpChamp;
    }

    public Boolean getEstPrive() {
        return estPrive;
    }

    public void setEstPrive(Boolean estPrive) {
        this.estPrive = estPrive;
    }

    public int getNbMaxChamp() {
        return nbMaxChamp;
    }

    public void setNbMaxChamp(int nbMaxChamp) {
        this.nbMaxChamp = nbMaxChamp;
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
