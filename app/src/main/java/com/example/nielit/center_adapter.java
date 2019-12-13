package com.example.nielit;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class center_adapter extends BaseAdapter {

    String[] cname ;
    String[] cweb ;
    Activity context;

    public center_adapter(Activity context, ArrayList<String> cname, ArrayList<String> cweb )
    {
        this.cname = cname.toArray(new String[0]);
        this.cweb = cweb.toArray(new String[0]);
        this.context = context;
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
        View v = inflater.inflate(R.layout.center_cell,null);
        TextView txt = v.findViewById(R.id.cname);
        txt.setText("Nielit "+cname[i]+" Centre");

        txt.setMovementMethod(LinkMovementMethod.getInstance());
        txt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse(cweb[i]));
                context.startActivity(browserIntent);
            }
        });

        return v;
    }
}