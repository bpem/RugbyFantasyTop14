package com.masquilierpemeja.rugbyfantasytop14.MonEquipe;

import android.view.View;

import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.Joueur;

import java.util.List;

/**
 * Created by bastienpemeja on 03/12/2017.
 */

public interface MonEquipeView {
    void sendListeJoueurByPoste(List<Joueur> joueurs);
}
