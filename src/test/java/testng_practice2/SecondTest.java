package testng_practice2;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SecondTest {

    @Test
    public void test(){
        int x = 3;
        int a = 1, b= 2, c= 3;
        Assert.assertEquals(x,a);
        Assert.assertTrue((x==c));
    }

    @Test
    public void test1(){
        SoftAssert softAssert = new SoftAssert();
        int x = 3;
        int a = 1, b= 2, c= 3;
        softAssert.assertEquals(x,a,"tesst");
        softAssert.assertTrue((x!=c),"x is equal to c");
        softAssert.assertAll();
    }
}
