package com.masquilierpemeja.rugbyfantasytop14.Login;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.masquilierpemeja.rugbyfantasytop14.BottomNavigation.BottomNavigationActivity;
import com.masquilierpemeja.rugbyfantasytop14.MenuPrincipal.MenuPrincipalActivity;
import com.masquilierpemeja.rugbyfantasytop14.MotDePasseOublie.MotDePasseOublieActivity;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.Championnat;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.DatabaseManagerEquipeTop14;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.DatabaseManagerJoueur;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.DatabaseManagerUser;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.DatabaseManagerChampionnat;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.User;
import com.masquilierpemeja.rugbyfantasytop14.R;
import com.masquilierpemeja.rugbyfantasytop14.Signup.SignupActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {


    private EditText inputEmail, inputPassword;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private Button btnSignup, btnLogin, btnReset, signupButton;
    private GoogleSignInClient mGoogleSignInClient;
    private SignInButton googleButton;
   // private LoginButton facebookButton;
    private LoginPresenterImpl mLoginPresenter;
    DatabaseManagerUser db;
    DatabaseManagerChampionnat dbC;
    DatabaseManagerEquipeTop14 dbETop14;
    DatabaseManagerJoueur dbJ;



    private CallbackManager callbackManager;
    private static final int RC_SIGN_IN = 2;

    GoogleApiClient mGoogleApiClient ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



       // FacebookSdk.sdkInitialize(getApplicationContext());

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        initializeControl();

//        // Choose authentication providers
//        List<AuthUI.IdpConfig> providers = Arrays.asList(
//                new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build(),
//                new AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build());
//
//// Create and launch sign-in intent
//        startActivityForResult(
//                AuthUI.getInstance()
//                        .createSignInIntentBuilder()
//                        .setAvailableProviders(providers)
//                        .build(),
//                RC_SIGN_IN);

//        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setProviders(
//                AuthUI.FACEBOOK_PROVIDER,
//                AuthUI.GOOGLE_PROVIDER)
//                .build(),1);


        // Une fois que l'utilisateur a enregistré ses informations de conenxion,
        // on récupère l'objet mLoginPresenter qui va s'occuper de gérer
        // les évènements possibles avec ce mail et ce password
        // (ex : pas de mail rentré, pas de password rentré, connexion failed, connexion success
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getLoginPresenter().onCompleteMailPassword(inputEmail.getText().toString(),inputPassword.getText().toString(), auth);
            }
        });

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

//        mGoogleApiClient = new GoogleApiClient.Builder(this)
//                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
//                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });

/*        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                callbackManager = CallbackManager.Factory.create();
                facebookButton.setReadPermissions("email", "public_profile");
                getLoginPresenter().onClickFacebook(facebookButton, callbackManager);
            }
        });*/

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, MotDePasseOublieActivity.class));
            }
        });



    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        getLoginPresenter().onActivityResult(requestCode, resultCode, data, auth);


        // NE PAS OUBLIER DE REMETTRE UNE CONDITION
        //callbackManager.onActivityResult(requestCode, resultCode, data);
    }



    public LoginPresenterImpl getLoginPresenter() {
        if (mLoginPresenter == null) mLoginPresenter = new LoginPresenterImpl(this);
        return mLoginPresenter;
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
        //facebookButton = (LoginButton) findViewById(R.id.button_facebook_login);
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
    public void setOnFacebookSuccess(LoginResult loginResult) {
        AccessToken token = loginResult.getAccessToken();

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());

        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            navigateToMain();
                            return;
                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(LoginActivity.this, "Authentication Facebook failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

    @Override
    public void showAlert(String message) {

    }

    @Override
    public void navigateToMain() {
        Toast.makeText(getApplicationContext(), "onSuccess", Toast.LENGTH_LONG).show();
        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        db = DatabaseManagerUser.getInstance();
        dbC = DatabaseManagerChampionnat.getInstance();

        // Créer des joueurs et des équipes pour données de tests
        /**dbETop14 = DatabaseManagerEquipeTop14.getInstance();
        dbETop14.creerToutesLesEquipes();
        dbJ = DatabaseManagerJoueur.getInstance();
        dbJ.creerDesJoueurs();**/
        db.getUserOnDatabase(user.getUid(), new DatabaseManagerUser.Result<User>() {
            @Override
            public void onSuccess(User user) {
                if(user.getEstDansUnChampionnat() && user.getKeyChampionnat() != ""){

                    // Appeler getChampionnat avec DatabaseManagerChampionnat
                    dbC.getChampionnatOnDatabase(user.getKeyChampionnat(), new DatabaseManagerChampionnat.Result<Championnat>() {
                        @Override
                        public void onSuccess(Championnat championnat) {
                            Intent intent = new Intent(LoginActivity.this, BottomNavigationActivity.class);
                            intent.putExtra("EXTRA_CHAMPIONNAT_NOM", championnat.getNomChamp());
                            intent.putExtra("EXTRA_CHAMPIONNAT_MDP", championnat.getMdpChamp());
                            intent.putExtra("EXTRA_CHAMPIONNAT_NBMAX", championnat.getNbMaxChamp());
                            intent.putExtra("EXTRA_CHAMPIONNAT_KEY", championnat.getKeyChamp());
                            intent.putExtra("EXTRA_CHAMPIONNAT_PRIVE", championnat.getEstPrive());
                            startActivity(intent);
                        }
                    });
                }
                else{
                    Intent intent = new Intent(LoginActivity.this, MenuPrincipalActivity.class);
                    startActivity(intent);
                }
            }
        });
        Intent intent = new Intent(LoginActivity.this, MenuPrincipalActivity.class);
        startActivity(intent);
        finish();
    }
}
