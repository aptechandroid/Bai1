package vn.uits.hello.recycleview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.uits.hello.R;
import vn.uits.hello.interfaces.ItemClickListener;
import vn.uits.hello.model.Student;

/**
 * Copyright © 2017 BAP CO., LTD
 * Created by PHUQUY on 3/1/18.
 */

public class RecyclviewActivity extends AppCompatActivity {

    // layoutmanager
    private LinearLayoutManager mLinearLayout;
    private GridLayoutManager mGridLayout;

    private List<Student> mArrStudent = new ArrayList<>();
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

        mAdapter = new RecycleViewAdapter(mArrStudent, new ItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(RecyclviewActivity.this, "Ho va Ten " + mArrStudent.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        mRecycleView.setLayoutManager(mLinearLayout);
        mRecycleView.setAdapter(mAdapter);

        mRecycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        // object (name)
        fetchData();
    }

    /**
     * data on list
     * and notifidatasetchange
     */
    private void fetchData() {
        // add data
        mArrStudent.add(new Student("Anh"));
        mArrStudent.add(new Student("Nhat"));
        mArrStudent.add(new Student("Nam"));
        mArrStudent.add(new Student("Hiep"));
        mArrStudent.add(new Student("Tung "));
        mArrStudent.add(new Student("Tien"));
        mArrStudent.add(new Student("Hung"));
        mArrStudent.add(new Student("Chia"));
        mArrStudent.add(new Student("Chu"));
        mArrStudent.add(new Student("Hoi"));
        // change all view
        mAdapter.notifyDataSetChanged();
    }
}
