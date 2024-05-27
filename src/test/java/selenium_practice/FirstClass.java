package selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstClass {
    @Test
    public void start(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        WebElement searchTextBox = driver.findElement(By.id("small-searchterms"));
        searchTextBox.sendKeys("Test");
        WebElement searchBtn = driver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/button"));
        searchBtn.click();
    }

}
