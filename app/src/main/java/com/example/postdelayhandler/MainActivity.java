package com.example.postdelayhandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler  = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void startRepeating(View view){

      //  mHandler.postDelayed(mToastRunnable,5000);//first parameter is runnable and other is delay
        mToastRunnable.run();
    }
    public void stopRepeating(View view){

        mHandler.removeCallbacks(mToastRunnable);
    }
    private Runnable mToastRunnable = new Runnable() {
        @Override
        public void run() {
            Toast.makeText(MainActivity.this, "This is delayed toast", Toast.LENGTH_SHORT).show();
            mHandler.postDelayed(this,5000);
        }
    };
}