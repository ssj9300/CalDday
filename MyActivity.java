package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int d_day = caldate(2019,10,27); //디데이 입력
        Log.d("[D-day]", "dday=" + d_day);
    }


        public int caldate(int myear, int mmonth, int mday) {
            try {
                Calendar today1 = Calendar.getInstance();//현재 오늘 날짜
                int today_year = today1.get(Calendar.YEAR);
                int today_month = today1.get(Calendar.MONTH);
                int today_day = today1.get(Calendar.DAY_OF_MONTH);

                Calendar today2 = Calendar.getInstance();//현재 오늘 날짜에 월 보정을 해줄 실제 계산 날짜

                Calendar dday = Calendar.getInstance();//디데이

                today2.set(today_year, today_month+1, today_day);
                dday.set(myear, mmonth, mday); //디데이입력값 반영
                //Log.d("[Day]", String.valueOf(today2));
                //Log.d("[Day]", String.valueOf(dday));

                long day = dday.getTimeInMillis() / 86400000; // 각각 날의 시간 값을 얻어옴 ( 1일의 값(86400000 = 24시간 * 60분 * 60초 * 1000(1초값) ) )
                long tday = today2.getTimeInMillis() / 86400000;
                long count = tday - day; // 오늘 날짜에서 dday 빼기
                return (int)count; 
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }



}
