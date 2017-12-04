package com.masquilierpemeja.rugbyfantasytop14.CreerChampionnat;

import android.text.TextUtils;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by bastienpemeja on 10/11/2017.
 */

public class CreerChampionnatInteractorImpl implements CreerChampionnatInteractor{

    @Override
    public void championnat(String nomChampionnat, Boolean estPublic, Integer nombreDeParticipant, String motDePasse, onCreerChampionnatFinishedListener listener) {
        if(TextUtils.isEmpty(nomChampionnat))
            listener.onNomChampionnatError();
        else if(nombreDeParticipant > 14 && nombreDeParticipant < 1)
            listener.onFailure("Nombre de participant incorrect");
        else if(!TextUtils.isEmpty(nomChampionnat)){
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Championnat");
            String idChampionnat = myRef.push().getKey();
            myRef.child(idChampionnat).child("nom").setValue(nomChampionnat);
            myRef.child(idChampionnat).child("prive").setValue(estPublic);
            if(nombreDeParticipant == null){
                myRef.child(idChampionnat).child("nombreMax").setValue(14);
            }
            else {
                myRef.child(idChampionnat).child("nombreMax").setValue(nombreDeParticipant);
            }
            myRef.child(idChampionnat).child("motDePasse").setValue(motDePasse);
            listener.onSuccess();
        }
    }
}
