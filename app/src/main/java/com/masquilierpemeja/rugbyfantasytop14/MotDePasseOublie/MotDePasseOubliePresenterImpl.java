package com.masquilierpemeja.rugbyfantasytop14.MotDePasseOublie;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Pierre on 12/11/2017.
 */

public class MotDePasseOubliePresenterImpl implements MotDePasseOubliePresenter, MotDePasseOublieInteractor.onMotDePasseOublieFinishedListener {

    MotDePasseOublieView mMotDePasseOublieView;
    MotDePasseOublieInteractorImpl mMotDePasseOublieInteractorImpl;

    public MotDePasseOubliePresenterImpl(MotDePasseOublieView mMotDePasseOublieView) {
            this.mMotDePasseOublieView = mMotDePasseOublieView;
            this.mMotDePasseOublieInteractorImpl = new MotDePasseOublieInteractorImpl();
    }

    @Override
    public void resetPassword(String email,FirebaseAuth auth) {
        mMotDePasseOublieInteractorImpl.resetPassword(email,auth, this);
    }

    @Override
    public void isEmptyEmail(String message) {

    }

    @Override
    public void registrationSucced(String message) {

    }

    @Override
    public void registrationUnsucced(String message) {

    }
}
