package nhc.basehome.util;

import android.app.Application;
import android.os.Build;

/**
 * Created by NHC on 30/11/2015.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DeviceManager.statusBarHeight = getStatusBarHeight();
        DeviceManager.isAboveAPI21 = getIsAboveAPI21();
        Constant.appContext = getApplicationContext();
        Constant.appResources = getResources();
        DeviceManager.dpi = Constant.appResources.getDisplayMetrics().densityDpi;
    }

    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private boolean getIsAboveAPI21() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return true;
        } else {
            return false;
        }
    }
}
