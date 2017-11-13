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
        if (mMotDePasseOublieView != null ){
            mMotDePasseOublieView.isEmptyEmail(message);
        }
    }

    @Override
    public void motDePasseEnvoyeSuccess(String message) {
        if (mMotDePasseOublieView != null ){
            mMotDePasseOublieView.motDePasseOublieSucced(message);
        }
    }

    @Override
    public void motDePasseEnvoyeFail(String message) {
        if (mMotDePasseOublieView != null ){
            mMotDePasseOublieView.motDePasseOublieUnsucced(message);
        }
    }
}
