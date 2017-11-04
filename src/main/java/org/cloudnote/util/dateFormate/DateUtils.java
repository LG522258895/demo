package org.cloudnote.util.dateFormate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.cloudnote.util.system.ObjectUtils;
import org.cloudnote.util.system.StringUtils;

public class DateUtils {
	public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static Date getCurrDate() {
        return new Date(System.currentTimeMillis());
    }

    public static String dateToStr(String format) {
        return dateToStr(getCurrDate(), format);
    }

    public static String dateToStr(Date date, String format) {
        if (StringUtils.isEmpty(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }

        if (ObjectUtils.isNull(date)) {
            date = getCurrDate();
        }

        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    public static Date strToDate(String str) {
        return strToDate(str, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date optDateMonth(int num) {
        return optDateField(2, num);
    }

    public static Date optDateField(int field, int num) {
        return optDateField(getCurrDate(), field, num);
    }

    public static Date optDateField(Date date, int field, int num) {
        if (ObjectUtils.isNull(date)) {
            date = getCurrDate();
        }

        Calendar cal = Calendar.getInstance(Locale.getDefault());
        cal.setTime(date);
        cal.set(field, cal.get(field) + num);
        return cal.getTime();
    }

    public static Date strToDate(String str, String format) {
        try {
            if (StringUtils.isEmpty(format)) {
                format = "yyyy-MM-dd HH:mm:ss";
            }

            SimpleDateFormat df = new SimpleDateFormat(format);
            return df.parse(str);
        } catch (Exception arg2) {
            return null;
        }
    }
}
