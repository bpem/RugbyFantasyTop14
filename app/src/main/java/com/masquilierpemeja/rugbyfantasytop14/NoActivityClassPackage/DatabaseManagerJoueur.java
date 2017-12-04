package com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage;

import android.util.Log;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
