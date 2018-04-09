package com.boerc.automaticrollinglistviewapplication;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/16.
 */

public class GoodsData {
    public static ArrayList<GoodsBean> getMusics(){
        ArrayList<GoodsBean> musics = new ArrayList<GoodsBean>();
        for(int i = 0;i<10;i++){
            GoodsBean m = new GoodsBean();
            m.setName("歌曲" + i);
            m.setAlbum("专辑" + i);
            m.setDuration("14:23");
            m.setArtist("陈奕迅");
            musics.add(m);
        }
        return musics;
    }
}
