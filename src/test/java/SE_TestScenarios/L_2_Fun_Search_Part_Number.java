package SE_TestScenarios;

import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import Utilities_Test.Constants_Test;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class L_2_Fun_Search_Part_Number {
    private WebDriver driver;
    private ExcelFileManager Variables;
    private Landing_Page Landing_Obj;
    private Login_Page Login_Obj;

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

    @Test(description = "TS001 || Validate To Search By Part Number", priority = 1)
    public void Search_with_Part_Number() {

        Landing_Obj.Z2D_Part_Number_Input_Search();
        Landing_Obj.Z2D_Click_Search();
        Landing_Obj.Z2D_Supplier_Check_Box_to_be_Clickable();
        Landing_Obj.Z2D_Check_Supplier();
        Assert.assertEquals(driver.findElement(Landing_Obj.Part_Name).getText(), "bav99");
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
