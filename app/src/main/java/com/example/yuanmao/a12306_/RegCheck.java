package com.example.yuanmao.a12306_;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by 张淦 on 2018/7/3.
 */

public class RegCheck {
    Context context;

    String userName,password,SumitPass,realName,cardCase,cardID,phone,email;
    Boolean isChecked = false,checkedSuccessful = false;
    Boolean un,pw,sp,rn,cc,ci,ph,em;
    public RegCheck(Context context){
        this.context = context;
    }
    public Boolean Check(String userName,String password,String SumitPass,String realName,String cardCase,
                         String cardID,String phone,String email,boolean isChecked){
        this.userName = userName;
        this.password = password;
        this.SumitPass = SumitPass;
        this.realName = realName;
        this.cardCase = cardCase;
        this.cardID = cardID;
        this.phone = phone;
        this.email = email;
        this.isChecked = isChecked;

        un = TextUtils.isEmpty(userName);
        pw = TextUtils.isEmpty(password);
        sp = TextUtils.isEmpty(SumitPass);
        rn = TextUtils.isEmpty(realName);
        cc = TextUtils.isEmpty(cardCase);
        ci = TextUtils.isEmpty(cardID);
        ph = TextUtils.isEmpty(phone);
        em = TextUtils.isEmpty(email);

        if (un){
            ToastMessage("请输入用户名");
        }else if(pw){
            ToastMessage("请输入密码");
        }
        else if(sp){
            ToastMessage("请输入确认密码");
        }
        else if(rn){
            ToastMessage("请输入姓名");
        }else if(cc){
            ToastMessage("请输入证件类型");

        }else if(ci){
            ToastMessage("请输入证件号");
        }else if(ph){
            ToastMessage("请输入手机号");
        }else if(em){
            ToastMessage("请输入邮箱");
        }else if(isChecked == false){
            ToastMessage("请勾选服务条款");
        }

        List<UserInformation> uifs = DataSupport.findAll(UserInformation.class);
        for (UserInformation uif : uifs){
            if(userName == uif.getUserName()){
                ToastMessage("该用户名已存在");
            }
        }

        boolean a = checkBoolean(un,pw,sp,rn,cc,ci,ph,em,isChecked);

        if(a){
            if(password.equals(SumitPass)){
                checkedSuccessful = true;
            }
            else {
                ToastMessage("两次密码输入不相同");
            }
        }
        return checkedSuccessful;
    }
    public void ToastMessage(String str){
        Toast.makeText(context,str,Toast.LENGTH_SHORT).show();
    }

    public boolean checkBoolean(Boolean un,Boolean pw,Boolean sp,Boolean rn,Boolean cc,
                                Boolean ci,Boolean ph,Boolean em,boolean isChecked){
        if((un==false)&&(pw==false)&&(sp==false)&&(rn==false)&&
                (cc==false)&&(ci==false)&&(ph==false)&&(em==false)&&(isChecked == true)){
            return true;
        }
        return false;
    }

}
