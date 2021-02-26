/**
 * Global variables
 */
package com.stupica;


/**
 * Created by bostjans on 2/4/16.
 */
public class GlobalVar {
    // Variables
    private static GlobalVar objInstance;

    public static boolean bIsModeDev = false;
    public static boolean bIsModeTest = false;
    public static boolean bIsModeVerbose = false;

    //
    public String sProgName;
    public String sVersionMax;
    public String sVersionMin;
    public String sVersionPatch;
    public String sVersionBuild;
    public String sAuthor = "Dev404 - BostjanStupica";

    //
    public String sProgDir;
    public String sUserHome;
    public String sUserDir;
    //public String sRunDir;

    //
    public String sFileSepar;
    public String sLineSepar;


    /**
     *
     */
    private GlobalVar() { }


    /**
     * Method: getInstance
     *
     * Return and/or create the object.
     *
     * @return object	instance of GlobalVar;
     */
    public static GlobalVar  getInstance() {
        // Check ...
        if (objInstance == null) {
            objInstance = new GlobalVar();
        }

        // Return ...
        return objInstance;
    }


    /**
     *
     */
    public String get_version() {
        // Local variables


        // Initialization

        // Return ...
        return sVersionMax + "." + sVersionMin + "." + sVersionPatch + "." + sVersionBuild;
    }
}
