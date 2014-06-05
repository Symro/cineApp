package cineapp.app;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Sylvain on 02/06/2014.
 * création d'une classe pour envoyer des requêtes à l'API
 */
public class MovieDetails extends Activity {

    private ImageView ivPosterImage;
    private TextView tvTitle;
    private TextView tvCast;
    private TextView tvYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        // On récupère les éléments de notre vue
        ivPosterImage = (ImageView) findViewById(R.id.ivPosterImage);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvCast = (TextView) findViewById(R.id.tvCast);
        tvYear = (TextView) findViewById(R.id.tvYear);

        // On utilise notre model pour peupler notre vue des bonnes données
        MovieData movie = (MovieData)
                getIntent().getSerializableExtra(MovieActivity.MOVIE_DETAIL_KEY);

        // on appelle la methode qui va permettre d'afficher ces données dans la vue
        loadMovie(movie);

    }

    public void loadMovie(MovieData movie) {

        // On envoie les données à la vue
        tvTitle.setText(movie.getTitle());
        tvYear.setText(Html.fromHtml("" + movie.getYear()));
        tvCast.setText(movie.getCastList());

        Picasso.with(this).load(movie.getLargePosterUrl()).
                placeholder(R.drawable.large_movie_poster).
                into(ivPosterImage);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.movie_details, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}
