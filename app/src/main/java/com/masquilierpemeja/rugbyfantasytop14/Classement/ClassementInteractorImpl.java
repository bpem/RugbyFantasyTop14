package com.masquilierpemeja.rugbyfantasytop14.Classement;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.DatabaseManagerInformationClassement;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.DatabaseManagerUser;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.InformationClassement;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pierre on 03/12/2017.
 */

public class ClassementInteractorImpl implements  ClassementInteractor {

    String uid;
    ClassementPresenterImpl mClassementPresenterImpl;
    FirebaseAuth auth;
    FirebaseUser firebaseUser;
    String FirebaseUserID;
    DatabaseManagerUser dbUser;
    DatabaseManagerInformationClassement dbInfoClassement;
    User user;
    List<InformationClassement> informationClassements;

    public ClassementInteractorImpl(ClassementPresenterImpl mClassementPresenterImpl) {
        this.mClassementPresenterImpl = mClassementPresenterImpl;
    }

    public void getListInfosClassementTriée(){

       getListOfInformationClassement(getKeyOfUser());

    }

    @Override
    public String getKeyOfUser() {

        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
        FirebaseUserID = firebaseUser.getUid();
        return FirebaseUserID;
    }

    @Override
    public User getUser(String firebaseUSerID) {

        dbUser = DatabaseManagerUser.getInstance();
        dbUser.getUserOnDatabase(firebaseUSerID, new DatabaseManagerUser.Result<User>() {
            @Override
            public void onSuccess(User user) {
                ClassementInteractorImpl.this.user = user;
            }
        });

        //SUREMENT Y AVOIR UNE ERREURE ICI
        return user;

    }

    @Override
    public void getListOfInformationClassement(String keyOfUser) {

        uid = keyOfUser;

        FirebaseDatabase.getInstance().getReference().child("Informations classement").addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)

            {
                List<InformationClassement> listInformationClassement = new ArrayList<InformationClassement>() ;

                for (DataSnapshot dt : dataSnapshot.getChildren()){

                    InformationClassement informationClassement = dt.getValue(InformationClassement.class);
                    if (informationClassement.getUser_ID().equals(uid) ){
                        listInformationClassement.add(informationClassement);
                    }
                }

                mClassementPresenterImpl.sendListInformationClassement(listInformationClassement);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });
    }

    @Override
    public void getListInfosClassement() {

    }


          /*  dbInfoClassement = DatabaseManagerInformationClassement.getInstance();

            dbInfoClassement.getListOfInfosMatchsOnDatabase(keyOfUser, new DatabaseManagerInformationClassement.Result<List<InformationClassement>>() {
                @Override
                public void onSuccess(List<InformationClassement> informationClassements) {
                    ClassementInteractorImpl.this.informationClassements = informationClassements;
                    return;

                }
            });
        }*/








}
