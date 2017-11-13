package com.masquilierpemeja.rugbyfantasytop14.CreerChampionnat;

/**
 * Created by bastienpemeja on 10/11/2017.
 */

public interface CreerChampionnatInteractor {

    interface onCreerChampionnatFinishedListener{
        void onNomChampionnatError();
        void onMotDePasseError();
        void onSuccess();
        void onFailure(String message);
    }


    void championnat(String nomChampionnat, Boolean estPublic, Integer nombreDeParticipant, String motDePasse, onCreerChampionnatFinishedListener listener);
}
