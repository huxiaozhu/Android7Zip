package com.huxiaozhu.a7zip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText zipEt;
    private EditText zipOutEt;
    private EditText unzipEt;
    private EditText unzipOutEt;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        checkPermission(this);
    }

    private void initView() {
        zipEt = findViewById(R.id.zipPath);
        zipOutEt = findViewById(R.id.zipOutPath);
        unzipEt = findViewById(R.id.unzipPath);
        unzipOutEt = findViewById(R.id.unzipOutPath);
        zipEt.setText("/storage/emulated/0/7zip/p7zip");
        zipOutEt.setText("/storage/emulated/0/7zip/7zdemo.zip");
        unzipEt.setText("/storage/emulated/0/7zip/upgrade.7z");
        unzipOutEt.setText("/storage/emulated/0/7zip/");
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
        new ZipDialog(MainActivity.this, zipEt.getText().toString(),
                zipOutEt.getText().toString());
    }

    private void decompressProcess() {
        new UnZipDialog(this, unzipEt.getText().toString(), unzipOutEt.getText().toString());
    }

}