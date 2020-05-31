package com.yoji.listwithcustomelements.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yoji.listwithcustomelements.R;

import java.util.ArrayList;
import java.util.List;

public class MainFragmentAdapter extends BaseAdapter {

    private List<MainFragmentItemData> itemList;
    private LayoutInflater inflater;

    public MainFragmentAdapter (Context context, List<MainFragmentItemData> itemList){
        if (itemList == null){
            this.itemList = new ArrayList<>();
        }else {
            this.itemList = itemList;
        }
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null){
            view = inflater.inflate(R.layout.item_fragment_main, parent, false);
        }

        MainFragmentItemData itemData = itemList.get(position);

        ImageView mainScreenImgView = view.findViewById(R.id.fragmentMainScreenImageViewId);
        TextView titleTxtView = view.findViewById(R.id.titleTxtViewId);
        TextView subtitleTxtView = view.findViewById(R.id.subtitleTxtViewId);

        mainScreenImgView.setImageDrawable(itemData.getImage());
        titleTxtView.setText(itemData.getTitle());
        subtitleTxtView.setText(itemData.getSubtitle());

        return view;
    }
}
