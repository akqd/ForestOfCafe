package com.example.forestofcafe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class Profile_CustomDialog extends Dialog {
    Context context;
    Button btn_dialog_ok,btn_dialog_cancel;
    TextView tv_dialog_title;
    View.OnClickListener dialog_postiveListener;
    View.OnClickListener dialog_negativeListener;
    String title;

    public Profile_CustomDialog(@NonNull Context _context, String title , View.OnClickListener postiveL,  View.OnClickListener negativeL) {
        super(_context);
        context = _context;
        dialog_postiveListener = postiveL;
        dialog_negativeListener = negativeL;
        this.title = title;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.8f;
        getWindow().setAttributes(layoutParams);
        setContentView(R.layout.dialog_profile);
        btn_dialog_ok = findViewById(R.id.btn_dialog_ok);
        btn_dialog_cancel = findViewById(R.id.btn_dialog_cancel);
        tv_dialog_title = findViewById(R.id.tv_dialogTitle);
        tv_dialog_title.setText(title);
        btn_dialog_ok.setOnClickListener(dialog_postiveListener);
        btn_dialog_cancel.setOnClickListener(dialog_negativeListener);
    }
}
