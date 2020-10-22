package com.example.forceoffline;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {
    private static final String TAG = "ActivityCollector";
    private static List<Activity> activities = new ArrayList<>();
    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
    public static void finishAll(){
        for(Activity activity : activities){
            Log.e(TAG, activity.getLocalClassName());
            if(!activity.isFinishing()){
                activity.finish();
                Log.e(TAG, "finishAll: "+activity.getLocalClassName());
            }
        }
        activities.clear();
    }
}
