package com.sqq.updateapk;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

/**
 * Created by Administrator on 2016/7/26.
 */
public class Utils {
    /**
     * sd卡是否可用
     *
     * @return
     */
    public static boolean isSdCardAvailable() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }

    /**
     * 创建根缓存目录
     *
     * @return
     */
    public static String createRootPath(Context mContext) {
        String cacheRootPath;
        if (isSdCardAvailable()) {
            // /sdcard/Android/data/<application package>/cache
            cacheRootPath = mContext.getExternalCacheDir()
                    .getPath();
        } else {
            // /data/data/<application package>/cache
            cacheRootPath = mContext.getCacheDir().getPath();
        }
        return cacheRootPath;
    }

    public static String getSDPath(){
        if(isSdCardAvailable()){
            return Environment.getExternalStorageDirectory().getPath().toString();
        }else{
            return "";
        }
    }

    public static String getPackagePath(Context context){
        if(context!=null){
            /*String path= Environment.getExternalStorageDirectory().getPath()+"/app-release.apk";
            Log.d("sqqq","path"+path);*/
            Log.d("sqqq", "path" + context.getPackageCodePath());
            return  context.getPackageCodePath();
        }
        return null;
    }
}
