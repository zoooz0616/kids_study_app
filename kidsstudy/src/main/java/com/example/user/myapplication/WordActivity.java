package com.example.user.myapplication;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

import static android.speech.tts.TextToSpeech.ERROR;

public class WordActivity extends AppCompatActivity {

    private Button button05;
    private Button button06;
    private Button button07;
    private Button button08;
    private Button button09;
    private Button button10;
    private Button button11;
    private Button button12;
    private Button button13;
    private Button button14;
    private Button button15;
    private Button button16;
    private Button button17;
    private Button button18;
    private Button button19;
    private Button button20;
    private Button button21;
    private Button button22;

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        button05 = findViewById(R.id.button05);
        button06 = findViewById(R.id.button06);
        button07 = findViewById(R.id.button07);
        button08 = findViewById(R.id.button08);
        button09 = findViewById(R.id.button09);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button13 = findViewById(R.id.button13);
        button14 = findViewById(R.id.button14);
        button15 = findViewById(R.id.button15);
        button16 = findViewById(R.id.button16);
        button17 = findViewById(R.id.button17);
        button18 = findViewById(R.id.button18);
        button19 = findViewById(R.id.button19);
        button20 = findViewById(R.id.button20);
        button21 = findViewById(R.id.button21);
        button22 = findViewById(R.id.button22);

        // TTS를 생성하고 OnInitListener로 초기화 한다.
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != ERROR) {
                    // 언어를 선택한다.
                    tts.setLanguage(Locale.KOREAN);
                }
            }
        });

        button05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // editText에 있는 문장을 읽는다.
                tts.speak(button05.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
                button05.setVisibility(View.INVISIBLE);
            }
        });
        button06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // editText에 있는 문장을 읽는다.
                tts.speak(button06.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
                button06.setVisibility(View.INVISIBLE);
            }
        });
        button07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // editText에 있는 문장을 읽는다.
                tts.speak(button07.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
                button07.setVisibility(View.INVISIBLE);
            }
        });
        button08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // editText에 있는 문장을 읽는다.
                tts.speak(button08.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
                button08.setVisibility(View.INVISIBLE);
            }
        });
        button09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // editText에 있는 문장을 읽는다.
                tts.speak(button09.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
                button09.setVisibility(View.INVISIBLE);
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // editText에 있는 문장을 읽는다.
                tts.speak(button10.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
                button10.setVisibility(View.INVISIBLE);
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // editText에 있는 문장을 읽는다.
                tts.speak(button11.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
                button11.setVisibility(View.INVISIBLE);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // editText에 있는 문장을 읽는다.
                tts.speak(button12.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
                button12.setVisibility(View.INVISIBLE);
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // editText에 있는 문장을 읽는다.
                tts.speak(button13.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
                button13.setVisibility(View.INVISIBLE);
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // editText에 있는 문장을 읽는다.
                tts.speak(button14.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
                button14.setVisibility(View.INVISIBLE);
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // editText에 있는 문장을 읽는다.
                tts.speak(button15.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
                button15.setVisibility(View.INVISIBLE);
            }
        });
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // editText에 있는 문장을 읽는다.
                tts.speak(button16.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
                button16.setVisibility(View.INVISIBLE);
            }
        });
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // editText에 있는 문장을 읽는다.
                tts.speak(button17.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
                button17.setVisibility(View.INVISIBLE);
            }
        });
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // editText에 있는 문장을 읽는다.
                tts.speak(button18.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
                button18.setVisibility(View.INVISIBLE);
            }
        });
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // editText에 있는 문장을 읽는다.
                tts.speak(button19.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
                button19.setVisibility(View.INVISIBLE);
            }
        });
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // editText에 있는 문장을 읽는다.
                tts.speak(button20.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
                button20.setVisibility(View.INVISIBLE);
            }
        });
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // editText에 있는 문장을 읽는다.
                tts.speak(button21.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
                button21.setVisibility(View.INVISIBLE);
            }
        });
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // editText에 있는 문장을 읽는다.
                tts.speak(button22.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
                button22.setVisibility(View.INVISIBLE);
            }
        });
    }
}
