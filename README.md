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
implementation 'com.github.shamalka:Pretty-TimeAgo-android-library:1.1.0'
```

# Methods
```
getTimeAgo(long time) 
// time : Time in milliseconds

getTimeAgo(Context context, String timeString, String simpleDateFormat) 
// timeString : Time in preffered string format (Refer example)
// simpleDateFormat : Date format equal to timeString's format
```

# Example
```
	try {
            String timeAgoWithStringDate = PrettyTimeAgo.getTimeAgo(
                    this, 
                    "2021.05.05 AD at 13:41:56 GMT+05:30", 
                    "yyyy.MM.dd G 'at' HH:mm:ss z"
            );

            long dateInMillis = PrettyTimeAgo.timestampToMilli(
                    this,
                    "2019.05.21 AD at 13:41:56 GMT+05:30", 
                    "yyyy.MM.dd G 'at' HH:mm:ss z"
            );
            String timeAgoWithMillisecondDate = PrettyTimeAgo.getTimeAgo(dateInMillis);
        } catch (ParseException e) {
            // Do error handling here
            e.printStackTrace();
        }
```

SimpleDateFormat patterns you can use.
```
"yyyy.MM.dd G 'at' HH:mm:ss z" ---- 2001.07.04 AD at 12:08:56 PDT
"hh 'o''clock' a, zzzz" ----------- 12 o'clock PM, Pacific Daylight Time
"EEE, d MMM yyyy HH:mm:ss Z"------- Wed, 4 Jul 2001 12:08:56 -0700
"yyyy-MM-dd'T'HH:mm:ss.SSSZ"------- 2001-07-04T12:08:56.235-0700
"yyMMddHHmmssZ"-------------------- 010704120856-0700
"K:mm a, z" ----------------------- 0:08 PM, PDT
"h:mm a" -------------------------- 12:08 PM
"EEE, MMM d, ''yy" ---------------- Wed, Jul 4, '01
```
