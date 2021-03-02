package SE_TestScenarios;

import SE_Page.Login_Page;
import SE_Page.Submit_Ticket_Page;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class AJ_1_Submit_Ticket {
    private WebDriver driver;
    private ExcelFileManager Variables;
    private Submit_Ticket_Page Submit_Ticket_Obj;
    private Login_Page Login_Obj;

    @BeforeClass(alwaysRun = true)
    @Parameters("Environment")
    public void initialize_Global_Objects_and_Navigate(String Environment) {
        if (Environment.equalsIgnoreCase("Production")) {
            Variables = new ExcelFileManager("D:\\IdeaProjects\\Z2Data-Part-Risk-Production-Version\\src\\test\\resources\\PartRiskTestData\\ProdEnv_Parameters.xlsx");
        } else {
            Variables = new ExcelFileManager("D:\\IdeaProjects\\Z2Data-Part-Risk-Production-Version\\src\\test\\resources\\PartRiskTestData\\TestEnv_Parameters.xlsx");
        }
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Obj = new Login_Page(driver);
        Login_Obj.Navigate_To_URL_for_Navigation(Variables.getCellData("URL", "Value"));
        Login_Obj.Z2D_SignIn(Variables.getCellData("UserName", "Value"), Variables.getCellData("Password", "Value"));
    }

    @Test(description = "TS001 || Submit Ticket", priority = 1)
    public void User_Submit_Ticket() {

        Submit_Ticket_Obj.Z2D_Open_Submit_Ticket();
        Submit_Ticket_Obj.Z2D_Type_Of_Issue();
        Submit_Ticket_Obj.Z2D_Enter_Issue_Data();
        Submit_Ticket_Obj.Z2D_Close_Ticket();
    }

    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Obj.Tear_Down();
    }

    @BeforeMethod
    public void BeforeMethod() {
        Login_Obj = new Login_Page(driver);
        Submit_Ticket_Obj = new Submit_Ticket_Page(driver);
    }
}
