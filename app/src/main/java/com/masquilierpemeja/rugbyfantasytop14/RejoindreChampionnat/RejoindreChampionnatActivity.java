package com.masquilierpemeja.rugbyfantasytop14.RejoindreChampionnat;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.masquilierpemeja.rugbyfantasytop14.PageChampionnat.PageChampionnatActivity;
import com.masquilierpemeja.rugbyfantasytop14.R;

import java.util.ArrayList;

public class RejoindreChampionnatActivity extends AppCompatActivity implements RejoindreChampionnatView {

    ListView lvChampionnats;
    ArrayList<String> desChampionnats = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private RejoindreChampionnatPresenter mRejoindreChampionnatPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejoindre_championnat);
        lvChampionnats = (ListView) findViewById(R.id.lv_championnats);
        mRejoindreChampionnatPresenter = new RejoindreChampionnatPresenterImpl(this);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, desChampionnats);
        mRejoindreChampionnatPresenter.listerChampionnat(lvChampionnats, adapter, desChampionnats);

        lvChampionnats.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dialog();
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
    public void setMotDePasseError() {

    }

    @Override
    public void navigateToMain() {

    } @Override

    public void navigateToPageChampionnat() {
        startActivity(new Intent(RejoindreChampionnatActivity.this, PageChampionnatActivity.class));
    }

    @Override
    public void showAlert(String message) {

    }

    public void dialog(){
        new AlertDialog.Builder(this)
                .setTitle("Rejoindre un championnat")
                .setMessage("Voulez-vous rejoindre ce championnat ?")
                .setNegativeButton("Non",null)
                .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        navigateToPageChampionnat();
                        Toast.makeText(getApplicationContext(), "Vous avez rejoint le championnat", Toast.LENGTH_SHORT).show();
                    }
                }).create().show();
    }
}
