package com.masquilierpemeja.rugbyfantasytop14.Signup;

/**
 * Created by Pierre on 11/11/2017.
 */

public interface SignupView {

    void isEmptyMail(String message);
    void isEmptyPassword(String message);
    void isTooShortPassword(String message);
    void signupIsSuccessful(String message);
    void signupFailed(String message);
    SignupPresenterImpl getSignupPresenter();

}
