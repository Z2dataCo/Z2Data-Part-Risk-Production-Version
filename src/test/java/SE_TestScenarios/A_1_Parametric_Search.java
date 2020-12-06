package SE_TestScenarios;


import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import com.shaft.gui.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class A_1_Parametric_Search {

    private WebDriver driver;
    public Login_Page Login_Obj;

    @BeforeClass(alwaysRun = true)
    public void initialize_Global_Objects_and_Navigate() {
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Obj = new Login_Page(driver);
        Login_Obj.navigateToURLForNavigationL();
    }

    @Test(description = "TS001 || Login to Z2Data Part Risk")
    public void Login() {
        Login_Obj = new Login_Page(driver);
        Login_Obj.Z2D_SignIn();
    }

    @Test(description = "TS002 || Validate Parametric Search")
    public void Parametric_Search() {
        Landing_Page Landing_Obj = new Landing_Page(driver);
        Landing_Obj.Search_using_Parametric();
        Assert.assertTrue(driver.getCurrentUrl().contains("/keysearch?ProductId=12292"));
    }

    @AfterClass(alwaysRun = true)
    public void TearDown() {
        driver.quit();
    }

}

