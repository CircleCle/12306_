package com.example.yuanmao.a12306_;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class Fragment_2 extends Fragment {

    private ImageButton ib_carorder,ib_card,ib_food;
    private Intent intent;

    public Fragment_2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("fragmenttest","*********");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ib_carorder = getActivity().findViewById(R.id.carorder);
        ib_card = getActivity().findViewById(R.id.cridetcard);
        ib_food = getActivity().findViewById(R.id.food);
        ClickEvent();
    }

    private void ClickEvent(){

        ib_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(),foodActivity.class);
                startActivity(intent);
            }
        });

        ib_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ib_carorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
