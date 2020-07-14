package com.yash.movies.utils;

import com.yash.movies.R;
import com.yash.movies.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class DataSources {


    public static List<Movie> getPopularMovies(){

        List<Movie> listMovies = new ArrayList<>();
        listMovies.add(new Movie("1917", R.drawable.movie1, R.drawable.cover));
        listMovies.add(new Movie("DORA", R.drawable.movie2, R.drawable.cover));
        listMovies.add(new Movie("After", R.drawable.movie3, R.drawable.cover));
        listMovies.add(new Movie("Archer", R.drawable.movie4, R.drawable.cover));
        listMovies.add(new Movie("Dead Horses", R.drawable.dead, R.drawable.cover));
        listMovies.add(new Movie("Sawshank Redemption", R.drawable.shaw, R.drawable.cover));
        listMovies.add(new Movie("GOLD", R.drawable.image2, R.drawable.cover));
        listMovies.add(new Movie("DilWale", R.drawable.image1jpg, R.drawable.cover));
        listMovies.add(new Movie("MOANA", R.drawable.moana, R.drawable.cover));
        listMovies.add(new Movie("The Martian", R.drawable.themartian, R.drawable.cover));

        return listMovies;

    }

    public static List<Movie>  getWeekMovies(){

        List<Movie> listMovies = new ArrayList<>();
        listMovies.add(new Movie("Sawshank Redemption", R.drawable.shaw, R.drawable.cover));
        listMovies.add(new Movie("GOLD", R.drawable.image2, R.drawable.cover));
        listMovies.add(new Movie("DilWale", R.drawable.image1jpg, R.drawable.cover));
        listMovies.add(new Movie("MOANA", R.drawable.moana, R.drawable.cover));
        listMovies.add(new Movie("The Martian", R.drawable.themartian, R.drawable.cover));
        listMovies.add(new Movie("1917", R.drawable.movie1, R.drawable.cover));
        listMovies.add(new Movie("DORA", R.drawable.movie2, R.drawable.cover));
        listMovies.add(new Movie("After", R.drawable.movie3, R.drawable.cover));
        listMovies.add(new Movie("Archer", R.drawable.movie4, R.drawable.cover));
        listMovies.add(new Movie("Dead Horses", R.drawable.dead, R.drawable.cover));


        return listMovies;

    }

}
