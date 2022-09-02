package com.cos.testbitmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.cos.testbitmp.widget.MyCustomView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity222";
    private MainActivity mContext;

    private MyCustomView customImg;
    private Button btnUp, btnDown;
    private EditText textValue;

    //초기값 설정
    private int nValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initListener();
        initData();

        customImg.setValue(nValue);

    }


    private void init(){

        customImg = findViewById(R.id.custom_img);
        btnUp = findViewById(R.id.btn_up);
        btnDown = findViewById(R.id.btn_down);
        textValue = findViewById(R.id.txt_value);

        nValue = 0;

    }

    private String strValue;
    private void initListener(){
        nValue = Integer.parseInt(textValue.getText().toString());

        btnUp.setOnClickListener(v -> {
            Log.d(TAG, "initListener: up");
            if(nValue <= 11){
                nValue++;
            }

            strValue = Integer.toString(nValue);
            textValue.setText(strValue);
            customImg.setValue(nValue); //customView change
        });

        btnDown.setOnClickListener(v -> {
            Log.d(TAG, "initListener: down");

            if(nValue>0){
                nValue--;
            }

            strValue = Integer.toString(nValue);
            textValue.setText(strValue);

            customImg.setValue(nValue); //customView change

        });

        Log.d(TAG, "initListener: nValue " + nValue);

    }
    private void initData(){ }


    private int nMax = 11;
    private int nMin = 0;
    private int setMax(int value){

        if(value < nMin)
            value = nMin;
        else if(value > nMax)
            value = nMax;

        return value;

    }

}