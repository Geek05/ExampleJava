package FixAndRetryTests;

import org.testng.annotations.*;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class TestNGORder {

    @BeforeClass
    public void BeforeClass(){
        System.out.println("BeforeClass");
    }

    @BeforeTest
    public void BeforeTest(){
        System.out.println("BeforeTest");
    }

    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("BeforeMethod");
    }

    @Test
    public void test(){
        System.out.println("test");
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("AfterMethod");
    }

    @AfterTest
    public void AfterTest(){
        System.out.println("AfterTest");
    }

    @AfterClass
    public void AfterClass(){
        System.out.println("AfterClass");
    }
}
