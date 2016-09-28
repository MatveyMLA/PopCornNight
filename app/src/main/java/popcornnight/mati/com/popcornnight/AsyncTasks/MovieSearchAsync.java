package popcornnight.mati.com.popcornnight.AsyncTasks;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import popcornnight.mati.com.popcornnight.classes.Movie;

/**
 * Created by evelina on 28.09.2016.
 */
public class MovieSearchAsync extends AsyncTask<String, Integer, String> {

    private ArrayList<Movie> movies;
    Movie movie;

    public MovieSearchAsync(ArrayList<Movie> movies) {
        this.movies = movies;
    }


    @Override
    protected String doInBackground(String... strings) {

        String result = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(strings[0]).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;


    }

    @Override
    protected void onPostExecute(String jsonMovies) {


        try {
            JSONObject jObect = new JSONObject(jsonMovies);
            JSONArray moviesJsonArray = jObect.getJSONArray("Search");
            for(int i = 0; i<10; i++){
                movie = new Movie();
                jObect = moviesJsonArray.getJSONObject(0);
                movie.setTitle(jObect.getString("Title"));
                movie.setYear(jObect.getInt("Year"));
                movie.setImdbID(jObect.getString("imdbID"));
                movie.setImgUrl(jObect.getString("Poster"));
                movies.add(movie);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
