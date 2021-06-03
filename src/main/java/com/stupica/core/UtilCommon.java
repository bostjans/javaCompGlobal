package com.stupica.core;


import com.stupica.ConstGlobal;
import com.stupica.GlobalVar;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.Properties;

import static com.stupica.ConstGlobal.STR_NEWLINE;


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


    /**
     * Method: propToString
     *
     * ..
     */
    public static String propToString(Properties aobjProp) {
        String  sResult = null;

        StringWriter writer = new StringWriter();
        if (aobjProp != null) {
            aobjProp.list(new PrintWriter(writer));
            sResult = writer.getBuffer().toString();
        }
        return sResult;
    }

    /**
     * Method: propToStringStore
     *
     * ..
     */
    public static String propToStringStore(Properties aobjProp) {
        String  sResult = null;

        StringWriter writer = new StringWriter();
        if (aobjProp != null) {
            try {
                aobjProp.store(writer, "");
            } catch (IOException e) {
            }
        }
        sResult = writer.getBuffer().toString();
        return sResult;
    }

    /**
     * Method: propToStringAll
     *
     * ..
     */
    public static String propToStringAll(Properties aobjProp, boolean abShouldNewLine) {
        return propToStringAll(aobjProp, abShouldNewLine, true, ": ");
    }
    public static String propToStringAll(Properties aobjProp, boolean abShouldNewLine, boolean asJson, String asDelimit) {
        boolean         bIsFirstTime = true;
        boolean         bIsString;
        String          sKey;
        String          sTemp;
        StringBuilder   sResult = new StringBuilder();

        if (asJson)
            sResult.append("{ ");
        if (aobjProp != null) {
            if (aobjProp.keySet() != null) {
                for (Object key: aobjProp.keySet()) {
                    if (!bIsFirstTime)
                        if (abShouldNewLine) {
                            if (asJson)
                                sResult.append(",");
                            sResult.append(STR_NEWLINE);
                            if (asJson)
                                sResult.append("  ");
                        }
                        else
                        if (asJson)
                            sResult.append(", ");
                        else
                            sResult.append("; ");
                    else
                        bIsFirstTime = false;

                    sKey = key.toString();
                    sTemp = "";
                    bIsString = false;
                    //Object objData = aobjProp.getProperty(sKey);
                    Object objData = aobjProp.get(sKey);
                    if (objData != null) {
                        if (objData instanceof Boolean) {
                            sTemp = ((Boolean) objData).toString();
                        } else if (objData instanceof Short) {
                            sTemp = ((Short) objData).toString();
                        } else if (objData instanceof Integer) {
                            sTemp = ((Integer) objData).toString();
                        } else if (objData instanceof Long) {
                            sTemp = ((Long) objData).toString();
                        } else if (objData instanceof Float) {
                            sTemp = ((Float) objData).toString();
                        } else if (objData instanceof Double) {
                            sTemp = ((Double) objData).toString();
                        } else if (objData instanceof BigDecimal) {
                            //double nTemp = ((BigDecimal) objData).doubleValue();
                            BigDecimal nTemp = (BigDecimal)objData;
                            sTemp = nTemp.toPlainString();
                        } else if (objData instanceof String) {
                            sTemp = (String) objData;
                            bIsString = true;
                        } else {
                            sTemp = "n/a (unknown type!)";
                        }
                    }
                    if (asJson) {
                        sResult.append("\"").append(sKey).append("\"").append(asDelimit);
                        if (bIsString)
                            sResult.append("\"");
                        sResult.append(sTemp.trim());
                        if (bIsString)
                            sResult.append("\"");
                    }
                    else
                        sResult.append(sKey).append(asDelimit).append(sTemp.trim());
                }
            }
        }
        if (asJson)
            sResult.append(" }");
        return sResult.toString();
    }
}
