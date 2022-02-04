import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private WebDriver driver;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/"); }

    @Test
    public void loginWithValidCredentials(){
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
//        WebElement element = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
//        element.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        String welcomeText = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > div.welcome-msg > p.hello > strong")).getText();
        Assert.assertTrue("The welcome test is incorrect!",welcomeText.equals("Hello, Cosmin Fast!"));
        Assert.assertEquals("Hello, Cosmin Fast!", welcomeText);
    }


    @Test
    public void loginWithInValidCredentials(){
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
//        WebElement element = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
//        element.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("hjk@fasttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
    }

    @After
    public void closeDriver(){
        driver.close();
    }
}
