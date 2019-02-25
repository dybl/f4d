package com.junjc9.funu.f4d.utils;

import com.junjc9.funu.f4d.F4d;

public class ResUtils {
    /* 获取文件资源 */
    public static String getString(int strId) {
        return F4d.getContext().getResources().getString(strId);
    }
}
