package com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    ///////////////////////CONSTRUCTEURs//////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////


    private DatabaseManager()
    {
        ref = new Reference();
    }


    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////FONCTIONS/////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////


    





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




}
