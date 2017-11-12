package com.masquilierpemeja.rugbyfantasytop14.MotDePasseOublie;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Pierre on 12/11/2017.
 */

public interface MotDePasseOublieInteractor {

    interface onMotDePasseOublieFinishedListener {

        void isEmptyEmail(String message);
        void registrationSucced(String message);
        void registrationUnsucced(String message);

    }

    void resetPassword(String email, FirebaseAuth auth, onMotDePasseOublieFinishedListener listener);

}
