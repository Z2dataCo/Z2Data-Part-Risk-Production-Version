package SE_TestScenarios;

import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import com.shaft.gui.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class L_2_Fun_Search_Part_Number   {
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
    @Test(description = "TS002 || Validate To Search By Part Number", priority = 2)
    public void Search_with_Part_Number() {
        Landing_Page Landing_Obj = new Landing_Page(driver);

        Landing_Obj.Z2D_Part_Number_Input_Search();
        Landing_Obj.Z2D_Click_Search();
        Landing_Obj.Z2D_Supplier_Check_Box_to_be_Clickable();
        Landing_Obj.Z2D_Check_Supplier();
        Assert.assertEquals(driver.findElement(Landing_Obj.Part_Name).getText(), "bav99");
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Tear_Down();
    }
}
