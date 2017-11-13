package com.masquilierpemeja.rugbyfantasytop14.Signup;

import com.google.firebase.auth.FirebaseAuth;
import com.masquilierpemeja.rugbyfantasytop14.Login.LoginView;

/**
 * Created by Pierre on 11/11/2017.
 */

public class SignupPresenterImpl implements SignupPresenter, SignupInteractor.onSignupFinishedListener {

    SignupView mSignupView;
     SignupInteractorImpl mSignupInterractor;

    public SignupPresenterImpl(SignupView mSignupView) {
        this.mSignupView = mSignupView;
        this.mSignupInterractor = new SignupInteractorImpl();
    }

    @Override
    public void onClickSignUp(String mail, String password, FirebaseAuth auth) {
        if (mSignupView != null ){
            mSignupInterractor.onClickSignup(mail, password, auth, this);
        }
    }

    @Override
    public void isEmptyMail(String message) {
        if (mSignupView != null ){
            mSignupView.isEmptyMail(message);
        }
    }

    @Override
    public void isEmptyPassword(String message) {
        if (mSignupView != null ){
            mSignupView.isEmptyPassword(message);
        }
    }

    @Override
    public void isTooShortPassword(String message) {
        if (mSignupView != null ){
            mSignupView.isTooShortPassword(message);
        }
    }

    @Override
    public void signupIsSuccessful(String message) {
        if (mSignupView != null ){
            mSignupView.signupIsSuccessful(message);
        }
    }

    @Override
    public void signupFailed(String message) {
        if (mSignupView != null ){
            mSignupView.signupFailed(message);
        }
    }
}
