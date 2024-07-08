package data_driven;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizingTest {

    @Parameters({"username", "password"})
    @Test
    public void test(String user, String password){
        System.out.println(user);
        System.out.println(password);
    }
}
