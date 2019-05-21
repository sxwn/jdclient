package com.jd.business;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * SharedPreference:1、直接IO  用户空间和内核空间 两次拷贝
 * MMAP:memory mapping(内存映射)
 */

public class MainActivity  extends AppCompatActivity{
    private NestedScrollView scrollView;
    private LinearLayout ll;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollView = (NestedScrollView)findViewById(R.id.module_activity_shoplist);
        ll = (LinearLayout)findViewById(R.id.module_activity_shoplist_ll);
        for(int i =0;i<100;i++){
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams
                    (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            final TextView textView = new TextView(this);
            textView.setTextColor(Color.BLUE);
            textView.setPadding(12,12,12,12);
            textView.setTag(i);
            textView.setText("item"+i);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,"click item:"+textView.getTag(),Toast.LENGTH_LONG).show();
                }
            });
            linearLayout.addView(textView);
            ll.addView(linearLayout);
        }
    }

}
