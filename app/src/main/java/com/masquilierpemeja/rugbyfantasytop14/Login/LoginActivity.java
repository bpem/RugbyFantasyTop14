package com.masquilierpemeja.rugbyfantasytop14.Login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.auth.FirebaseAuth;
import com.masquilierpemeja.rugbyfantasytop14.MainActivity;
import com.masquilierpemeja.rugbyfantasytop14.R;
import com.masquilierpemeja.rugbyfantasytop14.Signup.SignupActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {


    private EditText inputEmail, inputPassword;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private Button btnSignup, btnLogin, btnReset, signupButton;
    private GoogleSignInClient mGoogleSignInClient;
    private SignInButton googleButton;
    private LoginButton facebookButton;
    private LoginPresenterImpl mLoginPresenter;


    private CallbackManager callbackManager;
    private static final int RC_SIGN_IN = 2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FacebookSdk.sdkInitialize(getApplicationContext());

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        initializeControl();


        // Une fois que l'utilisateur a enregistré ses informations de conenxion,
        // on récupère l'objet mLoginPresenter qui va s'occuper de gérer
        // les évènements possibles avec ce mail et ce password
        // (ex : pas de mail rentré, pas de password rentré, connexion failed, connexion success
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getLoginPresenter().onCompleteMailPassword(inputEmail.getText().toString(),inputPassword.getText().toString(),auth);
            }
        });

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });

        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                callbackManager = CallbackManager.Factory.create();
                facebookButton.setReadPermissions("email", "public_profile");
                getLoginPresenter().onClickFacebook(facebookButton, callbackManager);
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });


    }

    public LoginPresenterImpl getLoginPresenter() {
        if (mLoginPresenter == null) mLoginPresenter = new LoginPresenterImpl(this);
        return mLoginPresenter;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        getLoginPresenter().onActivityResult(requestCode, resultCode, data);


        // NE PAS OUBLIER DE REMETTRE UNE CONDITION
        //callbackManager.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public Context getContext() {
        return this;
    }


    private void initializeControl(){

        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnSignup = (Button) findViewById(R.id.btn_signup);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnReset = (Button) findViewById(R.id.btn_reset_password);
        googleButton = (SignInButton) findViewById(R.id.sign_in_button_google);
        facebookButton = (LoginButton) findViewById(R.id.sign_in_button_facebook);
        signupButton = (Button) findViewById(R.id.btn_signup);


    }

    @Override
    public void signInMail() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setMailError(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordError(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void setOnFailure(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void setOnFailureGoogle(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setOnFacebookCancel(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setOnFacebookError(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAlert(String message) {

    }

    @Override
    public void navigateToMain() {

        Toast.makeText(getApplicationContext(), "onSuccess", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);

    }
}
