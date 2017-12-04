package com.masquilierpemeja.rugbyfantasytop14.Classement;

import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.InformationClassement;

import java.util.List;

/**
 * Created by Pierre on 03/12/2017.
 */

public interface ClassementView {

    void getListInfosClassementTriée();
     void sendListInformationClassementTriee(List<InformationClassement> listInformationClassement);



}
