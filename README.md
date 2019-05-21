# Pretty-TimeAgo-android-library
Android library to get time ago from a given timestamp.

[![](https://jitpack.io/v/shamalka/Pretty-TimeAgo-android-library.svg)](https://jitpack.io/#shamalka/Pretty-TimeAgo-android-library)
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
}
```
```
implementation 'com.github.shamalka:Pretty-TimeAgo-android-library:1.0.0'
```

# Example
```
//Initialize date format
        SimpleDateFormat desiredFormat = new SimpleDateFormat(
                "dd-MM-yyyy:hh-mm-ss");
        long dateInMillis = 0;
        try {
            //Pass your timestamp and SimpleDateFormat object to PrettyTimeAgo.timesampToMilli(timestamp , dateformat) method.
            //It will return timestamp in milliseconds as a long.
            dateInMillis = PrettyTimeAgo.timestampToMilli("20-05-2019:00-01-00", desiredFormat);

            //Current time in milliseconds
            long now = System.currentTimeMillis();

            //PrettyTimeAgo.getTimeAgo(pasttime_in_milliseconds) method returns ago time relative to current time.
            String TimeAgo = PrettyTimeAgo.getTimeAgo(dateInMillis);

            TextView timeText = (TextView)findViewById(R.id.timeago);
            timeText.setText(TimeAgo + " | " + dateInMillis + " | " + now);
        } catch (ParseException e) {

            e.printStackTrace();
        }
```
