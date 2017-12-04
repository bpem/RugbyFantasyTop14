package com.masquilierpemeja.rugbyfantasytop14.Classement;

import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.InformationClassement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pierre on 03/12/2017.
 */

public class ClassementPresenterImpl implements  ClassementPresenter, ClassementInteractor.onClassementFinishedListener {

    ClassementView mClassementView;
    ClassementInteractorImpl mClassementInterractorImpl;

    public ClassementPresenterImpl(ClassementView mClassementView) {
        this.mClassementView=mClassementView;
        mClassementInterractorImpl = new ClassementInteractorImpl(this);
    }


    public void  getListInfosClassement(){

       mClassementInterractorImpl.getListInfosClassementTriee();

    }

  public void sendListInformationClassement(ArrayList<InformationClassement> listInformationClassement){

        mClassementView.sendListInformationClassementTriee(listInformationClassement);

    }

}
