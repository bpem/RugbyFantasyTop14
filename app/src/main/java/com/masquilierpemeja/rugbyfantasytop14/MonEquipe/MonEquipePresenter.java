package com.masquilierpemeja.rugbyfantasytop14.MonEquipe;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.Joueur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bastienpemeja on 03/12/2017.
 */

public interface MonEquipePresenter {
    void creerEquipe();
    void sendListeJoueurByPoste(List<Joueur> joueurs);
    void getJoueurByPoste(final String poste,final ListView unListe, final ArrayAdapter<Joueur> adapter, final ArrayList<Joueur> joueurArray);
}
