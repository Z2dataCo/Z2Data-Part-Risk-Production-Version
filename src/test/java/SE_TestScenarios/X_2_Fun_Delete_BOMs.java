package SE_TestScenarios;


import SE_Page.Data_Management_Page;
import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import Utilities_Test.Constants_Test;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class X_2_Fun_Delete_BOMs {

    private WebDriver driver;
    private ExcelFileManager Variables;
    private Landing_Page Landing_Obj;
    private Data_Management_Page Data_Management_Obj;
    private Login_Page Login_Obj;

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

    @Test(description = "TS001 || Deleting Created BOMs", priority = 1)
    public void Delete_BOMs() throws InterruptedException {

        Landing_Obj.Z2D_Open_Data_Management();
        Data_Management_Obj.Z2D_Search_Text_Input_to_be_Clickable();
        Data_Management_Obj.Z2D_Type_Folder_Name();
        Data_Management_Obj.Z2D_Select_Folder();
        Data_Management_Obj.Z2D_Click_on_Check_Box();
        Data_Management_Obj.Z2D_Table_Body_to_be_Visibility();
        Data_Management_Obj.Z2D_Deleting_BOMs();
    }

    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Obj.Tear_Down();
    }

    @BeforeMethod
    public void BeforeMethod() {
        Login_Obj = new Login_Page(driver);
        Landing_Obj = new Landing_Page(driver);
        Data_Management_Obj = new Data_Management_Page(driver);
    }
}

