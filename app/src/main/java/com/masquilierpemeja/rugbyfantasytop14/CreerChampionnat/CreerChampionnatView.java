package com.masquilierpemeja.rugbyfantasytop14.CreerChampionnat;

/**
 * Created by bastienpemeja on 10/11/2017.
 */

public interface CreerChampionnatView {

    void showProgress();
    void hideProgress();
    void setNomChampionnatError();
    void setMotDePasseError();
    void navigateToRejoindreChampionnat();
    void navigateToMenuPrincipal();
    void showAlert(String message);
}
