package com.masquilierpemeja.rugbyfantasytop14.Profil;

import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.User;

/**
 * Created by bastienpemeja on 13/11/2017.
 */

public interface ProfilPresenter {
    void getUserCourant();
    void onDestroy();
    void sendUser(User user);

}
