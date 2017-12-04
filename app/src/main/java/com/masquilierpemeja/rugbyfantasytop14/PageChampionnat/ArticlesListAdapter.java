package com.masquilierpemeja.rugbyfantasytop14.PageChampionnat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.Article;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.InformationClassement;
import com.masquilierpemeja.rugbyfantasytop14.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Pierre on 04/12/2017.
 */

public class ArticlesListAdapter extends ArrayAdapter<Article> {

    private static final String TAG = "ArticlesListAdapter";
    private Context mContext;
    int mRessource;

    public ArticlesListAdapter(@NonNull Context context, int resource, ArrayList<Article>objects) {
        super(context, resource, objects);
        mContext = context;
        mRessource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String titreArticle = getItem(position).getTitre();
        String resumeArticle = getItem(position).getResume();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mRessource, parent, false);

        TextView textViewTitreArticle = (TextView) convertView.findViewById(R.id.titreDelarticle);
        TextView textViewResume = (TextView) convertView.findViewById(R.id.ResumeArticle);

        textViewResume.setText(resumeArticle);
        textViewTitreArticle.setText(titreArticle);

        return  convertView;
    }



}
