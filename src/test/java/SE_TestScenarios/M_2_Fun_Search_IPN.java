package SE_TestScenarios;


import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import com.shaft.gui.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class M_2_Fun_Search_IPN {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void initialize_Global_Objects_and_Navigate() {
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Navigate_To_URL_for_Navigation();
        Login_Obj.Z2D_SignIn();
    }

    @Test(description = "TS001 || Validate To Search By IPN", priority = 1)
    public void Search_by_IPN() {
        Landing_Page Landing_Obj = new Landing_Page(driver);

        Landing_Obj.Z2D_Open_Landing_Search_Menu();
        Landing_Obj.Z2D_IPN_DDL();
        Landing_Obj.Z2D_IPN_Input_Search();
        Landing_Obj.Z2D_IPN_Value_Visibility();
        Landing_Obj.Z2D_IPN_Value();
        Assert.assertTrue(driver.getCurrentUrl().contains("IPN"));
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Tear_Down();
    }
}