package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.LoginPage;

public class Steps {

    public WebDriver driver;
    public LoginPage lp;

    @Given("User Launch Chrome Browser")
    public void user_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
        driver = new ChromeDriver();

        lp = new LoginPage(driver);
    }
    @When("User opens url {string}")
    public void user_opens_url(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }
    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String pwd) {
        lp.setEmail(email);
        lp.setPassword(pwd);
    }
    @When("Click on Login")
    public void click_on_login() {
        lp.loginSubmit();
    }
    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {
        if(driver.getPageSource().contains("Login was unsuccesful.")){
            driver.close();
            Assert.assertTrue(false);
        }
        else {
            Assert.assertEquals(title,driver.getTitle());
        }
     }
    @When("User click on Log out link")
    public void user_click_on_log_out_link() throws InterruptedException {
        lp.logoutSubmit();
        Thread.sleep(3000);
    }
    @Then("close browser")
    public void close_browser() {
        driver.quit();
    }

}
