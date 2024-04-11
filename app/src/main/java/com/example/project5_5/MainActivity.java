package com.example.project5_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText edit1,edit2;
    Button btnadd,btnmin,btnmul,btndiv;
    TextView tv1;
    String num1,num2;
    Integer result;
    Button[] numButton = new Button[10];
    Integer[] numBtnids = {R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,
            R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9};
    int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("테이블레이아웃 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnadd = (Button) findViewById(R.id.btnadd);
        btnmin = (Button) findViewById(R.id.btnmin);
        btnmul = (Button) findViewById(R.id.btnmul);
        btndiv = (Button) findViewById(R.id.btndiv);

        tv1 = (TextView) findViewById(R.id.TextResult);

        btnadd.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1)
            {
                num1= edit1.getText().toString();
                num2= edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                tv1.setText("계산결과 : "+result.toString());
                return false;
            }
        });

        btnmin.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1)
            {
                num1= edit1.getText().toString();
                num2= edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                tv1.setText("계산결과 : "+result.toString());
                return false;
            }
        });

        btnmul.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1)
            {
                num1= edit1.getText().toString();
                num2= edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                tv1.setText("계산결과 : "+result.toString());
                return false;
            }
        });

        btndiv.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1)
            {
                num1= edit1.getText().toString();
                num2= edit2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                tv1.setText("계산결과 : "+result.toString());
                return false;
            }
        });

        for(i=0;i<numBtnids.length;i++)
        {
            numButton[i] = (Button) findViewById(numBtnids[i]);
        }

        for(i = 0; i<numBtnids.length;i++) {
            final int index;
            index = i;


            numButton[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (edit1.isFocused() == true) {
                        num1 = edit1.getText().toString()
                                + numButton[index].getText().toString();
                        edit1.setText(num1);
                    } else if (edit2.isFocused() == true) {
                        num2 = edit2.getText().toString()
                                + numButton[index].getText().toString();
                        edit2.setText(num2);
                    } else
                        Toast.makeText(getApplicationContext(), "먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show();

                }
            });

        }
    }
}