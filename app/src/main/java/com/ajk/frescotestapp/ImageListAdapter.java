package com.ajk.frescotestapp;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class ImageListAdapter extends BaseAdapter {

    private Context mContext;
    private List<ImageData> list;

    public ImageListAdapter(Context mContext, List<ImageData> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public ImageData getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        LayoutInflater mInflater;

        if (convertView == null) {
            //Initialize the View holder
            holder = new ViewHolder();
            //Layout Inflater to inflate the layout for each row
            mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //npw inflate the layout
            convertView = mInflater.inflate(R.layout.custom_list, null);

            //initialize all views
            //as we know the type casting like (tv = (TextView)...) is no more using now
            holder.title = convertView.findViewById(R.id.tvTitle);
            holder.count = convertView.findViewById(R.id.tvCount);
            holder.icon = convertView.findViewById(R.id.ivIcon);

            //set the holder like a tag to use further
            convertView.setTag(holder);
        } else {
            //now get the holder, it will help to set value in each view outside of this area
            holder = (ViewHolder)convertView.getTag();
        }

        //let's get each ImageData object for each row by the help of its position
        ImageData mImageData = list.get(position);

        //now set each value to each view
        holder.title.setText(mImageData.getTitle());

        //set the row number, starting from 1
        holder.count.setText("Row Number "+ position+1); //as position is starting from 0, we need to add one

        String url = mImageData.getImageUrl();
        Uri uri = Uri.parse(url);
        holder.icon.setImageURI(uri);

        return convertView;
    }

    static class ViewHolder {
        private TextView title;
        private TextView count;
        private SimpleDraweeView icon;
    }
}
