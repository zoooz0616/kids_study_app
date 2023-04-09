package com.example.user.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static java.lang.StrictMath.abs;

public class MGameActivity3 extends AppCompatActivity {

    Random md = new Random();

    private String mResult = "";
    public int counter = 60;
    private TextView counterText;
    private int heartIdx = 1;

    int[] img = {R.drawable.pic13, R.drawable.pic14, R.drawable.pic15, R.drawable.pic16, R.drawable.pic17, R.drawable.pic18};//배경화면.(동물)
    String[] finalAnswer = {"곰", "토끼","돼지","벌","나비","개미"};//배경화면 index에 따른 정답!

    @Override
    public void onBackPressed() {
        Toast.makeText(MGameActivity3.this, "게임 중에는 뒤로 갈 수 없습니다..", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mgame3);  //레이아웃 연결

        //배경 랜덤으로 지정하기.
        final int num= md.nextInt(img.length);
        RelativeLayout back = (RelativeLayout)findViewById(R.id.back);
        back.setBackgroundResource(img[num]);

        counterText = (TextView) findViewById(R.id.text);
        CountDownTimer c = new CountDownTimer(60 * 1000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                counterText.setText(String.valueOf(counter));
                counter--;
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent (MGameActivity3.this, LoseActivity.class);
                startActivity(intent);
            }
        }.start();

        final Button button1 = (Button)findViewById(R.id.button1);
        final Button button2 = (Button)findViewById(R.id.button2);
        final Button button3 = (Button)findViewById(R.id.button3);
        final Button button4 = (Button)findViewById(R.id.button4);
        final Button button5 = (Button)findViewById(R.id.button5);
        final Button button6 = (Button)findViewById(R.id.button6);
        final Button button7 = (Button)findViewById(R.id.button7);
        final Button button8 = (Button)findViewById(R.id.button8);

        final ImageView heart1 = (ImageView) findViewById(R.id.heart1);
        final ImageView heart2 = (ImageView) findViewById(R.id.heart2);
        final ImageView heart3 = (ImageView) findViewById(R.id.heart3);
        final ImageView heart4 = (ImageView) findViewById(R.id.heart4);
        final ImageView heart5 = (ImageView) findViewById(R.id.heart5);

        int A1;//피연산자1
        int B1;//피연산자2
        A1= md.nextInt(10);
        B1= md.nextInt(10);
        button1.setText(A1+" x "+B1);
        final String result1=Integer.toString(A1*B1);

        int A2;//피연산자1
        int B2;//피연산자2
        int n=md.nextInt(5);
        B2= md.nextInt(9) + 1;
        A2= n*B2;
        button2.setText(A2+" ÷ "+B2);
        final String result2=Integer.toString(A2/B2);

        int A3;//피연산자1
        int B3;//피연산자2
        A3= md.nextInt(10);
        B3= md.nextInt(10);
        button3.setText(A3+" x "+B3);
        final String result3=Integer.toString(A3*B3);

        int A4;//피연산자1
        int B4;//피연산자2
        n=md.nextInt(5);
        B4= md.nextInt(9) + 1;
        A4= n*B4;
        button4.setText(A4+" ÷ "+B4);
        final String result4=Integer.toString(A4/B4);

        int A5;//피연산자1
        int B5;//피연산자2
        A5= md.nextInt(10);
        B5= md.nextInt(10);
        button5.setText(A5+" x "+B5);
        final String result5=Integer.toString(A5*B5);

        int A6;//피연산자1
        int B6;//피연산자2
        n=md.nextInt(5);
        B6= md.nextInt(9) + 1;
        A6= n*B6;
        button6.setText(A6+" ÷ "+B6);
        final String result6=Integer.toString(A6/B6);

        int A7;//피연산자1
        int B7;//피연산자2
        A7= md.nextInt(10);
        B7= md.nextInt(10);
        button7.setText(A7+" x "+B7);
        final String result7=Integer.toString(A7*B7);

