package com.stupica.core;


import com.stupica.GlobalVar;


public class UtilCommon {

    /**
     * Method: sleepFoxMillis
     *
     * Sleep ..
     */
    public static void sleepFoxMillis(int aiMillis) {
        try { // Pause for X MiliSecond(s)
            Thread.sleep(aiMillis);
        } catch (Exception ex) {
            System.err.println("process(): Interrupt exception!!" + " Msg.: " + ex.getMessage());
            if (GlobalVar.bIsModeVerbose) {
                ex.printStackTrace();
            }
        }
    }
}
