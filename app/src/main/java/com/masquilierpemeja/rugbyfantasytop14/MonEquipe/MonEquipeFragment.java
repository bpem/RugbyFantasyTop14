package com.masquilierpemeja.rugbyfantasytop14.MonEquipe;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
    Button boutonCourant;
    View mView;
    View mViewDiaglog;


    public MonEquipeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        mView = inflater.inflate(R.layout.fragment_mon_equipe, container, false);
        mViewDiaglog = getLayoutInflater().inflate(R.layout.dialog_ajouter_joueur_compo,null);
        findViewButton(mView);
        uneListeView = (ListView) mViewDiaglog.findViewById(R.id.lv_joueurs_by_poste);
        adapter = new ArrayAdapter<Joueur>(mViewDiaglog.getContext(), android.R.layout.simple_dropdown_item_1line, desJoueurs);



        mMonEquipePresenter = new MonEquipePresenterImpl(this);



        btnPilierG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boutonCourant = btnPilierG;
                if(!desJoueurs.isEmpty())
                {
                    desJoueurs.clear();
                }
                mMonEquipePresenter.getJoueurByPoste("Pilier", uneListeView,adapter,desJoueurs);
                dialog(mViewDiaglog);
            }
        });


        btnTalonneur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boutonCourant = btnTalonneur;
                if(!desJoueurs.isEmpty())
                {
                    desJoueurs.clear();
                }
                mMonEquipePresenter.getJoueurByPoste("Talonneur", uneListeView,adapter,desJoueurs);
                dialog(mViewDiaglog);
            }
        });

        btnPilierD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boutonCourant = btnPilierD;
                if(!desJoueurs.isEmpty())
                {
                    desJoueurs.clear();
                }
                mMonEquipePresenter.getJoueurByPoste("Pilier", uneListeView,adapter,desJoueurs);
                dialog(mViewDiaglog);
            }
        });

        btn2ndLigne1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boutonCourant = btn2ndLigne1;
                if(!desJoueurs.isEmpty())
                {
                    desJoueurs.clear();
                }
                mMonEquipePresenter.getJoueurByPoste("2nd ligne", uneListeView,adapter,desJoueurs);
                dialog(mViewDiaglog);
            }
        });

        btn2ndLigne2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boutonCourant = btn2ndLigne2;
                if(!desJoueurs.isEmpty())
                {
                    desJoueurs.clear();
                }
                mMonEquipePresenter.getJoueurByPoste("2nd ligne", uneListeView,adapter,desJoueurs);
                dialog(mViewDiaglog);
            }
        });

        btn3emeLigneG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boutonCourant = btn3emeLigneG;
                if(!desJoueurs.isEmpty())
                {
                    desJoueurs.clear();
                }
                mMonEquipePresenter.getJoueurByPoste("3ème ligne", uneListeView,adapter,desJoueurs);
                dialog(mViewDiaglog);
            }
        });

        btn3emeLigneC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boutonCourant = btn3emeLigneC;
                        if(!desJoueurs.isEmpty())
                        {
                            desJoueurs.clear();
                        }
                        mMonEquipePresenter.getJoueurByPoste("3ème ligne", uneListeView,adapter,desJoueurs);
                        dialog(mViewDiaglog);
                    }
                });

        btn3emeLigneD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boutonCourant = btn3emeLigneD;
                        if(!desJoueurs.isEmpty())
                        {
                            desJoueurs.clear();
                        }
                        mMonEquipePresenter.getJoueurByPoste("3ème ligne", uneListeView,adapter,desJoueurs);
                        dialog(mViewDiaglog);
                    }
                });

        btnDemiDeMelee.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boutonCourant = btnDemiDeMelee;
                        if(!desJoueurs.isEmpty())
                        {
                            desJoueurs.clear();
                        }
                        mMonEquipePresenter.getJoueurByPoste("Demi de mélée", uneListeView,adapter,desJoueurs);
                        dialog(mViewDiaglog);
                    }
                });

        btnDemiDOuverture.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boutonCourant = btnDemiDOuverture;
                        if(!desJoueurs.isEmpty())
                        {
                            desJoueurs.clear();
                        }
                        mMonEquipePresenter.getJoueurByPoste("Demi d'ouverture", uneListeView,adapter,desJoueurs);
                        dialog(mViewDiaglog);
                    }
                });

        btnCentre1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boutonCourant = btnCentre1;
                if(!desJoueurs.isEmpty())
                {
                    desJoueurs.clear();
                }
                mMonEquipePresenter.getJoueurByPoste("Centre", uneListeView,adapter,desJoueurs);
                dialog(mViewDiaglog);
            }
        });

        btnCentre2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boutonCourant = btnCentre2;
                if(!desJoueurs.isEmpty())
                {
                    desJoueurs.clear();
                }
                mMonEquipePresenter.getJoueurByPoste("Centre", uneListeView,adapter,desJoueurs);
                dialog(mViewDiaglog);
            }
        });

        btnAilierG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boutonCourant = btnAilierG;
                if(!desJoueurs.isEmpty())
                {
                    desJoueurs.clear();
                }
                mMonEquipePresenter.getJoueurByPoste("Ailier", uneListeView,adapter,desJoueurs);
                dialog(mViewDiaglog);
            }
        });

        btnAilierD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boutonCourant = btnAilierD;
                if(!desJoueurs.isEmpty())
                {
                    desJoueurs.clear();
                }
                mMonEquipePresenter.getJoueurByPoste("Ailier", uneListeView,adapter,desJoueurs);
                dialog(mViewDiaglog);
            }
        });

        btnArriere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boutonCourant = btnArriere;
                if(!desJoueurs.isEmpty())
                {
                    desJoueurs.clear();
                }
                mMonEquipePresenter.getJoueurByPoste("Arrière", uneListeView,adapter,desJoueurs);
                dialog(mViewDiaglog);
            }
        });

        uneListeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                boutonCourant.setText(desJoueurs.get(position).toString());
                boutonCourant.setTextSize(12);
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


    public void dialog(final View mViewDiaglog)
    {
        new AlertDialog.Builder(mViewDiaglog.getContext())
                .setTitle("Quel joueur voulez-vous ajouter ?")
                .setView(mViewDiaglog)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((ViewGroup)mViewDiaglog.getParent()).removeView(mViewDiaglog);

                    }
                })
                .create().show();

    }


}
