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

public class DatabaseManagerEquipeTop14 {
    //////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////VARIABLES DE CLASSES///////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////

    // NOM DU NOEUD USER DANS FIREBASE
    private final static String EQUIPES = "EquipeTop14";
    private DatabaseManagerEquipeTop14.Reference ref;
    private EquipeTop14 equipeTop14;
    private static DatabaseManagerEquipeTop14 INSTANCE = new DatabaseManagerEquipeTop14();
    private Boolean isEquipeExist;


    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////CONSTRUCTEURS//////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////


    private DatabaseManagerEquipeTop14()
    {
        ref = new DatabaseManagerEquipeTop14.Reference();
    }


    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////FONCTIONS/////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////


    public void getEquipeOnDatabase(final String uid, final DatabaseManagerEquipeTop14.Result<EquipeTop14> result)
    {
        ref.equipes.child(uid).addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                EquipeTop14 uneEquipeTop14 = new EquipeTop14(
                   // DO STUFF
                );
                if (true) {
                    result.onSuccess(uneEquipeTop14);
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


    public Task<Void> setUserOnDatabase(final EquipeTop14 equipeTop14)
    {
        return ref.equipes.child(equipeTop14.getKeyEquipeTop14Top14()).setValue(equipeTop14);
    }


    public void creerToutesLesEquipes(){

    }


    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////GETTER & SETTER///////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////


    public static DatabaseManagerEquipeTop14 getInstance()
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
