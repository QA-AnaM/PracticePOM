package Test;

import Base.BaseTest;
import Pages.HomepagePage;
import Pages.LoginPage;
import Pages.PracticePage;
import Pages.ProfilePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://practicetestautomation.com/");

        homepagePage = new HomepagePage(driver);
        loginPage = new LoginPage(driver);
        practicePage = new PracticePage(driver);
        profilePage= new ProfilePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    
    @Test
    public void userCanLogIn() {
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoinPageButton();
        loginPage.inputUsername("student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(profilePage.getLogOutButton().isDisplayed());
    }

    @Test
    public void userCannotLoginWithInvalidUserName () {
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoinPageButton();
        loginPage.inputUsername("nonstudent");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
    }

}
