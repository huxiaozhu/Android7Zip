package com.xiaozhu.lib7zip;

//0 No error
//1 Warning (Non fatal error(s)). For example, one or more files were locked by some other application,
// so they were not compressed.
//2 Fatal error
//7 Command line error
//8 Not enough memory for operation
//255 User stopped the process

import android.text.TextUtils;

import java.io.File;

public class ZipUtils {
    static {
        System.loadLibrary("7zip");
    }

    private static native int excuteCommand(String command);

    public static ResultType zip(String zipPath, String outputPath) {
        if (TextUtils.isEmpty(zipPath) || TextUtils.isEmpty(outputPath)) {
            throw new IllegalArgumentException("zipPath or outputPath is null");
        }

        File zipFile = new File(zipPath);
        File outFile = new File(outputPath);
        if (!zipFile.exists()) {
            throw new RuntimeException("zipPath File not exists");
        }
        if (!outFile.getParentFile().exists()) {
            boolean mkdirs = outFile.mkdirs();
            if (!mkdirs) {
                throw new RuntimeException("Directory Create fail");
            }
        }
//        制定压缩类型
//        StringBuilder sbCmd = new StringBuilder("7z a -t7z ");
        StringBuilder sbCmd = new StringBuilder("7z a ");
        sbCmd.append(outputPath);
        sbCmd.append(" ");
        sbCmd.append(zipPath);

        return exeComand(sbCmd.toString());
    }

    public static ResultType unzip(String unZipPath, String outputPath) {
        if (TextUtils.isEmpty(unZipPath) || TextUtils.isEmpty(outputPath)) {
            throw new IllegalArgumentException("zipPath or outputPath is null");
        }

        File unZipFile = new File(unZipPath);
        File outFile = new File(outputPath);
        if (!unZipFile.exists()) {
            throw new RuntimeException("zipPath File not exists");
        }

        if (!outFile.getParentFile().exists()) {
            boolean mkdirs = outFile.mkdirs();
            if (!mkdirs) {
                throw new RuntimeException("Directory Create fail");
            }
        }
        // 7z x /storage/emulated/0/7z_demo/7zdemo.zip -o/storage/emulated/0/ -aoa
        StringBuilder sbCmd = new StringBuilder("7z x ");
        sbCmd.append(unZipPath);
        sbCmd.append(" -o");
        sbCmd.append(outputPath);
        sbCmd.append(" -aoa");
        return exeComand(sbCmd.toString());
    }

    private static ResultType exeComand(String comand) {
        switch (excuteCommand(comand)) {
            case 0:
                return ResultType.RESULT_SUCCESS;
            case 1:
                return ResultType.RESULT_WARNING;
            case 2:
                return ResultType.RESULT_FAULT;
            case 7:
                return ResultType.RESULT_COMMAND;
            case 8:
                return ResultType.RESULT_MEMORY;
            case 255:
                return ResultType.RESULT_SUER_STOP;
        }
        return ResultType.RESULT_SUCCESS;
    }

    public enum ResultType {
        RESULT_SUCCESS(0),
        RESULT_WARNING(1),
        RESULT_FAULT(2),
        RESULT_COMMAND(7),
        RESULT_MEMORY(8),
        RESULT_SUER_STOP(255);

        int result;

        ResultType(int i) {
            result = i;
        }

        public int getResult() {
            return result;
        }
    }

}
