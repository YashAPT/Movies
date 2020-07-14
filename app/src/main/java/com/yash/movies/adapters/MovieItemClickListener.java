package com.yash.movies.adapters;

import android.widget.ImageView;

import com.yash.movies.models.Movie;

public interface MovieItemClickListener {
    void onMovieCLick(Movie movie, ImageView movieImage);
}
