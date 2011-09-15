package org.okcdroid.intentsAndBroadcastReceivers.activity;

import org.okcdroid.intentsAndBroadcastReceivers.R;
import org.okcdroid.intentsAndBroadcastReceivers.receiver.ColorReceiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class BroadcastReceiversActivity extends Activity implements OnClickListener {

    public static final String COLOR = "color";
    public static final String BROADCAST_RECIEVER = "org.okcdroid.intentsAndBroadcastReceivers.action.BROADCAST_RECIEVER";

    private Button mBroadcastGreenButton;
    private Button mBroadcastCyanButton;

    // CREATE BROADCAST RECEIVER
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Bundle bundle = intent.getExtras();

            if (bundle != null) {
                LinearLayout broadcastLinearLayout = (LinearLayout) findViewById(R.id.broadcastLinearLayout);
                broadcastLinearLayout.setBackgroundColor(bundle.getInt(COLOR));

                Toast.makeText(getApplicationContext(), "Color Received!!!",
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "Color Not Received :(", Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcastreceivers);

        setupViews();
    }

    public void onResume() {
        super.onResume();

        IntentFilter filter = new IntentFilter();
        filter.addAction(BROADCAST_RECIEVER);

        // REGISTER BROADCAST RECEIVER
        registerReceiver(receiver, filter);
    }

    public void onPause() {
        super.onPause();

        // UNREGISTER BROADCAST RECEIVER
        unregisterReceiver(receiver);
    }

    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.broadcastGreenButton:
            sendBroadcast(createBroadcastIntent(Color.GREEN));
            break;
        case R.id.broadcastCyanButton:
            sendBroadcast(createBroadcastIntent(Color.CYAN));
            break;
        default:
            break;
        }
    }

    private void configureButton(final int id, Button button) {
        button = (Button) findViewById(id);
        button.setEnabled(true);
        button.setOnClickListener(this);
    }

    private Intent createBroadcastIntent(final int color) {
        Intent intent = new Intent(getApplicationContext(), ColorReceiver.class);
        intent.putExtra(COLOR, color);
        return intent;
    }

    private void setupViews() {
        configureButton(R.id.broadcastGreenButton, mBroadcastGreenButton);
        configureButton(R.id.broadcastCyanButton, mBroadcastCyanButton);
    }
}