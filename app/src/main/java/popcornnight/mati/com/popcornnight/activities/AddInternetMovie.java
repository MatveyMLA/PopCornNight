package popcornnight.mati.com.popcornnight.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import popcornnight.mati.com.popcornnight.AsyncTasks.MovieSearchAsync;
import popcornnight.mati.com.popcornnight.R;
import popcornnight.mati.com.popcornnight.adapters.InternetMovieViewAdapter;
import popcornnight.mati.com.popcornnight.classes.Movie;

public class AddInternetMovie extends AppCompatActivity {

    private ArrayList<Movie> movies;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_internet_movie);
        movies = new ArrayList<>();
        ImageButton search = (ImageButton)findViewById(R.id.searchImageBtn);
        listView = (ListView)findViewById(R.id.internetMovieListView);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView searchTitle = (TextView)findViewById(R.id.titleToSearch);
                String movieToFind = searchTitle.getText().toString();
                String searchQuery  = "http://www.omdbapi.com/?s="+movieToFind;
                MovieSearchAsync movieSearchAsync = new MovieSearchAsync(movies);
                movieSearchAsync.execute(searchQuery);
//                listView.setAdapter(new InternetMovieViewAdapter(movies));

            }
        });



    }
}
