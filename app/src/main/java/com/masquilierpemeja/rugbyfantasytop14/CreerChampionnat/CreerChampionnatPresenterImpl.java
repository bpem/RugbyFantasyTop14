package com.masquilierpemeja.rugbyfantasytop14.CreerChampionnat;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by bastienpemeja on 10/11/2017.
 */

@IgnoreExtraProperties
public class CreerChampionnatPresenterImpl implements CreerChampionnatPresenter, CreerChampionnatInteractor.onCreerChampionnatFinishedListener{

    CreerChampionnatView mCreerChampionnatView;
    CreerChampionnatInteractor mCreerChampionnatInteractor;

    public CreerChampionnatPresenterImpl(CreerChampionnatView mCreerChampionnatView){
        this.mCreerChampionnatView = mCreerChampionnatView;
        mCreerChampionnatInteractor = new CreerChampionnatInteractorImpl();
    }


    @Override
    public void creerChampionnat(String nomChampionnat,Boolean estPublic, Integer nombreDeJoueur, String motDePasse) {
        if (mCreerChampionnatView != null) {
            mCreerChampionnatView.showProgress();
            mCreerChampionnatInteractor.championnat(nomChampionnat, estPublic, nombreDeJoueur, motDePasse,this);
        }
    }

    @Override
    public void onDestroy() {
        if (mCreerChampionnatView != null) {
            mCreerChampionnatView = null;
        }
    }

    @Override
    public void onNomChampionnatError() {
        if (mCreerChampionnatView != null) {
            mCreerChampionnatView.hideProgress();
            mCreerChampionnatView.setNomChampionnatError();
        }
    }

    @Override
    public void onMotDePasseError() {
        if (mCreerChampionnatView != null) {
            mCreerChampionnatView.hideProgress();
            mCreerChampionnatView.setMotDePasseError();
        }
    }

    @Override
    public void onSuccess() {
        if (mCreerChampionnatView != null) {
            mCreerChampionnatView.hideProgress();
            mCreerChampionnatView.navigateToMenuPrincipal();
        }

    }

    @Override
    public void onFailure(String message) {
        if (mCreerChampionnatView != null) {
            mCreerChampionnatView.hideProgress();
            mCreerChampionnatView.showAlert(message);
        }
    }
}
