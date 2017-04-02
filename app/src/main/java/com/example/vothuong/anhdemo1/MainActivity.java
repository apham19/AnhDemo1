package com.example.vothuong.anhdemo1;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vothuong.anhdemo1.activity.Animation_Activity;
import com.example.vothuong.anhdemo1.activity.AnimatorActivity;
import com.example.vothuong.anhdemo1.activity.TimerActivity;
import com.example.vothuong.anhdemo1.activity.toA_Activity;
import com.example.vothuong.anhdemo1.activity.toB_Activity;
import com.example.vothuong.anhdemo1.activity.toC_Activity;
import com.example.vothuong.anhdemo1.activity.toD_Activity;
import com.example.vothuong.anhdemo1.bean.Book;
import com.example.vothuong.anhdemo1.dialog.CustomDialog;
import com.example.vothuong.anhdemo1.dialog.Main_Custom_Dialog;
import com.example.vothuong.anhdemo1.util.UtilLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity implements View.OnTouchListener{

    private ImageButton bt1;
    private ImageButton bt3;
    private ImageButton bt_act;

    private GestureDetector mGestureDetector;
    @BindView(R.id.main_fl)FrameLayout fl;
    @BindView(R.id.listOfActivity)
    LinearLayout ll;
    int count=0;

    @OnClick(R.id.profile)
    void show_profile(){
        if(count==0){
            ObjectAnimator animator = ObjectAnimator.ofFloat(ll, "translationX", 0, 950, 950,950,950); //translationY
            animator.setDuration(1000);
            animator.start();
            count++;
        }
        else{
            ObjectAnimator animator = ObjectAnimator.ofFloat(ll, "translationX", 950, 0, 0,0,0); //translationY
            animator.setDuration(1000);
            animator.start();
            count=0;
        }

    }

    @OnClick(R.id.custom)
    void customClick(){
        CustomDialogMain();
    }

    private void CustomDialogMain() {
        Main_Custom_Dialog dialog = new Main_Custom_Dialog(this, new Main_Custom_Dialog.ICustomDialogEventListener(){

            @Override
            public void OnClickListener() {
                Intent intent = new Intent();
                intent.putExtra("message","Dialog");
                setResult(RESULT_OK,intent);
            }

            @Override
            public void OnCancelClickListener() {

            }
        });
        dialog.show();
    }

    @OnClick(R.id.p_viewPager)
    public void to_ViewPager(){
        Intent intent = new Intent(this,ViewPagerActivity.class);
        intent.putExtra("key", "value");
        Bundle bundle = new Bundle();
        bundle.putInt("Integer", 12345);
        Book book = new Book();
        book.setName("Android");
        book.setAuthor("Anh");
        bundle.putSerializable("book", book);
        intent.putExtras(bundle);
        startActivityForResult(intent,1);
    }

    @OnClick(R.id.p_ListView)
    public void listViewActivity(){
        toActivity(ListViewActivity.class);
    }

    @OnClick(R.id.p_Animation)
    public void animationActivity(){
        toActivity(Animation_Activity.class);
    }

    @OnClick(R.id.p_Animator)
    public void animatorActivity(){
        toActivity(AnimatorActivity.class);
    }

    @OnClick(R.id.p_timer)
    public void timerActivity(){
        toActivity(TimerActivity.class);
    }

    @OnClick(R.id.p_dialog)
    public void dialogActivity(){
        toActivity(DialogActivity.class);
    }

    @OnClick(R.id.p_toA)
    public void aActivity(){
        toActivity(toA_Activity.class);
    }

    @OnClick(R.id.p_toB)
    public void bActivity(){
        toActivity(toB_Activity.class);
    }

    @OnClick(R.id.p_toC)
    public void cActivity(){
        toActivity(toC_Activity.class);
    }
    @OnClick(R.id.p_toD)
    public void dActivity(){
        toActivity(toD_Activity.class);
    }

    @OnClick(R.id.animator)
    public void toAnim() {
        toActivity(AnimatorActivity.class);
    }

    @OnClick(R.id.timer)
    void buttonTimerClick(){
        Intent intent = new Intent(this, TimerActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.animation)
    void buttonAnimationClick(){
        Intent intent = new Intent(this, TimerActivity.class);
        startActivity(intent);
    }



    @OnClick(R.id.bt2)
    void button2Click(){
        Intent intent = new Intent(this, DialogActivity.class);
        startActivityForResult(intent, 2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();
        ButterKnife.bind(this);
        mGestureDetector = new GestureDetector(this, new simpleGestureListener());
        fl.setOnTouchListener(this);
    }

    private void initialView(){
        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt3 = (ImageButton) findViewById(R.id.bt3);
        bt_act = (ImageButton) findViewById(R.id.start_activity);

    }



    @Override
    protected void onStart() {
        super.onStart();
        toastShort("onStart");
    }

    private void initialListener(){
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),ViewPagerActivity.class);
                intent.putExtra("key", "value");
                Bundle bundle = new Bundle();
                bundle.putInt("Integer", 12345);
                Book book = new Book();
                book.setName("Android");
                book.setAuthor("Anh");
                bundle.putSerializable("book", book);
                intent.putExtras(bundle);
                startActivityForResult(intent,1); //can pass infomration through intent

            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ListViewActivity.class);
                startActivityForResult(intent, 3);

            }
        });
        bt_act.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                toActivity(toA_Activity.class);


            }

        });
        bt_act.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                toActivity(AnimatorActivity.class);


            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                String message = data.getStringExtra("message");
                toastShort(message);
                break;
            case 2:
                toastShort("Dialog");
                break;
            case 3:
                toastShort("Custom");
                break;
            default:
        }
    }

    public void onClick(View v) {
        //Toast.makeText(v.getContext(),"Button 2 was clicked",Toast.LENGTH_LONG).show();
        toastLong("Button 2 was clicked");
        UtilLog.logD("testD","Toast");
        Log.d("testD","Toast");
    }

    public boolean onTouch(View v, MotionEvent event){
        return mGestureDetector.onTouchEvent(event);

    }
    private class simpleGestureListener extends
            GestureDetector.SimpleOnGestureListener{

        public boolean onDown(MotionEvent e){
//            UtilLog.logD("MyGesture", "onDown");
            toastShort("onDown");
            show_profile();
            return true;
        }
        public void onShowPress(MotionEvent e){
//            UtilLog.logD("MyGesture", "onShowPress");
            toastShort("onShowPress");
        }
        public void onLongPress(MotionEvent e){
//            UtilLog.logD("MyGesture", "onLongPress");
            toastShort("onLongPress");
        }
        public boolean onSingleTapUp(MotionEvent e){
//            UtilLog.logD("myGesture", "onSingleTapUp");
            toastShort("onSingleTapUp");
            return true;
        }
        public boolean onSingleTapConfirmed(MotionEvent e){
//            UtilLog.logD("myGesture", "onSingleTapUp");
            toastShort("onSingleTapConfirmed");
            return true;
        }
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){
            UtilLog.logD("myGesture", "onScroll:" + (e2.getX() - e1.getX()) + " " + distanceX);
            toastShort("onScroll");
            return true;
        }
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
            //           UtilLog.logD("myGesture", "onFling");
            toastShort("onFling");
            return true;
        }
        public boolean onDoubleTap(MotionEvent e){
            //           UtilLog.logD("myGesture", "onDoubleTap");
            //           toastShort("onDoubleTap");
            return true;
        }
        public boolean onDoubleTapEvent(MotionEvent e){
            //           UtilLog.logD("myGesture", "onDoubleTapEvent");
            //           toastShort("onDoubleTapEvent");
            return true;
        }

    }

}
