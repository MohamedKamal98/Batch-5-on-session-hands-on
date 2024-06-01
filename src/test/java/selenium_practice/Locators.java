package selenium_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Locators {

    @Test
    public void editAndDeleteFromTable1()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement table = driver.findElement(By.id("table1"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        rows.get(2).findElement(By.xpath("//a[@href=\"#edit\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/tables#edit");
    }

    @Test
    public void editAndDeleteFromTable2()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/tables");
        driver.findElement(By.xpath("//table[@id='table1']//tr[2]//a[@href='#delete']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/tables#delete");
    }

    @Test
    public void editAndDeleteFromTableWithEmail()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/tables");
        String email = "jdoe@hotmail.com";
        // xpaths :
        //table[@id="table1"]//td[text()="jdoe@hotmail.com"]/following::a[2]
        //table[@id="table1"]//td[text()="jdoe@hotmail.com"]/parent::tr//a[@href="#delete"]
        //table[@id="table1"]//td[text()="jdoe@hotmail.com"]//ancestor::tr//a[@href="#delete"]
        driver.findElement(By.xpath("//table[@id='table1']//td[text()="+email+"]/..//a[@href='#delete']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/tables#delete");
    }

    @Test
    public void verifyLinks()
    {
        SoftAssert softAssert = new SoftAssert();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        softAssert.assertEquals(links.size(),46);
        for (WebElement link: links) {
            System.out.println(link.getAttribute("href"));
        }
        softAssert.assertAll();
    }
}
