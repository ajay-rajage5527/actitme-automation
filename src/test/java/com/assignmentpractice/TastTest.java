package com.assignmentpractice;

import org.testng.annotations.*;

public class TastTest {
    @BeforeGroups(groups="sanity")
    public void beforeGroup(){
        System.out.println("This is before group method");
    }
    @AfterGroups(groups="regression")
    public void afterRegressionGroup(){
        System.out.println("This is after group method");
    }
    @BeforeTest(groups="regression")
    public void beforeTest(){
        System.out.println("This is before test method");
    }
    @AfterTest(groups="regression")
    public void afterTest(){
        System.out.println("This is after test method");
    }
    @BeforeSuite(groups="regression")
    public void beforeSuite(){
        System.out.println("Before suite method");
    }
    @AfterSuite(groups="regression")
    public void afterSuite(){
        System.out.println("Inside method after suite");
        }
        @BeforeMethod(groups="regression")
    public void beforeMethod(){
        System.out.println("insdide before method");
        }
        @AfterMethod(groups="regression")
    public void afterMethod(){
        System.out.println("Inside method after method");
        }
        @AfterClass
    public void afterClass(){
        System.out.println("inside method after class");
        }
    @BeforeClass
    public void beforeClass(){
        System.out.println("inside method before class");
    }
    @Test(groups="regression")
    public void test1(){
        System.out.println("inside method test1");
        }
    @Test(groups="sanity")
    public void test2(){
        System.out.println("inside method test2");
    }
    @Test(groups={"regression","sanity"})
    public void test3(){
        System.out.println("inside method test3");
    }

}
