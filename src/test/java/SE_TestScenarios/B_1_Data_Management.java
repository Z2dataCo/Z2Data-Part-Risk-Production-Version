package SE_TestScenarios;


import SE_Page.Data_Management_Page;
import SE_Page.Login_Page;
import Utilities_Test.Constants_Test;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.ExcelFileManager;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class B_1_Data_Management {
    public Login_Page Login_Obj;
    private WebDriver driver;
    private ExcelFileManager Variables;
    private Data_Management_Page Data_Management_Obj;

    @BeforeClass(alwaysRun = true)
    @Parameters("Environment")
    public void initialize_Global_Objects_and_Navigate(String Environment) {
        if (Environment.equalsIgnoreCase("Production")) {
            Variables = new ExcelFileManager(Constants_Test.Prod_Data_Path);
        } else {
            Variables = new ExcelFileManager(Constants_Test.Test_Data_Path);
        }
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Obj = new Login_Page(driver);
        Login_Obj.Navigate_To_URL_for_Navigation(Variables.getCellData("URL", "Value"));
        Login_Obj.Z2D_SignIn(Variables.getCellData("UserName", "Value"), Variables.getCellData("Password", "Value"));
    }

    @Test(description = "TS001 || Validate Scenario using Data Management Page ", priority = 1)
    @Severity(SeverityLevel.NORMAL)
    public void Data_Management() {

        Data_Management_Obj.Z2D_Open_Data_Management();
        Assert.assertEquals(driver.findElement(Data_Management_Obj.Table_Name).getText(), "Name");
        Assert.assertEquals(driver.findElement(Data_Management_Obj.Table_User).getText(), "User");
        Assert.assertEquals(driver.findElement(Data_Management_Obj.Table_Of_file).getText(), "# of Files");
        Assert.assertEquals(driver.findElement(Data_Management_Obj.of_Suppliers).getText(), "# of Suppliers");
        Assert.assertEquals(driver.findElement(Data_Management_Obj.Table_Data_Created).getText(), "Date Created");
        Assert.assertEquals(driver.findElement(Data_Management_Obj.Table_Action).getText(), "Actions");

    }

    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Obj.Tear_Down();
    }

    @BeforeMethod
    public void BeforeMethod() {
        Login_Obj = new Login_Page(driver);
        Data_Management_Obj = new Data_Management_Page(driver);
    }
}