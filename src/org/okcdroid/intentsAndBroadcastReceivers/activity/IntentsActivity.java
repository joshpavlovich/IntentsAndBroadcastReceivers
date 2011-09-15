package org.okcdroid.intentsAndBroadcastReceivers.activity;

import org.okcdroid.intentsAndBroadcastReceivers.R;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IntentsActivity extends Activity implements OnClickListener {

    private Button mBrowseIntentButton;
    private Button mDialIntentButton;
    private Button mMapIntentButton;
    private Button mSearchIntentButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intents);

        setupViews();
    }

    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.browseIntentButton:
            startActivity(createBrowseIntent());
            break;
        case R.id.dialIntentButton:
            startActivity(createDialIntent());
            break;
        case R.id.mapIntentButton:
            startActivity(createMapIntent());
            break;
        case R.id.searchIntentButton:
            startActivity(createSearchIntent());
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

    private Intent createBrowseIntent() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://okccoco.com"));
        return intent;
    }

    private Intent createDialIntent() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel: (405) 633-3603"));
        return intent;
    }

    private Intent createMapIntent() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?q=Coworking Collaborative loc:near: 723 N. Hudson Ave Oklahoma City, OK, 73102"));
        return intent;
    }

    private Intent createSearchIntent() {
        Intent intent = new Intent(Intent.ACTION_SEARCH);
        intent.putExtra(SearchManager.QUERY, "Oklahoma City Coworking Collaborative");
        return intent;
    }

    private void setupViews() {
        configureButton(R.id.browseIntentButton, mBrowseIntentButton);
        configureButton(R.id.dialIntentButton, mDialIntentButton);
        configureButton(R.id.mapIntentButton, mMapIntentButton);
        configureButton(R.id.searchIntentButton, mSearchIntentButton);
    }

}