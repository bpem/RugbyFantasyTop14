package com.masquilierpemeja.rugbyfantasytop14.Classement;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.InformationClassement;
import com.masquilierpemeja.rugbyfantasytop14.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pierre on 03/12/2017.
 */

public class InformationClassementAdapter extends ArrayAdapter<InformationClassement> {

    private static final String TAG = "InformationClassementAdapter";
    private Context mContext;
    private int mResource;

    public InformationClassementAdapter(@NonNull Context context, int resource, ArrayList<InformationClassement>objects ) {
        super(context, resource, objects);
        mResource= resource;
        mContext = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String ID = getItem(position).getUser_ID();
        int nbVictoires =   getItem(position).getNbVictoire();
        int nbDefaites = getItem(position).getNbDefaite();
        int nbEgalite = getItem(position).getNbEgalite();
        int difference = getItem(position).getDifference();
        int totalPoints = getItem(position).getPtsTotal();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView textView_nbVictoires = (TextView) convertView.findViewById(R.id.textView_nb_victoire);
        TextView textView_ID = (TextView) convertView.findViewById(R.id.textView_nom_joueur);
        TextView textView_nbEgalite = (TextView) convertView.findViewById(R.id.textView_nb_egalite);
        TextView textView_difference = (TextView) convertView.findViewById(R.id.textView_difference);
        TextView textView_nbDefaites = (TextView) convertView.findViewById(R.id.textView_nb_defaite);
        TextView textView_totalPoints = (TextView) convertView.findViewById(R.id.textView_total);


        textView_ID.setText(ID);
        textView_nbDefaites.setText(String.valueOf( nbDefaites));
        textView_nbVictoires.setText(String.valueOf(nbVictoires));
        textView_nbEgalite.setText(String.valueOf(nbEgalite));
        textView_difference.setText(String.valueOf(difference));
        textView_totalPoints.setText(String.valueOf(totalPoints));

        return convertView;
    }
}
