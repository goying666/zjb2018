package renchaigao.com.zjb.util;

import android.view.View;

/**
 * Created by Administrator on 2018/6/25/025.
 */

public class create_team_func {
    final private static String gone = "View.GONE";
    final private static String visible = "View.VISIBLE";

    private String invisible = "View.INVISIBLE";

    public static Integer retViewVisible(Integer selectOne, Integer whichOne) {
        if (whichOne == selectOne) {
            return View.VISIBLE;
        } else return View.GONE;
    }
}
