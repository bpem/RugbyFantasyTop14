package com.masquilierpemeja.rugbyfantasytop14.Signup;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Pierre on 11/11/2017.
 */

public interface SignupInteractor {

    interface onSignupFinishedListener{
        void isEmptyMail(String message);
        void isEmptyPassword(String message);
        void isTooShortPassword(String message);
        void signupIsSuccessful(String message);
        void signupFailed(String message);

    }

    void onClickSignup(String mail, String password, FirebaseAuth auth , SignupInteractor.onSignupFinishedListener Listener);
}
