package com.masquilierpemeja.rugbyfantasytop14.Championnat;

/**
 * Created by bastienpemeja on 10/11/2017.
 */

public interface CreerChampionnatView {

    void showProgress();
    void hideProgress();
    void setNomChampionnatError();
    void setMotDePasseError();
    void navigateToMain();
    void showAlert(String message);
}
