package selenium_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserInteractions {

    WebDriver driver;
    @BeforeMethod
    public void start()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void doubleClick()
    {
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//button"));
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void rightClick()
    {
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();
        WebElement btn = driver.findElement(By.xpath("//span[text()='right click me']"));
        Actions actions = new Actions(driver);
        actions.contextClick(btn).perform();
        driver.findElement(By.xpath("//span[text()='Edit']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void testHover()
    {
        driver.get("https://the-internet.herokuapp.com/hovers");
        driver.manage().window().maximize();
        WebElement element =driver.findElement(By.xpath("(//img)[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        WebElement result = driver.findElement(By.xpath("//a[@href=\"/users/1\"]"));
        Assert.assertEquals(result.getText(),"View profile");
    }

    @Test
    public void testDragAndDrop()
    {
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        driver.manage().window().maximize();
        WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));
        WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li"));
        Actions act=new Actions(driver);
        act.dragAndDrop(From, To).build().perform();
        WebElement result = driver.findElement(By.xpath("//div[@id='bal3']"));
        Assert.assertTrue(result.isDisplayed());
    }

    @Test
    public void testAlert()
    {
        driver.get("https://cookbook.seleniumacademy.com/Alerts.html");
        driver.manage().window().maximize();
        WebElement btn1 = driver.findElement(By.id("confirm"));
        WebElement btn2 = driver.findElement(By.id("prompt"));
        WebElement result1 = driver.findElement(By.id("demo"));
        WebElement result2 = driver.findElement(By.id("prompt_demo"));
        btn1.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Press a button!");
        alert.accept();
        Assert.assertEquals(result1.getText(),"You Accepted Alert!");
        btn1.click();
        alert.dismiss();
        Assert.assertEquals(result1.getText(),"You Dismissed Alert!");
        btn2.click();
        alert.sendKeys("Kamal");
        alert.accept();
        Assert.assertEquals(result2.getText(),"Hello Kamal! How are you today?");
    }

    @Test
    public void frameTest()
    {
        driver.get("https://cookbook.seleniumacademy.com/Frames.html");
        driver.manage().window().maximize();
        driver.switchTo().frame("left");
        System.out.println(driver.findElement(By.xpath("//p")).getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.xpath("//p")).getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("right");
        System.out.println(driver.findElement(By.xpath("//p")).getText());
        driver.switchTo().defaultContent();
    }

    @Test
    public void testFrames()
    {
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        driver.switchTo().frame("mce_0_ifr");
        WebElement element = driver.findElement(By.xpath("//body[@id=\"tinymce\"]//p"));
        Assert.assertEquals(element.getText(),"Your content goes here.");
        driver.switchTo().defaultContent();
    }

    @Test
    public void scrollByPixel() {
        driver.get("http://demo.guru99.com/test/guru99home/");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }

    @Test
    public void scrollByVisibleElement() {
        driver.get("http://demo.guru99.com/test/guru99home/");
        WebElement Element = driver.findElement(By.linkText("Linux"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }

    @Test
    public void scrollByPage() {
        driver.get("http://demo.guru99.com/test/guru99home/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Test
    public void ScrollHorizontally() {
        driver.get("http://demo.guru99.com/test/guru99home/scrolling.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(By.linkText("VBScript"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }

    @Test
    public void keyDown() {
        driver.get("https://www.selenium.dev/selenium/web/single_text_input.html");

        new Actions(driver)
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .perform();

        WebElement textField = driver.findElement(By.id("textInput"));
        Assert.assertEquals("A", textField.getAttribute("value"));
    }

    @Test
    public void keyUp() {
        driver.get("https://www.selenium.dev/selenium/web/single_text_input.html");

        new Actions(driver)
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("b")
                .perform();

        WebElement textField = driver.findElement(By.id("textInput"));
        Assert.assertEquals("Ab", textField.getAttribute("value"));
    }

    @Test
    public void copyAndPaste() {
        driver.get("https://www.selenium.dev/selenium/web/single_text_input.html");

        WebElement textField = driver.findElement(By.id("textInput"));
        Actions actions = new Actions(driver);
        actions.sendKeys(textField, "Selenium!")
                .sendKeys(Keys.ARROW_LEFT)
                .keyDown(Keys.SHIFT)
                .sendKeys(Keys.ARROW_UP)
                .keyUp(Keys.SHIFT)
                .keyDown(Keys.CONTROL)
                .sendKeys("xvv")
                .keyUp(Keys.CONTROL)
                .perform();
        Assert.assertEquals("SeleniumSelenium!", textField.getAttribute("value"));
    }
    @Test
    public void keyboardActions(){
        driver.get("https://demo.guru99.com/test/login.html");
        WebElement usernameTxt = driver.findElement(By.xpath("//input[@id=\"email\"]"));
        usernameTxt.click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("b")
                .perform();
        actions.keyDown(Keys.CONTROL)
                .sendKeys("ac")
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .perform();

    }
}