        int A8;//피연산자1
        int B8;//피연산자2
        n=md.nextInt(5);
        B8= md.nextInt(9) + 1;
        A8= n*B8;
        button8.setText(A8+" ÷ "+B8);
        final String result8=Integer.toString(A8/B8);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MGameActivity3.this);
                alert.setTitle("정답을 입력하세요.");
                alert.setMessage("Q."+ button1.getText() + "=");

                final EditText result = new EditText(MGameActivity3.this); //입력
                result.setInputType(InputType.TYPE_CLASS_NUMBER);  //연락처 키패드 사용
                alert.setView(result);

                alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if(result.getText().toString().equals(result1)){
                            button1.setVisibility(View.INVISIBLE);
                        }
                    }
                });
                alert.setNegativeButton("no",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                });
                alert.show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MGameActivity3.this);
                alert.setTitle("정답을 입력하세요.");
                alert.setMessage("Q."+ button2.getText() + "=");

                final EditText result = new EditText(MGameActivity3.this); //입력
                result.setInputType(InputType.TYPE_CLASS_NUMBER);  //연락처 키패드 사용
                alert.setView(result);

                alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if(result.getText().toString().equals(result2)){
                            button2.setVisibility(View.INVISIBLE);
                        }
                    }
                });
                alert.setNegativeButton("no",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                });
                alert.show();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MGameActivity3.this);
                alert.setTitle("정답을 입력하세요.");
                alert.setMessage("Q."+ button3.getText() + "=");

                final EditText result = new EditText(MGameActivity3.this); //입력
                result.setInputType(InputType.TYPE_CLASS_NUMBER);  //연락처 키패드 사용
                alert.setView(result);

                alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if(result.getText().toString().equals(result3)){
                            button3.setVisibility(View.INVISIBLE);
                        }
                    }
                });
                alert.setNegativeButton("no",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                });
                alert.show();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MGameActivity3.this);
                alert.setTitle("정답을 입력하세요.");
                alert.setMessage("Q."+ button4.getText() + "=");

                final EditText result = new EditText(MGameActivity3.this); //입력
                result.setInputType(InputType.TYPE_CLASS_NUMBER);  //연락처 키패드 사용
                alert.setView(result);

                alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if(result.getText().toString().equals(result4)){
                            button4.setVisibility(View.INVISIBLE);
                        }
                    }
                });
                alert.setNegativeButton("no",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                });
                alert.show();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MGameActivity3.this);
                alert.setTitle("정답을 입력하세요.");
                alert.setMessage("Q."+ button5.getText() + "=");

                final EditText result = new EditText(MGameActivity3.this); //입력
                result.setInputType(InputType.TYPE_CLASS_NUMBER);  //연락처 키패드 사용
                alert.setView(result);

                alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if(result.getText().toString().equals(result5)){
                            button5.setVisibility(View.INVISIBLE);
                        }
                    }
                });
                alert.setNegativeButton("no",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                });
                alert.show();
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MGameActivity3.this);
                alert.setTitle("정답을 입력하세요.");
                alert.setMessage("Q."+ button6.getText() + "=");

                final EditText result = new EditText(MGameActivity3.this); //입력
                result.setInputType(InputType.TYPE_CLASS_NUMBER);  //연락처 키패드 사용
                alert.setView(result);

                alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if(result.getText().toString().equals(result6)){
                            button6.setVisibility(View.INVISIBLE);
                        }
                    }
                });
                alert.setNegativeButton("no",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                });
                alert.show();
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MGameActivity3.this);
                alert.setTitle("정답을 입력하세요.");
                alert.setMessage("Q."+ button7.getText() + "=");

                final EditText result = new EditText(MGameActivity3.this); //입력
                result.setInputType(InputType.TYPE_CLASS_NUMBER);  //연락처 키패드 사용
                alert.setView(result);

                alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if(result.getText().toString().equals(result7)){
                            button7.setVisibility(View.INVISIBLE);
                        }
                    }
                });
                alert.setNegativeButton("no",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                });
                alert.show();
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MGameActivity3.this);
                alert.setTitle("정답을 입력하세요.");
                alert.setMessage("Q."+ button8.getText() + "=");

                final EditText result = new EditText(MGameActivity3.this); //입력
                result.setInputType(InputType.TYPE_CLASS_NUMBER);  //연락처 키패드 사용
                alert.setView(result);

                alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if(result.getText().toString().equals(result8)){
                            button8.setVisibility(View.INVISIBLE);
                        }
                    }
                });
                alert.setNegativeButton("no",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                });
                alert.show();
            }
        });
        final InputMethodManager keyboard = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        final EditText answerInput = (EditText) findViewById(R.id.editText);
        final Button answerButton = (Button) findViewById(R.id.answerButton);
        answerButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                answerInput.requestFocus();
                keyboard.hideSoftInputFromWindow(answerInput. getWindowToken(), 0);
                if(answerInput.getText().toString().length() == 0){
                    Toast.makeText(MGameActivity3.this,"정답을 입력하세요!", Toast.LENGTH_SHORT).show();
                }else if(answerInput.getText().toString().equals(finalAnswer)){
                    Toast.makeText(MGameActivity3.this,"정답입니다!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent (MGameActivity3.this, WinActivity.class);
                    intent.putExtra("score",  (counter * 10)+"");
                    startActivity(intent);
                }else{
                    Toast.makeText(MGameActivity3.this,"정답이 아닙니다!", Toast.LENGTH_SHORT).show();
                    switch (heartIdx){
                        case 1:
                            heart5.setVisibility(View.INVISIBLE);
                            heartIdx++;
                            break;
                        case 2:
                            heart4.setVisibility(View.INVISIBLE);
                            heartIdx++;
                            break;
                        case 3:
                            heart3.setVisibility(View.INVISIBLE);
                            heartIdx++;
                            break;
                        case 4:
                            heart2.setVisibility(View.INVISIBLE);
                            heartIdx++;
                            break;
                        case 5:
                            heart1.setVisibility(View.INVISIBLE);
                            heartIdx++;
                            Intent intent = new Intent (MGameActivity3.this, LoseActivity.class);
                            startActivity(intent);
                            break;
                    }
                }
            }
        });


    }//onCreate
}