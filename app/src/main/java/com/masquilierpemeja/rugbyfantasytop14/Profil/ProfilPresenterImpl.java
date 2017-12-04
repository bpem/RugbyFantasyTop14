package com.masquilierpemeja.rugbyfantasytop14.Profil;

import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.User;

/**
 * Created by bastienpemeja on 13/11/2017.
 */

public class ProfilPresenterImpl implements ProfilPresenter {

    ProfilView mProfilView;
    ProfilInteractor mProfilInteractor;


    public ProfilPresenterImpl(ProfilView mProfilView){
        this.mProfilView = mProfilView;
        mProfilInteractor = new ProfilInteractorImpl(this);
    }

    @Override
    public void getUserCourant() {
        if(mProfilView != null){
            mProfilInteractor.getUserCourant();
        }
    }

    public void sendUser(User user){
          mProfilView.sendUser(user);
    }

    @Override
    public void onDestroy() {

    }
}
