package com.example.yuanmao.a12306_;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    private RegCheck regCheck;
    private Button btn_register;
    private EditText edt_userName,edt_Password,edt_sumitPass,
            edt_realName,edt_cardCase,edt_cardID,edt_phone,
            edt_email;
    private CheckBox chc_agree;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initID();
        regCheck = new RegCheck(this);
        btn_register = findViewById(R.id.btn_reg);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean isChecked = regCheck.Check(edt_userName.getText().toString(),
                        edt_Password.getText().toString(),
                        edt_sumitPass.getText().toString(),
                        edt_realName.getText().toString(),
                        edt_cardCase.getText().toString(),
                        edt_cardID.getText().toString(),
                        edt_phone.getText().toString(),
                        edt_email.getText().toString(),
                        chc_agree.isChecked()
                        );
                if (isChecked == true){
                    intent = getIntent();
                    intent.putExtra("userName",edt_userName.getText().toString());
                    intent.putExtra("password",edt_Password.getText().toString());
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }

    private void initID() {
        edt_userName = findViewById(R.id.edt_userName);
        edt_Password = findViewById(R.id.edt_Password);
        edt_sumitPass = findViewById(R.id.edt_sumitPass);
        edt_realName = findViewById(R.id.edt_realName);
        edt_cardCase = findViewById(R.id.edt_cardCase);
        edt_cardID = findViewById(R.id.edt_cardID);
        edt_phone = findViewById(R.id.edt_phone);
        edt_email = findViewById(R.id.edt_email);
        chc_agree = findViewById(R.id.chc_agree);
    }
}
