package com.masquilierpemeja.rugbyfantasytop14.Profil;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.masquilierpemeja.rugbyfantasytop14.R;

public class ProfilActivity extends AppCompatActivity implements ProfilView{

    TextView tvNomUtilisateur;
    TextView txtvEmail;
    TextView txtvUid;
    ImageButton ibImageUtilisateur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        tvNomUtilisateur = findViewById(R.id.txtv_nom_utilisateur);
        ibImageUtilisateur = findViewById(R.id.ib_image_utilisateur);
        txtvEmail = findViewById(R.id.txtv_email);
        txtvUid = findViewById(R.id.txtv_uid);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String nom = user.getDisplayName();
            String mail = user.getEmail();
            String uid = user.getUid();
            Uri photoUrl = user.getPhotoUrl();

            tvNomUtilisateur.setText(nom);
            //ibImageUtilisateur.setImageURI(photoUrl);
            txtvEmail.setText(mail);
            txtvUid.setText(uid);
        }


    }
}
