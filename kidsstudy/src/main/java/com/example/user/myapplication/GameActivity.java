package com.example.user.myapplication;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            /*사용자 단말기의 권환 중 권한이 허용되어 있는지 체크합니다. */
            int permissionResult = checkSelfPermission(Manifest.permission.RECORD_AUDIO);
            /*권한이 없을 때 */
            if (permissionResult != PackageManager.PERMISSION_GRANTED) {
                /*사용자가 권한을 한번이라도 거부한 적이 있는 지 확인합니다. */
                if (shouldShowRequestPermissionRationale(Manifest.permission.RECORD_AUDIO)) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(GameActivity.this);
                    dialog.setTitle("권한이 필요합니다.")
                            .setMessage("이 게임을 사용하기 위해서는 권한이 필요합니다. 허용하시겠습니까?")
                            .setPositiveButton("네", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, 1000);
                                    }
                                }
                            })
                            .setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(GameActivity.this, "기능을 취소했습니다.", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .create()
                            .show();
                }
                //최초로 권한을 요청하는 경우
                else {
                    //권한을 요청합니다.
                    requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, 1000);
                }

            }
        }
    }

    public void btnclicked(View v) {
        if (checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(GameActivity.this, "권한이 없어 게임을 할 수 없습니다.", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(this, GameActivity1.class);
            startActivity(intent);
        }
    }

    public void btnclicked2(View v) {
        if (checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(GameActivity.this, "권한이 없어 게임을 할 수 없습니다.", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(this, GameActivity2.class);
            startActivity(intent);
        }
    }

    public void btnclicked3(View v) {
        if (checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(GameActivity.this, "권한이 없어 게임을 할 수 없습니다.", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(this, GameActivity3.class);
            startActivity(intent);
        }
    }

    public void btnclicked4(View v) {
        Intent intent = new Intent(this, WordActivity.class);
        startActivity(intent);
    }
}
