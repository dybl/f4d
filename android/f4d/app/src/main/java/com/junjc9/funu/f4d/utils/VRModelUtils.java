package com.junjc9.funu.f4d.utils;

import com.junjc9.funu.f4d.R;
import com.junjc9.funu.f4d.model.PanoramaImageModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunfusheng on 2017/8/2.
 */
public class VRModelUtils {

    public static final String[] titleArr = {
            "帝都、北京",
            "迪拜塔"
    };

    public static final String[] descArr = {
            "北京是一座有着三千多年历史的古都，是中华人民共和国的首都、直辖市。\n故宫是中国明清两代的皇家宫殿，旧称为紫禁城，位于北京中轴线的中心，是中国古代宫廷建筑之精华。",
            "迪拜塔是世界第一高楼与人工构造物，楼层总数162层，造价15亿美元。\n迪拜塔也叫哈利法塔，在古阿拉伯世界中，哈利法为“伊斯兰世界最高领袖”之意，同时也是历史上阿拉伯帝国统治者的称号。"
            };

    public static final String[] assetArr = {
            "beijing_gugong.jpg",
            "dibaita.jpg"
    };

    public static final int[] resourceArr = {
            R.mipmap.beijing_gugong,
            R.mipmap.dibaita
    };

    public static List<PanoramaImageModel> getPanoramaImageList() {
        List<PanoramaImageModel> list = new ArrayList<>();
        for (int i = 0; i < titleArr.length; i++) {
            list.add(new PanoramaImageModel(0, titleArr[i], descArr[i], assetArr[i], resourceArr[i]));
        }
        return list;
    }

}
