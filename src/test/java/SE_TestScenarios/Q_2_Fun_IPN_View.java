package SE_TestScenarios;


import SE_Page.Data_Management_Page;
import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import SE_Page.Risk_Management_Module;
import com.shaft.gui.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Q_2_Fun_IPN_View {

    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void initialize_Global_Objects_and_Navigate() {
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Navigate_To_URL_for_Navigation();
        Login_Obj.Z2D_SignIn();
    }

    @Test(description = "TS001 || Check that parts tab have data appear and count of uploaded IPN (IPN View)", priority = 1)
    public void IPN_View() throws InterruptedException {

        Landing_Page Landing_Obj = new Landing_Page(driver);
        Data_Management_Page Data_Management_Obj = new Data_Management_Page(driver);
        Risk_Management_Module Risk_Management_Obj = new Risk_Management_Module(driver);

        Landing_Obj.Z2D_Open_Data_Management();
        Data_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        Data_Management_Obj.Z2D_Search();
        Data_Management_Obj.SetFile();
        Data_Management_Obj.Z2D_Open_BOM();
        Risk_Management_Obj.Switch_Tabs();
        Risk_Management_Obj.Z2D_Parts_to_be_Clickable();
        Risk_Management_Obj.Z2D_Open_Parts();
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        Risk_Management_Obj.Z2D_Select_Switcher();
        Risk_Management_Obj.Z2D_IPN_Table_Header_Visibility();
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.IPN_Table_Header).getText().contains("IPN"));
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Product_Table_Header).getText().contains("Product"));
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Description_Table_Header).getText().contains("Description"));
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.ofMPNs_Table_Header).getText().contains("# of MPNs"));
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.OfSource_Table_Header).getText().contains("# of Sources"));
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Multi_Sourcing_Table_Header).getText().contains("Multi-Sourcing"));
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Package_Table_Header).getText().contains("Package"));
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.RoHS_Table_Header).getText().contains("RoHS"));
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Lead_Finish_Table_Header).getText().contains("Lead-finish"));
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Dimension_Table_Header).getText().contains("Dimension"));
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Crosses_Table_Header).getText().contains("Crosses"));
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.IPN_Lifecycl_Forecast_Table_Header).getText().contains("IPN Lifecycle Forecast"));
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.IPN_Risk_Table_Header).getText().contains("IPN Risk"));
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Tear_Down();
    }
}