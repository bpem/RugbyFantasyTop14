package com.masquilierpemeja.rugbyfantasytop14.PageChampionnat;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.masquilierpemeja.rugbyfantasytop14.R;


public class PageChampionnatFragment extends Fragment {


    public PageChampionnatFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_championnat, container, false);
    }


}
