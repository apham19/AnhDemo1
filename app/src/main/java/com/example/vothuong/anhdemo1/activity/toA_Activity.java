package com.example.vothuong.anhdemo1.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.vothuong.anhdemo1.BaseActivity;
import com.example.vothuong.anhdemo1.DialogActivity;
import com.example.vothuong.anhdemo1.R;

import butterknife.OnClick;

public class toA_Activity extends BaseActivity {

    private ImageButton toA;
    private ImageButton toB;
    private ImageButton toC;
    private ImageButton toD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_a_);
        initialButtons();
        initialListener();
    }

    private void initialListener() {
        toA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(toA_Activity.class);
            }
        });

        toB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(toB_Activity.class);
            }
        });

        toC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(toC_Activity.class);
            }
        });

        toD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(toD_Activity.class);
            }
        });
    }

    private void initialButtons() {
        toA = (ImageButton) findViewById(R.id.to_A);
        toB = (ImageButton) findViewById(R.id.to_B);
        toC = (ImageButton) findViewById(R.id.to_C);
        toD = (ImageButton) findViewById(R.id.to_D);
    }


}
