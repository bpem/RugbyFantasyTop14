package com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage;

/**
 * Created by Pierre on 04/12/2017.
 */

public class Article {

    private String titre;
    private String resume;

    public Article(String titre, String resume) {
        this.titre = titre;
        this.resume = resume;
    }

    public String getTitre() {
        return titre;

    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }



}
