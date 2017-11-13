package com.masquilierpemeja.rugbyfantasytop14.MenuPrincipal;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by bastienpemeja on 12/11/2017.
 */

public interface MenuPrincipalInteractor {

    void logout(FirebaseAuth mFirebaseAuth, MenuPrincipalPresenter mMenuPrincipalPresenter);
}
