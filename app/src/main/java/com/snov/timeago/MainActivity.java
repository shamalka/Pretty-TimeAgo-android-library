package com.snov.timeago;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.snov.timeagolibrary.PrettyTimeAgo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize date format
        SimpleDateFormat desiredFormat = new SimpleDateFormat(
                "yyyy.MM.dd G 'at' HH:mm:ss z");
        long dateInMillis = 0;
        try {
            //Pass your timestamp and SimpleDateFormat object to PrettyTimeAgo.timesampToMilli(timestamp , dateformat) method.
            //It will return timestamp in milliseconds as a long.
            dateInMillis = PrettyTimeAgo.timestampToMilli("2019.05.21 AD at 13:41:56 GMT+05:30", desiredFormat);

            //Current time in milliseconds
            long now = System.currentTimeMillis();

            //PrettyTimeAgo.getTimeAgo(pasttime_in_milliseconds) method returns ago time relative to current time.
            String TimeAgo = PrettyTimeAgo.getTimeAgo(dateInMillis);

            TextView timeText = (TextView)findViewById(R.id.timeago);
            timeText.setText(TimeAgo + " | " + dateInMillis + " | " + now);
        } catch (ParseException e) {

            e.printStackTrace();
        }
    }
}
