package SE_TestScenarios;

import SE_Page.Login_Page;
import SE_Page.Submit_Ticket_Page;
import com.shaft.gui.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AJ_1_Submit_Ticket   {

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
     @Test(description = "TS002 || Submit Ticket", priority = 2)
    public void User_Submit_Ticket() {
         Submit_Ticket_Page Submit_Ticket_Obj = new Submit_Ticket_Page(driver);

        Submit_Ticket_Obj.Z2D_Open_Submit_Ticket();
        Submit_Ticket_Obj.Z2D_Type_Of_Issue();
        Submit_Ticket_Obj.Z2D_Enter_Issue_Data( );
        Submit_Ticket_Obj.Z2D_Close_Ticket();
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Tear_Down();
    }
}
