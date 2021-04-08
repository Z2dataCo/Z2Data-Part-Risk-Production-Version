package SE_TestScenarios;


import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import SE_Page.Suppliers_Page;
import Utilities_Test.Constants_Test;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class J_1_Supplier_Search {
    private WebDriver driver;
    private ExcelFileManager Variables;
    private Login_Page Login_Obj;
    private Landing_Page Landing_Obj;
    private Suppliers_Page Suppliers_Obj;

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

    @Test(description = "TS001 || Validate To Search For Supplier", priority = 1)
    public void Search_for_Supplier() throws InterruptedException {

        Landing_Obj.Z2D_More_Menu();
        Landing_Obj.Z2D_Select_Supplier();
        boolean Stale_Element = true;
        while (Stale_Element) {
            try {
                Suppliers_Obj.Z2D_Enter_Supplier();
                Stale_Element = false;
            } catch (Exception e) {
                Stale_Element = true;
            }
        }
        Suppliers_Obj.Z2D_Click_Search();
        Suppliers_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        Assert.assertTrue(driver.findElement(Suppliers_Obj.SuppName).getText().contains("Toshiba"));

    }

    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Obj.Tear_Down();
    }

    @BeforeMethod
    public void BeforeMethod() {
        Login_Obj = new Login_Page(driver);
        Landing_Obj = new Landing_Page(driver);
        Suppliers_Obj = new Suppliers_Page(driver);
    }
}