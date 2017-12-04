package com.masquilierpemeja.rugbyfantasytop14.MonEquipe;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.Joueur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bastienpemeja on 03/12/2017.
 */

public class MonEquipePresenterImpl implements MonEquipePresenter {

    MonEquipeView mMonEquipeView;
    MonEquipeInteractor mMonEquipeInteractor;


    public MonEquipePresenterImpl(MonEquipeView mMonEquipeView){
        this.mMonEquipeView = mMonEquipeView;
        mMonEquipeInteractor = new MonEquipeInteractorImpl(this);
    }

    @Override
    public void creerEquipe() {
        mMonEquipeInteractor.listerTousLesJoueurs();
    }


    @Override
    public void sendListeJoueurByPoste(List<Joueur> joueurs) {
        mMonEquipeView.sendListeJoueurByPoste(joueurs);
    }

    @Override
    public void getJoueurByPoste(String poste, ListView unListe, ArrayAdapter<Joueur> adapter, ArrayList<Joueur> joueurArray) {
        if (mMonEquipeView != null) {
            mMonEquipeInteractor.listerJoueurByPoste(poste, unListe, adapter,joueurArray);
        }
    }


}
