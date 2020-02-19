package com.info.calculatorplus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button button0,button1,button2,button3,button4,button5;
    private Button buttonDot,button6,button7,button8,button9,buttonAdd;
    private Button buttonSub,buttonMul,buttonDiv,buttonEqu,buttonClr;

    private TextView textViewInput, textViewResult;

    private char SIGN;
    private char ADD = '+';
    private char SUB = '-';
    private char MUL = '*';
    private char DIV = '/';
    private char EQU = 0;

    private double num1=Double.NaN, num2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpComponents();
        buttons();
        buttonClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewInput.setText(null);
                textViewResult.setText(null);
                num1 = Double.NaN;
                num2 = 0;
                result = 0;
                buttons();
            }
        });

    }

    private void buttons() {

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewInput.setText(textViewInput.getText().toString() + "0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewInput.setText(textViewInput.getText().toString() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewInput.setText(textViewInput.getText().toString() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewInput.setText(textViewInput.getText().toString() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewInput.setText(textViewInput.getText().toString() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewInput.setText(textViewInput.getText().toString() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewInput.setText(textViewInput.getText().toString() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewInput.setText(textViewInput.getText().toString() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewInput.setText(textViewInput.getText().toString() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewInput.setText(textViewInput.getText().toString() + "9");
            }
        });
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewInput.setText(textViewInput.getText().toString() + ".");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcute();
                SIGN = ADD;
                typeControl(num1);
                textViewInput.setText(null);

            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcute();
                SIGN = SUB;
                typeControl(num1);
                textViewInput.setText(null);

            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcute();
                SIGN = MUL;
                typeControl(num1);
                textViewInput.setText(null);

            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcute();
                SIGN = DIV;
                typeControl(num1);
                textViewInput.setText(null);

            }
        });
        buttonEqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcute();
                resultControl(num1,num2);
                if (SIGN == DIV && num2==0) {
                    textViewResult.setText("Error");
                } else {
                    if (result - (int) result == 0) {
                        textViewResult.setText(String.valueOf((int) result));
                    } else {
                        textViewResult.setText(String.valueOf(result));
                    }
                }
            }
        });
    }

    private void calcute() {
        //num1=Double.parseDouble(textViewInput.getText().toString());
        if(!Double.isNaN(num1)) {
            num2 = Double.parseDouble(textViewInput.getText().toString());

            if (SIGN == ADD){
                result = num1 + num2;
                return;
            } else if (SIGN == SUB){
                result = num1 - num2;
                return;
            } else if (SIGN == MUL) {
                result = num1 * num2;
                return;
            } else if(SIGN == DIV) {
                result = num1 / num2;
                return;
            } else if(SIGN == EQU)
                return;
        }
        else {
            num1=Double.parseDouble(textViewInput.getText().toString());
        }
    }

    private void setUpComponents() {
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonDot = findViewById(R.id.buttonDot);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSub = findViewById(R.id.buttonSub);
        buttonMul = findViewById(R.id.buttonMul);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonEqu = findViewById(R.id.buttonEqu);
        buttonClr = findViewById(R.id.buttonClear);
        textViewResult = findViewById(R.id.textViewResult);
        textViewInput = findViewById(R.id.textViewInput);
    }
    private void typeControl(double val1) {
        if(num1 - (int)num1==0)
        {
            textViewResult.setText(String.valueOf((int)num1) + SIGN);
        } else {
            textViewResult.setText(String.valueOf(num1) + SIGN);
        }
    }
    private void resultControl(double val1, double val2) {
        if(val1 - (int)val1 == 0 && val2 - (int)val2 != 0){
            textViewInput.setText(String.valueOf((int)val1) + SIGN + String.valueOf(val2));
        } else if(val2 - (int)val2 == 0 && val1 - (int)val1 != 0){
            textViewInput.setText(String.valueOf(val1) + SIGN + String.valueOf((int)val2));
        } else if(val1 - (int)val1 == 0 && val2 - (int)val2 == 0){
            textViewInput.setText(String.valueOf((int)val1) + SIGN + String.valueOf((int)val2));
        }else {
            textViewInput.setText(String.valueOf(val1) + SIGN + String.valueOf(val2));
        }
    }

}






