package com.example.morten.control;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Morten on 24.09.2014.
 */
public class FirstScreen extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.first_layout);

        Intent activityThatCalled = getIntent();

        String previousActivity =
                activityThatCalled.getExtras().getString("callingACtivity");

        TextView callingActivityMessage = (TextView)
                findViewById(R.id.calling_activity_info_text_view);

        callingActivityMessage.append(" " + previousActivity);
    }

    public void onSendUsersName(View view) {

        Intent goingBack = new Intent();

        setResult(RESULT_OK, goingBack);

        finish();

    }
}
