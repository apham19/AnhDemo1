package com.example.vothuong.anhdemo1.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.vothuong.anhdemo1.BaseActivity;
import com.example.vothuong.anhdemo1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Animation_Activity extends BaseActivity {

    @BindView(R.id.animation_tv)
    TextView tv;
    private Animation alphaAnimation;
    private Animation scaleAnimation;
    private Animation rotateAnimation;
    private Animation transAnimation;
    private Animation setAnimation;

    @OnClick(R.id.alpha)
    public void alpha_click(){
        tv.startAnimation(alphaAnimation);
    }
    @OnClick(R.id.scale)
    public void scale_click(){
        tv.startAnimation(scaleAnimation);
    }
    @OnClick(R.id.rotate)
    public void rotate_click(){
        tv.startAnimation(rotateAnimation);
    }
    @OnClick(R.id.trans)
    public void trans_click(){
        tv.startAnimation(transAnimation);
    }
    @OnClick(R.id.set)
    public void set_click(){
        tv.startAnimation(setAnimation);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_);
        ButterKnife.bind(this);
        initialAnimation();
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastShort("Click");
            }
        });
    }

    private void initialAnimation() {
        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        transAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_trans);
        setAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_set);
    }
}
