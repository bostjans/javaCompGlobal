package com.stupica.core;


import com.stupica.ConstGlobal;
import com.stupica.GlobalVar;


public class UtilCommon {

    /**
     * Method: sleepFoxMillis
     *
     * Sleep ..
     */
    public static int sleepFoxMillis(int aiMillis) {
        int         iResult;

        iResult = ConstGlobal.RETURN_OK;
        try { // Pause for X MiliSecond(s)
            Thread.sleep(aiMillis);
        } catch (Exception ex) {
            iResult = ConstGlobal.RETURN_ERROR;
            System.err.println("process(): Interrupt exception!!" + " Msg.: " + ex.getMessage());
            if (GlobalVar.bIsModeVerbose) {
                ex.printStackTrace();
            }
        }
        return iResult;
    }
}
