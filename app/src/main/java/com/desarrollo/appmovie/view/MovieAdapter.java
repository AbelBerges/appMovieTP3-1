package com.desarrollo.appmovie.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.desarrollo.appmovie.databinding.ItemMovieBinding;
import com.desarrollo.appmovie.listener.MovieClickedListener;
import com.desarrollo.appmovie.model.Movie;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<Movie> movies;
    private MovieClickedListener movieClickedListener;
    private Context context;
    public MovieAdapter(List<Movie> movies, MovieClickedListener movieClickedListener, Context context){
        this.movies = movies;
        this.movieClickedListener = movieClickedListener;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMovieBinding binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.getContext()), parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemMovieBinding binding;
        public ViewHolder(@NotNull ItemMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Movie movie) {
            binding.movieTitle.setText(movie.getTitle());
            Glide.with(context)
                    .load(movie.getCover())
                    .into(binding.movieCover);
            binding.movieRating.setRating(movie.getEstrellas());
            binding.movieCover.setOnClickListener(v -> movieClickedListener.onMovieClicked(movie));
        }
    }
}
