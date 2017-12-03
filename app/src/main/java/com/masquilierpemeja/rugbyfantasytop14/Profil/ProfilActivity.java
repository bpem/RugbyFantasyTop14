package com.masquilierpemeja.rugbyfantasytop14.Profil;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.User;
import com.masquilierpemeja.rugbyfantasytop14.R;

public class ProfilActivity extends AppCompatActivity implements ProfilView{

    TextView tvNomUtilisateur;
    TextView txtvEmail;
    TextView txtvUid;
    ImageButton ibImageUtilisateur;
    ProfilPresenter mProfilPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        tvNomUtilisateur = findViewById(R.id.txtv_nom_utilisateur);
        ibImageUtilisateur = findViewById(R.id.ib_image_utilisateur);
        txtvEmail = findViewById(R.id.txtv_email);
        txtvUid = findViewById(R.id.txtv_uid);
        mProfilPresenter = new ProfilPresenterImpl(this);

        getUser();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String nom = user.getDisplayName();
            String mail = user.getEmail();
            String uid = user.getUid();
            Uri photoUrl = user.getPhotoUrl();


            tvNomUtilisateur.setText(nom);
            txtvEmail.setText(mail);
            txtvUid.setText(uid);
        }
    }


    public void getUser(){
        mProfilPresenter.getUserCourant();
    }

    @Override
    public void sendUser(User user) {
        Toast.makeText(this,"Yoolo" + user.getUserID(), Toast.LENGTH_LONG).show();
    }
}
