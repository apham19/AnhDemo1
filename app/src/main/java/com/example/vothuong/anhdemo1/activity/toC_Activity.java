package com.example.vothuong.anhdemo1.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vothuong.anhdemo1.R;

import butterknife.OnClick;

public class toC_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_c_);
    }
    @OnClick(R.id.to_A)
    void to_A_Click(){
        Intent intent = new Intent(this, toA_Activity.class);
        startActivityForResult(intent, 1);
    }

    @OnClick (R.id.to_B)
    void to_B_Click(){
        Intent intent = new Intent(this, toB_Activity.class);
        startActivityForResult(intent, 2);
    }

    @OnClick (R.id.to_C)
    void to_C_Click(){
        Intent intent = new Intent(this, toC_Activity.class);
        startActivityForResult(intent, 3);
    }

    @OnClick (R.id.to_D)
    void to_D_Click(){
        Intent intent = new Intent(this, toD_Activity.class);
        startActivityForResult(intent, 4);
    }
}
