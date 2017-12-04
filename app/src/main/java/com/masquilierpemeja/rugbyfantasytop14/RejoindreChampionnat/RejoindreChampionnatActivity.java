package com.masquilierpemeja.rugbyfantasytop14.RejoindreChampionnat;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.masquilierpemeja.rugbyfantasytop14.BottomNavigation.BottomNavigationActivity;
import com.masquilierpemeja.rugbyfantasytop14.CreerChampionnat.CreerChampionnatActivity;
import com.masquilierpemeja.rugbyfantasytop14.MenuPrincipal.MenuPrincipalActivity;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.Championnat;
import com.masquilierpemeja.rugbyfantasytop14.PageChampionnat.PageChampionnatFragment;
import com.masquilierpemeja.rugbyfantasytop14.R;

import java.io.Serializable;
import java.util.ArrayList;

public class RejoindreChampionnatActivity extends AppCompatActivity implements RejoindreChampionnatView, Serializable {

    ListView lvChampionnats;
    ArrayList<Championnat> desChampionnats = new ArrayList<>();
    private ArrayAdapter<Championnat> adapter;
    private RejoindreChampionnatPresenter mRejoindreChampionnatPresenter;
    EditText etMdpChampionnat;
    Button goToCreerChampionnat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejoindre_championnat);
        lvChampionnats = (ListView) findViewById(R.id.lv_championnats);
        goToCreerChampionnat = (Button) findViewById(R.id.btn_creer_championnat);
        mRejoindreChampionnatPresenter = new RejoindreChampionnatPresenterImpl(this);
        adapter = new ArrayAdapter<Championnat>(this, android.R.layout.simple_dropdown_item_1line, desChampionnats);
        mRejoindreChampionnatPresenter.listerChampionnat(lvChampionnats, adapter, desChampionnats);


        lvChampionnats.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    dialog(desChampionnats.get(position));
            }
        });

        goToCreerChampionnat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToCreerChampionnat();
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
    public void navigateToPageChampionnat(Championnat unChampionnat) {
        Intent intent = new Intent(this, BottomNavigationActivity.class);
        intent.putExtra("EXTRA_CHAMPIONNAT_NOM", unChampionnat.getNomChamp());
        intent.putExtra("EXTRA_CHAMPIONNAT_MDP", unChampionnat.getMdpChamp());
        intent.putExtra("EXTRA_CHAMPIONNAT_NBMAX", unChampionnat.getNbMaxChamp());
        intent.putExtra("EXTRA_CHAMPIONNAT_KEY", unChampionnat.getKeyChamp());
        intent.putExtra("EXTRA_CHAMPIONNAT_PRIVE", unChampionnat.getEstPrive());

        startActivity(intent);
    }

    @Override
    public void navigateToCreerChampionnat() {
            startActivity(new Intent(RejoindreChampionnatActivity.this, CreerChampionnatActivity.class));
    }

    @Override
    public void showAlert(String message) {

    }

    public void dialog(final Championnat unChampionnat){

        final View mView = getLayoutInflater().inflate(R.layout.dialog_rejoindre_championnat_prive,null);
        etMdpChampionnat = (EditText) mView.findViewById(R.id.et_mdp_championnat);
        if(unChampionnat.getEstPrive()){
            new AlertDialog.Builder(this)
                    .setTitle("Rejoindre un championnat")
                    .setMessage("Ce championnat est privé, voulez-vous le rejoindre ?")
                    .setView(mView)
                    .setNegativeButton("Non",null)
                    .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(etMdpChampionnat.getText().toString().equals(unChampionnat.getMdpChamp().toString())){
                                mRejoindreChampionnatPresenter.rejoindreChampionnat(unChampionnat.getKeyChamp());
                                navigateToPageChampionnat(unChampionnat);
                                Toast.makeText(getApplicationContext(), "Vous avez rejoint le championnat " + unChampionnat.getNomChamp(), Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "Mauvais mot de passe", Toast.LENGTH_SHORT).show();

                            }
                        }
                    }).create().show();
        }
        else{
            new AlertDialog.Builder(this)
                    .setTitle("Rejoindre un championnat")
                    .setMessage("Voulez-vous rejoindre ce championnat ?")
                    .setNegativeButton("Non",null)
                    .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mRejoindreChampionnatPresenter.rejoindreChampionnat(unChampionnat.getKeyChamp());
                            navigateToPageChampionnat(unChampionnat);
                            Toast.makeText(getApplicationContext(), "Vous avez rejoint le championnat" + unChampionnat.getNomChamp(), Toast.LENGTH_SHORT).show();
                        }
                    }).create().show();
        }
    }
}

