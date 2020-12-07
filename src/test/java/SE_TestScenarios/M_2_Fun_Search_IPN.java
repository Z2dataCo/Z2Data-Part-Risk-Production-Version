package SE_TestScenarios;


import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import com.shaft.gui.browser.BrowserFactory;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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
        Login_Obj.navigateToURLForNavigationL();
    }

    @Test(description = "TS001 || Login to Z2Data Part Risk", priority = 1)
    public void Login() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Z2D_SignIn();
    }

    @Test(description = "TS002 || Validate To Search By IPN", priority = 2)
    public void Search_by_IPN() {
        Landing_Page Landing_Obj = new Landing_Page(driver);

        Landing_Obj.Z2D_Open_DDL_Menu();
        Landing_Obj.Z2D_IPN_DDL();
        Landing_Obj.Z2D_IPN_Input_Search();
        Landing_Obj.Z2D_IPN_Value_Visibility();
        Landing_Obj.Z2D_IPN_Value();
        Assert.assertTrue(driver.getCurrentUrl().contains("IPN"));
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        driver.quit();
    }
}