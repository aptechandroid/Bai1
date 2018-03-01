package vn.uits.hello.recycleview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import vn.uits.hello.R;

/**
 * Copyright © 2017 BAP CO., LTD
 * Created by PHUQUY on 3/1/18.
 */

public class RecyclviewActivity extends AppCompatActivity {

    // layoutmanager
    private LinearLayoutManager mLinearLayout;
    private GridLayoutManager mGridLayout;

    // view
    private RecyclerView mRecycleView;
    // adapter
    private RecycleViewAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // install layout
        setContentView(R.layout.activity_recycleview);
        // khai bao
        mRecycleView = (RecyclerView) findViewById(R.id.mRecycleView);

        mGridLayout = new GridLayoutManager(this, 3);

        mLinearLayout = new LinearLayoutManager(this);
        mAdapter = new RecycleViewAdapter();
        mRecycleView.setLayoutManager(mGridLayout);
        mRecycleView.setAdapter(mAdapter);

    }
}
