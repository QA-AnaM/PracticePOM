package Base;

import Pages.HomepagePage;
import Pages.LoginPage;
import Pages.PracticePage;
import Pages.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTest {

    public WebDriver driver;
    public HomepagePage homepagePage;
    public LoginPage loginPage;
    public PracticePage practicePage;
    public ProfilePage profilePage;
    public ExcelReader excelReader;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        excelReader = new ExcelReader("C:\\Users\\Ana\\Downloads\\TestData.xlsx");

    }


}
