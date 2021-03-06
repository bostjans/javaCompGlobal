/**
 * Class with basic methods for File manipulation.
 */
package com.stupica.core;


import com.stupica.ConstGlobal;
import com.stupica.GlobalVar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class UtilFile {

    /**
     * Method writeString() ..
     *
     * @param asFile ..
     * @param asVal ..
     * @return int
     */
    public static int writeString(String asFile, String asVal) {
        int         iResult;

        iResult = ConstGlobal.RETURN_OK;

        try {
            // Java 7
            Files.write(Paths.get(asFile), asVal.getBytes());
            // encoding
            // Files.write(Paths.get(path), content.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            iResult = ConstGlobal.RETURN_ERROR;
            if (GlobalVar.bIsModeVerbose)
                e.printStackTrace();
        }
        return iResult;
    }

    /**
     * Method writeStringAppend() ..
     *
     * @param asFile ..
     * @param asVal ..
     * @return int
     */
    public static int writeStringAppend(String asFile, String asVal) {
        int         iResult;

        iResult = ConstGlobal.RETURN_OK;

        try {
            // Java 7
            if (Files.exists(Paths.get(asFile))) {
                Files.write(Paths.get(asFile), asVal.getBytes(), StandardOpenOption.APPEND);
            } else {
                Files.write(Paths.get(asFile), asVal.getBytes());
            }
            // extra options
            // Files.write(Paths.get(path), content.getBytes(),
            //		StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            iResult = ConstGlobal.RETURN_ERROR;
            if (GlobalVar.bIsModeVerbose)
                e.printStackTrace();
        }
        return iResult;
    }
}
