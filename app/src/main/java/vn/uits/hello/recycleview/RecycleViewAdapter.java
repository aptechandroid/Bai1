package vn.uits.hello.recycleview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vn.uits.hello.R;
import vn.uits.hello.interfaces.ItemClickListener;
import vn.uits.hello.model.Student;

/**
 * Copyright © 2017 BAP CO., LTD
 * Created by PHUQUY on 3/1/18.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.StudentHolder> {

    private List<Student> mList;
    private ItemClickListener mListener;

    public RecycleViewAdapter(List<Student> list, ItemClickListener listener) {
        this.mList = list;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewhoder_item, null);
        return new StudentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, int position) {
        holder.mTvName.setText(mList.get(position).getName());
        holder.mTvSchool.setText(mList.get(position).getSchool());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * view holder
     */
    public class StudentHolder extends RecyclerView.ViewHolder {

        private TextView mTvName;
        private TextView mTvSchool;

        public StudentHolder(View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.mTvName);
            mTvSchool = itemView.findViewById(R.id.mTvSchool);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        mListener.onClick(getLayoutPosition());
                    }
                }
            });
        }
    }
}
