package com.example.efoeakolly.flightkit.fragments;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.Log;

/**
 * Created by efoeakolly on 6/15/16.
 */

public class CompatibilityUtil {

    /** Get the current Android API level. */
    public static int getSdkVersion() {
        return Build.VERSION.SDK_INT;
    }

    /** Determine if the device is running API level 8 or higher. */
    public static boolean isFroyo() {
        return getSdkVersion() >= Build.VERSION_CODES.FROYO;
    }

    /** Determine if the device is running API level 11 or higher. */
    public static boolean isHoneycomb() {
        return getSdkVersion() >= Build.VERSION_CODES.HONEYCOMB;
    }

    /**
     * Determine if the device is a tablet (i.e. it has a large screen).
     *
     * @param context The calling context.
     */
    public static boolean isTablet(Context context) {
        boolean isTablet = false;
        isTablet = (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
        if(isTablet){
            Log.d("This is a Tablet ::", "true");
        } else {
            Log.d("This is not a tablet ::", "false");
        }
        return isTablet;
    }

    /**
     * Determine if the device is a HoneyComb tablet.
     *
     * @param context The calling context.
     */
    public static boolean isHoneycombTablet(Context context) {
        return isHoneycomb() && isTablet(context);
    }

    /** This class can't be instantiated. */
    private CompatibilityUtil() { }
}
