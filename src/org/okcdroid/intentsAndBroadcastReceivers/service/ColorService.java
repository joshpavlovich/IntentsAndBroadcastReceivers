package org.okcdroid.intentsAndBroadcastReceivers.service;

import org.okcdroid.intentsAndBroadcastReceivers.activity.BroadcastReceiversActivity;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;

public class ColorService extends IntentService {

    private static final String TAG = "ColorService";

    public ColorService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        // DO SOME WORK OUTSIDE OF THE UI THREAD

        Bundle extras = intent.getExtras();
        Intent sendBroadcastIntent = new Intent(BroadcastReceiversActivity.BROADCAST_RECIEVER);

        if (extras != null) {
            sendBroadcastIntent.putExtras(extras);
        }

        sendBroadcast(sendBroadcastIntent);
    }

}