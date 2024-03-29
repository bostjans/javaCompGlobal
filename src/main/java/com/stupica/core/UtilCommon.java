package com.stupica.core;


import com.stupica.ConstGlobal;
import com.stupica.GlobalVar;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.*;

import static com.stupica.ConstGlobal.STR_NEWLINE;


public class UtilCommon {

    public static boolean   bShouldSortProp2Str = false;


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
        return propToStringAll(aobjProp, abShouldNewLine, true, true, ": ");
    }
    public static String propToStringAll(Properties aobjProp, boolean abShouldNewLine, boolean asJson, boolean abFormat, String asDelimit) {
        boolean         bIsFirstTime = true;
        boolean         bIsString;
        boolean         bIsEmpty = false;
        String          sKey;
        String          sTemp;
        BigDecimal      nTemp;
        Set             objKeys = null;
        SortedSet       objKeysSorted = null;
        StringBuilder   sResult = new StringBuilder();

        if (aobjProp == null)
            bIsEmpty = true;
        else {
            objKeys = aobjProp.keySet();
            if (objKeys == null)
                bIsEmpty = true;
            else if (objKeys.isEmpty())
                bIsEmpty = true;
        }

        if (!bIsEmpty) {
            if (bShouldSortProp2Str) {
                objKeysSorted = new TreeSet<>(objKeys);
                objKeys = objKeysSorted;
            }
            if (asJson)
                sResult.append("{ ");
            for (Object key: objKeys) {
                if (!bIsFirstTime)
                    if (abShouldNewLine) {
                        if (asJson)
                            sResult.append(",");
                        sResult.append(STR_NEWLINE);
                        if (asJson)
                            sResult.append("  ");
                    } else
                        if (asJson)
                            sResult.append(", ");
                        else
                            sResult.append("; ");
                else
                    bIsFirstTime = false;

                sKey = key.toString();
                sTemp = "";
                bIsString = false;

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
                        if (abFormat) {
                            if (objData == null) {
                                nTemp = BigDecimal.ZERO;
                            } else {
                                Float nTempF = (Float) objData;
                                nTemp = BigDecimal.ZERO;
                                if (nTempF.isInfinite()) {
                                    //objEvalJsonProp.add(sKey + "-Float", "is_infinite");
                                    propToStringAddElement(sKey + "-Float", "is_infinite", asDelimit, true, asJson, sResult);
                                } else if (nTempF.isNaN()) {
                                    propToStringAddElement(sKey + "-Float", "is_NaN", asDelimit, true, asJson, sResult);
                                } else {
                                    try {
                                        nTemp = BigDecimal.valueOf(nTempF.doubleValue());
                                    } catch (Exception ex) {
                                        nTemp = BigDecimal.ZERO;
                                        ex.printStackTrace();
                                    }
                                }
                                nTemp = nTemp.setScale(8, BigDecimal.ROUND_CEILING);
                            }
                            //objEvalJsonProp.add(sKey, nTemp.floatValue());
                            sTemp = "" + nTemp.floatValue();
                            if (sTemp.contains("E")) {
                                propToStringAddElement(sKey + "-asStr", nTemp.toPlainString(), asDelimit, true, asJson, sResult);
                            }
                        } else
                            sTemp = ((Float) objData).toString();
                    } else if (objData instanceof Double) {
                        if (abFormat) {
                            if (objData == null) {
                                nTemp = BigDecimal.ZERO;
                            } else {
                                try {
                                    nTemp = BigDecimal.valueOf(((Double) objData).doubleValue());
                                } catch (Exception ex) {
                                    nTemp = BigDecimal.ZERO;
                                    ex.printStackTrace();
                                }
                                nTemp = nTemp.setScale(8, BigDecimal.ROUND_CEILING);
                            }
                            //objEvalJsonProp.add(sKey, nTemp.doubleValue());
                            //sTemp = "" + nTemp.floatValue();
                            sTemp = "" + nTemp.doubleValue();
                            if (sTemp.contains("E")) {
                                propToStringAddElement(sKey + "-asStr", nTemp.toPlainString(), asDelimit, true, asJson, sResult);
                            }
                        } else
                            sTemp = ((Double) objData).toString();
                    } else if (objData instanceof BigDecimal) {
                        if (abFormat) {
                            nTemp = (BigDecimal) objData;
                            //objEvalJsonProp.add(sKey, nTemp.doubleValue());
                            sTemp = "" + nTemp.doubleValue();
                            if (sTemp.contains("E")) {
                                propToStringAddElement(sKey + "-asStr", nTemp.toPlainString(), asDelimit, true, asJson, sResult);
                            }
                        } else {
                            //double nTemp = ((BigDecimal) objData).doubleValue();
                            nTemp = (BigDecimal)objData;
                            sTemp = nTemp.toPlainString();
                        }
                    } else if (objData instanceof String) {
                        sTemp = (String) objData;
                        if (asJson) {
                            if (sTemp.contains("\""))
                                sTemp = sTemp.replace("\"", "\\\"");
                            if (sTemp.contains("\n"))
                                sTemp = sTemp.replace("\n", "\\n");
                            if (sTemp.contains("\t"))
                                sTemp = sTemp.replace("\t", "\\t");
                        }
                        bIsString = true;
                    } else if (objData instanceof Date) {
                        sTemp = UtilDate.toUniversalString((Date) objData);
                        bIsString = true;
                    } else {
                        sTemp = "n/a (unknown type!)";
                    }
                }
                propToStringAddElement(sKey, sTemp, asDelimit, bIsString, asJson, sResult);
            }
            if (asJson)
                sResult.append(" }");
        }
        return sResult.toString();
    }
    private static void propToStringAddElement(String asKey, String asValue, String asDelimit,
                                               boolean abIsString, boolean asJson, StringBuilder aobjResult) {
        if (asJson) {
            aobjResult.append("\"").append(asKey).append("\"").append(asDelimit);
            if (abIsString)
                aobjResult.append("\"");
            aobjResult.append(asValue.trim());
            if (abIsString)
                aobjResult.append("\"");
        }
        else
            aobjResult.append(asKey).append(asDelimit).append(asValue.trim());
    }


    /**
     * Method: exceptionToString
     *
     * ..
     */
    public static String exceptionToString(Exception aobjEx) {
        StringBuilder sResult = new StringBuilder();

        if (!UtilString.isEmpty(aobjEx.getMessage()))
            sResult.append("; Msg.: ").append(aobjEx.getMessage());
        sResult.append("; Exception: ").append(aobjEx.toString());
        {
            int iCountLevel = 1;
            Throwable objCause = aobjEx.getCause();

            if (objCause != null) {
                sResult.append("; cause(").append(iCountLevel++).append("): ").append(objCause.getMessage());
                objCause = objCause.getCause();
            }
            if (objCause != null) {
                sResult.append("; cause(").append(iCountLevel++).append("): ").append(objCause.getMessage());
                objCause = objCause.getCause();
            }
            if (objCause != null) {
                sResult.append("; cause(").append(iCountLevel++).append("): ").append(objCause.getMessage());
                objCause = objCause.getCause();
            }
            if (objCause != null) {
                sResult.append("; cause(").append(iCountLevel++).append("): ").append(objCause.getMessage());
            }
        }
        return sResult.toString();
    }
    /**
     * Method: exceptionStackToString
     *
     * ..
     */
    public static String exceptionStackToString(Exception aobjEx) {
        String      sResult;
        StringWriter writer = new StringWriter();

        sResult = exceptionToString(aobjEx);
        {
            PrintWriter pw = new PrintWriter(writer);
            aobjEx.printStackTrace(pw);
            sResult += "\n\tExceptionStack: " + writer.toString();
        }
        return sResult;
    }
}
