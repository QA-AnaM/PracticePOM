package Base;

import Pages.HomepagePageBeta;
import Pages.LoginPageBeta;
import Pages.PracticePageBeta;
import Pages.ProfilePageBeta;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTestBeta {
    public static WebDriver driver;
    public HomepagePageBeta homepagePageBeta;
    public LoginPageBeta loginPageBeta;
    public PracticePageBeta practicePageBeta;
    public ProfilePageBeta profilePageBeta;
    public ExcelReader excelReader;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        excelReader = new ExcelReader("C:\\Users\\Ana\\Downloads\\TestData.xlsx");
    }
}
