package com.masquilierpemeja.rugbyfantasytop14.RejoindreChampionnat;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by bastienpemeja on 12/11/2017.
 */

public interface RejoindreChampionnatPresenter {

    void rejoindreChampionnat(String keyChampionnat);
    void listerChampionnat(ListView uneListe, final ArrayAdapter<String> adapter, final ArrayList<String> champArray);
    void onDestroy();

}
