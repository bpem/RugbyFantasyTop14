package com.masquilierpemeja.rugbyfantasytop14.RejoindreChampionnat;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by bastienpemeja on 12/11/2017.
 */

public class RejoindreChampionnatInteractorImpl implements RejoindreChampionnatInteractor {


    DatabaseReference myRef;
    ArrayList<String> desChampionnats = new ArrayList<>();

    @Override
    public void rejoindreChampionnat(String keyChampionnat) {

    }

    @Override
    public void listerChampionnat(ListView uneListe, final ArrayAdapter<String> adapter,final ArrayList<String> champArray) {
        uneListe.setAdapter(adapter);
        myRef = FirebaseDatabase.getInstance().getReference("Championnat");

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                champArray.add(dataSnapshot.child("nom").getValue(String.class));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                desChampionnats.remove(dataSnapshot.getValue(String.class));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
