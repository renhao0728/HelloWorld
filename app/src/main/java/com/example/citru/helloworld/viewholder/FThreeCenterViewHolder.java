package com.example.citru.helloworld.viewholder;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.citru.helloworld.R;
import com.example.citru.helloworld.util.UIUtils;
import com.example.citru.helloworld.view.FlowLayout;
import com.example.citru.helloworld.view.MyScrollView;

/**
 * Created by citrus on 2016/11/8.
 */

public class FThreeCenterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    MyScrollView mWiki;
    Context context;
    LinearLayout mContainer;
    ImageView mIvArrow;
    TextView mTv;
    //判断打开状态
    private boolean isOpened;

    private String[] mDatas;

    public FThreeCenterViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        mDatas = createDatas();
        setupView(itemView);
        initListener();
        initData();
    }


    private void initListener() {
        mTv.setOnClickListener(this);
        mIvArrow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (isOpened) {
            ObjectAnimator.ofFloat(mIvArrow, "rotation", -180, 0).start();
            animate(UIUtils.dip2px(200), UIUtils.dip2px(80));
            mTv.setText("查看更多");
            //设置不可滑动
            mWiki.setCanScroll(false);
        } else {
            ObjectAnimator.ofFloat(mIvArrow, "rotation", 0, 180).start();
            animate(UIUtils.dip2px(80), UIUtils.dip2px(200));
            mTv.setText("收起");
            //设置可滑动
            mWiki.setCanScroll(true);
        }
        isOpened = !isOpened;
    }


    private void animate(int start, int end) {
        ValueAnimator animator = ValueAnimator.ofInt(start, end);
        animator.setDuration(400);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = mWiki.getLayoutParams();
                layoutParams.height = value;
                mWiki.setLayoutParams(layoutParams);
            }
        });
        animator.start();
    }

    public void setupView(View upView) {
        mWiki = (MyScrollView) itemView.findViewById(R.id.faxian_center_wiki);
        mTv = (TextView) itemView.findViewById(R.id.faxian_center_tv);
        mIvArrow = (ImageView) itemView.findViewById(R.id.faxian_bottom_arrow);
        mContainer = (LinearLayout) itemView.findViewById(R.id.faxian_center_container);
    }

    private void initData() {
        if (mDatas == null) {
            mContainer.setVisibility(View.GONE);
            return;
        }
        mContainer.setVisibility(View.VISIBLE);

        FlowLayout mLayout = new FlowLayout(UIUtils.getContext());
        mWiki.addView(mLayout);

        ViewGroup.LayoutParams layoutParams = mWiki.getLayoutParams();
        layoutParams.height = UIUtils.dip2px(80);
        mWiki.setLayoutParams(layoutParams);

        mLayout.setSpace(UIUtils.dip2px(12), UIUtils.dip2px(12));

        for (int i = 0; i < mDatas.length; i++) {

            TextView tv = new TextView(UIUtils.getContext());
            tv.setText(mDatas[i]);
            tv.setGravity(Gravity.CENTER);
            tv.setPadding(UIUtils.dip2px(5), UIUtils.dip2px(5), UIUtils.dip2px(5), UIUtils.dip2px(5));
            //设置字体颜色的选择器
            ColorStateList colorSateList = AppCompatResources.getColorStateList(context,R.color.faxian_text_selector);
            tv.setTextColor(colorSateList);

            GradientDrawable normal = new GradientDrawable();
            normal.setShape(GradientDrawable.RECTANGLE);
            normal.setCornerRadius(UIUtils.dip2px(3));
            normal.setColor(Color.parseColor("#ffffff"));

            GradientDrawable pressed = new GradientDrawable();
            pressed.setShape(GradientDrawable.RECTANGLE);
            pressed.setCornerRadius(UIUtils.dip2px(3));
            pressed.setColor(Color.parseColor("#97445C"));

            StateListDrawable selector = new StateListDrawable();
            selector.addState(new int[]{android.R.attr.state_pressed}, pressed);
            selector.addState(new int[]{}, normal);

            tv.setBackground(selector);
            final int index = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(UIUtils.getContext(), "" + mDatas[index], Toast.LENGTH_SHORT).show();
                }
            });
            mLayout.addView(tv);
        }
    }
    public String[] createDatas() {
        String[] arr = {"太子妃升职记", "奶酪陷阱", "拜托了冰箱", "吃货天下", "请和废材的我谈恋爱", "暴走大事件", "了不起的挑战",
                "太子妃升职记", "奶酪陷阱", "拜托了冰箱", "吃货天下", "请和废材的我谈恋爱", "暴走大事件", "了不起的挑战",
                "太子妃升职记", "奶酪陷阱", "拜托了冰箱", "吃货天下", "请和废材的我谈恋爱", "暴走大事件", "了不起的挑战"};
        return arr;
    }
}
