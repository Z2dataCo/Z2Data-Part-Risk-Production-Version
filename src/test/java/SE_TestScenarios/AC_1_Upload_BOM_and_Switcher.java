package SE_TestScenarios;

import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import SE_Page.Risk_Management_Module;
import SE_Page.Upload_BOM_Page;
import Utilities_Test.Constants_Test;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;

public class AC_1_Upload_BOM_and_Switcher {
    private WebDriver driver;
    private ExcelFileManager Variables;
    private Landing_Page Landing_Obj;
    private Upload_BOM_Page Upload_BOM_Obj;
    private Risk_Management_Module Risk_Management_Obj;
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

    @Test(description = "TS001 || Validate User Upload BOM", priority = 1, enabled = false)
    public void Upload_BOM_and_Switcher() throws AWTException, InterruptedException {

        Landing_Obj.Z2D_Upload_BOM();
        Upload_BOM_Obj.Z2D_Click_Next_Visibility();

        while (!(driver.findElement(By.xpath("//thead/tr[1]/td[2]"))).isDisplayed()) {
            Upload_BOM_Obj.Z2D_Click_Next();
        }
        Upload_BOM_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        Upload_BOM_Obj.Z2D_Select_Type();
        Upload_BOM_Obj.Z2D_Supplier_Selection();
        Upload_BOM_Obj.Z2D_Select_Type();
        Upload_BOM_Obj.Z2D_MPN_Select();
        Upload_BOM_Obj.Z2D_Open_Column();
        Upload_BOM_Obj.Z2D_Supplier_Selection();
        Upload_BOM_Obj.Z2D_Open_Column();
        Upload_BOM_Obj.Z2D_Mapped_IPN_to_be_Clickable();
        Upload_BOM_Obj.Z2D_Mapped_IPN();
        Upload_BOM_Obj.Z2D_Next_Step_to_be_Clickable();
        Upload_BOM_Obj.Z2D_Second_Step();
        Upload_BOM_Obj.Z2D_Select_Folder();
        Upload_BOM_Obj.Z2D_Selected_Folder();
        Upload_BOM_Obj.Z2D_Finish();
        Upload_BOM_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        Risk_Management_Obj.Z2D_Dashboard_Tab_Visibility();
        Assert.assertEquals(Risk_Management_Obj.DashboardTitle(), "Dashboard");
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();

        Risk_Management_Obj.Z2D_Scrub_Tab_Visibility();
        Risk_Management_Obj.Z2D_Click_Scrub_Tab();
        Assert.assertEquals(Risk_Management_Obj.ScrubTitle(), "Scrub");
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();

        Risk_Management_Obj.Z2D_Parts_Tab_Visibility();
        Risk_Management_Obj.Z2D_Click_Parts_Tab();
        Assert.assertEquals(Risk_Management_Obj.PartsTitle(), "Parts");
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        Risk_Management_Obj.Z2D_Select_Switcher();
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        Risk_Management_Obj.Z2D_Select_Switcher();
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();

        Risk_Management_Obj.Z2D_Forecast_Tab_Visibility();
        Risk_Management_Obj.Z2D_Click_Forecast_Tab();
        Assert.assertEquals(Risk_Management_Obj.ForecastTitle(), "Forecast");
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        Risk_Management_Obj.Z2D_Select_Switcher();
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        Risk_Management_Obj.Z2D_Select_Switcher();
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();

        Risk_Management_Obj.Z2D_Compliance_Tab_Visibility();
        Risk_Management_Obj.Z2D_Click_Compliance_Tab();
        Assert.assertEquals(Risk_Management_Obj.ComplianceTitle(), "Compliance");
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();

        Risk_Management_Obj.Z2D_Mitigation_Tab_Visibility();
        Risk_Management_Obj.Z2D_Click_Mitigation_Tab();
        Assert.assertEquals(Risk_Management_Obj.MitigationTitle(), "Mitigation");
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        Risk_Management_Obj.Z2D_Select_Switcher();
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        Risk_Management_Obj.Z2D_Select_Switcher();
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();

        Risk_Management_Obj.Z2D_Reports_Tab_Visibility();
        Risk_Management_Obj.Z2D_Click_Reports_Tab();
        Assert.assertEquals(Risk_Management_Obj.ReportsTitle(), "Reports");
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
    }

    @AfterClass(alwaysRun = true, enabled = false)
    public void TearDown() {
        Login_Obj.Tear_Down();
    }

    @BeforeMethod
    public void BeforeMethod() {
        Login_Obj = new Login_Page(driver);
        Landing_Obj = new Landing_Page(driver);
        Upload_BOM_Obj = new Upload_BOM_Page(driver);
        Risk_Management_Obj = new Risk_Management_Module(driver);
    }
}