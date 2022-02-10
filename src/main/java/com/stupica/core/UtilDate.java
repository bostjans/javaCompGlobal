/**
 * Copyright (c) 2017 Dev404
 * (http://www.dev404.net)
 */
package com.stupica.core;


import com.stupica.ConstGlobal;

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
    public static final String DATETIME_FORMAT_UNI_TIMECOMP = "yyyy-MM-dd_HHmmss";
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
    private static SoftReference objSrUniversalTimeComp = null;
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
    public static String toUniversalStringNow() {
        Date   dtNow = new Date();
        return toUniversalString(dtNow);
    }

    public static String toUniversalTimeCompString(Date aDate) {
        DateFormat formatter = null;

        if (objSrUniversalTimeComp != null)
            formatter = (DateFormat) objSrUniversalTimeComp.get();
        if (formatter == null) {
            formatter = new SimpleDateFormat(DATETIME_FORMAT_UNI_TIMECOMP);
            objSrUniversalTimeComp = new SoftReference(formatter);
        }
        synchronized (formatter) {
            return formatter.format(aDate);
        }
    }
    public static String toUniversalTimeCompStringNow() {
        Date   dtNow = new Date();
        return toUniversalTimeCompString(dtNow);
    }

    public static String toUTCString(Date a_ntpDate) {
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
    public static String toUTCStringNow() {
        Date   dtNow = new Date();
        return toUTCString(dtNow);
    }

    public static String toUniversalTimeString(Date aDate) {
        DateFormat formatter = null;

        if (aDate == null)
            return "__:__:__";
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

        if (UtilString.isEmpty(asVal)) {
            dtResult = new Date();
            return dtResult;
        }
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


    public static Date fromUnixString2Date(String asVal) {
        long lDT = 0L;
        Date dtReturn = null;

        if (!UtilString.isEmptyTrim(asVal))
            try {
                lDT = Long.parseLong(asVal);
            } catch (Exception ex) {
                //logger.severe("getTickerRecFromJsonBitstamp(): Error at data parsing!"
                //        + " Can NOT extract timestamp field!"
                //        + " sData: " + objJson);
                ex.printStackTrace();
            }
        dtReturn = new Date(lDT * 1000);
        return dtReturn;
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
