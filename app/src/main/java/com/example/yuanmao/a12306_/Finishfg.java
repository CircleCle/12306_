package com.example.yuanmao.a12306_;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Finishfg extends Fragment {

    private TextView now_date;
    private  SimpleDateFormat sdf;

    public Finishfg() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        now_date = getActivity().findViewById(R.id.date);
        sdf = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date(System.currentTimeMillis());
        now_date.setText(sdf.format(date));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.finish_layout, container, false);
    }
}
