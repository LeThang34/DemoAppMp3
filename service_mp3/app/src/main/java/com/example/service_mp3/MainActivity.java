package com.example.service_mp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageButton btn_play, btn_stop;
    Boolean flag = true; // thuộc về nhóm code thay đổi nút play
    SeekBar seekBar;
    TextView currentTime, totalTime;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_play = findViewById(R.id.btn_play);
        btn_stop = findViewById(R.id.btn_stop);
        seekBar = findViewById(R.id.seekBar);
        currentTime = findViewById(R.id.currentTime);
        totalTime = findViewById(R.id.totalTime);
        mediaPlayer = new MediaPlayer();

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Khai báo intent công khai để khởi động service
                Intent intent1 = new Intent(MainActivity.this, MyService.class);
                startService(intent1);//Gọi đến hàm onStartCommand ở Myservice
                if (flag ==true){
                    btn_play.setImageResource(R.drawable.pause);
                    flag = false;
                }
                else {
                    btn_play.setImageResource(R.drawable.play);
                    flag = true;
                }
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, MyService.class);
                stopService(intent2);//Gọi đến hàm onDestroy ở Myservice
                btn_play.setImageResource(R.drawable.play);
                flag = true;
            }
        });
    }
}