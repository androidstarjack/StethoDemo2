package cn.edu.zafu.stethodemo.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.concurrent.atomic.AtomicReference;

import cn.edu.zafu.stethodemo.MyApplication;

/**
 * Created by Administrator on 2017/3/23/023.
 */

public class PreferenceSingleton  {
    private static AtomicReference<PreferenceSingleton> INSTANCE = new AtomicReference<>();
    private  static SharedPreferences.Editor editor;
    private  static SharedPreferences sharedPreferences;
    private PreferenceSingleton() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
        editor = sharedPreferences.edit();
    }
    public static PreferenceSingleton getInstace(){
        PreferenceSingleton current = INSTANCE.get();
        for (;;) {
            if(current != null){
                return current;
            }
            current = new PreferenceSingleton();
            if(INSTANCE.compareAndSet(null, current))
            {
                return current;
            }
        }
    }


    public static boolean getBoolean(String key, boolean defValue) {
        return sharedPreferences.getBoolean(key, defValue);
    }

    public static void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static int getInt(String key, int defValue) {
        return sharedPreferences.getInt(key, defValue);
    }

    public static void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public static long getLong(String key, long defValue) {
        return sharedPreferences.getLong(key, defValue);
    }

    public static void putLong(String key, long value) {
        editor.putLong(key, value);
        editor.commit();
    }

    public static String getString(String key, String defValue) {
        return sharedPreferences.getString(key, defValue);
    }

    public static void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

}
