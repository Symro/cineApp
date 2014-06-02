package cineapp.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MovieActivity extends Activity {

    private ListView lvMovies;
    private MoviesAdapter adapterMovies;
    NetworkService client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_movies);

        lvMovies = (ListView) findViewById(R.id.lvMovies);
        ArrayList<MovieData> aMovies = new ArrayList<MovieData>();
        adapterMovies = new MoviesAdapter(this, aMovies);
        lvMovies.setAdapter(adapterMovies);

        fetchMovieData();
    }

    // Appel à l'API, parse des résultats
    // Conversion des resultats en tableau d'objet movie et ajout à l'adapter
    private void fetchMovieData() {
        client = new NetworkService();
        client.getBoxOfficeMovies(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int code, JSONObject body) {
                JSONArray items = null;
                try {
                    // Get the movies json array
                    items = body.getJSONArray("movies");
                    // Parse json array into array of model objects
                    ArrayList<MovieData> movies = MovieData.fromJson(items);
                    // Load model objects into the adapter
                    for (MovieData movie : movies) {
                        adapterMovies.add(movie);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
