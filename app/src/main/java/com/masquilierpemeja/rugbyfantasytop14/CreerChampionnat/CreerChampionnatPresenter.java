package com.masquilierpemeja.rugbyfantasytop14.CreerChampionnat;

/**
 * Created by bastienpemeja on 10/11/2017.
 */

public interface CreerChampionnatPresenter {

    void creerChampionnat(String nomChampionnat, Boolean estPublic, Integer nombreDeJoueur, String motDePasse);
    void onDestroy();
}
