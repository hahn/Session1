package com.iak.intermediate.session1.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iak.intermediate.session1.R;
import com.iak.intermediate.session1.app.model.MemberEducation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hahn on 16/04/16.
 */
public class MemberEducationListAdapter extends RecyclerView.Adapter<MemberEducationListAdapter.MyViewHolder> {
    private ArrayList<MemberEducation> data;
    private LayoutInflater inflater;
    private Context context;

    public MemberEducationListAdapter(Context context){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = new ArrayList<>();
    }

    public ArrayList<MemberEducation> getListMemberEducation() {
        return data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_member_education, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final MemberEducation member = data.get(position);
        Log.d("onBindViewHolder", "Pos: " + position);

        if(member != null){
            holder.txt_member_year.setText(member.getYear());
            holder.txt_member_at.setText(member.getAt());
            holder.txt_member_subject.setText(member.getSubject());
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        int position;
        TextView txt_member_year, txt_member_at, txt_member_subject;

        public MyViewHolder(View itemView) {
            super(itemView);

            txt_member_year = (TextView) itemView.findViewById(R.id.txt_member_ed_year);
            txt_member_at = (TextView) itemView.findViewById(R.id.txt_member_ed_at);
            txt_member_subject = (TextView) itemView.findViewById(R.id.txt_member_ed_subject);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
