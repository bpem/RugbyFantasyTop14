package com.masquilierpemeja.rugbyfantasytop14.PageChampionnat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.masquilierpemeja.rugbyfantasytop14.R;

public class PageChampionnatActivity extends AppCompatActivity implements PageChampionnatView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_championnat);
    }
}
