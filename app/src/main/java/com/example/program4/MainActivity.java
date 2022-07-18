package com.example.program4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    private long lastpause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Chronometer mychrono=(Chronometer) findViewById(R.id.chronometer);
        Button buttonStart=(Button) findViewById(R.id.start);
        Button buttonStop=(Button) findViewById(R.id.stop);
        Button buttonReset=(Button) findViewById(R.id.reset);

        buttonStart.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastpause!=0){
                    mychrono.setBase(mychrono.getBase()+ SystemClock.elapsedRealtime()-lastpause);
                }
                else {
                    mychrono.setBase(SystemClock.elapsedRealtime());
                }
                mychrono.start();
                buttonStart.setEnabled(false);
                buttonStop.setEnabled(true);
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                lastpause=SystemClock.elapsedRealtime();
                mychrono.stop();
                buttonStart.setEnabled(true);
                buttonStop.setEnabled(false);
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                mychrono.setBase(SystemClock.elapsedRealtime());
            }
        });

    }
}