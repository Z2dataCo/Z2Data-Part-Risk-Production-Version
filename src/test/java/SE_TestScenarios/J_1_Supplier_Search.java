package SE_TestScenarios;


import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import SE_Page.Suppliers_Page;
import com.shaft.gui.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class J_1_Supplier_Search {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void initialize_Global_Objects_and_Navigate() {
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Navigate_To_URL_for_Navigation();
    }

    @Test(description = "TS001 || Login to Z2Data Part Risk", priority = 1)
    public void Login() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Z2D_SignIn();
    }

    @Test(description = "TS002 || Validate To Search For Supplier", priority = 2)
    public void Search_for_Supplier() throws InterruptedException {
        Landing_Page Landing_Obj = new Landing_Page(driver);
        Suppliers_Page Suppliers_Obj = new Suppliers_Page(driver);

        Landing_Obj.Z2D_More_Menu();
        Landing_Obj.Z2D_Select_Supplier();
        boolean Stale_Element = true;
        while (Stale_Element) {
            try {
                Suppliers_Obj.Z2D_Enter_Supplier();
                Stale_Element = false;
            } catch (Exception e) {
                Stale_Element = true;
            }
        }
        Suppliers_Obj.Z2D_Click_Search();
        Suppliers_Obj.Z2D_Spinner_to_Disappear();
        Assert.assertTrue(driver.findElement(Suppliers_Obj.SuppName).getText().contains("Toshiba"));

    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Tear_Down();
    }
}