package com.desarrollo.appmovie.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.desarrollo.appmovie.R;
import com.desarrollo.appmovie.databinding.ActivityMainBinding;
import com.desarrollo.appmovie.listener.MovieClickedListener;
import com.desarrollo.appmovie.model.Movie;
import com.desarrollo.appmovie.viewModel.MovieViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MovieViewModel movieViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);

        movieViewModel.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                if (movies != null && !movies.isEmpty()){
                    Log.d("MovieList", "Milista " + movies.size());
                    MovieAdapter adapter = new MovieAdapter(movies, new MovieClickedListener() {
                        @Override
                        public void onMovieClicked(Movie movie) {
                            Toast.makeText(MainActivity.this,"Elegís: " + movie.getTitle(), Toast.LENGTH_LONG).show();
                        }
                    },MainActivity.this);
                    binding.recycler.setAdapter(adapter);
                } else {
                    Log.d("MovieList","Lista vacía");
                }
            }
        });
    }
}