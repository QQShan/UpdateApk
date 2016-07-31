package com.sqq.updateapk;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String srcDir, destDir1, patchDir,destDir2;
    ProgressDialog pD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //srcDir = Utils.getPackagePath(this);
        srcDir = Utils.getSDPath()+"/app-release.apk";
        destDir1 = Utils.getSDPath()+"/a/sqq2.apk";
        patchDir = Utils.getSDPath()+"/b/sqq.patch";
        destDir2 = Utils.getSDPath()+"/b/sqq2.apk";
        /*patchDir = Utils.createRootPath(this)+"/patch/sqq.patch";
        destDir2 = Utils.createRootPath(this)+"/sqq2.apk";*/

        Log.d("vqqq", srcDir + ":" + destDir1 + ":" + patchDir + ":" + destDir2);
        pD = new ProgressDialog(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.bt_create:
                //生成差分包
                pD.setMessage("正在生成差分包");
                pD.show();
                new DiffTask().execute();
                break;
            case R.id.bt_apk:
                //生成apk
                pD.setMessage("正在生成apk");
                pD.show();
                new PatchTask().execute();
                break;
        }
    }

    /**
     * 生成差分包
     *
     * @author yuyuhang
     * @date 2016-1-25 下午12:24:34
     */
    private class DiffTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {

            try {
                int result = DiffUtils.getInstance().genDiff(srcDir, destDir1, patchDir);
                if (result == 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean integer) {
            super.onPostExecute(integer);
            TextView tv = (TextView) findViewById(R.id.tip);
            if(integer){
                tv.setText("生成成功");
            }else{
                tv.setText("生成失败");
            }
            pD.cancel();

        }
    }

    /**
     * 差分包合成APK
     *
     * @author yuyuhang
     * @date 2016-1-25 下午12:24:34
     */
    private class PatchTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {

            try {

                int result = PatchUtils.getInstance().patch(srcDir, destDir2, patchDir);
                if (result == 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean integer) {
            super.onPostExecute(integer);
            TextView tv = (TextView) findViewById(R.id.tip);
            if(integer){
                tv.setText("生成成功");
            }else{
                tv.setText("生成失败");
            }
            pD.cancel();
        }
    }
}
