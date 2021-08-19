package com.hmtsoft.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class HeadsetBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        String toastMessage = "";
        if (intentAction != null) {

            if (intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)) {
                int state = intent.getIntExtra("state", -1);
                switch (state) {
                    case 0:
                        toastMessage = "Headset disconnected";
                        break;
                    case 1:
                        toastMessage = "Headset connected!";
                        break;
                }
            }

            if (!toastMessage.isEmpty())
                Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }

}