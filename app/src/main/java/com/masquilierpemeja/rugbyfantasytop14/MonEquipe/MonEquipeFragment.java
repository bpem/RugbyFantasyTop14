package com.masquilierpemeja.rugbyfantasytop14.MonEquipe;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.masquilierpemeja.rugbyfantasytop14.BottomNavigation.BottomNavigationActivity;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.Joueur;
import com.masquilierpemeja.rugbyfantasytop14.Profil.ProfilPresenter;
import com.masquilierpemeja.rugbyfantasytop14.R;

import java.util.ArrayList;
import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * A simple {@link Fragment} subclass.
 */
public class MonEquipeFragment extends Fragment implements MonEquipeView{

    private MonEquipePresenter mMonEquipePresenter;
    Button btnPilierG, btnPilierD, btnTalonneur, btn2ndLigne1, btn2ndLigne2, btn3emeLigneG,
            btn3emeLigneC, btn3emeLigneD, btnDemiDeMelee, btnDemiDOuverture, btnCentre1, btnCentre2,
            btnAilierG, btnArriere, btnAilierD;
    ListView uneListeView;
    ArrayList<Joueur> desJoueurs = new ArrayList<>();
    private ArrayAdapter<Joueur> adapter;



    public MonEquipeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View mView = inflater.inflate(R.layout.fragment_mon_equipe, container, false);
        final View mViewDiaglog = getLayoutInflater().inflate(R.layout.dialog_ajouter_joueur_compo,null);
        findViewButton(mView);
        uneListeView = (ListView) mViewDiaglog.findViewById(R.id.lv_joueurs_by_poste);
        adapter = new ArrayAdapter<Joueur>(mViewDiaglog.getContext(), android.R.layout.simple_dropdown_item_1line, desJoueurs);


        mMonEquipePresenter = new MonEquipePresenterImpl(this);

        btnPilierG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMonEquipePresenter.getJoueurByPoste("Pilier", uneListeView,adapter,desJoueurs);
                /** new AlertDialog.Builder(mViewDiaglog.getContext())
                        .setTitle("Quel joueur voulez-vous ajouter ?")
                        .setView(mViewDiaglog)
                        .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Vous avez rejoint le championnat ", Toast.LENGTH_SHORT).show();
                            }
                        }).create().show(); **/
            }
        });

        // Inflate the layout for this fragment
        return mView;
    }


    /**
     * Créer une équipe de base de test
     */
    public void getListeJoueurs(){
        mMonEquipePresenter.creerEquipe();
    }

    public void findViewButton(View mView){
        btnPilierG = (Button) mView.findViewById(R.id.btn_pilierG);
        btnPilierD = (Button) mView.findViewById(R.id.btn_pilierD);
        btnTalonneur = (Button) mView.findViewById(R.id.btn_talonneur);
        btn2ndLigne1 = (Button) mView.findViewById(R.id.btn_2nd_ligne1);
        btn2ndLigne2 = (Button) mView.findViewById(R.id.btn_2nd_ligne2);
        btn3emeLigneG = (Button) mView.findViewById(R.id.btn_3eme_ligneG);
        btn3emeLigneC = (Button) mView.findViewById(R.id.btn_3eme_ligneC);
        btn3emeLigneD = (Button) mView.findViewById(R.id.btn_3eme_ligneD);
        btnDemiDeMelee = (Button) mView.findViewById(R.id.btn_demi_de_melee);
        btnDemiDOuverture = (Button) mView.findViewById(R.id.btn_demi_d_ouverture);
        btnCentre1 = (Button) mView.findViewById(R.id.btn_centre1);
        btnCentre2 = (Button) mView.findViewById(R.id.btn_centre2);
        btnAilierG = (Button) mView.findViewById(R.id.btn_ailierG);
        btnArriere = (Button) mView.findViewById(R.id.btn_arriere);
        btnAilierD = (Button) mView.findViewById(R.id.btn_ailierD);
    }

    @Override
    public void sendListeJoueurByPoste(List<Joueur> joueurs) {
        final View mView = getLayoutInflater().inflate(R.layout.dialog_ajouter_joueur_compo,null);
        new AlertDialog.Builder(getContext())
                .setTitle("Rejoindre un championnat")
                .setMessage("Ce championnat est privé, voulez-vous le rejoindre ?")
                .setView(mView)
                .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), "Vous avez rejoint le championnat ", Toast.LENGTH_SHORT).show();
                    }
                }).create().show();
    }
}
