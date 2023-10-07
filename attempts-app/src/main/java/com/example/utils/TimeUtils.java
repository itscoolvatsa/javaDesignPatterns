package com.example.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    public static long TimeDiff(Date date) throws ParseException {
        // Thu Oct 05 12:00:41 IST 2023
        SimpleDateFormat format = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
        Date date1 = format.parse(date.toString());
        Date date2 = format.parse(new Date().toString());
        long oneDay = 60L;

        return oneDay - (date2.getTime() - date1.getTime()) / 1000;
    }

    public static String TimeDiffString(long secondsLeft) {
        long minutesLeft = 0;
        long hoursLeft = 0;

        if (secondsLeft > (60 * 60)) {
            hoursLeft = secondsLeft / 60 / 60;
            secondsLeft = secondsLeft % (60 * 60);
        }
        if (secondsLeft > 60) {
            minutesLeft = secondsLeft / 60;
            secondsLeft = secondsLeft % 60;
        }

        return hoursLeft + " hr " + minutesLeft + " min " + secondsLeft + " sec";
    }
}
