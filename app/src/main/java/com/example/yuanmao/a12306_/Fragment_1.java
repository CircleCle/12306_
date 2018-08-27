package com.example.yuanmao.a12306_;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class Fragment_1 extends Fragment implements View.OnClickListener{

    private Intent intent;

    private TextView data,time, form_city, destination;
    private Calendar calendar;
    private ImageView late_point,careserv,food,gogo;
    private Button btn_find;

    public Fragment_1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragmen_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComponent();//初始化组件
        initClickEvent();//组件的点击事件实现

    }

    private void initComponent(){
        //ImageView
        late_point = getActivity().findViewById(R.id.iv_late_point);
        careserv = getActivity().findViewById(R.id.iv_careserv);
        food = getActivity().findViewById(R.id.iv_food) ;
        gogo = getActivity().findViewById(R.id.iv_gogo);
        //TextView
        form_city = getActivity().findViewById(R.id.tv_startPint);
        destination = getActivity().findViewById(R.id.tv_destination);
        data = getActivity().findViewById(R.id.tv_ChooseData);
        time = getActivity().findViewById(R.id.tv_ChooseTime);

        btn_find = getActivity().findViewById(R.id.btn_find);
        calendar = Calendar.getInstance();
    }

    private void initClickEvent(){
        //日期选择
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataChooseUtil.DataChoose(getActivity(),4,data,calendar);
            }
        });
        //时间选择
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataChooseUtil.TimeChoose(getActivity(),2,time,calendar);
            }
        });
        //出发地选择
        form_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //目的地选择
        destination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(),TicketChooseActivity.class);
                intent.putExtra("from",form_city.getText().toString());
                intent.putExtra("des",destination.getText().toString());
                intent.putExtra("data",data.getText().toString());
                intent.putExtra("time",time.getText().toString());
                startActivityForResult(intent,-1);
            }
        });

        InitEvent();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_late_point:
                intent = new Intent(v.getContext(),latepointActivity.class);
                startActivity(intent);
                break;

            case R.id.iv_careserv:
                intent = new Intent(v.getContext(),careserverActivity.class);
                startActivity(intent);
                break;

            case R.id.iv_gogo:
                intent = new Intent(v.getContext(),gogoActivity.class);
                startActivity(intent);
                break;

            case R.id.iv_food:
                intent = new Intent(v.getContext(),foodActivity.class);
                startActivity(intent);
                break;
        }
    }
    private void InitEvent(){
        //设置LinearLayout监听
        late_point.setOnClickListener(this);
        gogo.setOnClickListener(this);
        food.setOnClickListener(this);
        careserv.setOnClickListener(this);
    }
}
