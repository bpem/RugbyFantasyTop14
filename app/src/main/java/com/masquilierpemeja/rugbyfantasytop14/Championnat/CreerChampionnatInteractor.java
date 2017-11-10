package com.masquilierpemeja.rugbyfantasytop14.Championnat;

/**
 * Created by bastienpemeja on 10/11/2017.
 */

public interface CreerChampionnatInteractor {

    interface onCreerChampionnatFinishedListener{
        void onNomChampionnatError();
        void onSuccess();
        void onFailure(String message);
    }

    void championnat(String nom, onCreerChampionnatFinishedListener listener);
}
