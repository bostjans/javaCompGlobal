/**
 * Class with basic methods for File manipulation.
 */
package com.stupica.core;


import com.stupica.ConstGlobal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


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

            // extra options
            // Files.write(Paths.get(path), content.getBytes(),
            //		StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            iResult = ConstGlobal.RETURN_ERROR;
            e.printStackTrace();
        }
        return iResult;
    }
}
