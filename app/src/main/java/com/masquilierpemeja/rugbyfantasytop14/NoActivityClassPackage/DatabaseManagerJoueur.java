package com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage;

import android.util.Log;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bastienpemeja on 03/12/2017.
 */

public class DatabaseManagerJoueur {
    //////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////VARIABLES DE CLASSES///////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////

    // NOM DU NOEUD USER DANS FIREBASE
    private final static String JOUEURS = "Joueur";
    private DatabaseManagerJoueur.Reference ref;
    private Joueur joueur;
    private static DatabaseManagerJoueur INSTANCE = new DatabaseManagerJoueur();
    private Boolean isJoueurExist;


    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////CONSTRUCTEURS//////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////


    private DatabaseManagerJoueur()
    {
        ref = new DatabaseManagerJoueur.Reference();
    }


    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////FONCTIONS/////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////


    public void getJoueurOnDatabase(final String uid, final DatabaseManagerJoueur.Result<Joueur> result)
    {
        ref.joueurs.child(uid).addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                Joueur uneJoueur = new Joueur(
                        // STUFF TO DO
                );
                if (true) {
                    result.onSuccess(uneJoueur);
                } else {
                    result.onFailure();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                result.onError(databaseError);
            }
        });
    }


    public void getListOfJoueurOnDatabase(final DatabaseManagerJoueur.Result<List<Joueur>> result){
        ref.joueurs.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                ArrayList<Joueur> listJoueurs = new ArrayList<Joueur>() ;
                for (DataSnapshot dt : dataSnapshot.getChildren()){
                    Joueur unJoueur = dt.getValue(Joueur.class);
                    listJoueurs.add(unJoueur);
                }
                result.onSuccess(listJoueurs);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void isJoueurExist(final String uid, final DatabaseManagerUser.ResultBoolean<Boolean> resultBoolean){

        ref.joueurs.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    resultBoolean.onSuccess(true);
                }
                else {
                    resultBoolean.onSuccess(false);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


    public Task<Void> setUserOnDatabase(final Joueur joueur)
    {
        return ref.joueurs.child(joueur.getKeyJoueur()).setValue(joueur);
    }




    public void creerDesJoueurs() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference(JOUEURS);
        final DatabaseManagerEquipeTop14 dbTop14;
            for (int i = 0; i < 13; i++) {
                String keyEquipe = myRef.push().getKey();
                if (i == 0) {
                    myRef.child(keyEquipe).child("nom").setValue("Parra");
                    myRef.child(keyEquipe).child("prenom").setValue("Morgan");
                    myRef.child(keyEquipe).child("keyEquipe").setValue("-L-UEIuChbcqrDUaZMlw"); // ASM
                    myRef.child(keyEquipe).child("poste").setValue("Demi de mélée");
                    myRef.child(keyEquipe).child("nationalite").setValue("France");
                }
                if (i == 1) {
                    myRef.child(keyEquipe).child("nom").setValue("Atonio");
                    myRef.child(keyEquipe).child("prenom").setValue("Uini");
                    myRef.child(keyEquipe).child("keyEquipe").setValue("-L-UEIuBAYpHlzhSZCA1"); // SR
                    myRef.child(keyEquipe).child("poste").setValue("Pilier");
                    myRef.child(keyEquipe).child("nationalite").setValue("France");
                }
                if (i == 2) {
                    myRef.child(keyEquipe).child("nom").setValue("Ruffenach");
                    myRef.child(keyEquipe).child("prenom").setValue("Romain");
                    myRef.child(keyEquipe).child("keyEquipe").setValue("-L-UEIu4DhrMNEqbHPVi"); // MHR
                    myRef.child(keyEquipe).child("poste").setValue("Talonneur");
                    myRef.child(keyEquipe).child("nationalite").setValue("France");
                }
                if (i == 3) {
                    myRef.child(keyEquipe).child("nom").setValue("Maestri");
                    myRef.child(keyEquipe).child("prenom").setValue("Yoann");
                    myRef.child(keyEquipe).child("keyEquipe").setValue("-L-UEIu9MfBK4dtXwdef"); //ST
                    myRef.child(keyEquipe).child("poste").setValue("2nd ligne");
                    myRef.child(keyEquipe).child("nationalite").setValue("France");
                }
                if (i == 4) {
                    myRef.child(keyEquipe).child("nom").setValue("Sanconnie");
                    myRef.child(keyEquipe).child("prenom").setValue("Fabien");
                    myRef.child(keyEquipe).child("keyEquipe").setValue("-L-UEIuE9x3jgwK7ixAn"); //CAB
                    myRef.child(keyEquipe).child("poste").setValue("Demi de mélée");
                    myRef.child(keyEquipe).child("nationalite").setValue("France");
                }
                if (i == 5) {
                    myRef.child(keyEquipe).child("nom").setValue("Jelonch");
                    myRef.child(keyEquipe).child("prenom").setValue("Anthony");
                    myRef.child(keyEquipe).child("keyEquipe").setValue("-L-UEIuDddt3DMGHF5Pw"); // CO
                    myRef.child(keyEquipe).child("poste").setValue("3ème ligne");
                    myRef.child(keyEquipe).child("nationalite").setValue("France");
                }
                if (i == 6) {
                    myRef.child(keyEquipe).child("nom").setValue("Grice");
                    myRef.child(keyEquipe).child("prenom").setValue("Rory");
                    myRef.child(keyEquipe).child("keyEquipe").setValue("-L-UVWvbCO5D3m8kaxRc"); //OYO
                    myRef.child(keyEquipe).child("poste").setValue("3ème ligne");
                    myRef.child(keyEquipe).child("nationalite").setValue("Nouvelle-Zélande");
                }
                if (i == 7) {
                    myRef.child(keyEquipe).child("nom").setValue("Slade");
                    myRef.child(keyEquipe).child("prenom").setValue("Colin");
                    myRef.child(keyEquipe).child("keyEquipe").setValue("-L-UEIuFeZnzvqzL57HB"); //SP
                    myRef.child(keyEquipe).child("poste").setValue("Demi d'ouverture");
                    myRef.child(keyEquipe).child("nationalite").setValue("Nouvelle-Zélande");
                }
                if (i == 8) {
                    myRef.child(keyEquipe).child("nom").setValue("Ducuing");
                    myRef.child(keyEquipe).child("prenom").setValue("Nans");
                    myRef.child(keyEquipe).child("keyEquipe").setValue("-L-UEIuE9x3jgwK7ixAo"); //UBB
                    myRef.child(keyEquipe).child("poste").setValue("Arrière");
                    myRef.child(keyEquipe).child("nationalite").setValue("France");
                }
                if (i == 9) {
                    myRef.child(keyEquipe).child("nom").setValue("Bastareaud");
                    myRef.child(keyEquipe).child("prenom").setValue("Mathieu");
                    myRef.child(keyEquipe).child("keyEquipe").setValue("-L-UEIuDddt3DMGHF5Pv"); //RCT
                    myRef.child(keyEquipe).child("poste").setValue("Centre");
                    myRef.child(keyEquipe).child("nationalite").setValue("France");
                }
                if (i == 10) {
                    myRef.child(keyEquipe).child("nom").setValue("WulfRudi");
                    myRef.child(keyEquipe).child("prenom").setValue("Rudi");
                    myRef.child(keyEquipe).child("keyEquipe").setValue("-L-UEIuGkTug3kZYe62T"); //LOU
                    myRef.child(keyEquipe).child("poste").setValue("Centre");
                    myRef.child(keyEquipe).child("nationalite").setValue("Nouvelle-Zélande");
                }
                if (i == 11) {
                    myRef.child(keyEquipe).child("nom").setValue("Tilsley");
                    myRef.child(keyEquipe).child("prenom").setValue("George");
                    myRef.child(keyEquipe).child("keyEquipe").setValue("-L-UEIuHevpEObE6_1xL"); // SUA
                    myRef.child(keyEquipe).child("poste").setValue("Ailier");
                    myRef.child(keyEquipe).child("nationalite").setValue("Nouvelle-Zélande");
                }
                if (i == 12) {
                    myRef.child(keyEquipe).child("nom").setValue("Arias");
                    myRef.child(keyEquipe).child("prenom").setValue("Julien");
                    myRef.child(keyEquipe).child("keyEquipe").setValue("-L-UEIuAKEXi_ZsUChoA"); // SF
                    myRef.child(keyEquipe).child("poste").setValue("Ailier");
                    myRef.child(keyEquipe).child("nationalite").setValue("France");
                }
                if (i == 13) {
                    myRef.child(keyEquipe).child("nom").setValue("Dulin");
                    myRef.child(keyEquipe).child("prenom").setValue("Brice");
                    myRef.child(keyEquipe).child("keyEquipe").setValue("-L-UEIuBAYpHlzhSZCA2"); //R92
                    myRef.child(keyEquipe).child("poste").setValue("Arrière");
                    myRef.child(keyEquipe).child("nationalite").setValue("France");
                }
        }
    }




    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////GETTER & SETTER///////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////


    public static DatabaseManagerJoueur getInstance()
    {
        return INSTANCE;
    }




    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////INNER CLASS //////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////

    private class Reference
    {
        private DatabaseReference database;
        private DatabaseReference joueurs;

        Reference()
        {
            database = FirebaseDatabase.getInstance().getReference();
            joueurs = database.child(JOUEURS);
        }
    }



    public static abstract class Result<T>
    {
        public void onComplete() {}

        public abstract void onSuccess(T t);

        public void onFailure()
        {
            onError(DatabaseError.fromException(new Exception("Data not found")));
        }

        public void onError(DatabaseError error)
        {
            Log.d("DATABASE ERROR", error.getMessage());
        };
    }

    public static abstract class ResultBoolean<Boolean>
    {
        public void onComplete() {}

        public abstract void onSuccess(Boolean bool);

        public void onFailure()
        {

        }


    }
}
