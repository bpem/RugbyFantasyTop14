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

public class DatabaseManagerEquipe {

    //////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////VARIABLES DE CLASSES///////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////

    // NOM DU NOEUD USER DANS FIREBASE
    private final static String EQUIPES = "Equipe";
    private DatabaseManagerEquipe.Reference ref;
    private Equipe equipe;
    private static DatabaseManagerEquipe INSTANCE = new DatabaseManagerEquipe();
    private Boolean isEquipeExist;
    private List<Joueur> uneListeJoueur;



    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////CONSTRUCTEURS//////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////


    private DatabaseManagerEquipe()
    {
        ref = new DatabaseManagerEquipe.Reference();
    }


    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////FONCTIONS/////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////


    public void getEquipeOnDatabase(final String uid, final DatabaseManagerEquipe.Result<Equipe> result)
    {
        ref.equipes.child(uid).addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                Equipe uneEquipe = new Equipe(
                        // DO STUFF
                );
                if (true) {
                    result.onSuccess(uneEquipe);
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

    public void getJoueurOnDatabaseByPoste(final String poste, final DatabaseManagerEquipe.Result<List<Joueur>> result)
    {
        ref.equipes.child(poste).addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                ArrayList<Joueur> listJoueurs = new ArrayList<Joueur>() ;

                for (DataSnapshot dt : dataSnapshot.getChildren()){
                        Joueur unJoueur = dt.getValue(Joueur.class);
                    if(unJoueur.getPoste().equals(poste)){
                        listJoueurs.add(unJoueur);
                    }

                }
                result.onSuccess(listJoueurs);

            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                result.onError(databaseError);
            }
        });
    }


    public void isEquipeExist(final String uid, final DatabaseManagerUser.ResultBoolean<Boolean> resultBoolean){

        ref.equipes.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
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


    public Task<Void> setUserOnDatabase(final Equipe equipe)
    {
        return ref.equipes.child(equipe.getKeyEquipe()).setValue(equipe);
    }


    public List<Joueur> creerListeEquipe(){
        uneListeJoueur = new ArrayList<Joueur>();
        return uneListeJoueur;
    }


    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////GETTER & SETTER///////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////


    public static DatabaseManagerEquipe getInstance()
    {
        return INSTANCE;
    }




    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////INNER CLASS //////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////

    private class Reference
    {
        private DatabaseReference database;
        private DatabaseReference equipes;

        Reference()
        {
            database = FirebaseDatabase.getInstance().getReference();
            equipes = database.child(EQUIPES);
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
