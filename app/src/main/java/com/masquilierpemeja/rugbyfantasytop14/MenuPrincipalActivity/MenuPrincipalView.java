package com.masquilierpemeja.rugbyfantasytop14.MenuPrincipalActivity;

/**
 * Created by bastienpemeja on 12/11/2017.
 */

public interface MenuPrincipalView {

    void showProgress();
    void hideProgress();
    void navigateToRejoindreChampionnat();
    void navigateToCreerChampionnat();
    void navigateToMonProfil();
    void showAlert(String message);
    void logout(String message);

}
