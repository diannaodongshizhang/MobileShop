package com.example.yrx217.Common;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;

import com.example.yrx217.R;
import com.example.yrx217.http.HttpMethods;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import okhttp3.internal.http.HttpMethod;

/**
 * Created by 摩尔那个点 on 2019/10/2.
 */

public class MobileShopApp  extends Application {
    public  static Handler handler=new Handler();
    private static Context sContext;
    @Override
    public void onCreate() {
        super.onCreate();
        sContext=getApplicationContext();
        initImageLoader();
        HttpMethods.getInstance();
    }
    private void initImageLoader(){
        DisplayImageOptions default_option=new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.image_loading)
                .showImageForEmptyUri(R.drawable.image_empty)
                .showImageOnFail(R.drawable.image_error)
                .resetViewBeforeLoading(false)
                .delayBeforeLoading(1000)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(false)
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
                .bitmapConfig(Bitmap.Config.ARGB_8888)
                .displayer(new SimpleBitmapDisplayer())
                .handler(new Handler())
                .build();
        ImageLoaderConfiguration config=new ImageLoaderConfiguration.Builder(getApplicationContext())
                .memoryCacheExtraOptions(400,800)
                .memoryCacheSize(2*1024*1024)
                .memoryCacheSizePercentage(13)
                .diskCacheSize(50*1024*1024)
                .diskCacheFileCount(100)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())

                .threadPoolSize(3)
                .threadPriority(Thread.NORM_PRIORITY-2)
                .denyCacheImageMultipleSizesInMemory()
                .imageDownloader(new BaseImageDownloader(getApplicationContext()))
                .defaultDisplayImageOptions(default_option)
                .writeDebugLogs()
                .build();


        ImageLoader.getInstance().init(config);
    }
    public static Context getContext(){
        return sContext;
    }
}
