package com.masquilierpemeja.rugbyfantasytop14.BottomNavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.masquilierpemeja.rugbyfantasytop14.Calendrier.CalendrierFragment;
import com.masquilierpemeja.rugbyfantasytop14.Classement.ClassementFragment;
import com.masquilierpemeja.rugbyfantasytop14.MonEquipe.MonEquipeFragment;
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
                    afficherHome();


                    return true;
                case R.id.navigation_mon_equipe:
                    // ICI ON LANCE LE CODE DU FRAGMENT PAGE MON EQUIPE
                    setTitle("Mon equipe");
                    MonEquipeFragment monEquipeFragment = new MonEquipeFragment();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.container, monEquipeFragment, "Mon equipe");
                    fragmentTransaction2.commit();

                    return true;


                case R.id.navigation_classement:

                    // ICI ON LANCE LE CODE DU FRAGMENT PAGE CLASSEMENT
                    setTitle("Classement");
                    ClassementFragment classementFragment = new ClassementFragment();
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.container, classementFragment, "Classement");
                    fragmentTransaction3.commit();

                    return true;


                case R.id.navigation_calendrier:

                    // ICI ON LANCE LE CODE DU FRAGMENT PAGE CALENDRIER
                    setTitle("Calendrier");
                    CalendrierFragment calendrierFragment = new CalendrierFragment();
                    FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction4.replace(R.id.container, calendrierFragment, "Calendrier");
                    fragmentTransaction4.commit();


                    return true;

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

        afficherHome();
    }


    private void afficherHome(){
        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        bundle.putString("EXTRA_CHAMPIONNAT_NOM", intent.getExtras().getString("EXTRA_CHAMPIONNAT_NOM"));
        bundle.putString("EXTRA_CHAMPIONNAT_KEY", intent.getExtras().getString("EXTRA_CHAMPIONNAT_KEY"));
        bundle.putString("EXTRA_CHAMPIONNAT_MDP", intent.getExtras().getString("EXTRA_CHAMPIONNAT_MDP"));
        bundle.putBoolean("EXTRA_CHAMPIONNAT_PRIVE", intent.getExtras().getBoolean("EXTRA_CHAMPIONNAT_PRIVE"));
        bundle.putInt("EXTRA_CHAMPIONNAT_NBMAX", intent.getExtras().getInt("EXTRA_CHAMPIONNAT_NBMAX"));

        PageChampionnatFragment fragment = new PageChampionnatFragment();
        fragment.setArguments(bundle);
        String nomChampionnat = intent.getExtras().getString("EXTRA_CHAMPIONNAT_NOM");
        setTitle("Bienvenue dans le championnat: " + nomChampionnat);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, "Accueil");
        fragmentTransaction.commit();
    }
}
