package com.masquilierpemeja.rugbyfantasytop14.MotDePasseOublie;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.masquilierpemeja.rugbyfantasytop14.Login.LoginActivity;
import com.masquilierpemeja.rugbyfantasytop14.MainActivity;
import com.masquilierpemeja.rugbyfantasytop14.R;

public class MotDePasseOublieActivity extends AppCompatActivity implements MotDePasseOublieView {


    private EditText inputEmail;
    private Button btnReset, btnBack;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private MotDePasseOubliePresenterImpl mMotDePasseOubliePresenterImpl;
    private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mot_de_passe_oublie);

        inputEmail = (EditText) findViewById(R.id.email);
        btnReset = (Button) findViewById(R.id.btn_reset_password);
        btnBack = (Button) findViewById(R.id.btn_back);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        auth = FirebaseAuth.getInstance();


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MotDePasseOublieActivity.this, LoginActivity.class));
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
       getMotDePasseOubliePresenterImpl().resetPassword(inputEmail.getText().toString().trim(),auth);

            }
        });

    }

    public MotDePasseOubliePresenterImpl getMotDePasseOubliePresenterImpl() {
        if (mMotDePasseOubliePresenterImpl == null) mMotDePasseOubliePresenterImpl= new MotDePasseOubliePresenterImpl(this);
        return mMotDePasseOubliePresenterImpl;
    }

    @Override
    public void isEmptyEmail(String message) {
        Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void motDePasseOublieSucced(String message) {
        Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void motDePasseOublieUnsucced(String message) {
        Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show();
    }


}
