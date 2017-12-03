package com.masquilierpemeja.rugbyfantasytop14.BottomNavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.Championnat;
import com.masquilierpemeja.rugbyfantasytop14.PageChampionnat.PageChampionnatFragment;
import com.masquilierpemeja.rugbyfantasytop14.R;

public class BottomNavigationActivity extends AppCompatActivity {

    TextView tvTitreChampionnat;
    Championnat championnat;




    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    // ICI ON LANCE LE CODE DU FRAGMENT PAGE CHAMPIONNAT
                    setTitle("ACCUEIL");
                    PageChampionnatFragment pageChampionnatFragment = new PageChampionnatFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container, pageChampionnatFragment, "FragmentName");
                    fragmentTransaction.commit();


                    return true;
                case R.id.navigation_dashboard:

                    // ICI ON LANCE LE CODE DU FRAGMENT PAGE MON EQUIPE

                    return true;
                case R.id.navigation_notifications:

                    // ICI ON LANCE LE CODE DU FRAGMENT PAGE CALENDRIER

                    return true;




                    // ICI ON LANCE LE CODE DU FRAGMENT PAGE CLASSEMENT
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Intent intent = getIntent();

        championnat = new Championnat(intent.getExtras().getString("EXTRA_CHAMPIONNAT_KEY"),
                intent.getExtras().getString("EXTRA_CHAMPIONNAT_NOM"),
                intent.getExtras().getString("EXTRA_CHAMPIONNAT_MDP"),
                intent.getExtras().getBoolean("EXTRA_CHAMPIONNAT_PRIVE"),
                intent.getExtras().getInt("EXTRA_CHAMPIONNAT_NBMAX")
        );


       // tvTitreChampionnat = (TextView) findViewById(R.id.tv_titre_championnat);
       // tvTitreChampionnat.setText("Bienvenue dans le championnat " + championnat.getNomChamp());
    }

}
