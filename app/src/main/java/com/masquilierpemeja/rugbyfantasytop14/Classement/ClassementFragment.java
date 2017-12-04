package com.masquilierpemeja.rugbyfantasytop14.Classement;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassementFragment extends Fragment implements ClassementView {

    private DatabaseManagerInformationClassement dbInformationClassement;
    private String IDcurrentFirebaseUser;
    private ClassementPresenterImpl mClassementPresenterImpl;
    private ArrayList<InformationClassement> listInformationClassementTriee;
    private ListView mListView;
     private View mView;

    public ClassementFragment() {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_classement, container, false);;
        mListView =  mView.findViewById(R.id.listview_classement);

        mClassementPresenterImpl = new ClassementPresenterImpl(this);

        getListInfosClassementTriée();


        return mView;
    }

    @Override
    public void getListInfosClassementTriée() {
       mClassementPresenterImpl.getListInfosClassement();

    }

    public void sendListInformationClassementTriee(ArrayList<InformationClassement> listInformationClassementTriee){
        this.listInformationClassementTriee = listInformationClassementTriee;
        printAdapter();
    }

    public void printAdapter(){

        InformationClassementAdapter adapter = new InformationClassementAdapter(getContext(), R.layout.adapter_view_classement, listInformationClassementTriee);
        mListView.setAdapter(adapter);


    }


}
