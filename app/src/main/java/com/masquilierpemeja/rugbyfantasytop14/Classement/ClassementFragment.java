package com.masquilierpemeja.rugbyfantasytop14.Classement;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.masquilierpemeja.rugbyfantasytop14.BottomNavigation.BottomNavigationActivity;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.DatabaseManagerInformationClassement;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.DatabaseManagerUser;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.InformationClassement;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.User;
import com.masquilierpemeja.rugbyfantasytop14.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassementFragment extends Fragment {

    private DatabaseManagerInformationClassement dbInformationClassement;
    private String IDcurrentFirebaseUser;

    public ClassementFragment() {

        RecupererUserCourant();
        AjouterClassementAUser();
        // Required empty public constructor
    }


    private void RecupererUserCourant(){



    }

    private void AjouterClassementAUser(){
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser currentFirebaseUser = auth.getCurrentUser() ;
        IDcurrentFirebaseUser = currentFirebaseUser.getUid();
        dbInformationClassement = DatabaseManagerInformationClassement.getInstance();
        dbInformationClassement.setInformationClassementOnDatabase(new InformationClassement(IDcurrentFirebaseUser))
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getActivity() , "AJOUT CLASSEMENT !!!!!!!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_classement, container, false);
    }

}
