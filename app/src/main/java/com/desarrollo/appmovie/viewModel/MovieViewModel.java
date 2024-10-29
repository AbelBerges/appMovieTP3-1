package com.desarrollo.appmovie.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.desarrollo.appmovie.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieViewModel extends ViewModel {
    private MutableLiveData<List<Movie>> movieList;
    public MovieViewModel(){
        movieList = new MutableLiveData<>();
        loadMovie();
    }
    private void loadMovie(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie( "Vacaciones en Familia", "https://via.assets.so/movie.png?id=1&q=95&w=360&h=360&fit=fill",3.0f));
        movies.add(new Movie( "He's all That", "https://via.assets.so/movie.png?id=2&q=95&w=360&h=360&fit=fill", 4.0f));
        movies.add(new Movie( "Venom", "https://via.assets.so/movie.png?id=3&q=95&w=360&h=360&fit=fill", 2.5f));
        movies.add(new Movie( "Encanto", "https://via.assets.so/movie.png?id=4&q=95&w=360&h=360&fit=fill", 4.0f));
        movies.add(new Movie( "Los locos Adams", "https://via.assets.so/movie.png?id=5&q=95&w=360&h=360&fit=fill", 4.0f));
        movies.add(new Movie( "LAMB", "https://via.assets.so/movie.png?id=6&q=95&w=360&h=360&fit=fill", 2.0f));
        movieList.setValue(movies);
    }
    public LiveData<List<Movie>> getMovies(){
        return movieList;
    }
}
