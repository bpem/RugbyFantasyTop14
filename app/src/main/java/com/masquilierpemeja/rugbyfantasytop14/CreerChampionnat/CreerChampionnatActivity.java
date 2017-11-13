package com.masquilierpemeja.rugbyfantasytop14.CreerChampionnat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import com.masquilierpemeja.rugbyfantasytop14.R;
import com.masquilierpemeja.rugbyfantasytop14.RejoindreChampionnat.RejoindreChampionnatActivity;
import com.masquilierpemeja.rugbyfantasytop14.MenuPrincipal.*;

public class CreerChampionnatActivity extends AppCompatActivity implements CreerChampionnatView, CompoundButton.OnCheckedChangeListener {

    private EditText edNomChampionnat;
    private EditText edMotDePasse;
    private Button btnCreerChampionnat;
    private ProgressBar pbLoad;
    private Switch swEstPublic;
    private Spinner spNombreDeJoueur;
    private ArrayAdapter<Integer> adapter;

    private CreerChampionnatPresenter mCreerChampionnatPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_chamionnat);


        mCreerChampionnatPresenter = new CreerChampionnatPresenterImpl(this);

        edNomChampionnat = (EditText) findViewById(R.id.ed_nom_championnat);
        edMotDePasse = (EditText) findViewById(R.id.ed_mot_de_passe);
        btnCreerChampionnat = (Button) findViewById(R.id.btn_creer_championnat);
        pbLoad = (ProgressBar) findViewById(R.id.pb_load);
        swEstPublic = (Switch) findViewById(R.id.sw_est_public);
        if (swEstPublic != null) {
            swEstPublic.setOnCheckedChangeListener(this);
        }

        spNombreDeJoueur = (Spinner) findViewById(R.id.sp_nombre_de_joueur);
        if (spNombreDeJoueur != null) {
            String[] array = getResources().getStringArray(R.array.nombre_de_joueur);
            Integer[] intArray = new Integer[array.length];
            for(int i = 0; i < array.length; i++) {
                intArray[i] = Integer.parseInt(array[i]);
            }

            adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, intArray);
            spNombreDeJoueur.setAdapter(adapter);
        }

        btnCreerChampionnat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCreerChampionnatPresenter.creerChampionnat(edNomChampionnat.getText().toString().trim(), swEstPublic.isChecked(), (Integer) spNombreDeJoueur.getSelectedItem(), edMotDePasse.getText().toString().trim());
            }
        });
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            edMotDePasse.setVisibility(View.VISIBLE);
        }
        else{
            edMotDePasse.setVisibility(View.GONE);
        }
    }

    @Override
    public void showProgress() {
        pbLoad.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbLoad.setVisibility(View.GONE);
    }

    @Override
    public void setNomChampionnatError() {
        edNomChampionnat.setError("Nom du championnat vide !");
    }

    public void setMotDePasseError() {
        edMotDePasse.setError("Mot de passe vide !");
    }

    @Override
    public void navigateToRejoindreChampionnat() {
        startActivity(new Intent(CreerChampionnatActivity.this, RejoindreChampionnatActivity.class));
    }

    @Override
    public void navigateToMenuPrincipal() {
        startActivity(new Intent(CreerChampionnatActivity.this, MenuPrincipalActivity.class));
    }

    @Override
    public void showAlert(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCreerChampionnatPresenter.onDestroy();
    }


}
