package com.masquilierpemeja.rugbyfantasytop14.RejoindreChampionnat;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.Championnat;

import java.util.ArrayList;

/**
 * Created by bastienpemeja on 12/11/2017.
 */

public interface RejoindreChampionnatPresenter {

    void rejoindreChampionnat(String keyChampionnat);
    void listerChampionnat(ListView uneListe, final ArrayAdapter<Championnat> adapter, final ArrayList<Championnat> champArray);
    void onDestroy();

}
