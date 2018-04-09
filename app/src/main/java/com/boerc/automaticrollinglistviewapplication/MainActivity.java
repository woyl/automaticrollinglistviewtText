package com.boerc.automaticrollinglistviewapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**
     *
     * recyclerview实现方法
     * */
    private RecyclerView recyclerView;
    private List<Bean> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intview();
        inData();
        intAdapter();
    }
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            handler.removeCallbacks(run_scroll_down);
            handler.removeCallbacks(run_scroll_up);
        }
    };
    Runnable run_scroll_up = new Runnable() {
        @Override
        public void run() {
            /**
             * public void smoothScrollBy (int distance, int duration)
             *
             * Added in API level 8 Smoothly scroll by distance pixels over duration milliseconds.
             *
             * Parameters
             *     distance Distance to scroll in pixels.
             *     duration Duration of the scroll animation in milliseconds.
             */

            recyclerView.smoothScrollBy(80, 10);
            handler.postDelayed(run_scroll_up, 1000);
        }
    };
    Runnable run_scroll_down = new Runnable() {
        @Override
        public void run() {
            /**
             * public void smoothScrollBy (int distance, int duration)
             *
             * Added in API level 8 Smoothly scroll by distance pixels over duration milliseconds.
             *
             * Parameters
             *     distance Distance to scroll in pixels.
             *     duration Duration of the scroll animation in milliseconds.
             */

            recyclerView.smoothScrollBy(-80, 10);
            handler.postDelayed(run_scroll_up, 1000);
        }
    };
    /**
     * 向上滚动
     */
    public void listScrollUp() {
        listScrollOff();
        handler.postDelayed(run_scroll_up, 0);
    }

    /**
     * 向下滚动
     */
    public void listScrollDown() {
        listScrollOff();
        handler.postDelayed(run_scroll_down, 0);
    }
    /**
     * 停止滚动
     */
    public void listScrollOff() {
        handler.removeCallbacks(run_scroll_down);
        handler.removeCallbacks(run_scroll_up);
    }

    private void intAdapter() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this,MyDividerItemDecoration.VERTICAL_LIST));
        BaseRecycAdapter adapter = new BaseRecycAdapter(list);
        recyclerView.setAdapter(adapter);
        listScrollUp();
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                /**什么样的布局，就设置什么的管理器*/
                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                //当停止滑动的时候
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    /**获取最后一个显示在最的角标值*/
                    int lastItemVisible = manager.findLastCompletelyVisibleItemPosition();
                    //所有条目 的数量值
                    int totalItemCount = manager.getItemCount();
                    if (lastItemVisible == (totalItemCount-1)){
                        Log.d("ListView", "##### 滚动到底部dsfdsfdsfds ######");
                        recyclerView.smoothScrollToPosition(0);
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    private void inData() {
        list = new ArrayList<>();
        Bean b = new Bean();
        b.setName("小马");
        b.setSex("男");
        Bean b1 = new Bean();
        b1.setName("佛挡杀佛");
        b1.setSex("男");
        Bean b2 = new Bean();
        b2.setName("ff");
        b2.setSex("女");
        Bean b3 = new Bean();
        b3.setName("范德萨");
        b3.setSex("男");
        Bean b4 = new Bean();
        b4.setName("红红");
        b4.setSex("女");
        Bean b5 = new Bean();
        b5.setName("小马");
        b5.setSex("男");
        Bean b6 = new Bean();
        b6.setName("不痤疮颗粒");
        b6.setSex("男");
        Bean b7 = new Bean();
        b7.setName("选妃");
        b7.setSex("女");
        list.add(b);
        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);
        list.add(b5);
        list.add(b6);
        list.add(b7);

    }

    private void intview() {
        recyclerView = (RecyclerView) findViewById(R.id.recyc);
    }
}
