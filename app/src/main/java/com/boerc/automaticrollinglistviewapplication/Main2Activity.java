package com.boerc.automaticrollinglistviewapplication;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {

    private ListView lvMusics;
    private mAdapter adapter;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            handler.removeCallbacks(run_scroll_down);
            handler.removeCallbacks(run_scroll_up);
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

            lvMusics.smoothScrollBy(80, 10);
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

            lvMusics.smoothScrollBy(-80, 10);
            handler.postDelayed(run_scroll_up, 1000);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lvMusics = (ListView) findViewById(R.id.lvMusics);
        adapter = new mAdapter(this, GoodsData.getMusics());
        lvMusics.setAdapter(adapter);
        listScrollUp();
        lvMusics.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                if (i == 0) {
                    Log.e("ListView", "##### 滚动到顶部 #####");
                } else
                    if ((i + i1) == i2) {
                    Log.e("ListView", "##### 滚动到底部 ######");
                        View lastVisibleItemView = lvMusics.getChildAt(lvMusics.getChildCount() - 1);
                        if (lastVisibleItemView != null && lastVisibleItemView.getBottom() == lvMusics.getHeight()) {
                            Log.d("ListView", "##### 滚动到底部dsfdsfdsfds ######");
                            lvMusics.smoothScrollToPosition(0);
                        }

                }
            }
        });
    }


    public void ondfd(View view) {
        switch (view.getId()){
            case R.id.btn_scroll_up:
                lvMusics.smoothScrollToPosition(0);
                break;
        }
    }
}
