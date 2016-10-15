package com.example.citru.helloworld.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.citru.helloworld.R;
import com.example.citru.helloworld.entity.ContentEntity;
import com.example.citru.helloworld.util.P;

import java.util.ArrayList;

/**
 * Created by citrus on 2016/8/11.
 */
public class ContetntAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    ArrayList<ContentEntity> data;

    public ContetntAdapter(Context context,ArrayList<ContentEntity> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.context = context;
        if (data == null) {
            this.data = new ArrayList<ContentEntity>();
        } else {
            this.data = data;
        }
    }

    public void setData(ArrayList<ContentEntity> data) {
        if (data == null) {
            this.data = new ArrayList<ContentEntity>();
        } else {
            this.data = data;
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View v, ViewGroup parent ) {
        ViewHolder vh = null;
        ContentEntity entity = data.get(i);
        if (v == null) {
            vh = new ViewHolder();
            v = inflater.inflate(R.layout.item_acttivity_content, parent,
                    false);
            vh.iv1 = (ImageView) v.findViewById(R.id.iv_item_content_1);
            vh.iv2 = (ImageView) v.findViewById(R.id.iv_item_content_2);
            vh.iv3 = (ImageView) v.findViewById(R.id.iv_item_content_3);
            v.setTag(vh);
        } else {
            vh = (ViewHolder) v.getTag();

        }
        P.loadImage(context,entity.img1,vh.iv1,R.mipmap.ic_launcher);
        P.loadImage(context,entity.img2,vh.iv2,R.mipmap.ic_launcher);
        P.loadImage(context,entity.img3,vh.iv3,R.mipmap.ic_launcher);
        return v;

    }

    class ViewHolder {
        ImageView iv1;
        ImageView iv2;
        ImageView iv3;

    }
}
