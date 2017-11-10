package com.masquilierpemeja.rugbyfantasytop14.Championnat;

/**
 * Created by bastienpemeja on 10/11/2017.
 */

public class CreerChampionnatPresenterImpl implements CreerChampionnatPresenter, CreerChampionnatInteractor.onCreerChampionnatFinishedListener{

    CreerChampionnatView mCreerChampionnatView;
    CreerChampionnatInteractor mCreerChampionnatInteractor;

    public CreerChampionnatPresenterImpl(CreerChampionnatView mCreerChampionnatView){
        this.mCreerChampionnatView = mCreerChampionnatView;
        mCreerChampionnatInteractor = new CreerChampionnatInteractorImpl();
    }


    @Override
    public void creerChampionnat(String nomChampionnat) {
        if (mCreerChampionnatView != null) {
            mCreerChampionnatView.showProgress();
            mCreerChampionnatInteractor.championnat(nomChampionnat,this);
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
    public void onSuccess() {
        if (mCreerChampionnatView != null) {
            mCreerChampionnatView.hideProgress();
            mCreerChampionnatView.navigateToMain();
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
