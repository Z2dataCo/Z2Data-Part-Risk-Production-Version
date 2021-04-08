package SE_TestScenarios;

import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import Utilities_Test.Constants_Test;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class H_1_Advanced_Crosses {
    private WebDriver driver;
    private ExcelFileManager Variables;
    private Login_Page Login_Obj;
    private Landing_Page Landing_Obj;


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

    @Test(description = "TS001 || Validate To Search By Advanced Crosses", priority = 1)
    public void Advanced_Crosses() {

        Landing_Obj.Z2D_Open_Landing_Search_Menu();
        Landing_Obj.Z2D_Adv_Crosses_Value_to_be_Clickable();
        Landing_Obj.Z2D_Adv_Crosses();
        Landing_Obj.Z2D_Advanced_Crosses_Input_Search();
        Landing_Obj.Z2D_Adv_Product();
        Assert.assertTrue(driver.findElement(Landing_Obj.Total).getText().contains("Total"));
        Assert.assertTrue(driver.findElement(Landing_Obj.Different_Input).getText().contains("Different Pinout"));
        Assert.assertTrue(driver.findElement(Landing_Obj.Drop_in).getText().contains("Drop-In"));
        Assert.assertTrue(driver.findElement(Landing_Obj.Drop_in_Same_Supplier).getText().contains("Drop-In Same Supplier"));
        Assert.assertTrue(driver.findElement(Landing_Obj.Similar_Different_Package).getText().contains("Similar / Different Package"));
    }

    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Obj.Tear_Down();
    }

    @BeforeMethod
    public void BeforeMethod() {
        Login_Obj = new Login_Page(driver);
        Landing_Obj = new Landing_Page(driver);
    }
}