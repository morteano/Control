package com.example.morten.control;

import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    private ImageButton up;
    private ImageButton left;
    private ImageButton right;
    private ImageButton down;
    private Switch laser;
    private TextView output;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Only for testing
        output = (TextView) findViewById(R.id.testOutput);

        //Gets buttons
        up = (ImageButton) findViewById(R.id.uparrow);
        left= (ImageButton) findViewById(R.id.leftarrow);
        right = (ImageButton) findViewById(R.id.rightarrow);
        down = (ImageButton) findViewById(R.id.downarrow);
        laser = (Switch) findViewById(R.id.laserButton);

        //Add press and release listener
        up.setOnTouchListener(clickListen);
        left.setOnTouchListener(clickListen);
        right.setOnTouchListener(clickListen);
        down.setOnTouchListener(clickListen);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void pressedButton(View view) {
        output.setText("You clicked " + this.getCallingActivity());
        String response = "Yey, you pressed something!";
        Toast.makeText(this, response, Toast.LENGTH_SHORT).show();
    }

    View.OnTouchListener clickListen = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                char cmd ='.';
                switch (view.getId()) {
                    case (R.id.uparrow):
                        cmd = 'w';
                        break;
                    case (R.id.leftarrow):
                        cmd = 'a';
                        break;
                    case (R.id.rightarrow):
                        cmd = 'd';
                        break;
                    case (R.id.downarrow):
                        cmd = 's';
                        break;
                    case (R.id.upaim):
                        cmd = 'i';
                        break;
                    case (R.id.leftaim):
                        cmd = 'j';
                        break;
                    case (R.id.rightaim):
                        cmd = 'l';
                        break;
                    case (R.id.downaim):
                        cmd = 'k';
                        break;
                    case (R.id.fire):
                        cmd = ' ';
                        break;
                    case (R.id.laserButton):
                        cmd = 'n';
                        break;
                    default:
                        break;
                }
                String response = "Sender " + Character.toString(cmd);
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                //send(cmd);
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
               // send('q');
            }
            return false;
        }

    };
}
//Tag aim buttons!!!!!