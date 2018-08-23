package com.moremoregreen.androidinstagramfilter.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moremoregreen.androidinstagramfilter.R;

import java.util.ArrayList;
import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ColorViewHolder> {
    Context context;
    List<Integer> colorList;
    ColorAdapterListener listener;

    public ColorAdapter(Context context, ColorAdapterListener listener) {
        this.context = context;
        this.colorList = genColorList();
        this.listener = listener;
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.color_item, parent, false);
        return new ColorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        holder.color_section.setCardBackgroundColor(colorList.get(position));

    }

    @Override
    public int getItemCount() {
        return colorList.size();
    }

    public class ColorViewHolder extends RecyclerView.ViewHolder {
        public CardView color_section;

        public ColorViewHolder(View itemView) {
            super(itemView);
            color_section = itemView.findViewById(R.id.color_section);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onColorSelected(colorList.get(getAdapterPosition()));
                }
            });
        }
    }
    private List<Integer> genColorList() {
        List<Integer> colorList = new ArrayList<>();
        colorList.add(Color.parseColor("#131722"));
        colorList.add(Color.parseColor("#ffc0cb"));
        colorList.add(Color.parseColor("#ffffff"));
        colorList.add(Color.parseColor("#ff0000"));
        colorList.add(Color.parseColor("#ffd700"));
        colorList.add(Color.parseColor("#00ffff"));
        colorList.add(Color.parseColor("#800000"));
        colorList.add(Color.parseColor("#008080"));
        colorList.add(Color.parseColor("#660066"));
        return colorList;
    }
    public interface ColorAdapterListener {
        void onColorSelected(int color);
    }
}
