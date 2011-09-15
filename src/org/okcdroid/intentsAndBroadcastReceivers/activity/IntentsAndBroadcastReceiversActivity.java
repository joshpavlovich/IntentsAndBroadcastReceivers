package org.okcdroid.intentsAndBroadcastReceivers.activity;

import org.okcdroid.intentsAndBroadcastReceivers.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IntentsAndBroadcastReceiversActivity extends Activity implements OnClickListener {

    private Button mIntentsButton;
    private Button mBroadcastReceiversButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        setupViews();
    }

    private void setupViews() {
        mIntentsButton = (Button) findViewById(R.id.intentsButton);
        mIntentsButton.setEnabled(true);
        mIntentsButton.setOnClickListener(this);

        mBroadcastReceiversButton = (Button) findViewById(R.id.broadcastReceiversButton);
        mBroadcastReceiversButton.setEnabled(true);
        mBroadcastReceiversButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.intentsButton:
            startActivity(new Intent(getApplicationContext(), IntentsActivity.class));
            break;
        case R.id.broadcastReceiversButton:
            startActivity(new Intent(getApplicationContext(), BroadcastReceiversActivity.class));
            break;
        default:
            break;
        }
    }
}