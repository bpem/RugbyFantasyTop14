package com.masquilierpemeja.rugbyfantasytop14.MonEquipe;

import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.DatabaseManagerEquipe;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.DatabaseManagerJoueur;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.DatabaseManagerUser;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.Joueur;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by bastienpemeja on 03/12/2017.
 */

public class MonEquipeInteractorImpl implements MonEquipeInteractor {

    DatabaseReference myRef;
    DatabaseReference myRef2;
    DatabaseReference myRef3;
    DatabaseManagerEquipe dbE;
    DatabaseManagerUser dbU;
    DatabaseManagerJoueur dbJ;
    FirebaseAuth auth;
    MonEquipePresenterImpl mMonEquipePresenterImpl;
    Joueur unJoueur;
    ArrayList<Joueur> desJoueurs;
    String a,b,c;


    public MonEquipeInteractorImpl(MonEquipePresenterImpl mMonEquipePresenterImpl){
        this.mMonEquipePresenterImpl = mMonEquipePresenterImpl;
    }

    @Override
    public void creerEquipe(final List<Joueur> listJoueurs) {
        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        dbU = DatabaseManagerUser.getInstance();
        dbU.getUserOnDatabase(user.getUid(), new DatabaseManagerUser.Result<User>() {
            @Override
            public void onSuccess(User user) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                myRef = database.getReference("Equipe");
                String keyEquipe = myRef.push().getKey();
                myRef.child(keyEquipe).child("keyUser").setValue(user.getUserID());
                myRef.child(keyEquipe).child("listeJoueur").setValue(listJoueurs);
            }
        });
    }

    @Override
    public void listerTousLesJoueurs() {
        auth = FirebaseAuth.getInstance();
        dbJ = DatabaseManagerJoueur.getInstance();
        dbJ.getListOfJoueurOnDatabase(new DatabaseManagerJoueur.Result<List<Joueur>>() {
            @Override
            public void onSuccess(List<Joueur> listJoueurs) {
                creerEquipe(listJoueurs);
            }
        });
    }

    @Override
    public void listerJoueurByPoste(final String poste, final ListView unListe, final ArrayAdapter<Joueur> adapter, final ArrayList<Joueur> joueurArray) {
        unListe.setAdapter(adapter);
        myRef = FirebaseDatabase.getInstance().getReference("Equipe");
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Iterator<DataSnapshot> dataSnapshotsChat = dataSnapshot.child("listeJoueur").getChildren().iterator();

                while (dataSnapshotsChat.hasNext()) {
                    DataSnapshot dataSnapshotChild = dataSnapshotsChat.next();

                    unJoueur = new Joueur(dataSnapshotChild.getKey(),
                            dataSnapshotChild.child("nom").getValue(String.class),
                            dataSnapshotChild.child("prenom").getValue(String.class),
                            dataSnapshotChild.child("keyEquipe").getValue(String.class),
                            dataSnapshotChild.child("poste").getValue(String.class),
                            dataSnapshotChild.child("nationalite").getValue(String.class)
                    );
                    if(unJoueur.getPoste().equals(poste)){
                        joueurArray.add(unJoueur);
                    }

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    /** public void listerJoueurByPoste(String poste) {
        auth = FirebaseAuth.getInstance();
        dbE = DatabaseManagerEquipe.getInstance();
        dbE.getJoueurOnDatabaseByPoste(poste, new DatabaseManagerEquipe.Result<List<Joueur>>() {
            @Override
            public void onSuccess(List<Joueur> joueurs) {
                mMonEquipePresenterImpl.sendListeJoueurByPoste(joueurs);
            }
        });
    } **/




}
