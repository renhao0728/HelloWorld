/*
 * Copyright (C) 2011 Patrik 锟絢erfeldt
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.citru.helloworld.adapter;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.example.citru.helloworld.R;
import com.example.citru.helloworld.entity.BannersEntity;
import com.example.citru.helloworld.util.P;

import java.util.ArrayList;


public class ImageAdapter extends BaseAdapter {
	private Context mContext;
	private LayoutInflater mInflater;
	ArrayList<BannersEntity> campusImgs;
	private int picW;
	private int picH;

	public ImageAdapter(Context context, ArrayList<BannersEntity> campusImgs, int screenWith) {
		
		this.campusImgs=campusImgs;
		mContext = context;
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		picW = (int) (screenWith * 1.0f / 1);
		picH = (int) (screenWith * 1.0f / 2);
	}

	

	@Override
	public int getCount() {
		return Integer.MAX_VALUE;  
	}
	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.image_item, null);
		}
		ImageView image = (ImageView) convertView
				.findViewById(R.id.imgView);
		image.setScaleType(ScaleType.FIT_XY);
		
//		P.loadImage(mContext, ids[position%ids.length], image, R.drawable.ic_launcher);
//		P.loadImage(mContext, AppConfig.URL_IMAGE+campusImgs.get(position%campusImgs.size()).imgPath, image, R.drawable.ic_launcher);
		P.loadResizeImage(mContext, campusImgs.get(position%campusImgs.size()).imgPath, image, picW, picH, R.mipmap.ic_launcher);
		convertView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
		return convertView;
	}

}
