package SE_TestScenarios;


import SE_Page.Data_Management_Page;
import SE_Page.Login_Page;
import SE_Page.Risk_Management_Module;
import com.shaft.gui.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AH_2_Fun_Check_Minerals_Metal_Report  {

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

    @Test(description = "TS002 || Check Conflict Minerals Reports : Minerals Chemical Reports & Exporting As Excel", priority = 2)

    public void Check_Minerals_Report()  {
        Data_Management_Page Data_Management_Obj = new Data_Management_Page(driver);
        Risk_Management_Module Risk_Management_Obj = new Risk_Management_Module(driver);

        Data_Management_Obj.Z2D_Move_to_Reports_BOM();
        Risk_Management_Obj.Z2D_Reports_Open_Minerals_Metal_Report();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_2();
        Risk_Management_Obj.Z2D_Reports_Report_Window_Title_Visibility();
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.Report_Window_Title).getText(), ("Conflict Minerals Metal"));
        Risk_Management_Obj.Z2D_Reports_Export_Button_Visibility();
        Risk_Management_Obj.Z2D_Reports_Export_Report_Excel();
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Tear_Down();
    }
}
