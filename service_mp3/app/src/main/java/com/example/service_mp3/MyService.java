package com.example.service_mp3;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
    //Khai báo đối tượng service quản lý
    MediaPlayer myMusic;

    //Hàm này được dùng khi service trao đổi dl với activity(k dùng trong app này)
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    //Hàm dùng để khởi tạo các đối tượng và thiết lập các thuộc tính mà đối tượng do service quản lý
    @Override
    public void onCreate() {//Được chạy ngay khi mở ứng dụng
        super.onCreate();
        //Tạo ra đối tượng
        myMusic = MediaPlayer.create(MyService.this, R.raw.nammoduocsuphat);
        myMusic.setLooping(true);//Thuộc tính lặp lại bài hát
    }

    //Hàm khởi động đối tượng service quản lý
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Khởi động
        if (myMusic.isPlaying()){
            myMusic.pause();
        }else{
            myMusic.start();
        }
        return super.onStartCommand(intent, flags, startId);
    }

//    Hàm dùng để dừng đối tượng mà service quản lý
        @Override
        public void onDestroy() {
            super.onDestroy();
            myMusic.stop();
        }
}
