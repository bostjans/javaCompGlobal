/**
 * Copyright (c) 2017 SETCCE
 * (http://www.setcce.si)
 */
package com.stupica.core;


import java.lang.ref.SoftReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    public static final String DATE_FORMAT_UNIVERSAL = "yyyy-MM-dd";


    public static String toUniversalString(Date a_ntpDate) {
        DateFormat formatter = null;

        if (formatter == null) {
            // No cache yet, or cached formatter GC'd
            formatter = new SimpleDateFormat(DATETIME_FORMAT_UNIVERSAL);
        }
        synchronized (formatter) {
            return formatter.format(a_ntpDate);
        }
    }


    public static String toUTCString(Date a_ntpDate) {
        SoftReference utcFormatter = null;
        DateFormat formatter = null;

        if (utcFormatter != null)
            formatter = (DateFormat) utcFormatter.get();
        if (formatter == null) {
            // No cache yet, or cached formatter GC'd
            formatter = new SimpleDateFormat(NTP_DATE_FORMAT); // + " 'UTC'");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            //utcFormatter = new SoftReference(formatter);
        }
        synchronized (formatter) {
            return formatter.format(a_ntpDate);
        }
    }
}
