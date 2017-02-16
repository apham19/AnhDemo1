package com.example.vothuong.anhdemo1.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.vothuong.anhdemo1.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Vo Thuong on 2/15/2017.
 */

public class CustomDialog extends Dialog {

    @OnClick(R.id.dialog_ok)
    public void okClick(){
        listener.OnClickListener();
        dismiss();
    }
    private ICustomDialogEventListener listener;

    public interface ICustomDialogEventListener{
        public void OnClickListener();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);
        ButterKnife.bind(this);
    }

    public CustomDialog(@NonNull Context context, ICustomDialogEventListener ICustomDialogEventListener) {
        super(context, R.style.dialog);
        this.listener = ICustomDialogEventListener;
    }
}
