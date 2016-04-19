package com.iak.intermediate.session1.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.iak.intermediate.session1.R;
import com.iak.intermediate.session1.app.adapter.MemberEducationListAdapter;
import com.iak.intermediate.session1.app.model.Member;
import com.iak.intermediate.session1.app.model.MemberEducation;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by aderifaldi on 09-Apr-16.
 */
public class MemberDetailActivity extends AppCompatActivity {

    private Member member;
    private Bundle extras;

    private TextView txt_member_name, txt_member_place_born, txt_member_birth_date, txt_member_address;
    private TextView txt_member_status, txt_member_email, txt_member_contact, txt_member_fb, txt_member_twitter;

    private RecyclerView rv;
    private LinearLayoutManager llm;
    MemberEducationListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_detail);

//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        Date birth;

        extras = getIntent().getExtras();
        member = (Member) extras.getSerializable("member");

//        birth = member.getGeneral_info().getBirth_date();
        txt_member_name = (TextView) findViewById(R.id.txt_member_name);
        txt_member_place_born = (TextView) findViewById(R.id.txt_member_place_born);
        txt_member_birth_date = (TextView) findViewById(R.id.txt_member_birth_date);
        txt_member_address = (TextView) findViewById(R.id.txt_member_address);
        txt_member_status = (TextView) findViewById(R.id.txt_member_status);
        txt_member_email = (TextView) findViewById(R.id.txt_member_email);
        txt_member_contact = (TextView) findViewById(R.id.txt_member_contact);
        txt_member_fb = (TextView) findViewById(R.id.txt_member_fb);
        txt_member_twitter = (TextView) findViewById(R.id.txt_member_twitter);

        txt_member_name.setText(member.getGeneral_info().getName());
        txt_member_place_born.setText(member.getGeneral_info().getPalce_born());
        txt_member_birth_date.setText(member.getGeneral_info().getBirth_date());
        txt_member_address.setText(member.getGeneral_info().getAddress());
        txt_member_status.setText(member.getGeneral_info().getStatus());
        txt_member_email.setText(member.getGeneral_info().getEmail());
        txt_member_contact.setText(member.getGeneral_info().getContact());
        txt_member_fb.setText(member.getGeneral_info().getFacebook());
        txt_member_twitter.setText(member.getGeneral_info().getTwitter());

        rv = (RecyclerView) findViewById(R.id.list_member_ed);
        llm = new LinearLayoutManager(this);

//        MemberEducation[] med = member.getEducation();
        adapter = new MemberEducationListAdapter(this);
        rv.setAdapter(adapter);


        for(MemberEducation med : member.getEducation()){
            adapter.getListMemberEducation().add(med);
            adapter.notifyDataSetChanged();
        }


        rv.setLayoutManager(llm);

        Log.d("detail","" + member.getEducation().length);

    }
}
