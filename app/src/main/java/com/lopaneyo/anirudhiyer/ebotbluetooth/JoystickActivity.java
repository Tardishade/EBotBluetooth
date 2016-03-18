package com.lopaneyo.anirudhiyer.ebotbluetooth;

import android.widget.TextView;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.zerokol.views.JoystickView;
import com.zerokol.views.JoystickView.OnJoystickMoveListener;

public class JoystickActivity extends MainActivity {

    private TextView angleTextView;
    private TextView powerTextView;
    private TextView directionTextView;
    private TextView debugView;

    private JoystickView joystick;
    public String myValue;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_joystick);

        angleTextView = (TextView) findViewById(R.id.angleText);
        powerTextView = (TextView) findViewById(R.id.powerText);
        directionTextView = (TextView) findViewById(R.id.directionText);
        debugView = (TextView) findViewById(R.id.debugView);

        joystick = (JoystickView) findViewById(R.id.joystick);


        joystick.setOnJoystickMoveListener(new OnJoystickMoveListener() {


            public void onValueChanged(int angle, int power, int direction) {

                angleTextView.setText(" " + String.valueOf(angle) + "°");
                powerTextView.setText(" " + String.valueOf(power) + "%");

                switch (direction) {
                    case JoystickView.FRONT:
                        directionTextView.setText("Front");
                        break;
                    case JoystickView.FRONT_RIGHT:
                        directionTextView.setText("Front Left");
                        break;
                    case JoystickView.RIGHT:
                        directionTextView.setText("Left");
                        break;
                    case JoystickView.RIGHT_BOTTOM:
                        directionTextView.setText("Bottom Left");
                        break;
                    case JoystickView.BOTTOM:
                        directionTextView.setText("Bottom");
                        break;
                    case JoystickView.BOTTOM_LEFT:
                        directionTextView.setText("Bottom Right");
                        break;
                    case JoystickView.LEFT:
                        directionTextView.setText("Right");
                        break;
                    case JoystickView.LEFT_FRONT:
                        directionTextView.setText("Front Right");
                        break;
                    default:
                        directionTextView.setText("Center");

                }

                if(myThreadConnected!=null){

                    Float floatPower = (float)power;

                    myValue = "8" + "w" + Integer.toString((int) ((((floatPower / 100) * 1) + 2) * 100)) + ";" + Integer.toString((int) ((((floatPower / 100) * 1) + 2) * 100));
                    byte[] bytesToSend = myValue.getBytes();
                    myThreadConnected.write(bytesToSend);
                    debugView.setText("sidsidsi");


                }


            }

        }, JoystickView.DEFAULT_LOOP_INTERVAL);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }


}
