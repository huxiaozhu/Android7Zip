package com.xiaozhu.lib7zip;

public class ZipUtils {
    static {
        System.loadLibrary("7zip");
    }

    public static native int excuteCommand(String command);


}
