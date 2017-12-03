package com.masquilierpemeja.rugbyfantasytop14.PageChampionnat;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.Championnat;
import com.masquilierpemeja.rugbyfantasytop14.R;


public class PageChampionnatFragment extends Fragment implements PageChampionnatView{

    TextView tvTitreChampionnat;
    Championnat championnat;
    public PageChampionnatFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View mView = inflater.inflate(R.layout.fragment_page_championnat, container, false);



        String strtext = "unTexte";
        if(getArguments() != null){
            championnat = new Championnat(
                getArguments().getString("EXTRA_CHAMPIONNAT_KEY"),
                getArguments().getString("EXTRA_CHAMPIONNAT_NOM"),
                getArguments().getString("EXTRA_CHAMPIONNAT_MDP"),
                getArguments().getBoolean("EXTRA_CHAMPIONNAT_PRIVE"),
                getArguments().getInt("EXTRA_CHAMPIONNAT_NBMAX")
            );
        }

        tvTitreChampionnat = (TextView) mView.findViewById(R.id.test_nom);
        tvTitreChampionnat.setText("Bienvenue dans le championnat " + championnat.getNomChamp());

        // Inflate the layout for this fragment
        return mView;
    }


}
