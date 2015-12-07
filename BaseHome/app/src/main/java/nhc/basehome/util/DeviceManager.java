package nhc.basehome.util;

import android.app.Activity;

import nhc.basehome.R;

/**
 * Created by NHC on 30/11/2015.
 */
public class DeviceManager {
    public static int statusBarHeight;
    public static boolean isAboveAPI21;
    public static int dpi, screenWidth, screenHeight;

    public static float convertDpToPixel(int dp){
        float px = dp * (DeviceManager.dpi / 160f);
        return px;
    }

    public static float convertPixelsToDp(int px){
        float dp = px / (DeviceManager.dpi / 160f);
        return dp;
    }

    public static void setupStatusBar(Activity activity) {
        activity.findViewById(R.id.statusBarBackground).getLayoutParams().height = DeviceManager.statusBarHeight;
    }
}
