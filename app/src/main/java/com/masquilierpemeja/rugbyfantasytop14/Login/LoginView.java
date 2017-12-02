package com.masquilierpemeja.rugbyfantasytop14.Login;

import android.content.Context;

import com.facebook.login.LoginResult;

/**
 * Created by Pierre on 10/11/2017.
 */

public interface LoginView {

    void signInMail();
    void setOnFailure(String message);

    void showProgress();
    void hideProgress();
    void setMailError(String message);
    void setPasswordError(String message);
    void showAlert(String message);
    void navigateToMain();
    Context getContext();
    void setOnFailureGoogle(String message);
    void setOnFacebookCancel(String message);
    void setOnFacebookError(String message);
    void setOnFacebookSuccess(LoginResult loginResult);



}
