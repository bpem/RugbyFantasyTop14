package com.masquilierpemeja.rugbyfantasytop14.RejoindreChampionnat;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bastienpemeja on 12/11/2017.
 */

public interface RejoindreChampionnatInteractor {

    interface onRejoindreChampionnatFinishedListener{
        void onMotDePasseError();
        void onSuccess();
        void onFailure(String message);
    }

    void rejoindreChampionnat(String keyChampionnat);

    void listerChampionnat(ListView uneListe, final ArrayAdapter<String> adapter, final ArrayList<String> champArray);

}
