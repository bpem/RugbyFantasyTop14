package com.masquilierpemeja.rugbyfantasytop14.Signup;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.DatabaseManagerUser;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.User;

/**
 * Created by Pierre on 12/11/2017.
 */

public class SignupInteractorImpl implements SignupInteractor {

    // success : ajout d'un utilisateur à la database
    private Boolean success = true;
    private DatabaseManagerUser db;
    private FirebaseAuth globalAuth;
    @Override
    public void onClickSignup(final String mail, String password, FirebaseAuth auth, final SignupInteractor.onSignupFinishedListener Listener) {


        globalAuth = auth;
        if (TextUtils.isEmpty(mail)) {
            Listener.isEmptyMail("Veuillez rentrer une adresse mail");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Listener.isEmptyPassword("Veuillez rentrer un mot de passe");
            return;
        }

        if (password.length() < 6) {
            Listener.isTooShortPassword("Veuillez rentrer un mot de passe d'au moins 6 caractères");
            return;
        }

        auth.createUserWithEmailAndPassword(mail, password)
                // LISTENER DU SUCCESS DE L'ENREGISTREMENT VIA L'ADRESSE MAIL
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        if (addUserOnDatabse(mail)){

                            Listener.signupIsSuccessful("Vous êtes maintenant enregistrés! ");
                            return;
                        }
                        else {

                            Listener.signupFailed("L'enregistrement a échoué");
                            return;
                        }
                    }
                })

                // LISTENER DU FAILURE DE L'ENREGISTREMENT VIA L'ADRESSE MAIL
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("addUserwithMailAdress", "FAILURE");
                        Listener.signupFailed("L'enregistrement a échoué");
                        return;
                    }
                });
    }

    // AJOUTE L'UTILISATEUR A LA DATABASE
    // RENVOI TRUE SI L'AJOUT A FONCTIONNE
    public boolean addUserOnDatabse(final String email){
        db = DatabaseManagerUser.getInstance();
        FirebaseUser currentFirebaseUser = globalAuth.getCurrentUser() ;
        String currentFirebaseUserID = currentFirebaseUser.getUid();
        db.setUserOnDatabase(new User(email, currentFirebaseUserID, false,""))
                .addOnSuccessListener
                        (new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.i("addUserOnDatabse", "SUCCESS");
                                success = true;
                            }
                        })
                .addOnFailureListener
                        (new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.i("addUserOnDatabse", "FAILURE");
                                success = false;
                            }
                        });
        return success;
    }
}
