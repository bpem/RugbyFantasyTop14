package com.masquilierpemeja.rugbyfantasytop14.MenuPrincipalActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.masquilierpemeja.rugbyfantasytop14.CreerChampionnat.CreerChampionnatActivity;
import com.masquilierpemeja.rugbyfantasytop14.R;
import com.masquilierpemeja.rugbyfantasytop14.RejoindreChampionnat.RejoindreChampionnatActivity;

public class MenuPrincipalActivity extends AppCompatActivity implements MenuPrincipalView{

    Button btnGoToMonProfil, btnGoToCreerChampionnat, btnGoToRejoindreChampionnat, btnDeconnexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btnGoToMonProfil = (Button) findViewById(R.id.btn_go_to_mon_profil);
        btnGoToCreerChampionnat = (Button) findViewById(R.id.btn_go_to_creer_championnat);
        btnGoToRejoindreChampionnat = (Button) findViewById(R.id.btn_go_to_rejoindre_championnat);
        btnDeconnexion = (Button) findViewById(R.id.btn_deconnexion);

        btnGoToCreerChampionnat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToCreerChampionnat();
            }
        });

        btnGoToRejoindreChampionnat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToRejoindreChampionnat();
            }
        });


    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void navigateToRejoindreChampionnat() {
        startActivity(new Intent(MenuPrincipalActivity.this, RejoindreChampionnatActivity.class));
    }

    @Override
    public void navigateToCreerChampionnat() {
        startActivity(new Intent(MenuPrincipalActivity.this, CreerChampionnatActivity.class));
    }

    @Override
    public void navigateToMonProfil() {

    }

    @Override
    public void showAlert(String message) {

    }
}
