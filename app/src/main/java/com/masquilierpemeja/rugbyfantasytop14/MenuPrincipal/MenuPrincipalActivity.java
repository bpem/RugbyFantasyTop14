package com.masquilierpemeja.rugbyfantasytop14.MenuPrincipal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.google.firebase.auth.FirebaseAuth;
import com.masquilierpemeja.rugbyfantasytop14.BottomNavigation.BottomNavigationActivity;
import com.masquilierpemeja.rugbyfantasytop14.CreerChampionnat.CreerChampionnatActivity;
import com.masquilierpemeja.rugbyfantasytop14.Login.LoginActivity;
import com.masquilierpemeja.rugbyfantasytop14.MenuPrincipal.MenuPrincipalPresenterImpl;
import com.masquilierpemeja.rugbyfantasytop14.MenuPrincipal.MenuPrincipalView;
import com.masquilierpemeja.rugbyfantasytop14.Profil.ProfilActivity;
import com.masquilierpemeja.rugbyfantasytop14.R;
import com.masquilierpemeja.rugbyfantasytop14.RejoindreChampionnat.RejoindreChampionnatActivity;

public class MenuPrincipalActivity extends AppCompatActivity implements MenuPrincipalView {

    Button btnGoToMonProfil, btnGoToCreerChampionnat, btnGoToRejoindreChampionnat, btnDeconnexion;
    private MenuPrincipalPresenterImpl mMenuPrincipalPresenterImpl;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        mFirebaseAuth = FirebaseAuth.getInstance();

        btnGoToCreerChampionnat = (Button) findViewById(R.id.btn_go_to_creer_championnat);
        btnGoToRejoindreChampionnat = (Button) findViewById(R.id.btn_go_to_rejoindre_championnat);

        btnGoToCreerChampionnat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToCreerChampionnat();
            }
        });

        btnGoToRejoindreChampionnat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToRejoindreChampionnat();
            }
        });

        btnDeconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mFirebaseAuth.signOut();
                startActivity(new Intent(MenuPrincipalActivity.this, LoginActivity.class));
                finish();
            }


    });

        btnGoToMonProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMonProfil();
            }
        });

    }


    public MenuPrincipalPresenterImpl getMenuPrincipalPresenterImpl() {
        if (mMenuPrincipalPresenterImpl == null) mMenuPrincipalPresenterImpl = new MenuPrincipalPresenterImpl(this);
        return mMenuPrincipalPresenterImpl;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void navigateToRejoindreChampionnat() {
        startActivity(new Intent(MenuPrincipalActivity.this, RejoindreChampionnatActivity.class));
    }

    @Override
    public void navigateToCreerChampionnat() {
        startActivity(new Intent(MenuPrincipalActivity.this, CreerChampionnatActivity.class));
    }

    @Override
    public void navigateToMonProfil() {
        startActivity(new Intent(MenuPrincipalActivity.this, ProfilActivity.class));
    }

    @Override
    public void showAlert(String message) {

    }

    @Override
    public void logout(String message) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_trois_petits_points, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.profil:
                Intent intent = new Intent(MenuPrincipalActivity.this, ProfilActivity.class);
                startActivity(intent);

                return true;
            case R.id.deconnexion:
                FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();
                mFirebaseAuth.signOut();
                startActivity(new Intent(MenuPrincipalActivity.this, LoginActivity.class));
                finish();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
