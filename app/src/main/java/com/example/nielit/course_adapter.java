package com.example.nielit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class course_adapter extends RecyclerView.Adapter<course_adapter.ViewHolder> {

    Integer[] image;
    String[] title;
    String[] price;
    String[] duration;


    public course_adapter(Integer[] image, String[] title, String[] price,String[] duration)
    {
        this.image = image;
        this.title = title;
        this.price = price;
        this.duration = duration;
    }

    @Override
    public course_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.courses_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull course_adapter.ViewHolder holder, int position) {
        holder.img.setImageResource(image[position]);
        holder.course_title.setText(title[position]);
        holder.course_fee.setText(price[position]);
        holder.course_duration.setText(duration[position]);
    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView course_title, course_fee,course_duration;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.course_image);
            course_title = itemView.findViewById(R.id.course_name);
            course_fee = itemView.findViewById(R.id.course_fee);
            course_duration = itemView.findViewById(R.id.course_duration);
        }
    }
}