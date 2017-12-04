package com.masquilierpemeja.rugbyfantasytop14.Profil;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.DatabaseManagerUser;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.User;

/**
 * Created by bastienpemeja on 13/11/2017.
 */

public class ProfilInteractorImpl implements ProfilInteractor {


    DatabaseReference myRef;
    DatabaseManagerUser db;
    FirebaseAuth auth;
    ProfilPresenterImpl mProfilPresenterImpl;


    public ProfilInteractorImpl(ProfilPresenterImpl mProfilPresenterImpl){
        this.mProfilPresenterImpl = mProfilPresenterImpl;
    }

    @Override
    public void getUserCourant() {
        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        db = DatabaseManagerUser.getInstance();
        db.getUserOnDatabase(user.getUid(), new DatabaseManagerUser.Result<User>() {
            @Override
            public void onSuccess(User user) {
                mProfilPresenterImpl.sendUser(user);
            }
        });
    }


}
