package com.example.user.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
//import android.support.annotation.WorkerThread;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

//import com.naver.speech.clientapi.SpeechConfig;
//import com.naver.speech.clientapi.SpeechRecognitionException;
//import com.naver.speech.clientapi.SpeechRecognitionListener;
import com.naver.speech.clientapi.SpeechRecognitionResult;
//import com.naver.speech.clientapi.SpeechRecognizer;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity1 extends AppCompatActivity implements View.OnClickListener{
    Random md = new Random();

    private static final String TAG = GameActivity1.class.getSimpleName();
    private static final String CLIENT_ID = "68powl1xlb";

    private RecognitionHandler handler;
    private NaverRecognizer naverRecognizer;
    private String answerWord[] = new String[4];
    private Button button[] = new Button[4];

    private String mResult = "";
    public int counter = 60;
    private TextView counterText;

    private com.naver.naverspeech.client.utils.AudioWriterPCM writer;

    private String nowAnswer = "?"; // 버튼의 정답
    private int btnNum = 0;

    private ImageView heart1;
    private ImageView heart2;
    private ImageView heart3;
    private ImageView heart4;
    private ImageView heart5;

    private int heartIdx = 1;
    int[] img = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6};//배경화면.(과일)
    String[] finalAnswer = {"바나나", "복숭아","사과", "수박","포도","딸기"};//배경화면 index에 따른 정답!


    private void handleMessage(Message msg) {
        switch (msg.what) {
            //음성인식을 시작할 준비가 완료된 경우
            case R.id.clientReady:
                writer = new com.naver.naverspeech.client.utils.AudioWriterPCM(Environment.getExternalStorageDirectory().getAbsolutePath() + " /NaverSpeechTest");
                writer.open("Test");
                break;

            //현재 음성인식이 진행되고 있는 경우
            case R.id.audioRecordint:
                writer.write((short[]) msg.obj);
                break;

            //처리가 되고 있는 도중에 결과를 받은 경우
            case R.id.partialResult:
                mResult = (String) (msg.obj);
                break;

            //최종인식이 완료되면 유사 결과를 모두 보여준다.
            case R.id.finalResult:
                SpeechRecognitionResult speechRecognitionResult = (SpeechRecognitionResult) msg.obj;
                List<String> results = speechRecognitionResult.getResults();
                StringBuilder strBuf = new StringBuilder();

                for (String result : results) {
                    strBuf.append(result);
                    strBuf.append("\n");
                }

                Log.d(TAG, "로그로그 final nowAnswer: "+nowAnswer+", mResult; "+mResult);
                mResult = strBuf.toString();
                if(!nowAnswer.equals("?") && mResult.contains(nowAnswer)) {
                    button[btnNum].setVisibility(View.INVISIBLE);
                }
                break;


            //인식 오류가 발생한 경우
            case R.id.recognitionError:
                if (writer != null) {
                    writer.close();
                }
                mResult = "Error code: " + msg.obj.toString();
                break;

            //음성 인식 비활성화 상태인 경우
            case R.id.clientInactive:
                if (writer != null) {
                    writer.close();
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(GameActivity1.this, "게임 중에는 뒤로 갈 수 없습니다..", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);


        //배경 랜덤으로 지정하기.
        final int num= md.nextInt(img.length);
        ConstraintLayout back = (ConstraintLayout)findViewById(R.id.back);
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
                Intent intent = new Intent (GameActivity1.this, LoseActivity.class);
                startActivity(intent);
            }
        }.start();


        button[0] = (Button) findViewById(R.id.button1);
        button[1] = (Button) findViewById(R.id.button2);
        button[2] = (Button) findViewById(R.id.button3);
        button[3] = (Button) findViewById(R.id.button4);

        answerWord[0] = (String)button[0].getText();
        answerWord[1] = (String)button[1].getText();
        answerWord[2] = (String)button[2].getText();;
        answerWord[3] = (String)button[3].getText();

        heart1 = (ImageView) findViewById(R.id.heart1);
        heart2 = (ImageView) findViewById(R.id.heart2);
        heart3 = (ImageView) findViewById(R.id.heart3);
        heart4 = (ImageView) findViewById(R.id.heart4);
        heart5 = (ImageView) findViewById(R.id.heart5);

        handler = new RecognitionHandler(this);
        naverRecognizer = new NaverRecognizer(this, handler, CLIENT_ID);

        for(int i = 0; i < 4; i++)
            button[i].setOnClickListener(this);

        final InputMethodManager keyboard = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        final EditText answerInput = (EditText) findViewById(R.id.editText);
        final Button answerButton = (Button) findViewById(R.id.answerButton);
        answerButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                answerInput.requestFocus();
                keyboard.hideSoftInputFromWindow(answerInput. getWindowToken(), 0);
                if(answerInput.getText().toString().length() == 0){
                    Toast.makeText(GameActivity1.this,"정답을 입력하세요!", Toast.LENGTH_SHORT).show();
                }else if(answerInput.getText().toString().equals(finalAnswer)){
                    Toast.makeText(GameActivity1.this,"정답입니다!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent (GameActivity1.this, WinActivity.class);
                    intent.putExtra("score",  (counter * 10)+"");
                    startActivity(intent);
                }else{
                    Toast.makeText(GameActivity1.this,"정답이 아닙니다!", Toast.LENGTH_SHORT).show();
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
                            Intent intent = new Intent (GameActivity1.this, LoseActivity.class);
                            startActivity(intent);
                            break;
                    }
                }
            }
        });

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.button1:
                nowAnswer = answerWord[0];
                btnNum = 0;
                break;
            case R.id.button2:
                nowAnswer = answerWord[1];
                btnNum = 1;
                break;
            case R.id.button3:
                nowAnswer = answerWord[2];
                btnNum = 2;
                break;
            case R.id.button4:
                nowAnswer = answerWord[3];
                btnNum = 3;
                break;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Log.d(TAG, "로그로그 else 진입");
            /*음성 인식 기능을 처리합니다. */
            if (!naverRecognizer.getSpeechRecognizer().isRunning()) {
                naverRecognizer.recognize();
                Log.d(TAG, "로그로그  mResult; "+mResult);

            } else {
                Log.d(TAG, "로그로그 stop and wait Final Result");
                naverRecognizer.getSpeechRecognizer().stop();
            }
        } else { /*사용자의 os버전이 마시멜로우 이하일 때 */
            /*음성 인식 기능을 처리합니다. */
            Log.i(TAG, "로그로그 else2 진입");
            if (!naverRecognizer.getSpeechRecognizer().isRunning()) {
                Log.d(TAG, "로그로그 else2의 if 진입");
                mResult = "";
                naverRecognizer.recognize();
            } else {
                Log.i(TAG, "로그로그 stop and wait Final Result");
                button[btnNum].setEnabled(false);
                naverRecognizer.getSpeechRecognizer().stop();
            }
        }


    }
    @Override
    protected void onStart() {
        super.onStart();
        //음성인식 서버 초기화를 진행합니다.
        naverRecognizer.getSpeechRecognizer().initialize();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mResult = "";
    }

    @Override
    protected void onStop() {
        super.onStop();
        //음성인식 서버를 종료합니다.
        naverRecognizer.getSpeechRecognizer().release();
    }

    //SpeechRecognizer 쓰레드의 메시지를 처리하는 핸들러를 정의합니다.
    static class RecognitionHandler extends Handler {
        private final WeakReference<GameActivity1> mActivity;

        RecognitionHandler(GameActivity1 activity) {
            mActivity = new WeakReference<GameActivity1>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            GameActivity1 activity = mActivity.get();
            if (activity != null) {
                activity.handleMessage(msg);
            }
        }
    }
}