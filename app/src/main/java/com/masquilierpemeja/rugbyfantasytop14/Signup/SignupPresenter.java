package com.masquilierpemeja.rugbyfantasytop14.Signup;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Pierre on 11/11/2017.
 */

public interface SignupPresenter {

   void onClickSignUp(String mail, String password, FirebaseAuth auth);


}
