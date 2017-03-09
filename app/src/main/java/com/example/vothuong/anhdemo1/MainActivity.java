package com.example.vothuong.anhdemo1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.vothuong.anhdemo1.activity.AnimatorActivity;
import com.example.vothuong.anhdemo1.activity.TimerActivity;
import com.example.vothuong.anhdemo1.activity.toA_Activity;
import com.example.vothuong.anhdemo1.bean.Book;
import com.example.vothuong.anhdemo1.dialog.CustomDialog;
import com.example.vothuong.anhdemo1.dialog.Main_Custom_Dialog;
import com.example.vothuong.anhdemo1.util.UtilLog;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {

    private ImageButton bt1;
    private ImageButton bt3;
    private ImageButton bt_act;


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
                book.setAuthor("Viral");
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


}
