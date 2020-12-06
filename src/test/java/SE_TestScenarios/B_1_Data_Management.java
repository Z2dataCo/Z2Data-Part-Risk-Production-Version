package SE_TestScenarios;


import SE_Page.Data_Management_Page;
import SE_Page.Login_Page;
import com.shaft.gui.browser.BrowserFactory;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class B_1_Data_Management  {
    private WebDriver driver;
    public Login_Page Login_Obj;

    @BeforeClass(alwaysRun = true)
    public void initialize_Global_Objects_and_Navigate() {
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Obj = new Login_Page(driver);
        Login_Obj.navigateToURLForNavigationL();
    }

    @Test(description = "TS001 || Login to Z2Data Part Risk")
    public void Login() {
        Login_Obj = new Login_Page(driver);
        Login_Obj.Z2D_SignIn();
    }

    @Test(description = "TS002 || Validate To Open Data Management Page ")
    @Severity(SeverityLevel.NORMAL)
    public void Data_Management() {
        Data_Management_Page DManagement_Obj = new Data_Management_Page(driver);
        DManagement_Obj.Z2D_Open_Data_Management();
        Assert.assertEquals(driver.findElement(DManagement_Obj.Table_Name).getText(), "Name");
        Assert.assertEquals(driver.findElement(DManagement_Obj.Table_User).getText(), "User");
        Assert.assertEquals(driver.findElement(DManagement_Obj.Table_Of_file).getText(), "# of Files");
        Assert.assertEquals(driver.findElement(DManagement_Obj.of_Suppliers).getText(), "# of Suppliers");
        Assert.assertEquals(driver.findElement(DManagement_Obj.Table_Data_Created).getText(), "Date Created");
        Assert.assertEquals(driver.findElement(DManagement_Obj.Table_Action).getText(), "Actions");
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        driver.quit();
    }
}