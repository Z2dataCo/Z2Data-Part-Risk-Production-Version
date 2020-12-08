package SE_TestScenarios;

import SE_Page.*;
import com.shaft.gui.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static SE_Page.Risk_Management_Module.Switch_Tabs;

public class C_1_Existing_BOM_and_Switcher {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void initialize_Global_Objects_and_Navigate() {
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Navigate_To_URL_for_Navigation();
    }

    @Test(description = "TS001 || Login to Z2Data Part Risk",priority = 1)
    public void Login() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Z2D_SignIn();
    }

    @Test(description = "TS002 || Validate Existing BOM and Switcher",priority = 2)
    public void Existing_BOM_and_Switcher() throws InterruptedException {

        Landing_Page Landing_Obj = new Landing_Page(driver);
        Data_Management_Page Data_Management_Obj = new Data_Management_Page(driver);
        Risk_Management_Module Risk_Management_Obj = new Risk_Management_Module(driver);

        Landing_Obj.Z2D_Open_Data_Management();
        Landing_Obj.Z2D_Wait_General_Spinner_Disappear();
        Data_Management_Obj.Z2D_Type_Folder_Name();
        Data_Management_Obj.Z2D_Select_Folder();
        Data_Management_Obj.Z2D_Open_BOM();
        Switch_Tabs();
        Risk_Management_Obj.Z2D_Spinner_to_Disappear();
        Risk_Management_Obj.Z2D_High_Risk_Card_Clickability();
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.High_Risk_Card).isDisplayed());
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Compliance_Card).isDisplayed());
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Market_Availability_Card).isDisplayed());
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.Dashboard_Tab).getText(), "Dashboard");

        Risk_Management_Obj.Z2D_Click_Scrub_Tab();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_1();
        Risk_Management_Obj.Z2D_Total_Card_Clickability();
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Total_Card).isDisplayed());
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Scrub_Exact_Matches).isDisplayed());
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.Scrub_Tab).getText(), "Scrub");


        Risk_Management_Obj.Z2D_Click_Parts_Tab();
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.First_Table_Data).isDisplayed());

        Risk_Management_Obj.Z2D_Click_Forecast_Tab();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_1();
        Risk_Management_Obj.Z2D_Forecast_First_Filter_Clickability();
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Forecast_Ele_First_Filter).isDisplayed());
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Forecast_Ele_Second_Filter).isDisplayed());
        Risk_Management_Obj.Z2D_Switchers_Pipeline_Clickability();
        Risk_Management_Obj.Z2D_Select_Switcher();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_1();
        Risk_Management_Obj.Z2D_Forecast_First_Filter_Clickability();
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Forecast_Ele_First_Filter).isDisplayed());
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Forecast_Ele_Second_Filter).isDisplayed());

        Risk_Management_Obj.Z2D_Click_Compliance_Tab();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_1();
        Risk_Management_Obj.Z2D_First_CheckBox_Comp_Clickability();
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.First_Table_Data_Comp).isDisplayed());

        Risk_Management_Obj.Z2D_Click_Mitigation_Tab();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_1();
        Risk_Management_Obj.Z2D_First_Total_Card_Mitigation_Clickability();
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Total_Card_Mitigation).isDisplayed());
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Unknown_Card).isDisplayed());
        Risk_Management_Obj.Z2D_Switchers_Pipeline_Clickability();
        Risk_Management_Obj.Z2D_Select_Switcher();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_1();
        Risk_Management_Obj.Z2D_Active_Parts_Clickability();
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Active_Parts).isDisplayed());
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.NRND_Parts).isDisplayed());

        Risk_Management_Obj.Z2D_Click_Reports_Tab();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_1();
        Risk_Management_Obj.Z2D_Preview_Button_Clickability();
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.First_Report).isDisplayed());
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Tear_Down();
    }
}