package SE_TestScenarios;

import SE_Page.Data_Management_Page;
import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import SE_Page.Risk_Management_Module;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class C_1_Existing_BOM_and_Switcher {
    private WebDriver driver;
    private ExcelFileManager Variables;
    private Landing_Page Landing_Obj;
    private Data_Management_Page Data_Management_Obj;
    private Login_Page Login_Obj;
    private Risk_Management_Module Risk_Management_Obj;

    @BeforeClass(alwaysRun = true)
    @Parameters("Environment")
    public void initialize_Global_Objects_and_Navigate(String Environment) {
        if (Environment.equalsIgnoreCase("Production")) {
            Variables = new ExcelFileManager("D:\\IdeaProjects\\Z2Data-Part-Risk-Production-Version\\src\\test\\resources\\PartRiskTestData\\ProdEnv_Parameters.xlsx");
        } else {
            Variables = new ExcelFileManager("D:\\IdeaProjects\\Z2Data-Part-Risk-Production-Version\\src\\test\\resources\\PartRiskTestData\\TestEnv_Parameters.xlsx");
        }
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Obj = new Login_Page(driver);
        Login_Obj.Navigate_To_URL_for_Navigation(Variables.getCellData("URL", "Value"));
        Login_Obj.Z2D_SignIn(Variables.getCellData("UserName", "Value"), Variables.getCellData("Password", "Value"));
    }

    @Test(description = "TS001 || Validate Existing BOM and Switcher", priority = 1)
    public void Existing_BOM_and_Switcher() throws InterruptedException {

        Landing_Obj.Z2D_Open_Data_Management();
        Landing_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        Data_Management_Obj.Z2D_Type_Folder_Name();
        Data_Management_Obj.Z2D_Select_Folder();
        Data_Management_Obj.Z2D_Open_BOM();
        Risk_Management_Obj.Switch_Tabs();
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        Risk_Management_Obj.Z2D_High_Risk_Card_to_be_Clickable();
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.High_Risk_Card).isDisplayed());
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Compliance_Card).isDisplayed());
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Market_Availability_Card).isDisplayed());
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.Dashboard_Tab).getText(), "Dashboard");

        Risk_Management_Obj.Z2D_Click_Scrub_Tab();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Z2D_Total_Card_to_be_Clickable();
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Total_Card).isDisplayed());
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Scrub_Exact_Matches).isDisplayed());
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.Scrub_Tab).getText(), "Scrub");


        Risk_Management_Obj.Z2D_Click_Parts_Tab();
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.First_Table_Data).isDisplayed());

        Risk_Management_Obj.Z2D_Click_Forecast_Tab();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Z2D_Forecast_First_Filter_to_be_Clickable();
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Forecast_Ele_First_Filter).isDisplayed());
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Forecast_Ele_Second_Filter).isDisplayed());
        Risk_Management_Obj.Z2D_Switchers_Pipeline_to_be_Clickable();
        Risk_Management_Obj.Z2D_Select_Switcher();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Z2D_Forecast_First_Filter_to_be_Clickable();
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Forecast_Ele_First_Filter).isDisplayed());
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Forecast_Ele_Second_Filter).isDisplayed());

        Risk_Management_Obj.Z2D_Click_Compliance_Tab();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Z2D_First_CheckBox_Comp_to_be_Clickable();
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.First_Table_Data_Comp).isDisplayed());

        Risk_Management_Obj.Z2D_Click_Mitigation_Tab();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Z2D_First_Total_Card_Mitigation_to_be_Clickable();
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Total_Card_Mitigation).isDisplayed());
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Unknown_Card).isDisplayed());
        Risk_Management_Obj.Z2D_Switchers_Pipeline_to_be_Clickable();
        Risk_Management_Obj.Z2D_Select_Switcher();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Z2D_Active_Parts_to_be_Clickable();
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Active_Parts).isDisplayed());
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.NRND_Parts).isDisplayed());

        Risk_Management_Obj.Z2D_Click_Reports_Tab();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Z2D_Preview_Button_to_be_Clickable();
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.First_Report).isDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Tear_Down();
    }

    @BeforeMethod
    public void BeforeMethod() {
        Login_Obj = new Login_Page(driver);
        Landing_Obj = new Landing_Page(driver);
        Data_Management_Obj = new Data_Management_Page(driver);
        Risk_Management_Obj = new Risk_Management_Module(driver);
    }
}