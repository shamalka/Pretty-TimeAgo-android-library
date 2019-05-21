package com.snov.timeagolibrary;

import android.support.annotation.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrettyTimeAgo {

    private static final int SECOND_MILLIS = 1000;
    private static final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
    private static final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
    private static final int DAY_MILLIS = 24 * HOUR_MILLIS;

    public PrettyTimeAgo() {
    }

    public static String getTimeAgo(long time){
        long now = System.currentTimeMillis();

        if (time < 1000000000000L) {
            time *= 1000;
        }

        if (time > now || time <= 0) {
            return null;
        }

        final long diff = now - time;
        if (diff < MINUTE_MILLIS) {
            return "just now";
        } else if (diff < 2 * MINUTE_MILLIS) {
            return "a minute ago";
        } else if (diff < 50 * MINUTE_MILLIS) {
            return diff / MINUTE_MILLIS + " minutes ago";
        } else if (diff < 90 * MINUTE_MILLIS) {
            return "an hour ago";
        } else if (diff < 24 * HOUR_MILLIS) {
            return diff / HOUR_MILLIS + " hours ago";
        } else if (diff < 48 * HOUR_MILLIS) {
            return "1 day ago";
        } else {
            //return diff / DAY_MILLIS + " days ago";
            int days = Integer.parseInt(String.valueOf(diff / DAY_MILLIS));
            if(days < 14){
                return "1 week ago";
            }else if(days < 21){
                return "2 weeks ago";
            }else{
                //return diff / DAY_MILLIS + " days ago";
                Date date = new Date();
                date.setTime(time);
                String formattedDate=new SimpleDateFormat("d MMM, yyyy").format(date);
                return formattedDate;
            }
        }
    }

    public static long timestampToMilli(String timestamp, @NonNull SimpleDateFormat desiredFormat) throws ParseException {
        Date date = desiredFormat.parse(timestamp);
        long timeInMillis = date.getTime();
        return timeInMillis;
    }

}
