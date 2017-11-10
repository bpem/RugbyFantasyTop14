package com.masquilierpemeja.rugbyfantasytop14.Championnat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.masquilierpemeja.rugbyfantasytop14.MainActivity;
import com.masquilierpemeja.rugbyfantasytop14.R;

public class CreerChampionnatActivity extends AppCompatActivity implements CreerChampionnatView{

    private EditText edNomChampionnat;
    private Button btnCreerChampionnat;
    private ProgressBar pbLoad;

    private CreerChampionnatPresenter mCreerChampionnatPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_chamionnat);


        mCreerChampionnatPresenter = new CreerChampionnatPresenterImpl(this);

        edNomChampionnat = (EditText) findViewById(R.id.ed_nom_championnat);
        btnCreerChampionnat = (Button) findViewById(R.id.btn_creer_championnat);
        pbLoad = (ProgressBar) findViewById(R.id.pb_load);

        btnCreerChampionnat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCreerChampionnatPresenter.creerChampionnat(edNomChampionnat.getText().toString().trim());
            }
        });
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

    @Override
    public void navigateToMain() {
        startActivity(new Intent(CreerChampionnatActivity.this, MainActivity.class));
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
