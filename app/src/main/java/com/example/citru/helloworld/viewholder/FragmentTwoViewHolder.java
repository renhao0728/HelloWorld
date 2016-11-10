package com.example.citru.helloworld.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.citru.helloworld.R;
import com.example.citru.helloworld.entity.FragmentTwoEntity;

/**
 * Created by citrus on 2016/11/4.
 */

public class FragmentTwoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView ivIcon;
    private TextView tvTitle;
    Context context;
    public FragmentTwoViewHolder(View itemView,Context context) {
        super(itemView);
        this.context=context;
        ivIcon=(ImageView)itemView.findViewById(R.id.item_fenqu_icon);
        tvTitle=(TextView)itemView.findViewById(R.id.item_fenqu_tv);
        itemView.setOnClickListener(this);
    }
    public void loadData(FragmentTwoEntity fenquBean) {
        ivIcon.setImageResource(fenquBean.icon);
        tvTitle.setText(fenquBean.title);
    }
    @Override
    public void onClick(View view) {
        Toast.makeText(context, tvTitle.getText(), Toast.LENGTH_SHORT).show();
    }
}
