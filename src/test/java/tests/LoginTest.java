package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class LoginTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/"); }

    @Test
    public void loginWithValidCredentials(){
        homePage.clickOnMyAccount();
        homePage.clickLoginLink();
        loginPage.setEmailField("cosmin@fasttrackit.org");
        loginPage.setPassField("123456");
        loginPage.clickLoginButton();
        Assert.assertTrue("Incorrect message or user not logged in",myAccountPage.isUserLoggedIn("Cosmin Fast"));
    }


    @Test
    public void loginWithInValidCredentials(){
        homePage.clickOnMyAccount();
        homePage.clickLoginLink();
        loginPage.setEmailField("cosmin@fasttrackit.org");
        loginPage.setPassField("asdf");
        loginPage.clickLoginButton();

    }

    @After
    public void closeDriver(){
        driver.close();
    }
}
