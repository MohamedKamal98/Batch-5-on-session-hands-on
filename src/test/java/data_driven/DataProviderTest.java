package data_driven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @DataProvider(name = "Login Data")
    public Object[][] loginData() {
        return new Object[][]{
                {"Mohamed","Mohamed Password","1"},
                {"Kamal","Kamal Password","2"}
        };
    }

    @Test (dataProvider = "Login Data")
    public void test(String username, String password, String id){
        System.out.println(id);
        System.out.println(username);
        System.out.println(password);
    }
}
