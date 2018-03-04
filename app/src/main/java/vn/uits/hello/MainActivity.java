package vn.uits.hello;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import vn.uits.hello.recycleview.RecyclviewActivity;

/**
 * Copyright © 2017 BAP CO., LTD
 * Created by PHUQUY on 3/1/18.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Button mBtnGetTime;
    private Button mBtnExit;
    private Button mBtnGet;
    private CheckBox mCbDetail;
    private RatingBar mRatingBar;
    private AlertDialog.Builder mAlertDialog;
    private TextView mTvDetail;
    private EditText mEditInput;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relativelayout);

        mBtnGetTime = findViewById(R.id.mBtnGetTime);
        mBtnExit = findViewById(R.id.mBtnExit);
        mBtnGet = findViewById(R.id.mBtnGet);
        mCbDetail = findViewById(R.id.mCbDetail);
        mRatingBar = findViewById(R.id.mRatingBar);
        mTvDetail = findViewById(R.id.mTvDetail);
        mEditInput = findViewById(R.id.mEditInput);

        mBtnExit.setOnClickListener(this);

        mBtnGetTime.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showNotification();
                return false;
            }
        });

        mCbDetail.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, "onCheckedChanged: " + isChecked);
            }
        });

        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(MainActivity.this, "Rating" + rating, Toast.LENGTH_SHORT).show();
            }
        });

        mBtnGet.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                mTvDetail.setText("Thông Tin bạn nhập là : " + mEditInput.getText().toString());
            }
        });

    }

    /**
     * show notification
     */
    private void showNotification() {
        NotificationManager notification = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(this, RecyclviewActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 100, intent, 0);
        // old
        Notification notify = new Notification(R.mipmap.ic_launcher, "Notification Aptech", 1000);
        // v4 and v7
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity.this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Notification")
                .setContentText("Hello Aptech !!!")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Hello"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent);

        notification.notify((int) System.currentTimeMillis(), mBuilder.build());
    }

    /**
     * show AlertDialog
     */
    private void showAlertDialog() {
        if (this.isFinishing()) {
            mAlertDialog = new AlertDialog.Builder(this, R.style.MyAlertDialogStyle);
            mAlertDialog.setTitle("DiaLog");
            mAlertDialog.setMessage("Bạn có muốn thoát ứng dụng không ?");
            mAlertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    finish();
                }
            });
            mAlertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            mAlertDialog.show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mBtnExit:
                showAlertDialog();
                break;
        }
    }

    private void addFragment(@IdRes int containerViewId,
                             @NonNull Fragment fragment,
                             @NonNull String fragmentTag) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(containerViewId, fragment, fragmentTag)
                .disallowAddToBackStack()
                .commit();
    }

    private void replaceFragment(@IdRes int containerViewId,
                                 @NonNull Fragment fragment,
                                 @NonNull String fragmentTag,
                                 @Nullable String backStackStateName) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerViewId, fragment, fragmentTag)
                .addToBackStack(backStackStateName)
                .commit();
    }
}
