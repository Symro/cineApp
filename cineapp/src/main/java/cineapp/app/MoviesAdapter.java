package cineapp.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Sylvain on 02/06/2014.
 * Faire la liaison entre MovieData à une vue
 */
public class MoviesAdapter extends ArrayAdapter<MovieData> {

    public MoviesAdapter(Context context, ArrayList<MovieData> aMovies) {

        super(context, 0, aMovies);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        // on récupère la data en fonction de notre position
        MovieData movie = getItem(position);

        // On vérifie si une vue existente est réutilisée
        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.movie_item, parent, false);

        }

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvCriticsScore = (TextView) convertView.findViewById(R.id.tvCriticsScore);
        TextView tvCast = (TextView) convertView.findViewById(R.id.tvCast);
        ImageView ivPosterImage = (ImageView) convertView.findViewById(R.id.ivPosterImage);

        // On met la data dans la vue
        tvTitle.setText(movie.getTitle());
        tvCriticsScore.setText("Score: " + movie.getCriticsScore() + "%");
        tvCast.setText("With: " + movie.getCastList());
        Picasso.with(getContext()).load(movie.getPosterUrl()).into(ivPosterImage);

        // On retourne la vue pour pouvoir l'afficher
        return convertView;

    }
}
