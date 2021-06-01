package com.snov.timeagolibrary;

import android.content.Context;
import android.text.format.DateUtils;

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

    public static String getTimeAgo(long time) {
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
        } else if (diff < 7 * DAY_MILLIS) {
            if(String.valueOf(diff / DAY_MILLIS).equals("1")) {
                return "1 day ago";
            } else {
                return diff / DAY_MILLIS + " days ago";
            }

        } else if (diff < 4 * DateUtils.WEEK_IN_MILLIS) {
            if(String.valueOf(diff / DateUtils.WEEK_IN_MILLIS).equals("1")) {
                return "1 week ago";
            } else {
                return diff / DateUtils.WEEK_IN_MILLIS + " week ago";
            }

        } else {
            return "More than a month ago";
        }
    }

    public static String getTimeAgo(Context context, String timeString, String simpleDateFormat) throws ParseException {
        long now = System.currentTimeMillis();

        long time = timestampToMilli(context, timeString, simpleDateFormat);

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
        } else if (diff < 7 * DAY_MILLIS) {
            if(String.valueOf(diff / DAY_MILLIS).equals("1")) {
                return "1 day ago";
            } else {
                return diff / DAY_MILLIS + " days ago";
            }
        } else if (diff < 4 * DateUtils.WEEK_IN_MILLIS) {
            if(String.valueOf(diff / DateUtils.WEEK_IN_MILLIS).equals("1")) {
                return "1 week ago";
            } else {
                return diff / DateUtils.WEEK_IN_MILLIS + " week ago";
            }
        } else {
            return "More than a month ago";
        }
    }

    public static long timestampToMilli(Context context, String timestamp, String simpleDateFormat)
            throws ParseException {
        SimpleDateFormat desiredFormat = new SimpleDateFormat(
                simpleDateFormat,
                context.getResources().getConfiguration().locale
        );
        Date date = desiredFormat.parse(timestamp);
        assert date != null;
        return date.getTime();
    }

}
