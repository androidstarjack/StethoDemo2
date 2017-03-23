package cn.edu.zafu.stethodemo;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Administrator on 2017/3/23/023.
 */

public class MyApplication extends Application{
    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application =  this;
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(
                                Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(
                                Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }

   public static MyApplication getInstance(){
        return application;
    }
}
