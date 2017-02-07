package com.example.vothuong.anhdemo1;

import android.app.Application;

import com.example.vothuong.anhdemo1.util.UtilLog;

/**
 * Created by Vo Thuong on 2/6/2017.
 */

public class AnhApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setDebug(true);
    }
}
