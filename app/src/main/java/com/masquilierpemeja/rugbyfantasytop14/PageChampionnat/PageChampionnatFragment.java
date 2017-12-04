package com.masquilierpemeja.rugbyfantasytop14.PageChampionnat;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.Article;
import com.masquilierpemeja.rugbyfantasytop14.NoActivityClassPackage.Championnat;
import com.masquilierpemeja.rugbyfantasytop14.R;

import java.util.ArrayList;


public class PageChampionnatFragment extends Fragment implements PageChampionnatView{

    Article article1;
    Article article2;
    Article article3;
    TextView tvTitreChampionnat;
    Championnat championnat;
    ArrayList<Article> arrayListArticles;
    ListView mListView;
    View mView;
    public PageChampionnatFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         mView = inflater.inflate(R.layout.fragment_page_championnat, container, false);


        String strtext = "unTexte";
        if(getArguments() != null){
            championnat = new Championnat(
                    getArguments().getString("EXTRA_CHAMPIONNAT_KEY"),
                    getArguments().getString("EXTRA_CHAMPIONNAT_NOM"),
                    getArguments().getString("EXTRA_CHAMPIONNAT_MDP"),
                    getArguments().getBoolean("EXTRA_CHAMPIONNAT_PRIVE"),
                    getArguments().getInt("EXTRA_CHAMPIONNAT_NBMAX")
            );
        }


        tvTitreChampionnat = (TextView) mView.findViewById(R.id.test_nom);
        tvTitreChampionnat.setText("Bienvenue dans le championnat " + championnat.getNomChamp());
        mListView = mView.findViewById(R.id.listView_championnat);

        creationArticle();
        creationListeArticle();
        adapter();


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent browserIntent;

                switch (position){
                    case 0:
                        browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lemonde.fr/top-14/article/2017/12/03/top-14-le-stade-francais-s-impose-face-au-racing-lors-du-derby-francilien_5224032_1616942.html"));
                        startActivity(browserIntent);
                    case 1:
                         browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lemonde.fr/top-14/article/2017/12/02/top-14-la-rochelle-prend-la-premiere-place-en-battant-montpellier_5223774_1616942.html"));
                        startActivity(browserIntent);
                    case 2:
                         browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lemonde.fr/top-14/article/2017/11/26/top-14-le-racing-fait-tomber-le-leader-montpellierain_5220686_1616942.html"));
                        startActivity(browserIntent);


                }


            }
        });

        // Inflate the layout for this fragment
        return mView;
    }

    public void creationArticle(){

       article1 = new Article("Top 14 : le Stade français s’impose face au Racing lors du derby francilien\n"
               , " Trois essais inscrits dans la première demi-heure : le Stade Français a fait voler en éclat la défense du Racing 92, la meilleure du Top 14, pour s’offrir dimanche devant son public une victoire (27-17) capitale lors de la 12e journée.\n" +
                "Les Parisiens se donnent en effet de l’air au classement, puisqu’ils portent leur avance sur la 13e place, synonyme de barrage d’accession-relégation, à huit points, et celle sur la 14e (relégation) à onze longueurs. Encore loin, évidemment, du wagon des six premiers qualifiés (10 points devant), mais au moins se sont-ils sans doute donnés le droit de vivre une deuxième partie de saison épicée par autre chose que la lutte pour le maintien.\n" +
                "\n");

      article2 = new Article("Top 14 : La Rochelle prend la première place en battant Montpellier", "La Rochelle est de retour au sommet. En dominant Montpellier, qui détenait jusqu’ici les commandes du championnat, les joueurs de Patrice Collazo ont récupéré le fauteuil de leader qu’ils avaient longuement occupé l’an dernier, avant de tomber en demi-finales de Top 14 contre Toulon.\n" +
                "Les Maritimes (39 points), avec deux longueurs d’avance sur le MHR et six sur Lyon et le Racing 92 - qui jouent plus tard dans le week-end - sont assurés de conserver ce fauteuil de leader à l’issue de cette 12è journée.");

       article3 = new Article("Guy Novès-Bernard Laporte, le duo contrarié du rugby français\n"
              , "Les deux hommes ne se sont pas choisis mais font avec, jurent-ils sur les grands dieux de l’Ovalie. La désolante tournée de novembre qui vient de s’achever, pourtant, soulève quelques questions. Jusqu’à quand Guy Novès supportera-t-il Bernard Laporte, et réciproquement ? Le premier a été nommé sélectionneur du XV de France dès novembre 2015 ; le second, élu président de la Fédération française de rugby (FFR) en décembre 2016.\n"
               );

    }

    public void creationListeArticle(){

        arrayListArticles = new ArrayList<>();
        arrayListArticles.add(article1);
        arrayListArticles.add(article2);
        arrayListArticles.add(article3);

    }

    public void adapter(){

        ArticlesListAdapter adapter = new ArticlesListAdapter(getContext(), R.layout.adapter_view_actualite, arrayListArticles);
        mListView.setAdapter(adapter);
    }


}
