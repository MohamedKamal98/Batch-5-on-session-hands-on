package testng_practice;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestNGTest {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @Test
    public void Test1()
    {
        System.out.println("First Test");
    }

    @Test
    public void Test2()
    {
        System.out.println("Second Test");
    }

    @Test (priority = -1 , enabled = false)
    public void start()
    {
        System.out.println("start");
    }

    @Test (priority = 1, enabled = false)
    public void end()
    {
        System.out.println("end");
    }
}
