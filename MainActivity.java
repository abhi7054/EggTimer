package com.example.android.eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView timerTextView;
    SeekBar timerSeekBar;
    public void buttonClicked(View view)
    {


        new CountDownTimer(timerSeekBar.getProgress() * 1000, 1000) {
            @Override
            public void onTick(long l) {
                updateTimer((int) l/1000);
            }

            @Override
            public void onFinish() {
                MediaPlayer mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.airhorn);
                mediaPlayer.start();


            }
        }.start();
    }
    public void updateTimer(int secondsLeft){

        int minutes=secondsLeft/60;
        int seconds= secondsLeft-(minutes*60);

        String secondsString= Integer.toString(seconds);
        if(seconds<=9){
            secondsString="0"+secondsString;
        }

        timerTextView.setText(Integer.toString(minutes) + ":" + secondsString);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerTextView= findViewById(R.id.countdowntextView);
        timerSeekBar= findViewById(R.id.TimerSeekBar);

        timerSeekBar.setMax(600);
        timerSeekBar.setProgress(30);
        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                updateTimer(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
