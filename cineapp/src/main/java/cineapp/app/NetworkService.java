package cineapp.app;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by Sylvain on 02/06/2014.
 * création d'une classe pour envoyer des requêtes à l'API
 */
public class NetworkService {

    private final String API_KEY = "cg3nrtnp2mm9c2zvtmkdp365";
    private final String API_BASE_URL = "http://api.rottentomatoes.com/api/public/v1.0/";
    private AsyncHttpClient client;

    public NetworkService() {
        this.client = new AsyncHttpClient();
    }

    // Méthode pour acceder a l'API de façon asynchrone
    // Notre requête
    // http://api.rottentomatoes.com/api/public/v1.0/lists/movies/box_office.json?apikey=cg3nrtnp2mm9c2zvtmkdp365
    public void getBoxOfficeMovies(JsonHttpResponseHandler handler) {
        String url = getApiUrl("lists/movies/box_office.json");
        RequestParams params = new RequestParams("apikey", API_KEY);
        client.get(url, params, handler);
    }

    private String getApiUrl(String relativeUrl) {
        return API_BASE_URL + relativeUrl;
    }

}
