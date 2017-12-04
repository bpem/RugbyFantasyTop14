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


    public void getEquipeOnDatabaseByAcronyme(final String acronyme, final DatabaseManagerEquipeTop14.Result<EquipeTop14> result)
    {
        ref.equipes.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                EquipeTop14 unEquipeTop14;

                for (DataSnapshot dt : dataSnapshot.getChildren()){

                    unEquipeTop14 = dt.getValue(EquipeTop14.class);
                    if (unEquipeTop14.getAcronymeTop14().equals(acronyme) ){
                        result.onSuccess(unEquipeTop14);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) { }
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
        return ref.equipes.child(equipeTop14.getKeyEquipeTop14()).setValue(equipeTop14);
    }



    public void creerToutesLesEquipes(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(EQUIPES);
        for(int i = 0; i<14; i++)
        {
            String keyEquipe = myRef.push().getKey();
            if(i==0) {
                myRef.child(keyEquipe).child("nom").setValue("Montpellier Hérault Rugby");
                myRef.child(keyEquipe).child("acronyme").setValue("MHR");
            }
            if(i==1) {
                myRef.child(keyEquipe).child("nom").setValue("Stade Toulousain");
                myRef.child(keyEquipe).child("acronyme").setValue("ST");
            }
            if(i==2) {
                myRef.child(keyEquipe).child("nom").setValue("Stade Français");
                myRef.child(keyEquipe).child("acronyme").setValue("SF");
            }
            if(i==3) {
                myRef.child(keyEquipe).child("nom").setValue("Stade Rochelais");
                myRef.child(keyEquipe).child("acronyme").setValue("SR");
            }
            if(i==4) {
                myRef.child(keyEquipe).child("nom").setValue("Racing 92");
                myRef.child(keyEquipe).child("acronyme").setValue("R92");
            }
            if(i==5) {
                myRef.child(keyEquipe).child("nom").setValue("ASM Clermont Auvergne");
                myRef.child(keyEquipe).child("acronyme").setValue("ASM");
            }
            if(i==6) {
                myRef.child(keyEquipe).child("nom").setValue("Rugby Club Toulonnais");
                myRef.child(keyEquipe).child("acronyme").setValue("RCT");
            }
            if(i==7) {
                myRef.child(keyEquipe).child("nom").setValue("Castres Olympique");
                myRef.child(keyEquipe).child("acronyme").setValue("CO");
            }
            if(i==8) {
                myRef.child(keyEquipe).child("nom").setValue("Club Athlétique Brive");
                myRef.child(keyEquipe).child("acronyme").setValue("CAB");
            }
            if(i==9) {
                myRef.child(keyEquipe).child("nom").setValue("Union Bordeaux Bègles");
                myRef.child(keyEquipe).child("acronyme").setValue("UBB");
            }
            if(i==10) {
                myRef.child(keyEquipe).child("nom").setValue("Section Paloise");
                myRef.child(keyEquipe).child("acronyme").setValue("SP");
            }
            if(i==11) {
                myRef.child(keyEquipe).child("nom").setValue("Lyon Olympique Universitaire");
                myRef.child(keyEquipe).child("acronyme").setValue("LOU");
            }
            if(i==12) {
                myRef.child(keyEquipe).child("nom").setValue("Sporting Union Agen Lot-et-Garonne");
                myRef.child(keyEquipe).child("acronyme").setValue("SUA");
            }
            if(i==13) {
                myRef.child(keyEquipe).child("nom").setValue("Union Sportive Oyonnax Rugby");
                myRef.child(keyEquipe).child("acronyme").setValue("USO");
            }
        }
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
