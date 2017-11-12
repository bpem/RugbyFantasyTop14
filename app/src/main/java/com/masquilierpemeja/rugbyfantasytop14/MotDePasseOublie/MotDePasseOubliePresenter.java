package com.masquilierpemeja.rugbyfantasytop14.MotDePasseOublie;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Pierre on 12/11/2017.
 */

public interface MotDePasseOubliePresenter {

    void resetPassword(String email,FirebaseAuth auth);

}
