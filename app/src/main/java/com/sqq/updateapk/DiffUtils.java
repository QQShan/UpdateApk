package com.sqq.updateapk;

/**
 * Created by sqq on 2016/7/26.
 */
public class DiffUtils {
    static {
        System.loadLibrary("ApkPatch");
    }

    static DiffUtils instance;

    public static DiffUtils getInstance() {
        if (instance == null)
            instance = new DiffUtils();
        return instance;
    }

    /**
     * native方法 比较路径为oldPath的apk与newPath的apk之间差异，并生成patch包，存储于patchPath
     *
     * 返回：0，说明操作成功
     *
     * @param oldApkPath
     *            示例:/sdcard/old.apk
     * @param newApkPath
     *            示例:/sdcard/new.apk
     * @param patchPath
     *            示例:/sdcard/xx.patch
     * @return
     */
    public native int genDiff(String oldApkPath, String newApkPath, String patchPath);
}
