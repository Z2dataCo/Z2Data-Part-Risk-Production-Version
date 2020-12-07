package SE_TestScenarios;


import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import SE_Page.PCN_Manager_Page;
import com.shaft.gui.browser.BrowserFactory;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class N_2_Fun_Impacted_Parts   {
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


    @Test(description = "TS002 || Validate To Check ability to view impacted parts in PCN", priority = 2)
    public void Impacted_Parts() throws InterruptedException {

        Landing_Page Landing_Obj = new Landing_Page(driver);
        PCN_Manager_Page PCN_Manager_Obj = new PCN_Manager_Page(driver);

        Landing_Obj.Z2D_Open_PCN_Manager();
        boolean Stale_Element = true;
        while (Stale_Element) {
            try {
                PCN_Manager_Obj.Z2D_Open_Impacted_Parts_Tab();
                Stale_Element = false;
            } catch (ElementClickInterceptedException e) {
                Stale_Element = true;
            }
        }
        PCN_Manager_Obj.Z2D_Wait_General_Spinner_Disappear();
        PCN_Manager_Obj.Z2D_Select_Supplier();
        Assert.assertEquals(driver.findElement(PCN_Manager_Obj.Search_Btn).getText(), "Search");
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        driver.quit();
    }
}