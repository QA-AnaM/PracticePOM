package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginWithExcel extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://practicetestautomation.com/");
    }

    @Test
    public void userCanLogIn() {
        String validUserName = excelReader.getStringData("Sheet1", 1, 0);
        String validPassword = excelReader.getStringData("Sheet1", 1, 1);
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoinPageButton();
        loginPage.inputUsername(validUserName);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(profilePage.getLogOutButton().isDisplayed());
    }

    @Test
    public void invalidUserCanNotLogIn() {
        for (int i = 1; i <= excelReader.getLastRow("Sheet1"); i++) {
            String invalidUser = excelReader.getStringData("Sheet1", i, 2);
            String validPassword = excelReader.getStringData("Sheet1", 1, 1);
            homepagePage.clickOnPracticeButton();
            practicePage.clickOnTestLoinPageButton();
            loginPage.inputUsername(invalidUser);
            loginPage.inputPassword(validPassword);
            loginPage.clickOnSubmitButton();
            Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
        }
    }

    @Test
    public void invalidPasswordCanNotLogIn() {
        for (int i = 1; i <= excelReader.getLastRow("Sheet1"); i++) {
            String validUser = excelReader.getStringData("Sheet1", 1, 0);
            String invalidPassword = excelReader.getStringData("Sheet1", i, 3);
            homepagePage.clickOnPracticeButton();
            practicePage.clickOnTestLoinPageButton();
            loginPage.inputUsername(validUser);
            loginPage.inputPassword(invalidPassword);
            loginPage.clickOnSubmitButton();
            Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
        }
    }

    @Test
    public void invalidPasswordAndNameCanNotLogIn() {
        for (int i = 1; i <= excelReader.getLastRow("Sheet1"); i++) {
            String invalidUser = excelReader.getStringData("Sheet1", i, 2);
            String invalidPassword = excelReader.getStringData("Sheet1", i, 3);
            homepagePage.clickOnPracticeButton();
            practicePage.clickOnTestLoinPageButton();
            loginPage.inputUsername(invalidUser);
            loginPage.inputPassword(invalidPassword);
            loginPage.clickOnSubmitButton();
            Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());

        }
    }

    @Test
    public void emptyPasswordAndNameCanNotLogIn() {

        String invalidUser = "";
        String invalidPassword = "";
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoinPageButton();
        loginPage.inputUsername(invalidUser);
        loginPage.inputPassword(invalidPassword);
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());


    }


}
