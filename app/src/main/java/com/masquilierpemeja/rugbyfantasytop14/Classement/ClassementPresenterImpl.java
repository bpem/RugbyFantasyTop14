package com.masquilierpemeja.rugbyfantasytop14.Classement;

import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.InformationClassement;

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


    public void  getListInfosClassementTriée(){

       mClassementInterractorImpl.getListInfosClassementTriée();

    }

  public void sendListInformationClassement(List<InformationClassement> listInformationClassement){

        mClassementView.sendListInformationClassement(listInformationClassement);

    }

}
