/**
 * Class with basic methods for String manipulation.
 */
package com.stupica.core;


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
        if (sReturn == null) {
            return sReturn;
        }
        if (sReturn.isEmpty()) {
            return sReturn;
        }
        sReturn = sReturn.replace("\n", "").replace("\r", "");
        //sReturn = sReturn.trim();
        return sReturn;
    }
}
