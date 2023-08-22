package com.demo.SharedPrefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1,editText2,editText3;

    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        button = findViewById(R.id.button);

        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        returnData();
    }

  public  void saveData(){

        SharedPreferences preferences = getSharedPreferences("mypref", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("text",editText1.getText().toString());
        editor.putString("text2",editText2.getText().toString());
        editor.putString("text3",editText3.getText().toString());
        editor.apply();

      Toast.makeText(MainActivity.this, "Data is saved ", Toast.LENGTH_SHORT).show();


  }


  public void returnData(){

      String data, data2 ,data3;
      SharedPreferences preferences = getSharedPreferences("mypref", MODE_PRIVATE);


      data = preferences.getString("text","");
      data2 = preferences.getString("text2","");
      data3 = preferences.getString("text3","");


      Log.e("======",data+"");

      editText1.setText(data);
      editText2.setText(data2);
      editText3.setText(data3);

  }

}