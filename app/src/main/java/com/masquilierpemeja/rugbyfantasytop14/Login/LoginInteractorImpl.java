package com.masquilierpemeja.rugbyfantasytop14.Login;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.masquilierpemeja.rugbyfantasytop14.*;
import com.masquilierpemeja.rugbyfantasytop14.Login.LoginActivity;

import java.util.concurrent.Executor;

import static android.content.ContentValues.TAG;

/**
 * Created by Pierre on 10/11/2017.
 */

public class LoginInteractorImpl implements LoginInteractor {

    private static final int RC_SIGN_IN = 2;
    CallbackManager callbackManager;

    @Override
    public void loginWithMail(FirebaseAuth auth, String email, String password, final onLoginFinishedListener listener) {


        if (TextUtils.isEmpty(email)){
            listener.onMailError("Entrez une adresse mail!");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            listener.onPasswordError("Entrez un mot de passe!");
            return;
        }


        final Task<AuthResult> authResultTask = auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            listener.onFailure("L'authenfication a échoué");
                            return;
                        } else {
                            listener.onSuccess();
                            return;
                        }
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data, FirebaseAuth auth, onLoginFinishedListener listener) {

        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account, auth , listener);
                // Signed in successfully, show authenticated UI.
                // updateUI(account);



            } catch (ApiException e) {

                // The ApiException status code indicates the detailed failure reason.
                // Please refer to the GoogleSignInStatusCodes class reference for more information.
                Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
                //updateUI(null);
                listener.onGoogleFailure("Connexion impossible avec Google");
            }
        }

//        else if (resultCode != 0) {
//            callbackManager.onActivityResult(requestCode, resultCode, data);
//        }
    }

    public void firebaseAuthWithGoogle(GoogleSignInAccount account, final FirebaseAuth auth, final onLoginFinishedListener listener) {

        Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);

            auth.signInWithCredential(credential)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "signInWithCredential:success");
                                FirebaseUser user = auth.getCurrentUser();
                                listener.onGoogleSuccess();
    //                            updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithCredential:failure", task.getException());
                                listener.onGoogleFailure("Connexion impossible avec Google");

                            }

                        }
                    });

    }

    @Override
    public void onClickFacebook(LoginButton facebookButton, CallbackManager callbackManager, final onLoginFinishedListener listener) {

        this.callbackManager = callbackManager;
        facebookButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "facebook:onSuccess:" + loginResult);
                listener.onFacebookSuccess();
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "facebook:onCancel");
                listener.onFacebookCancel("Connexion à facebook annulé");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "facebook:onError", error);
                listener.onGoogleFailure("Erreur de connexion à Facebook");
            }
        });
//        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//
//
//            @Override
//            public void onCancel() {
//                }
//
//            @Override
//            public void onError(FacebookException error) {
//                }
//        });

    }

}





