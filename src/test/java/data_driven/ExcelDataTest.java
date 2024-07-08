package data_driven;

import org.testng.annotations.Test;

public class ExcelDataTest {
    @Test
    public void test(){
        ReadDataFromExcel excelReadFile = new ReadDataFromExcel("Login Data.xlsx");
        String username = excelReadFile.getCellData("Valid",1,"Username");
        String password = excelReadFile.getCellData("Valid",1,"Password");
        System.out.println(username);
        System.out.println(password);
    }
}
