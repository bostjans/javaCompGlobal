package com.stupica.core;


import com.stupica.GlobalVar;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;


public class TestUtilDate {

    @Before
    public void setUp() {
        System.out.println("Setup: ..");
        GlobalVar.bIsModeVerbose = true;
    }


    @Test
    public void testTrunc11() {
        // Local variables
        String          sReturn = null;
        String          sUrl = "http://www.stupica.com";

        // Initialization
        System.out.println("--");
        System.out.println("Test: testTrunc11() - " + this.getClass().getName());

        System.out.println("Current date - truncate: " + UtilDate.truncateToDate(new Date()));
        //assertTrue(UtilString.isEmpty(sReturn));
        //assertFalse(UtilString.isEmpty(sUrl));
    }
}
