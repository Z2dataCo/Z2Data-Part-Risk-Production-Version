package SE_TestScenarios;


import SE_Page.Data_Management_Page;
import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import SE_Page.Risk_Management_Module;
import Utilities_Test.Constants_Test;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AI_2_Fun_Conflict_Minerals {
    private WebDriver driver;
    private ExcelFileManager Variables;
    private Login_Page Login_Obj;
    private Risk_Management_Module Risk_Management_Obj;
    private Data_Management_Page Data_Management_Obj;
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

    @Test(description = "TS001 || Check Report Gold Tantalum Tin Tungsten Cobalt", priority = 1)
    public void Check_Report_Gold_Tantalum_Tin_Tungsten_Cobalt() {
        Landing_Obj.Z2D_Open_Data_Management();
        Data_Management_Obj.Z2D_Type_Folder_Name();
        ElementActions.click(driver, Data_Management_Obj.Test_Folder);
        Data_Management_Obj.Z2D_Open_BOM();
        Risk_Management_Obj.Switch_Tabs();
        Risk_Management_Obj.Z2D_Reports_Open_Reports_Tab();
        Risk_Management_Obj.Z2D_Reports_Open_Conflict_Minerals();
        Risk_Management_Obj.Z2D_Reports_Open_Con_Metals();
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.Tungsten).getText(), "Tungsten");
    }

    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Obj.Tear_Down();
    }

    @BeforeMethod
    public void BeforeMethod() {
        Login_Obj = new Login_Page(driver);
        Risk_Management_Obj = new Risk_Management_Module(driver);
        Data_Management_Obj = new Data_Management_Page(driver);
        Landing_Obj = new Landing_Page(driver);
    }
}
