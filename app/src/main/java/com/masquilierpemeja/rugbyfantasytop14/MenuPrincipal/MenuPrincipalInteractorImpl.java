package com.masquilierpemeja.rugbyfantasytop14.MenuPrincipal;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by bastienpemeja on 12/11/2017.
 */

public class MenuPrincipalInteractorImpl implements MenuPrincipalInteractor {

    private MenuPrincipalPresenterImpl mMenuPrincipalPresenterImpl;


    public MenuPrincipalInteractorImpl(MenuPrincipalPresenterImpl mMenuPrincipalPresenterImpl) {
        this.mMenuPrincipalPresenterImpl = mMenuPrincipalPresenterImpl;
    }

    @Override
    public void logout(FirebaseAuth mFirebaseAuth, MenuPrincipalPresenter mMenuPrincipalPresenter) {

    }
}
