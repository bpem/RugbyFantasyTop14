package com.masquilierpemeja.rugbyfantasytop14.Login;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Pierre on 10/11/2017.
 */

public interface LoginInteractor {

        interface onLoginFinishedListener{
        void onMailError(String message);
        void onPasswordError(String message);
        void onSuccess();
        void onFailure(String message);
        void onGoogleSuccess();
        void onGoogleFailure(String message);
        void onFacebookSuccess();
        void onFacebookCancel(String message);
        void onFacebookError(String message);
    }

    void loginWithMail(FirebaseAuth auth, String email, String password, onLoginFinishedListener Listener);
    void onActivityResult(int requestCode, int resultCode, Intent data,  FirebaseAuth auth, onLoginFinishedListener listener);
    void onClickFacebook(LoginButton facebookButton, CallbackManager mCallbackManager , onLoginFinishedListener listener);
   void firebaseAuthWithGoogle(GoogleSignInAccount account, final FirebaseAuth auth, final onLoginFinishedListener listener);
}
