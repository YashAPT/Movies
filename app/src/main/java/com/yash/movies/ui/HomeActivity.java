package com.yash.movies.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;
import com.yash.movies.models.Movie;
import com.yash.movies.adapters.MovieAdapter;
import com.yash.movies.adapters.MovieItemClickListener;
import com.yash.movies.R;
import com.yash.movies.models.Slide;
import com.yash.movies.adapters.SliderAdapter;
import com.yash.movies.utils.DataSources;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> listSlide;
    private ViewPager slidePager;
    private TabLayout indicator;
    private RecyclerView movieRV, moviesRvWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        iniViews();

        iniSlider();

        iniPopularMovies();

        iniWeekMovies();

    }

    private void iniWeekMovies() {
        MovieAdapter weekAdapter = new MovieAdapter(this, DataSources.getWeekMovies(), this);
        moviesRvWeek.setAdapter(weekAdapter);
        moviesRvWeek.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void iniPopularMovies() {

        MovieAdapter movieAdapter = new MovieAdapter(this, DataSources.getPopularMovies(), this);
        movieRV.setAdapter(movieAdapter);
        movieRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void iniSlider() {
        listSlide = new ArrayList<>();
        listSlide.add(new Slide(R.drawable.dead, "Dead Horses"));
        listSlide.add(new Slide(R.drawable.shaw, "Shawshank Redemption"));
        listSlide.add(new Slide(R.drawable.image1jpg, "DilWale"));
        listSlide.add(new Slide(R.drawable.image2, "GOLD"));

        SliderAdapter mAdapter = new SliderAdapter(this, listSlide);
        slidePager.setAdapter(mAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 3700);
        indicator.setupWithViewPager(slidePager, true);
    }

    private void iniViews() {
        slidePager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        movieRV = findViewById(R.id.rv_movies);
        moviesRvWeek = findViewById(R.id.rv_this_week);
    }

    @Override
    public void onMovieCLick(Movie movie, ImageView movieImage) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("title", movie.getTitle());
        intent.putExtra("imgURL", movie.getThumbnail());
        intent.putExtra("imgCover", movie.getCoverPhoto());
        //startActivity(intent);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this
                , movieImage, "sharedName");
        startActivity(intent, options.toBundle());

    }

    class SliderTimer extends TimerTask {
        @Override
        public void run() {
            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (slidePager.getCurrentItem() < listSlide.size() - 1) {
                        slidePager.setCurrentItem(slidePager.getCurrentItem() + 1);
                    } else {
                        slidePager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}