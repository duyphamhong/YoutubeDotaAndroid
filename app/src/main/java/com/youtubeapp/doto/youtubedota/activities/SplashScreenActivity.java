package com.youtubeapp.doto.youtubedota.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.youtubeapp.doto.youtubedota.R;
import com.youtubeapp.doto.youtubedota.utils.ConnectionUtils;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if (ConnectionUtils.isNetworkConnected(getApplicationContext())) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else {
            new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(getString(R.string.connection_status_message))
                    .setContentText(getString(R.string.connection_fail_message))
                    .setConfirmText(getString(R.string.action_ok))
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                            finish();
                            return;
                        }
                    })
                    .show();
        }
    }

}
