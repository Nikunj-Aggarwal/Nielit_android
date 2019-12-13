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

public class nsqf_adapter extends BaseAdapter {
    String[] cname ;
    Activity context;

    public nsqf_adapter(Activity context, ArrayList<String> cname)
    {
        this.cname = cname.toArray(new String[0]);
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
        txt.setText(cname[i]);

        return v;
    }
}
