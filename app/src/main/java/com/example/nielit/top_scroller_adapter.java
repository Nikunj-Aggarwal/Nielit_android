package com.example.nielit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class top_scroller_adapter extends RecyclerView.Adapter<top_scroller_adapter.ViewHolder> {

    Integer[] image;

    public top_scroller_adapter(Integer[] image)
    {
        this.image = image;
    }

    @Override
    public top_scroller_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.top_scroller,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull top_scroller_adapter.ViewHolder holder, int position) {
        holder.img.setImageResource(image[position]);
    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView);
        }
    }
}
