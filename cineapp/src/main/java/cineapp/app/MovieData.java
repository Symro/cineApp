package cineapp.app;

import java.io.Serializable;
import java.util.ArrayList;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by Sylvain on 02/06/2014.
 * Model qui représente les données de chaque films
 */
public class MovieData implements Serializable {

    private static final long serialVersionUID = -8959832007991513854L;

    private String largePosterUrl;
    private String criticsConsensus;
    private int audienceScore;

    private String title;
    private int year;
    private String synopsis;
    private String posterUrl;
    private int criticsScore;
    private ArrayList<String> castList;

    // Désérialisation du JSON
    public static MovieData fromJson(JSONObject jsonObject) {

        MovieData b = new MovieData();

        try {

            // Json -> objet
            b.title = jsonObject.getString("title");
            b.year = jsonObject.getInt("year");
            b.synopsis = jsonObject.getString("synopsis");
            b.posterUrl = jsonObject.getJSONObject("posters").getString("detailed");
            b.largePosterUrl = jsonObject.getJSONObject("posters").getString("detailed");
            b.criticsConsensus = jsonObject.getString("critics_consensus");
            b.audienceScore = jsonObject.getJSONObject("ratings").getInt("audience_score");
            b.criticsScore = jsonObject.getJSONObject("ratings").getInt("critics_score");

            // Création du tabeleau
            b.castList = new ArrayList<String>();
            JSONArray abridgedCast = jsonObject.getJSONArray("abridged_cast");

            for (int i = 0; i < abridgedCast.length(); i++) {

                b.castList.add(abridgedCast.getJSONObject(i).getString("name"));

            }

        } catch (JSONException e) {

            e.printStackTrace();
            return null;

        }

        // Return de l'objet
        return b;

    }

    // Parse du json
    // MovieData.fromJson(jsonArrayOfMovies)
    public static ArrayList<MovieData> fromJson(JSONArray jsonArray) {

        ArrayList<MovieData> businesses = new ArrayList<MovieData>(jsonArray.length());

        // objet
        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject businessJson = null;

            try {

                businessJson = jsonArray.getJSONObject(i);

            } catch (Exception e) {

                e.printStackTrace();
                continue;

            }

            MovieData business = MovieData.fromJson(businessJson);

            if (business != null) {

                businesses.add(business);

            }
        }

        return businesses;

    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public String getLargePosterUrl() {
        return largePosterUrl;
    }

    public String getCriticsConsensus() {
        return criticsConsensus;
    }

    public int getAudienceScore() {
        return audienceScore;
    }

    public int getCriticsScore() {
        return criticsScore;
    }

    public String getCastList() {
        return TextUtils.join(", ", castList);
    }

}
