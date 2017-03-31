package com.cooloongwu.coolarithmetic.utils;

import android.app.Activity;
import android.content.Intent;

import com.cooloongwu.coolarithmetic.activity.AdvanceActivity;

/**
 * 跳转逻辑工具
 * Created by CooLoongWu on 2017-3-31 17:06.
 */

public class StartActivityUtils {

    public static void startAdvanceActivity(Activity activity, int grade) {
        Intent intent = new Intent(activity, AdvanceActivity.class);
        intent.putExtra("grade", grade);
        activity.startActivity(intent);
    }

}