package com.cooloongwu.coolarithmetic.utils;

import android.app.Activity;
import android.content.Intent;

import com.cooloongwu.coolarithmetic.activity.AdvanceActivity;
import com.cooloongwu.coolarithmetic.activity.LoginActivity;
import com.cooloongwu.coolarithmetic.activity.MainActivity;
import com.cooloongwu.coolarithmetic.activity.RankActivity;

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

    public static void startRankActivity(Activity activity) {
        Intent intent = new Intent(activity, RankActivity.class);
        activity.startActivity(intent);
    }

    public static void startLoginActivity(Activity activity) {
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
    }

    public static void startMainActivity(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }

}
