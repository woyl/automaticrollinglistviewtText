package com.boerc.automaticrollinglistviewapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 * @date 2017/12/5
 */

public class mAdapter extends BaseAdapter {
    private ArrayList<GoodsBean> goodsBeen;
    private LayoutInflater inflater;

    public mAdapter(Context context, ArrayList<GoodsBean> goodsBeen) {
        if(goodsBeen != null)
            this.goodsBeen = goodsBeen;
        else
            this.goodsBeen = new ArrayList<GoodsBean>();
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return goodsBeen.size();
    }

    @Override
    public GoodsBean getItem(int position) {
        // TODO Auto-generated method stub
        return goodsBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        ViewHolder holder = null;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.item, null);
            holder = new ViewHolder();
            holder.tvName = (TextView)convertView.findViewById(R.id.tvName);
            holder.tvAlbum = (TextView)convertView.findViewById(R.id.tvAlbum);
            holder.tvArtist = (TextView)convertView.findViewById(R.id.tvArtist);
            holder.tvDuration = (TextView)convertView.findViewById(R.id.tvDuration);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        GoodsBean m = goodsBeen.get(position);
        holder.tvName.setText(m.getName());
        holder.tvAlbum.setText(m.getAlbum());
        holder.tvArtist.setText(m.getArtist());
        holder.tvDuration.setText(m.getDuration());
        return convertView;

    }

    class ViewHolder{
        private TextView tvName;
        private TextView tvDuration;
        private TextView tvArtist;
        private TextView tvAlbum;
    }
}
