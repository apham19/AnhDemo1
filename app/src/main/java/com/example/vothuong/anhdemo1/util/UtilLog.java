package com.example.vothuong.anhdemo1.util;

import android.util.Log;

/**
 * Created by Vo Thuong on 2/6/2017.
 */

public class UtilLog {
    public static boolean Debug = false;

    public static void setDebug(boolean b){
        Debug = b;
    }

    public static void logD(String key, String value){
        if(Debug){
            Log.d(key, value);
        }
    }
}
