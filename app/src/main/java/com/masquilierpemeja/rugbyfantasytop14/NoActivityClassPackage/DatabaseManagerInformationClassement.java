package com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage;

import android.util.Log;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Pierre on 03/12/2017.
 */

////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////// FAIT LE LIEN ENTRE LA BDD FIREBASE DE INFO MATCH ET NOS CLASSES  ////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class DatabaseManagerInformationClassement {

    // NOM DU NOEUD USER DANS FIREBASE
    private final static String INFORMATIONCLASSEMENT = "Informations classement";
    private DatabaseManagerInformationClassement.Reference ref;
    private InformationClassement informationClassement;
    private static DatabaseManagerInformationClassement INSTANCE = new DatabaseManagerInformationClassement();

    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////CONSTRUCTEURS//////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////


    private DatabaseManagerInformationClassement()
    {
        ref = new DatabaseManagerInformationClassement.Reference();
    }


    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////FONCTIONS/////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////


    public void getInfosMatchsOnDatabase(final String uid, final DatabaseManagerInformationClassement.Result<InformationClassement> result)
    {
        ref.informationsClassementRef.child(uid).addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                informationClassement = dataSnapshot.getValue(InformationClassement.class);
                if (informationClassement != null) {
                    result.onSuccess(informationClassement.setClassement_ID(uid));

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


    public Task<Void> setInformationClassementOnDatabase(final InformationClassement informationClassement)

    {
        return ref.informationsClassementRef.push().setValue(informationClassement);
    }

    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////GETTER & SETTER///////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////


    public static DatabaseManagerInformationClassement getInstance()
    {
        return INSTANCE;
    }


    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////INNER CLASS //////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////

    private class Reference
    {
        private DatabaseReference database;
        private DatabaseReference informationsClassementRef;

        Reference()
        {
            database = FirebaseDatabase.getInstance().getReference();
            informationsClassementRef = database.child(INFORMATIONCLASSEMENT);
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


}
