package com.masquilierpemeja.rugbyfantasytop14.RejoindreChampionnat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.masquilierpemeja.rugbyfantasytop14.R;

import java.util.ArrayList;

public class RejoindreChampionnatActivity extends AppCompatActivity implements RejoindreChampionnatView {

    DatabaseReference myRef;
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
//                mRejoindreChampionnatPresenter.rejoindreChampionnat();
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

    }

    @Override
    public void showAlert(String message) {

    }

    public void listerChampionnat(){

    }
}
