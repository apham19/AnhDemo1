package com.example.vothuong.anhdemo1.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.example.vothuong.anhdemo1.BaseActivity;
import com.example.vothuong.anhdemo1.R;
import com.example.vothuong.anhdemo1.ViewPagerActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Vo Thuong on 3/8/2017.
 */

public class Main_Custom_Dialog extends Dialog {


    private int CheckedID;

    @OnClick(R.id.mdialog_cancel)
    public void CancelClick(){
        listener.OnCancelClickListener();
    }

    @OnClick(R.id.mdialog_ok)
    public void okClick(){
        switch (CheckedID) {
            case (R.id.mrb1):
            case (R.id.mrb2):
            default: listener.OnClickListener();
            dismiss();
        }
    }

    private Main_Custom_Dialog.ICustomDialogEventListener listener;

    public interface ICustomDialogEventListener{
        public void OnClickListener();
        public void OnCancelClickListener();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog_main);
        ButterKnife.bind(this);
    }
    public Main_Custom_Dialog(@NonNull Context context, Main_Custom_Dialog.ICustomDialogEventListener iCustomDialogEventListener) {
        super(context, R.style.dialog);
        this.listener = iCustomDialogEventListener;
    }
}

