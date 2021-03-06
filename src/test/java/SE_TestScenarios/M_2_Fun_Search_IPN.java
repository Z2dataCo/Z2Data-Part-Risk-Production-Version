package SE_TestScenarios;


import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import Utilities_Test.Constants_Test;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class M_2_Fun_Search_IPN {
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

    @Test(description = "TS001 || Validate To Search By IPN", priority = 1)
    public void Search_by_IPN() {

        Landing_Obj.Z2D_Open_Landing_Search_Menu();
        Landing_Obj.Z2D_IPN_DDL();
        Landing_Obj.Z2D_IPN_Input_Search();
        Landing_Obj.Z2D_IPN_Value_Visibility();
        Landing_Obj.Z2D_IPN_Value();
        Assert.assertTrue(driver.getCurrentUrl().contains("IPN"));
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