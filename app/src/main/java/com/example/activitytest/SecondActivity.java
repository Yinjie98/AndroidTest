package com.example.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        /*String data= getIntent().getStringExtra("extra_data");
        Log.d("SecondActivity",data);获取活动1的数据*/

        //点击按钮2，返回活动1，传递数据，并销毁
        Button button2=(Button)findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent();
                intent.putExtra("data_return", "Hello,from SEC");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
