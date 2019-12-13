package com.example.nielit;

import android.app.Activity;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class list_adapter extends BaseAdapter {

    String[] cname ;
    String[] cfee ;
    String[] cduration ;
    String[] celg ;
    Activity context;
    String[] csyll ;
    String[] img;



    public list_adapter(Activity context, ArrayList<String> cname, ArrayList<String> cfee , ArrayList<String> cduration , ArrayList<String> celg , ArrayList<String> csyll, ArrayList<String> image)
    {
        this.cduration = cduration.toArray(new String[0]);
        this.celg = celg.toArray(new String[0]);
        this.cfee = cfee.toArray(new String[0]);
        this.cname = cname.toArray(new String[0]);
        this.csyll = csyll.toArray(new String[0]);
        this.context = context;
        img = image.toArray(new String[0]);
        Log.e("tag","constructor called");
       // ArrayList<String> ima = img;

    }

    @Override
    public int getCount() {
        return cname.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(R.layout.course_cell,null);
        TextView name = v.findViewById(R.id.cname);
        TextView fee = v.findViewById(R.id.cfee);
        TextView dur = v.findViewById(R.id.cduration);
        TextView elg = v.findViewById(R.id.celg);
        Button btn = v.findViewById(R.id.btn);
        Button reg = v.findViewById(R.id.reg);
        ImageView imga = v.findViewById(R.id.courseImg);

        name.setText(cname[i]);
        fee.setText(cfee[i]);
        dur.setText(cduration[i]);
        elg.setText(celg[i]);
        Picasso
                .get()
                .load(Uri.parse(img[i]))
               // .centerCrop()
                .into(imga);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri = Uri.parse(csyll[i]); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);

            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(context,Registration.class);

                context.startActivity(intent);
            }
        });

        return v;
    }
}

