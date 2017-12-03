package com.masquilierpemeja.rugbyfantasytop14.Classement;

import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.InformationClassement;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.User;

import java.util.List;

/**
 * Created by Pierre on 03/12/2017.
 */

public interface ClassementInteractor {

    interface onClassementFinishedListener{



    }

    void getListInfosClassementTriée();
    String getKeyOfUser();
    User getUser(String FirebaseUserID);
    void getListOfInformationClassement(String keyOfUser);
    void getListInfosClassement();



}
