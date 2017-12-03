package com.masquilierpemeja.rugbyfantasytop14.PageChampionnat;

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
        /** championnat = (Championnat) getIntent().getSerializableExtra("EXTRA_UN_CHAMPIONNAT");

        tvTitreChampionnat = (TextView) findViewById(R.id.tv_titre_championnat);
        tvTitreChampionnat.setText("Bienvenue dans le championnat " + championnat.getNomChamp()); **/
    }
}
