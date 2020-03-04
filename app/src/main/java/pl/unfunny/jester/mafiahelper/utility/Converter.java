package pl.unfunny.jester.mafiahelper.utility;

import android.content.Context;
import android.util.DisplayMetrics;

public class Converter {

    public static float dp2px(float dp, Context context) {
        return dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public static float px2dp(float px, Context context) {
        return px / ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }
}
