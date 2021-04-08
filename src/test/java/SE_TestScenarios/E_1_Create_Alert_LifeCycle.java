package SE_TestScenarios;


import SE_Page.Data_Management_Page;
import SE_Page.Login_Page;
import SE_Page.Risk_Management_Module;
import Utilities_Test.Constants_Test;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class E_1_Create_Alert_LifeCycle {
    private WebDriver driver;
    private ExcelFileManager Variables;
    private Risk_Management_Module Risk_Management_Obj;
    private Login_Page Login_Obj;
    private Data_Management_Page Data_Management_Obj;


    @BeforeClass(alwaysRun = true)
    @Parameters("Environment")
    public void initialize_Global_Objects_and_Navigate(String Environment) {
        if (Environment.equalsIgnoreCase("Production")) {
            Variables = new ExcelFileManager(Constants_Test.Prod_Data_Path);
        } else {
            Variables = new ExcelFileManager(Constants_Test.Test_Data_Path);
        }
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Obj = new Login_Page(driver);
        Login_Obj.Navigate_To_URL_for_Navigation(Variables.getCellData("URL", "Value"));
        Login_Obj.Z2D_SignIn(Variables.getCellData("UserName", "Value"), Variables.getCellData("Password", "Value"));
    }

    @Parameters("Environment")
    @Test(description = "TS001 || Validate creating alert by selecting LifeCycle only", priority = 1)
    public void Create_Alert_LifeCycle(String Environment) throws InterruptedException {

        Data_Management_Obj.Z2D_Move_To_Prod_BOM(Environment);
        Risk_Management_Obj.Z2D_Followed_Text_to_be_Clickable();
        if (driver.findElement(Risk_Management_Obj.Followed_Text).getText().equals("Followed")) {
            Risk_Management_Obj.Z2D_Click_Followed_Btn();
            Risk_Management_Obj.Z2D_Unfollow_Btn_to_be_Clickable();
            Risk_Management_Obj.Z2D_Click_Unfollow_Btn();
            Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Toast_Container();
            Risk_Management_Obj.Z2D_Click_on_Create_Alert();
        } else {
            Risk_Management_Obj.Z2D_Click_on_Create_Alert();

        }
        Risk_Management_Obj.Z2D_LifeCycle_Btn_to_be_Clickable();
        Risk_Management_Obj.Z2D_Click_on_LifeCycle();
        Risk_Management_Obj.Z2D_Click_on_Submit_Btn();
        Risk_Management_Obj.Z2D_Wait_Text_Not_To_be_Create_Alert();
        String Status = driver.findElement(Risk_Management_Obj.Followed_Text).getText();
        Assert.assertEquals(Status, "Followed");
        Risk_Management_Obj.Z2D_Click_Followed_Btn();
        Risk_Management_Obj.Z2D_Unfollow_Btn_to_be_Clickable();
        Risk_Management_Obj.Z2D_Click_Unfollow_Btn();
    }

    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Obj.Tear_Down();
    }

    @BeforeMethod
    public void BeforeMethod() {
        Login_Obj = new Login_Page(driver);
        Data_Management_Obj = new Data_Management_Page(driver);
        Risk_Management_Obj = new Risk_Management_Module(driver);
    }
}