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

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassementFragment extends Fragment implements ClassementView {

    private DatabaseManagerInformationClassement dbInformationClassement;
    private String IDcurrentFirebaseUser;
    private ClassementPresenterImpl mClassementPresenterImpl;
    List<InformationClassement> sendListInformationClassementTriee;

    public ClassementFragment() {
        mClassementPresenterImpl = new ClassementPresenterImpl(this);
        getListInfosClassementTriée();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_classement, container, false);
    }

    @Override
    public void getListInfosClassementTriée() {
       mClassementPresenterImpl.getListInfosClassement();

    }

    public void sendListInformationClassementTriee(List<InformationClassement> sendListInformationClassementTriee){
        this.sendListInformationClassementTriee = sendListInformationClassementTriee;
    }
}
