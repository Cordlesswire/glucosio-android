package org.glucosio.android.tools;

import android.content.Context;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDateTime {

    private Context context;
    public FormatDateTime(Context mContext){
        this.context= mContext;
    }

    public String convertDate(String date) {
        java.text.DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        java.text.DateFormat finalDataFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        java.text.DateFormat finalTimeFormat;

        if (android.text.format.DateFormat.is24HourFormat(context)) {
            finalTimeFormat = new SimpleDateFormat("HH:mm");
        } else {
            finalTimeFormat = new SimpleDateFormat("hh:mm a");
        }

        Date parsed = null;
        try {
            parsed = inputFormat.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String finalData = finalDataFormat.format(parsed);
        String finalTime = finalTimeFormat.format(parsed);
        return finalData + " " + finalTime;
    }

    public String convertRawDate(String datetime) {
        java.text.DateFormat inputFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
        java.text.DateFormat finalDataFormat = DateFormat.getDateInstance(DateFormat.SHORT);

        Date parsed = null;
        try {
            parsed = inputFormat.parse(datetime);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String finalData = finalDataFormat.format(parsed);
        return finalData + "";
    }

    public String convertRawTime(String datetime) {
        java.text.DateFormat inputFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
        java.text.DateFormat finalTimeFormat;

        if (android.text.format.DateFormat.is24HourFormat(context)) {
            finalTimeFormat = new SimpleDateFormat("HH:mm");
        } else {
            finalTimeFormat = new SimpleDateFormat("hh:mm a");
        }

        Date parsed = null;
        try {
            parsed = inputFormat.parse(datetime);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String finalTime = finalTimeFormat.format(parsed);
        return finalTime + "";
    }
}
