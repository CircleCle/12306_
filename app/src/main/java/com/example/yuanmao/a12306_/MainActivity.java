package com.example.yuanmao.a12306_;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView user,password;
    private Button login,register;
    private CheckBox rememberpsd,autologin;
    private Boolean isEmpty = true;
    private Intent intent;
    private List<UserInformation> uifs;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LitePal.getDatabase();
        findid();
        initEvent();
        checkRememberOnCreate(pref.getBoolean("isRemember",false),
                pref.getBoolean("isAutplogin",false));
    }

    private void initEvent() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(user.getText().toString())||
                        TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(MainActivity.this,"用户名或密码不能为空",
                            Toast.LENGTH_SHORT).show();
                }else{
                    isEmpty = false;
                }
                if (!isEmpty){
                    checkLegal(user.getText().toString(),password.getText().toString());
                }

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    String userName = data.getStringExtra("userName");
                    String password = data.getStringExtra("password");
                    UserInformation uif = new UserInformation();
                    uif.setUserName(userName);
                    uif.setPassword(password);
                    uif.save();
                    Toast.makeText(MainActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                }
                break;
                default:
        }
    }

    private void findid() {
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        user = findViewById(R.id.tv_user);
        password = findViewById(R.id.tv_password);
        login = findViewById(R.id.btn_login);
        register = findViewById(R.id.btn_register);
        rememberpsd = findViewById(R.id.remenber_psd);
        autologin = findViewById(R.id.autologin);
    }

    private void checkLegal(String userName,String password){
        uifs = DataSupport.findAll(UserInformation.class);
        int flag = -1;
        for(UserInformation uif : uifs){
            //Toast.makeText(MainActivity.this,uif.getUserName(),Toast.LENGTH_SHORT).show();
            if(userName.equals(uif.getUserName().toString())){
                flag = 1;
                if(password.equals(uif.getPassword().toString())){
                    editor = pref.edit();
                    checkRemember(userName,password);
                    intent = new Intent(MainActivity.this,purchaseActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this,"密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        }
        if(flag == -1) {
            Toast.makeText(MainActivity.this, "用户名不存在", Toast.LENGTH_SHORT).show();
        }
    }

    private void checkRemember(String userName,String password) {
        if(rememberpsd.isChecked() || autologin.isChecked()){
            rememberpsd.setChecked(true);
            editor.putBoolean("isRemember",true);
            editor.putBoolean("isAutplogin",autologin.isChecked());
            editor.putString("userName",userName);
            editor.putString("password",password);
        }
        editor.apply();
    }

    private void checkRememberOnCreate(Boolean isRemember,Boolean isAutologin){
        if(isAutologin){
            intent = new Intent(MainActivity.this,purchaseActivity.class);
            startActivity(intent);
        }else if(isRemember){
            rememberpsd.setChecked(true);
            user.setText(pref.getString("userName",""));
            password.setText(pref.getString("password",""));
        }
    }

}
