package com.masquilierpemeja.rugbyfantasytop14.Championnat;

import android.text.TextUtils;

/**
 * Created by bastienpemeja on 10/11/2017.
 */

public class CreerChampionnatInteractorImpl implements CreerChampionnatInteractor{

    @Override
    public void championnat(String nom, onCreerChampionnatFinishedListener listener) {
        if(TextUtils.isEmpty(nom))
            listener.onNomChampionnatError();
        else if(nom.equals("wrong"))
            listener.onFailure("Nom incorrect");
        else if(!TextUtils.isEmpty(nom))
            listener.onSuccess();

    }
}
