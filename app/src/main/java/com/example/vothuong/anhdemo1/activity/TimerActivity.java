package com.example.vothuong.anhdemo1.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vothuong.anhdemo1.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TimerActivity extends AppCompatActivity {

    private int time;

    @BindView(R.id.timer_et)
    EditText editText;

    @BindView(R.id.timer_bt)
    Button timerButton;

    Handler mhandler = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            time--;
            if(time == 0){
                editText.setText(String.valueOf(time));
                mhandler.postDelayed(this,1000);
                mhandler.post(this);
            }
        }
    };

    final View.OnClickListener start = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            editText.setEnabled(false);
        time = Integer.valueOf(editText.getText().toString());
        timerButton.setText("STOP");
        timerButton.setOnClickListener(stop);

        }
    };

    final View.OnClickListener stop = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            timerButton.setText("RESET");
            timerButton.setOnClickListener(reset);
            mhandler.removeCallbacks(runnable);
        }
    };

    final View.OnClickListener reset = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            editText.setEnabled(true);
            timerButton.setText("START");
            timerButton.setOnClickListener(start);
            editText.setText(String.valueOf(20));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        ButterKnife.bind(this);
        timerButton.setOnClickListener(start);
    }


}
