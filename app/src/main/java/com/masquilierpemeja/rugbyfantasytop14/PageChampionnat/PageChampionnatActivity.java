package com.masquilierpemeja.rugbyfantasytop14.PageChampionnat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.Championnat;
import com.masquilierpemeja.rugbyfantasytop14.R;

public class PageChampionnatActivity extends AppCompatActivity implements PageChampionnatView{

    TextView tvTitreChampionnat;
    Championnat championnat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_championnat);

        Intent intent = getIntent();

        championnat = new Championnat(intent.getExtras().getString("EXTRA_CHAMPIONNAT_KEY"),
                intent.getExtras().getString("EXTRA_CHAMPIONNAT_NOM"),
                intent.getExtras().getString("EXTRA_CHAMPIONNAT_MDP"),
                intent.getExtras().getBoolean("EXTRA_CHAMPIONNAT_PRIVE"),
                intent.getExtras().getInt("EXTRA_CHAMPIONNAT_NBMAX")
                );


        tvTitreChampionnat = (TextView) findViewById(R.id.tv_titre_championnat);
        tvTitreChampionnat.setText("Bienvenue dans le championnat " + championnat.getNomChamp());
    }
}
