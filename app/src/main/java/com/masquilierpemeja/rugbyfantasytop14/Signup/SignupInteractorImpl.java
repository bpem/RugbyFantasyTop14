package com.masquilierpemeja.rugbyfantasytop14.Signup;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.masquilierpemeja.rugbyfantasytop14.*;

import java.util.List;

/**
 * Created by Pierre on 12/11/2017.
 */

public class SignupInteractorImpl implements SignupInteractor {
    @Override
    public void onClickSignup(String mail, String password, FirebaseAuth auth, final SignupInteractor.onSignupFinishedListener Listener) {

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
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        if (!task.isSuccessful()) {
                            Listener.signupIsSuccessful("Vous êtes maintenant enregistrés! ");
                                return;

                        } else {
                            Listener.signupFailed("L'enregistrement a échoué");
                        }
                    }
                });



    }
}
