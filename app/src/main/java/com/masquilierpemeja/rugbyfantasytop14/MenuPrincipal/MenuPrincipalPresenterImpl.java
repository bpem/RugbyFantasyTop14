package com.masquilierpemeja.rugbyfantasytop14.MenuPrincipal;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by bastienpemeja on 12/11/2017.
 */

public class MenuPrincipalPresenterImpl implements MenuPrincipalPresenter {

    private MenuPrincipalView mMenuPrincipalView;
    private MenuPrincipalInteractorImpl mMenuPrincipalInteractorImpl;

    public MenuPrincipalPresenterImpl (MenuPrincipalView mMenuPrincipalView){
        this.mMenuPrincipalView= mMenuPrincipalView;
        this.mMenuPrincipalInteractorImpl = new MenuPrincipalInteractorImpl(this);
    }

    @Override
    public void logout(FirebaseAuth mFirebaseAuth) {
        mMenuPrincipalInteractorImpl.logout(mFirebaseAuth, this);
    }
}
