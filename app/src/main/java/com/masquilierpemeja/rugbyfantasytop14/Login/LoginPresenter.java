package com.masquilierpemeja.rugbyfantasytop14.Login;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Pierre on 10/11/2017.
 */

public interface LoginPresenter {

    void onCompleteMailPassword(String email,String password, FirebaseAuth auth);
    void onDestroy();

    void onActivityResult(int requestCode, int resultCode, Intent data);
    void onClickFacebook(LoginButton facebookButton,  CallbackManager callbackManager);

}
