package com.yash.movies.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.*;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.yash.movies.R;
import com.yash.movies.adapters.CastAdapter;
import com.yash.movies.models.Cast;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private ImageView MovieThumbnail, movieCoverImg;
    private TextView tvTitle, tvDesc;
    private FloatingActionButton fab;
    private RecyclerView RvCast;
    private CastAdapter castAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();

        setUpRVcast();
    }

    private void setUpRVcast() {
        List<Cast> mData = new ArrayList<>();
        mData.add(new Cast("name", R.drawable.cast1_));
        mData.add(new Cast("name", R.drawable.cast5));
        mData.add(new Cast("name", R.drawable.cast4_));
        mData.add(new Cast("name", R.drawable.cast2_));
        mData.add(new Cast("name", R.drawable.cast1_));

        castAdapter = new CastAdapter(this, mData);
        RvCast.setAdapter(castAdapter);
        RvCast.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }

    void initView() {

        RvCast = findViewById(R.id.rv_cast);
        fab = findViewById(R.id.play_fab);
        String movieTitle = getIntent().getExtras().getString("title");
        int imgRes = getIntent().getExtras().getInt("imgURL");
        int imageCover = getIntent().getExtras().getInt("imgCover");
        MovieThumbnail = findViewById(R.id.detail_movie_img);
        Glide.with(this).load(imgRes)
                .placeholder(R.drawable.placeholder_image).into(MovieThumbnail);

        MovieThumbnail.setImageResource(imgRes);
        movieCoverImg = findViewById(R.id.detail_movie_cover);
        Glide.with(this).load(imageCover).placeholder(R.drawable.placeholder_image)
                .into(movieCoverImg);
        tvTitle = findViewById(R.id.detail_movie_title);
        tvDesc = findViewById(R.id.detail_movie_desc);

        tvTitle.setText(movieTitle);
        tvDesc = findViewById(R.id.detail_movie_desc);
        getSupportActionBar().setTitle(movieTitle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        movieCoverImg.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));
        fab.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));

    }

}