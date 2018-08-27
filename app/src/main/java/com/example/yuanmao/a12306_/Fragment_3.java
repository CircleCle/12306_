package com.example.yuanmao.a12306_;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.example.yuanmao.a12306_.R.id.isfinish_frame_content;

public class Fragment_3 extends Fragment implements View.OnClickListener{
    private Fragment finishfg;
    private Unfinishfg unfinishfg;
    private TextView tv_finish,tv_unfinish;
    public Fragment_3() {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv_finish = getActivity().findViewById(R.id.finish);
        tv_unfinish = getActivity().findViewById(R.id.unfinish);
        tv_finish.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"xingkai.ttf"));
        tv_finish.setTextColor(getResources().getColor(R.color.colorTextViewPress));
        InitEvent();
        InintFragment(1);
    }
    @Override
    public void onClick(View view) {
        restartButton();
        switch (view.getId()){
            case R.id.finish:
                tv_finish.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"xingkai.ttf"));
                tv_finish.setTextColor(getResources().getColor(R.color.colorTextViewPress));
                InintFragment(1);
                break;
            case R.id.unfinish:
                tv_unfinish.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"xingkai.ttf"));
                tv_unfinish.setTextColor(getResources().getColor(R.color.colorTextViewPress));
                InintFragment(2);
                break;
        }
    }

    private void restartButton() {
        tv_finish.setTypeface(Typeface.DEFAULT);
        tv_unfinish.setTypeface(Typeface.DEFAULT);

        tv_finish.setTextColor(getResources().getColor(R.color.colorTextViewNormal));
        tv_unfinish.setTextColor(getResources().getColor(R.color.colorTextViewNormal));

    }



    private void InitEvent() {
        tv_finish.setOnClickListener(this);
        tv_unfinish.setOnClickListener(this);
    }
    private void InintFragment(int index) {
        //v4包下的Fragment，使用getSupportFragmentManager获取
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        //启动事务
       FragmentTransaction transaction = fragmentManager.beginTransaction();
        //将所有的Fragment隐藏
        hideAllFragment(transaction);
        switch (index){
            case 1:
                if (finishfg == null){
                    finishfg = new Finishfg();
                    transaction.add(R.id.isfinish_frame_content,finishfg);
                }
                else{
                    transaction.show(finishfg);
                }
                break;

            case 2:
                if (unfinishfg == null){
                    unfinishfg = new Unfinishfg();
                    transaction.add(R.id.isfinish_frame_content,unfinishfg);
                }
                else{
                    transaction.show(unfinishfg);
                }
                break;


        }
        //提交事务
        transaction.commit();

    }
    private void hideAllFragment(android.support.v4.app.FragmentTransaction transaction){
        if (finishfg != null){
            transaction.hide(finishfg);
        }

        if (unfinishfg != null){
            transaction.hide(unfinishfg);
        }


        // transaction.commit();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_3, container, false);
    }

}
