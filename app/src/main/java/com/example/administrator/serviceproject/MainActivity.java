package com.example.administrator.serviceproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    //初始化控件
    private void initView() {
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                //启动
                Intent intent = new Intent(this, MyService.class);
                startService(intent);
                break;
            case R.id.button2:
                //停止
                Intent intent2 = new Intent(this, MyService.class);
                stopService(intent2);
                break;
            case R.id.button3:
                break;
            default:
        }
    }


}
