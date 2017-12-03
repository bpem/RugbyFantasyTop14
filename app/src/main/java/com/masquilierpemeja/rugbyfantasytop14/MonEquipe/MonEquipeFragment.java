package com.masquilierpemeja.rugbyfantasytop14.MonEquipe;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.masquilierpemeja.rugbyfantasytop14.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MonEquipeFragment extends Fragment {


    public MonEquipeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mon_equipe, container, false);
    }

}
