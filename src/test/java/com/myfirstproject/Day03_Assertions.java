package com.myfirstproject;

import org.junit.Assert;
import org.junit.Test;

public class Day03_Assertions {
    /*
    ****What is Assertion?
    Assertion is done to make sure expected and actual are equal
    Assertions are very, very important in testing
    Assertions are done to improve the quality of the application and bug free products
    -expected == actual ==> PASS
    -expected != actual ==> FAIL
    ************************************
    * assertEquals("expected","actual"); CHECKS THE VALUES AND DATA TYPES
    * assertTrue(true)==>PASS
    * assertTrue(false)==>FAIL
    * assertFalse(false)==>PASS
    * assertFalse(true)==>FAIL
    *************************************
    * These assertions are HARD assertions
    * If one of the assertion fails, the rest of the test case WILL NOT EXECUTE
    * For example: If line 29 FAILS, the test case will stop
    **************************************
    * Assertion VS Verification?
    * Assertion = Hard assertion  which means test case stops if this assertion fails
    * Verification = soft assertion = Not Hard assertion which means the test case continue to execute even after FAILURE
    * For example : if-else
     */
    @Test
    public void assertions (){
        Assert.assertEquals(5,5);
        Assert.assertEquals("ASSERTION OF EXPECTED AND ACTUAL FAILS",5,5);
        Assert.assertTrue("apple".contains("a"));
        Assert.assertFalse("apple".contains("x"));
    }

}
