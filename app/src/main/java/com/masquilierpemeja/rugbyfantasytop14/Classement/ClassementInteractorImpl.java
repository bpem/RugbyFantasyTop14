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
import java.util.Collections;
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

    public void getListInfosClassementTriee(){
      getUser(getKeyOfUser());
    }

    @Override
    public String getKeyOfUser() {

        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
        FirebaseUserID = firebaseUser.getUid();
        return FirebaseUserID;
    }

    @Override
    public void getUser(String firebaseUSerID) {

        dbUser = DatabaseManagerUser.getInstance();
        dbUser.getUserOnDatabase(firebaseUSerID, new DatabaseManagerUser.Result<User>() {
            @Override
            public void onSuccess(User user) {
                getListOfInformationClassement(user);
            }
        });


    }

    @Override
    public void getListOfInformationClassement(final User user) {


        FirebaseDatabase.getInstance().getReference().child("Informations classement").addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)

            {
                ArrayList<InformationClassement> listInformationClassement = new ArrayList<InformationClassement>() ;

                for (DataSnapshot dt : dataSnapshot.getChildren()){

                    InformationClassement informationClassement = dt.getValue(InformationClassement.class);
                    if (informationClassement.getKeyChampionnat().equals(user.getKeyChampionnat()) ){
                        listInformationClassement.add(informationClassement);
                    }
                }

            trierInformationClassement(listInformationClassement);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });
    }

    @Override
    public void trierInformationClassement(ArrayList<InformationClassement> listInformationClassement) {


        Boolean tab_en_ordre = false;
        int taille = listInformationClassement.size();

        while(!tab_en_ordre)
        {
            tab_en_ordre = true;
            for(int i=0 ; i < taille-1 ; i++)
            {
                if(listInformationClassement.get(i).getPtsTotal() < listInformationClassement.get(i+1).getPtsTotal())
                {
                    Collections.swap(listInformationClassement, i, i+1);

                    tab_en_ordre = false;
                }
            }
            taille--;
        }

        mClassementPresenterImpl.sendListInformationClassement(listInformationClassement);

    }


}
