package com.example.citru.helloworld.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.citru.helloworld.R;
import com.example.citru.helloworld.entity.FramentOneEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by citrus on 2016/11/4.
 */

public class FragmentOneAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public String net1 = "http://img2.imgtn.bdimg.com/it/u=2955762202,755888452&fm=21&gp=0.jpg";
    public String net2 = "http://img2.imgtn.bdimg.com/it/u=2955762202,755888452&fm=21&gp=0.jpg";
    public String net3 = "http://img2.imgtn.bdimg.com/it/u=2955762202,755888452&fm=21&gp=0.jpg";

    private static final int TYPE_LUNBO = 0;
    private static final int TYPE_TITLE = 1;
    private static final int TYPE_FENLEI = 2;
    private static final int TYPE_LIANZAI = 3;
    private static final int TYPE_TUIJIAN = 4;
    private static final int TYPE_WANJIE = 5;

    public List<FramentOneEntity> mDatas = new ArrayList<>();


    public FragmentOneAdapter() {
        mDatas = createData();
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
        //TODO
//      return mDatas.size() + 1;
    }

    public List<FramentOneEntity> createData() {
        List<FramentOneEntity> list = new ArrayList<>();
        list.add(new FramentOneEntity(R.drawable.ic_lianzai, "新番连载"));
        list.add(new FramentOneEntity(net1, "画江湖 之灵主", "第13话", "上周六", "1074人在看", net2, "游戏王 重制版 决斗这王国", "第1话", "上周六", "1074人在看"));
        list.add(new FramentOneEntity(net3, "爱神巧克力", "第2话", "上周六", "1074人在看", net1, "我们这一家 新篇", "第1话", "上周六", "1074人在看"));
        list.add(new FramentOneEntity(net2, "动画锻炼！EX", "第3话", "上周六", "1074人在看", net3, "高中女生给你做饭了", "第1话", "上周六", "1074人在看"));
        list.add(new FramentOneEntity(net1, "动画锻炼！EX", "第3话", "上周六", "1074人在看", net2, "高中女生给你做饭了", "第1话", "上周六", "1074人在看"));

        list.add(new FramentOneEntity(R.drawable.ic_wanjie, "完结动画"));
        list.add(new FramentOneEntity(net1, "恶棍之家 第六季", "12话全", net2, "恶棍之家 第五季", "18话全", net3, "恶棍之家 第四季", "28话全", 0.768f));

        list.add(new FramentOneEntity(R.drawable.ic_fenlei, "分类推荐"));
        list.add(new FramentOneEntity(net1, "乙女向", net2, "治愈", net3, "日常"));

        list.add(new FramentOneEntity(R.drawable.ic_zhuanti, "马猴烧月"));
        list.add(new FramentOneEntity(net3, "爱神巧克力", "第1话", "上周六", "1074人在看", net2, "爱神巧克力", "第1话", "上周六", "1074人在看"));
        list.add(new FramentOneEntity(net3, "爱神巧克力", "第1话", "上周六", "1074人在看", net2, "爱神巧克力", "第1话", "上周六", "1074人在看"));
        list.add(new FramentOneEntity(net3, "爱神巧克力", "第1话", "上周六", "1074人在看", net2, "爱神巧克力", "第1话", "上周六", "1074人在看"));

        list.add(new FramentOneEntity(R.drawable.ic_tuijian, "番剧推荐"));

        list.addAll(createTuiJianDatas());

        return list;
    }

    public  List<FramentOneEntity> createTuiJianDatas() {
        List<FramentOneEntity> list = new ArrayList<>();
        list.add(new FramentOneEntity(net1, "粗点心战争","第一话", "5", 0.656f));
        list.add(new FramentOneEntity(net2, "粗点心战争", "第一话", "5", 0.667f));
        list.add(new FramentOneEntity(net3, "粗点心战争", "第一话", "5", 0.667f));
        list.add(new FramentOneEntity(net1, "粗点心战争", "第一话", "5", 0.775f));
        list.add(new FramentOneEntity(net2, "粗点心战争", "第一话", "5", 1.6f));
        list.add(new FramentOneEntity(net3, "粗点心战争", "第一话", "5", 0.775f));
        list.add(new FramentOneEntity(net1, "粗点心战争", "第一话", "5", 1.6f));
        list.add(new FramentOneEntity(net2, "粗点心战争", "第一话", "5", 1.6f));
        list.add(new FramentOneEntity(net3, "粗点心战争", "第一话", "5", 1.6f));
        list.add(new FramentOneEntity(net1, "粗点心战争", "第一话", "5", 1.6f));
        return list;
    }
}
