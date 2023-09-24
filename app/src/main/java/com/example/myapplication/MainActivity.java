package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etId;
    private Button btn;
    private CheckBox cbBasketball,cbFootball,cbBadminton,cbRead;
    private Spinner spinner;
    private Switch SwHideSex;
    private RadioGroup rgSex;
    private RadioButton rbBoy,rbGirl;
    String text_sex="";
    String text_hobby="";
    String text_city="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId = findViewById(R.id.etId);
        btn = findViewById(R.id.btn);
        SwHideSex = findViewById(R.id.SwHideSex);
        spinner = findViewById(R.id.spinner);
        rgSex = findViewById(R.id.rgSex);
        cbBasketball = findViewById(R.id.cbBasketball);
        cbFootball = findViewById(R.id.cbFootball);
        cbBadminton = findViewById(R.id.cbBadminton);
        cbRead = findViewById(R.id.cbRead);

        //提交按钮
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, etId.getText()+text_sex+",您好！"+"您所在的城市是："+text_city+"\n"+"您的爱好是："+text_hobby, Toast.LENGTH_SHORT).show();
            }
        });

        //选择性别
        rgSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                if (checkId == R.id.rbBoy) {
                    text_sex = "男士";
                } else if (checkId == R.id.rbGirl) {
                    text_sex = "女士";
                }
            }
        });

        //隐藏性别
        SwHideSex.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    rgSex.setVisibility(View.INVISIBLE);
                    text_sex = "";
                }
                else {
                    rgSex.setVisibility(View.VISIBLE);
                }
            }
        });

        //兴趣爱好
        cbBasketball.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (cbBasketball.isChecked()) {
                    text_hobby += "篮球;";
                } else {
                    text_hobby = text_hobby.replace("篮球;", "");
                }
            }
        });

        cbFootball.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (cbFootball.isChecked()) {
                    text_hobby += "足球;";
                } else {
                    text_hobby = text_hobby.replace("足球;", "");
                }
            }
        });

        cbBadminton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (cbBadminton.isChecked()) {
                    text_hobby += "羽毛球;";
                } else {
                    text_hobby = text_hobby.replace("羽毛球;", "");
                }
            }
        });

        cbRead.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (cbRead.isChecked()) {
                    text_hobby += "阅读;";
                } else {
                    text_hobby = text_hobby.replace("阅读;", "");
                }
            }
        });

        //城市
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                text_city = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }

}