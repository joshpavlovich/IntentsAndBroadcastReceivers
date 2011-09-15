package org.okcdroid.intentsAndBroadcastReceivers.receiver;

import org.okcdroid.intentsAndBroadcastReceivers.service.ColorService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class ColorReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle extras = intent.getExtras();
        Intent serviceIntent = new Intent(context, ColorService.class);

        if (extras != null) {
            serviceIntent.putExtras(extras);
        }

        // START SERVICE
        context.startService(serviceIntent);
    }

}