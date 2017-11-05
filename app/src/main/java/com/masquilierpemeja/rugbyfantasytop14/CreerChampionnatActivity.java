package com.masquilierpemeja.rugbyfantasytop14;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreerChampionnatActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    public String nomChampionnat;
    public boolean estPublic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_championnat);

        mDatabase = FirebaseDatabase.getInstance().getReference();

    }

    public CreerChampionnatActivity() {

    }

    public void oreerChampionnat_OnClick(String nomChamp, boolean estPub){
        mDatabase = FirebaseDatabase.getInstance().getReference();

        this.nomChampionnat = nomChamp;
        this.estPublic = estPub;

    }
}
