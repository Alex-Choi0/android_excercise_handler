package com.example.testhandler;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // ImageView광고 베너 변수
    ImageView adverTiseBanner;
    // 인덱스의 시작은 0부터 시작한다.
    int index = 0;

    // 변경할 이미지 3개를 int배열로 저장한다.
    int[] images = {R.drawable.num1, R.drawable.num2, R.drawable.num3}; // 이미지 리소스 ID 배열;
    // 핸들러 변수 정의
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // xml에 ID를 확인해서 adverTiseBanner에 연결
        adverTiseBanner = findViewById(R.id.imageView);

        // handler를 정의한다.
        handler = new Handler(Looper.myLooper());

        // runnable을 정의한다.
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // 이미지 변경
                adverTiseBanner.setImageResource(images[index]);
                // 다음 이미지 인덱스 계산
                index = (index + 1) % images.length;
                // 1초 후 다시 실행
                handler.postDelayed(this, 1000);
            }
        };

        // runnable을 handler로 시작
        handler.post(runnable);
    }
}