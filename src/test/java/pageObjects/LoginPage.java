package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver ldriver;

    public LoginPage(WebDriver rdriver){
        ldriver= rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(id= "Email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(id = "Password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath = "//button[@type='submit']")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(xpath = "//*[@id='navbarText']/ul/li[3]/a")
    @CacheLookup
    WebElement lnkLogout;

    public void setEmail(String email){
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void setPassword(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);

    }

    public void loginSubmit() {
        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
    }

    public void logoutSubmit(){
        lnkLogout.click();
    }

}
