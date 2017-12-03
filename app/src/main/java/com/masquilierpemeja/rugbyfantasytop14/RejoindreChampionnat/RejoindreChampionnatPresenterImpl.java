package com.masquilierpemeja.rugbyfantasytop14.RejoindreChampionnat;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.Championnat;

import java.util.ArrayList;

/**
 * Created by bastienpemeja on 12/11/2017.
 */

public class RejoindreChampionnatPresenterImpl implements RejoindreChampionnatPresenter, RejoindreChampionnatInteractor.onRejoindreChampionnatFinishedListener {

    RejoindreChampionnatView mRejoindreChampionnatView;
    RejoindreChampionnatInteractor mRejoindreChampionnatInteractor;


    public RejoindreChampionnatPresenterImpl (RejoindreChampionnatView mRejoindreChampionnatView){
        this.mRejoindreChampionnatView = mRejoindreChampionnatView;
       mRejoindreChampionnatInteractor = new RejoindreChampionnatInteractorImpl();
    }

    @Override
    public void rejoindreChampionnat(String keyChampionnat) {

    }

    @Override
    public void listerChampionnat(ListView uneListe, final ArrayAdapter<Championnat> adapter, final ArrayList<Championnat> champArray) {
        if (mRejoindreChampionnatView != null) {
            mRejoindreChampionnatView.showProgress();
            mRejoindreChampionnatInteractor.listerChampionnat(uneListe, adapter, champArray);
        }

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onMotDePasseError() {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailure(String message) {

    }


}
