package com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage;


import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.google.android.gms.tasks.Task;


/**
 * Created by Pierre on 02/12/2017.
 */


////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////// FAIT LE LIEN ENTRE LA BDD FIREBASE ET NOS CLASSES  ////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class DatabaseManager {

    //////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////VARIABLES DE CLASSES///////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////

    // NOM DU NOEUD USER DANS FIREBASE
    private final static String USERS = "users";
    private Reference ref;
    private User user;
    private static DatabaseManager INSTANCE = new DatabaseManager();


    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////CONSTRUCTEURS//////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////


    private DatabaseManager()
    {
        ref = new Reference();
    }


    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////FONCTIONS/////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////


    public void getUserOnDatabse(final String uid, final Result<User> result)
    {
        ref.users.child(uid).addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                user = dataSnapshot.getValue(User.class);
                if (user != null) {
                    result.onSuccess(user.setUserID(uid));

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


    public Task<Void> setUserOnDatabase(final User user)
    {
        return ref.users.child(user.getUserID()).setValue(user);
    }



    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////GETTER & SETTER///////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////


    public static DatabaseManager getInstance()
    {
        return INSTANCE;
    }




    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////INNER CLASS //////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////

    private class Reference
    {
        private DatabaseReference database;
        private DatabaseReference users;

        Reference()
        {
            database = FirebaseDatabase.getInstance().getReference();
            users = database.child(USERS);
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
