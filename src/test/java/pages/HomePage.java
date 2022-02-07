package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private final By myAccountLink = By.cssSelector(".skip-account .label");
    private final By loginLink = By.cssSelector("[title='Log In']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnMyAccount(){
        driver.findElement(myAccountLink).click();
    }

    public void clickLoginLink(){
        driver.findElement(loginLink).click();
    }

}
