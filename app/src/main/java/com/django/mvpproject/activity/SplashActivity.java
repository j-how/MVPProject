package com.django.mvpproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.django.mvpproject.R;
import com.django.mvpproject.view.SimpleButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends AppCompatActivity implements SimpleButton.OnCheckedChangeListener {


    @BindView(R.id.sb_skip)
    SimpleButton mSbSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
//        initButton();
        new Thread(new Runnable()
        {
            @Override
            public void run() {
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run() {
//                        initButton();
                    }
                });
            }
        }).start();
    }

    private void initButton() {
        for (int i = 5; i > 0; i--) {
            try {
                mSbSkip.setShowText("跳转  " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onCheckedChanged(boolean isChecked) {
        isChecked = true;

    }

    @OnClick(R.id.sb_skip)
    public void onViewClicked() {
        _doSkip();
    }

    private boolean mIsSkip = false;

    private void _doSkip() {
        if (!mIsSkip) {
            mIsSkip = true;
            finish();
            startActivity(new Intent(SplashActivity.this, HomeActivity.class));
            overridePendingTransition(R.anim.hold, R.anim.zoom_in_exit);
        }
    }
}
