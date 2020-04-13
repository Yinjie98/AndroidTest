package com.example.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       switch (requestCode){
           case 1:
               if(resultCode==RESULT_OK){
                  String returned_Data=data.getStringExtra("data_return");
                   Log.d("FirstActivity",returned_Data);
               }
               break;
           default:
       }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1=(Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                                           //Toast.makeText(FirstActivity.this,"You clicked Button 1",
                                           //Toast.LENGTH_SHORT).show();
                                           //Intent intent=new Intent(FirstActivity.this,SecondActivity.class);显示intent
                                           //隐式intent Intent intent = new Intent("com.example.activitytest.ACTION_START");

                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent1);//这个intent可以选则用默认浏览器打开，也可以选择用活动3打开
                //活动3中定义了能够响应http消息的intent-filter
            }
        });
        Button button2=(Button)findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                /*Intent intent2 = new Intent(Intent.ACTION_DIAL);
                intent2.setData(Uri.parse("tel:10086"));
                startActivity(intent2);*/
                //要传递的数据
                String data = "HELLO";
                /*Intent intent3=new Intent(FirstActivity.this,SecondActivity.class);
                intent3.putExtra("extra_data",data);
                startActivity(intent3);*/
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);
            }
        });

    }
}

