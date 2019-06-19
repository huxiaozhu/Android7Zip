package com.huxiaozhu.a7zip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission(this);
    }

    //android6.0之后要动态获取权限
    private void checkPermission(Activity activity) {
        // Storage Permissions
        final int REQUEST_EXTERNAL_STORAGE = 1;
        String[] PERMISSIONS_STORAGE = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE};

        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(this,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void compress(View view) {
        compressProcess();
    }

    public void decompress(View view) {
        decompressProcess();
    }

    private void compressProcess() {
        StringBuilder sbCmd = new StringBuilder("7z a ");
        //sbCmd.append("-t7z ");   //7z a -t7z = 指定压缩后的文件类型
        sbCmd.append("'/storage/emulated/0/7zip/7zdemo.zip' "); //7z a '/storage/emulated/0/7z_demo/7zdemo.zip'
        //sbCmd.append("'/storage/emulated/0/wifi_config.log' "); //7z a '//storage/emulated/0/7z_demo/7zdemo.zip' '/storage/emulated/0/wifi_config.log' = 文件的压缩
        sbCmd.append("'/storage/emulated/0/7zip/p7zip' "); //7z a '//storage/emulated/0/7z_demo/7zdemo.zip' '/storage/emulated/0/zp_7100' = 文件夹的压缩
        new ZipProcess(MainActivity.this, sbCmd.toString()).start();
    }

    private void decompressProcess() {
        StringBuilder sbCmd = new StringBuilder("7z ");
        sbCmd.append("x ");    //7z x
        // input file path
        sbCmd.append("'/storage/emulated/0/7zip/upgrade.7z' "); //7z x '/storage/emulated/0/7z_demo/7zdemo.zip'
        // output path
        sbCmd.append("'-o" + "/storage/emulated/0/7zip/' ");  //7z x '/storage/emulated/0/7z_demo/7zdemo.zip' '-o/storage/emulated/0/'
        sbCmd.append("-aoa "); //-aoa Overwrite All existing files without prompt.
        // 7z x '/storage/emulated/0/7z_demo/7zdemo.zip' '-o/storage/emulated/0/' -aoa
        new ZipProcess(MainActivity.this, sbCmd.toString()).start();
    }

}