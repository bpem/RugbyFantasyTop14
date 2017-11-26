package com.masquilierpemeja.rugbyfantasytop14.Login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.masquilierpemeja.rugbyfantasytop14.*;
import com.masquilierpemeja.rugbyfantasytop14.Login.LoginActivity;

import java.util.concurrent.Executor;

/**
 * Created by Pierre on 10/11/2017.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.onLoginFinishedListener {

    LoginView mLoginView;
    LoginInteractorImpl mLoginInteractorImpl;

    private static final int RC_SIGN_IN = 2;

    public LoginPresenterImpl (LoginView mLoginView){
        this.mLoginView = mLoginView;
        this.mLoginInteractorImpl = new LoginInteractorImpl();
    }


    @Override
    public void onCompleteMailPassword(String email, String password, FirebaseAuth auth) {
        mLoginInteractorImpl.loginWithMail(auth, email, password, this);
    }



    @Override
    public void onDestroy() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data, FirebaseAuth auth) {
        if (mLoginView != null ){
            mLoginInteractorImpl.onActivityResult(requestCode, resultCode, data, auth , this);
        }
    }

    public void onClickFacebook(LoginButton facebookButton, CallbackManager callbackManager) {
        if (mLoginView != null ){
            mLoginInteractorImpl.onClickFacebook(facebookButton, callbackManager, this);
        }
    }

    @Override
    public void onMailError(String message) {

        if (mLoginView != null ){
            mLoginView.setPasswordError(message);
        }

    }

    @Override
    public void onPasswordError(String message) {

        if (mLoginView != null ){
            mLoginView.setPasswordError(message);
        }


    }

    @Override
    public void onSuccess() {
        if (mLoginView != null ){
            mLoginView.navigateToMain();
        }


    }

    @Override
    public void onFailure(String message) {
        if (mLoginView != null ){
            mLoginView.setOnFailure(message);
        }
    }

    @Override
    public void onGoogleSuccess() {
        if (mLoginView != null ){
            mLoginView.navigateToMain();
        }
    }

    @Override
    public void onGoogleFailure(String message) {
        if (mLoginView != null ){
            mLoginView.setOnFailureGoogle(message);
        }
    }

    @Override
    public void onFacebookSuccess(LoginResult loginResult) {
        if (mLoginView != null ){
            mLoginView.setOnFacebookSuccess(loginResult);
        }
    }

    @Override
    public void onFacebookCancel(String message) {
        if (mLoginView != null ){
            mLoginView.setOnFacebookError(message);
        }
    }

    @Override
    public void onFacebookError(String message) {
        if (mLoginView != null ){
            mLoginView.setOnFacebookError(message);
        }
    }
}
