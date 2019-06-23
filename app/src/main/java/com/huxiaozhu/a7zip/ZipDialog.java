package com.huxiaozhu.a7zip;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.xiaozhu.lib7zip.ZipUtils;

public class ZipDialog {
    /*      0 No error
    1 Warning (Non fatal error(s)). For example, one or more files were locked by some other application, so they were not compressed.
    2 Fatal error
    7 Command line error
    8 Not enough memory for operation
    255 User stopped the process
    */

    private static final int RET_SUCCESS = 0;
    private static final int RET_WARNING = 1;
    private static final int RET_FAULT = 2;
    private static final int RET_COMMAND = 7;
    private static final int RET_MEMORY = 8;
    private static final int RET_USER_STOP = 255;


    public ZipDialog(final Context context, final String zipPath, final String outputPath) {

        final ProgressDialog dialog = new ProgressDialog(context);
        dialog.setTitle(R.string.progress_title);
        dialog.setMessage(context.getText(R.string.progress_message));
        dialog.setCancelable(false);
        final Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                dialog.dismiss();
                int retMsgId = R.string.msg_ret_success;
                switch (msg.what) {
                    case RET_SUCCESS:
                        retMsgId = R.string.msg_ret_success;
                        break;
                    case RET_WARNING:
                        retMsgId = R.string.msg_ret_warning;
                        break;
                    case RET_FAULT:
                        retMsgId = R.string.msg_ret_fault;
                        break;
                    case RET_COMMAND:
                        retMsgId = R.string.msg_ret_command;
                        break;
                    case RET_MEMORY:
                        retMsgId = R.string.msg_ret_memmory;
                        break;
                    case RET_USER_STOP:
                        retMsgId = R.string.msg_ret_user_stop;
                        break;
                    default:
                        break;
                }
                String string = "压缩结果："+context.getResources().getString(retMsgId);
                Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        dialog.show();
        new Thread() {
            @Override
            public void run() {
                ZipUtils.ResultType resultType = ZipUtils.zip(zipPath, outputPath);
                handler.sendEmptyMessage(resultType.getResult());
                super.run();
            }
        }.start();
    }
}

