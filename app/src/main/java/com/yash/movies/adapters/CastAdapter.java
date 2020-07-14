package com.yash.movies.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yash.movies.R;
import com.yash.movies.models.Cast;

import java.util.List;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.MyViewHolder> {

    Context context;
    List<Cast> mCast;

    public CastAdapter(Context context, List<Cast> mCast) {
        this.context = context;
        this.mCast = mCast;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cast, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Glide.with(context).load(mCast.get(position).getImgLink()).placeholder(R.drawable.placeholder_image)
                .into(holder.castImg);

    }

    @Override
    public int getItemCount() {
        return mCast.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView castImg;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            castImg = itemView.findViewById(R.id.img_cast);
        }
    }
}
