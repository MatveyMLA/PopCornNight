package popcornnight.mati.com.popcornnight.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import popcornnight.mati.com.popcornnight.R;
import popcornnight.mati.com.popcornnight.classes.Movie;

/**
 * Created by evelina on 28.09.2016.
 */
public class InternetMovieViewAdapter extends ArrayAdapter<Movie> {

    private int currentLayout;
    private Context context;
    List<Movie> movies;

    public InternetMovieViewAdapter(Context context, int resource, List<Movie> movies) {
        super(context, resource, movies);
        this.currentLayout = resource;
        this.context = context;
        this.movies = movies;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(currentLayout,null);
        Movie movie = movies.get(position);
        ImageView image = (ImageView) view.findViewById(R.id.imageInterMovie);
        Picasso.with(context).load(movie.getImgUrl()).into(image);
        ((TextView)view.findViewById(R.id.titleInternetMovieTV)).setText(movie.getTitle());
        ((TextView)view.findViewById(R.id.yearInternetMovieTV)).setText(movie.getYear());

        return view;
    }
}
