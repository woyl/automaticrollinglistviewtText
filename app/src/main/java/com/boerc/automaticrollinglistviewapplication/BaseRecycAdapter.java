package com.boerc.automaticrollinglistviewapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/12/8.
 */

public class BaseRecycAdapter extends RecyclerView.Adapter<BaseRecycAdapter.ViewHolder> {
    private List<Bean> list;

    public BaseRecycAdapter(List<Bean> list) {
        this.list = list;
    }

    /**
     * 创建子项item布局
     * */
    @Override
    public BaseRecycAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler_item,null);
        return new ViewHolder(view);
    }

    /**
     *
     * 绑定数据*/
    @Override
    public void onBindViewHolder(BaseRecycAdapter.ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.sex.setText(list.get(position).getSex());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name,sex;
        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_tv);
            sex = itemView.findViewById(R.id.sex_tv);
        }
    }
}
