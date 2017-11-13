package com.masquilierpemeja.rugbyfantasytop14.RejoindreChampionnat;

/**
 * Created by bastienpemeja on 12/11/2017.
 */

public interface RejoindreChampionnatView {

    void showProgress();
    void hideProgress();
    void setMotDePasseError();
    void navigateToMain();
    void showAlert(String message);

}
