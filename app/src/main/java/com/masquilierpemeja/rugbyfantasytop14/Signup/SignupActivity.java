package com.masquilierpemeja.rugbyfantasytop14.Signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.masquilierpemeja.rugbyfantasytop14.Login.LoginActivity;
import com.masquilierpemeja.rugbyfantasytop14.Login.LoginPresenterImpl;
import com.masquilierpemeja.rugbyfantasytop14.Login.LoginView;
import com.masquilierpemeja.rugbyfantasytop14.MainActivity;
import com.masquilierpemeja.rugbyfantasytop14.R;

public class SignupActivity extends AppCompatActivity implements SignupView {

    private EditText inputEmail, inputPassword;
    private Button btnSignIn, btnSignUp, btnResetPassword;
    private ProgressBar progressBar;
    private SignupPresenterImpl mSignupPresenter;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        auth = FirebaseAuth.getInstance();
        btnSignIn = (Button) findViewById(R.id.sign_in_button);
        btnSignUp = (Button) findViewById(R.id.sign_up_button);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnResetPassword = (Button) findViewById(R.id.btn_reset_password);


        // bouton s'enregistrer
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSignupPresenter().onClickSignUp(inputEmail.getText().toString().trim(), inputPassword.getText().toString().trim(), auth);
            }
        });



        // Bouton qui fait revenir à la page d'authentification
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });
    }

    public SignupPresenterImpl getSignupPresenter() {
        if (mSignupPresenter == null) mSignupPresenter = new SignupPresenterImpl( this);
        return mSignupPresenter;
    }

    @Override
    public void isEmptyMail(String message) {
        Toast.makeText(SignupActivity.this , message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void isEmptyPassword(String message) {
        Toast.makeText(SignupActivity.this , message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void isTooShortPassword(String message) {
        Toast.makeText(SignupActivity.this , message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void signupIsSuccessful(String message) {
        Toast.makeText(SignupActivity.this , message, Toast.LENGTH_LONG).show();
        startActivity(new Intent(SignupActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void signupFailed(String message) {
        Toast.makeText(SignupActivity.this , message, Toast.LENGTH_LONG).show();

    }
}
