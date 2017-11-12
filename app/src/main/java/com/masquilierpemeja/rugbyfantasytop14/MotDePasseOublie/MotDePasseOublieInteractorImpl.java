package com.masquilierpemeja.rugbyfantasytop14.MotDePasseOublie;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.masquilierpemeja.rugbyfantasytop14.*;

/**
 * Created by Pierre on 12/11/2017.
 */

public class MotDePasseOublieInteractorImpl implements MotDePasseOublieInteractor {

    @Override
    public void resetPassword(String email, FirebaseAuth auth, final onMotDePasseOublieFinishedListener listener) {

        if (TextUtils.isEmpty(email)) {
            listener.isEmptyEmail("Veuillez rentrer une adresse mail! ");
        }

        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                        listener.registrationSucced("L'enregistrement a bien été effectué !");

                        } else {
                           listener.registrationUnsucced("L'enregistrement a échoué :/");


                        }

                    }
                });



        }
}
