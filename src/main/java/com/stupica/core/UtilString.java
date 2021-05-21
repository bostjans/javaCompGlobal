/**
 * Class with basic methods for String manipulation.
 */
package com.stupica.core;


import static com.stupica.ConstGlobal.STR_NEWLINE;
import static com.stupica.ConstGlobal.STR_RETURN;


/**
 * Created by stupicab on 8/31/17.
 */
public class UtilString {

    /**
     * Evaluates ..
     *
     * @param asVal ..
     * @return boolean
     */
    public static boolean isEmpty(String asVal) {
        if (asVal == null) return true;
        if (asVal.isEmpty()) return true;
        return false;
    }

    public static boolean isEmptyTrim(String asVal) {
        if (isEmpty(asVal)) return true;
        if (isEmpty(asVal.trim())) return true;
        return false;
    }


    /**
     * Get subString ..
     *
     * @param asInput ..
     * @param asBegin ..
     * @param asEnd ..
     * @return String
     */
    public static String getStringBetween(String asInput, String asBegin, String asEnd) {
        int     iStartData = 0;
        int     iEndData = 0;
        String sReturn = null;

        if (asInput == null) {
            return sReturn;
        }

        if (asBegin != null) {
            iStartData = asInput.indexOf(asBegin);
            iStartData += asBegin.length();
        }
        if (asEnd == null) {
            iEndData = asInput.length();
        } else {
            iEndData = asInput.lastIndexOf(asEnd);
        }
        if (iStartData > iEndData) {
            return sReturn;
        }
        if (iStartData == iEndData) {
            sReturn = "";
            return sReturn;
        }
        sReturn = asInput.substring(iStartData, iEndData);
        return sReturn;
    }

    /**
     * Get subString ..
     *
     * @param asInput ..
     * @param asBegin ..
     * @param asEnd ..
     * @return String
     */
    public static String getStringBetweenStripNL(String asInput, String asBegin, String asEnd) {
        String sReturn;

        sReturn = getStringBetween(asInput, asBegin, asEnd);
        if (isEmpty(sReturn)) {
            return sReturn;
        }
        sReturn = sReturn.replace(STR_NEWLINE, "").replace(STR_RETURN, "");
        //sReturn = sReturn.trim();
        return sReturn;
    }


    /**
     * Convert ..
     *
     * @param bytes ..
     * @return String
     */
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    public static String bytesToHex(byte[] arrBytes) {
        char[] hexChars = new char[arrBytes.length * 2];

        for (int j = 0; j < arrBytes.length; j++) {
            int v = arrBytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
}
