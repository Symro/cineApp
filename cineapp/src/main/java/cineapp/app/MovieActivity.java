package cineapp.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Sylvain on 02/06/2014.
 * création d'une classe pour envoyer des requêtes à l'API
 */
public class MovieActivity extends Activity {

    //init
    private ListView lvMovies;
    private MoviesAdapter adapterMovies;
    NetworkService client;

    public static final String MOVIE_DETAIL_KEY = "movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_movies);

        lvMovies = (ListView) findViewById(R.id.lvMovies);
        ArrayList<MovieData> aMovies = new ArrayList<MovieData>();
        adapterMovies = new MoviesAdapter(this, aMovies);
        lvMovies.setAdapter(adapterMovies);

        fetchMovieData();
        setupMovieSelectedListener();

    }

    // Appel à l'API, parse des résultats
    // Conversion des resultats en tableau d'objet movie et ajout à l'adapter
    private void fetchMovieData() {

        client = new NetworkService();
        client.getListMovies(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int code, JSONObject body) {

                JSONArray items = null;

                try {

                    // Récupération du tableau json
                    items = body.getJSONArray("movies");
                    // parse du json en objet
                    ArrayList<MovieData> movies = MovieData.fromJson(items);

                    // On charge l'adaptateur de notre objet
                    for (MovieData movie : movies) {

                        adapterMovies.add(movie);

                    }

                } catch (JSONException e) {

                    e.printStackTrace();

                }
            }
        });
    }

    // Ecouteur pour lancer la deuxième activitée
    public void setupMovieSelectedListener() {

        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View item, int position, long rowId) {

                // On passe les données à la vue par un putExtra
                Intent i = new Intent(MovieActivity.this, MovieDetails.class);
                i.putExtra(MOVIE_DETAIL_KEY, adapterMovies.getItem(position));
                startActivity(i);

            }

        });
    }

}
