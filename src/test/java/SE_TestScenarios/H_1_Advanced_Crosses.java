package SE_TestScenarios;

import SE_Page.Advanced_Crosses_Page;
import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import com.shaft.gui.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class H_1_Advanced_Crosses  {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void initialize_Global_Objects_and_Navigate() {
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.navigateToURLForNavigationL();
    }

    @Test(description = "TS001 || Login to Z2Data Part Risk", priority = 1)
    public void Login() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Z2D_SignIn();
    }

    @Test(description = "TS002 || Validate To Search By Advanced Crosses\"", priority = 2)
    public void Advanced_Crosses() {
        Landing_Page Landing_Obj = new Landing_Page(driver);
        Advanced_Crosses_Page Advanced_Crosses_Obj = new Advanced_Crosses_Page(driver);

        Landing_Obj.Z2D_Open_DDL_Menu();
        Landing_Obj.Z2D_is_Clickable_of_Adv_Crosses_Value();
        Landing_Obj.Z2D_Adv_Crosses();
        Landing_Obj.Z2D_input_Search();
        Landing_Obj.Z2D_Adv_Product();
        Assert.assertTrue(driver.findElement(Advanced_Crosses_Obj.Total).getText().contains("Total"));
        Assert.assertTrue(driver.findElement(Advanced_Crosses_Obj.Different_Input).getText().contains("Different Input"));
        Assert.assertTrue(driver.findElement(Advanced_Crosses_Obj.Drop_in).getText().contains("Drop-In"));
        Assert.assertTrue(driver.findElement(Advanced_Crosses_Obj.Drop_in_Same_Supplier).getText().contains("Drop-In Same Supplier"));
        Assert.assertTrue(driver.findElement(Advanced_Crosses_Obj.Similar_Different_Package).getText().contains("Similar / Different Package"));
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        driver.quit();
    }
}