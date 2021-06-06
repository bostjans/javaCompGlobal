package com.stupica.core;


import com.stupica.GlobalVar;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Properties;

import static org.junit.Assert.*;


public class TestUtilCommon {

    Properties      objProp = null;

    @BeforeClass
    public static void setUpOnce() {
        System.out.println("SetupOnce: ..");
        GlobalVar.bIsModeVerbose = true;
    }

    @Before
    public void setUp() {
        System.out.println("Setup: ..");

        objProp = new Properties();
        objProp.setProperty("k1", "val1");
        objProp.setProperty("k2", "val2");
        //objProp.put("k3", BigDecimal.ONE);
    }


    @Test
    public void testProp2Str11() {
        // Local variables
        String          sReturn = null;

        // Initialization
        System.out.println("--");
        System.out.println("Test: testProp2Str11() - " + this.getClass().getName());

        sReturn = "";
        sReturn = UtilCommon.propToString(objProp);
        assertNotNull(sReturn);
        System.out.println("Prop.: " + sReturn);
    }

    @Test
    public void testProp2Str12() {
        // Local variables
        String          sReturn = null;

        // Initialization
        System.out.println("--");
        System.out.println("Test: testProp2Str12() - " + this.getClass().getName());

        sReturn = UtilCommon.propToStringStore(objProp);
        assertNotNull(sReturn);
        System.out.println("Prop.: " + sReturn);
    }

    @Test
    public void testProp2Str13() {
        // Local variables
        String          sReturn = null;

        // Initialization
        System.out.println("--");
        System.out.println("Test: testProp2Str13() - " + this.getClass().getName());

        objProp.put("k3", BigDecimal.ONE);
        objProp.put("k4", Float.MAX_EXPONENT);
        objProp.put("k11", new Date());

        sReturn = UtilCommon.propToStringAll(objProp, true);
        assertNotNull(sReturn);
        System.out.println("Prop.: " + sReturn);

        sReturn = UtilCommon.propToStringAll(objProp, false, true, false, ": ");
        System.out.println("Prop.: " + sReturn);

        sReturn = UtilCommon.propToStringAll(objProp, true, false, false, " = ");
        System.out.println("Prop.: " + sReturn);

        sReturn = UtilCommon.propToStringAll(objProp, false, false, false, " = ");
        System.out.println("Prop.: " + sReturn);

        sReturn = UtilCommon.propToStringAll(objProp, true, true, true, " = ");
        System.out.println("Prop.: " + sReturn);
    }
}
