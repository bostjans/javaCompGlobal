package com.stupica.core;


import com.stupica.GlobalVar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestUtilString {

    @Before
    public void setUp() {
        System.out.println("Setup: ..");
        GlobalVar.bIsModeVerbose = true;
    }


    @Test
    public void testIsNull11() {
        // Local variables
        String          sReturn = null;
        String          sUrl = "http://www.stupica.com";

        // Initialization
        System.out.println("--");
        System.out.println("Test: testIsNull11() - " + this.getClass().getName());

        assertTrue(UtilString.isEmpty(sReturn));
        assertFalse(UtilString.isEmpty(sUrl));
    }
}
