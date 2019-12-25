/**
 * Copyright (c) 2017 SETCCE
 * (http://www.setcce.si)
 */
package com.stupica.core;


import java.lang.ref.SoftReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


/**
 * Container class for utility functions.
 * Created by stupicab on 6/15/17.
 */
public class UtilDate {

    /**
     * Default NTP date string format. E.g. Fri, Sep 12 2003 21:06:23.860.
     * See <code>java.text.SimpleDateFormat</code> for code descriptions.
     */
    public static final String NTP_DATE_FORMAT = "EEE MMM dd HH:mm:ss yyyy";

    public static final String DATETIME_FORMAT_UNIVERSAL = "yyyy-MM-dd_HH:mm:ss";
    public static final String DATETIME_FORMAT_UNIVERSAL2 = "yyyy-MM-dd HH:mm:ss";
    public static final String DATETIME_FORMAT_SI = "dd.MM.yyyy HH:mm:ss";
    public static final String DATE_FORMAT_UNIVERSAL = "yyyy-MM-dd";
    public static final String DATE_FORMAT_SI = "dd.MM.yyyy";
    public static final String TIME_FORMAT_UNIVERSAL = "hh:mm:ss";

    private static Calendar     calendar = Calendar.getInstance();

    //protected SimpleDateFormat objDateFormatUni2 = new SimpleDateFormat(DATETIME_FORMAT_UNIVERSAL2);
    protected SimpleDateFormat objDateFormatTime = new SimpleDateFormat(TIME_FORMAT_UNIVERSAL);

    //private static SoftReference objSrCalendar = null;
    private static SoftReference objSrUniversalFormatter = null;
    private static SoftReference objSrUniversal2Formatter = null;
    private static SoftReference objSrUtcFormatter = null;
    private static SoftReference objSrUniversalTimeFormatter = null;


    public static String toUniversalString(Date aDate) {
        DateFormat formatter = null;

        if (objSrUniversalFormatter != null)
            formatter = (DateFormat) objSrUniversalFormatter.get();
        if (formatter == null) {
            formatter = new SimpleDateFormat(DATETIME_FORMAT_UNIVERSAL);
            objSrUniversalFormatter = new SoftReference(formatter);
        }
        synchronized (formatter) {
            return formatter.format(aDate);
        }
    }

    public static String toUTCString(Date a_ntpDate) {
        //SoftReference utcFormatter = null;
        DateFormat formatter = null;

        if (objSrUtcFormatter != null)
            formatter = (DateFormat) objSrUtcFormatter.get();
        if (formatter == null) {
            // No cache yet, or cached formatter GC'd
            formatter = new SimpleDateFormat(NTP_DATE_FORMAT); // + " 'UTC'");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            objSrUtcFormatter = new SoftReference(formatter);
        }
        synchronized (formatter) {
            return formatter.format(a_ntpDate);
        }
    }

    public static String toUniversalTimeString(Date aDate) {
        DateFormat formatter = null;

        if (objSrUniversalTimeFormatter != null)
            formatter = (DateFormat) objSrUniversalTimeFormatter.get();
        if (formatter == null) {
            formatter = new SimpleDateFormat(TIME_FORMAT_UNIVERSAL);
            objSrUniversalTimeFormatter = new SoftReference(formatter);
        }
        synchronized (formatter) {
            return formatter.format(aDate);
        }
    }


    public static Date fromUniversal2StringDef(String asVal) {
        Date dtResult = null;
        DateFormat formatter = null;

        if (objSrUniversal2Formatter != null)
            formatter = (DateFormat) objSrUniversal2Formatter.get();
        if (formatter == null) {
            formatter = new SimpleDateFormat(DATETIME_FORMAT_UNIVERSAL2);
            objSrUniversal2Formatter = new SoftReference(formatter);
        }
        synchronized (formatter) {
            try {
                dtResult = formatter.parse(asVal);
            } catch (Exception e) {
                // Ignore ..
                dtResult = new Date();
            }
        }
        return dtResult;
    }


    /**
     * Method: truncateToDate
     *
     * Method ..
     *
     * @return Date not_null = AllOK;
     */
    public static Date truncateToDate(Date adtDT) {
        calendar.setTime(adtDT);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }


    /**
     * Method: isEqualInDate
     *
     * Method ..
     *
     * @return boolean true/false;
     */
    public static boolean isEqualInDate(Date adtA, Date adtB) {
        Date dtA, dtB;

        if ((adtA == null) && (adtB == null)) return true;
        if ((adtA == null) && (adtB != null)) return false;
        if ((adtA != null) && (adtB == null)) return false;
        dtA = truncateToDate(adtA);
        dtB = truncateToDate(adtB);
        if (dtA.getTime() == dtB.getTime()) return true;
        return false;
    }
}
