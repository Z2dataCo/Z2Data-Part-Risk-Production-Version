package SE_TestScenarios;


import SE_Page.Data_Management_Page;
import SE_Page.Login_Page;
import SE_Page.Risk_Management_Module;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class G_1_Create_Alert_LifeCycle_Litigation {

    private WebDriver driver;
    private ExcelFileManager Variables;

    @BeforeClass(alwaysRun = true)
    @Parameters("Environment")
    public void initialize_Global_Objects_and_Navigate(String Environment) {
        if (Environment.equalsIgnoreCase("Production")) {
            Variables = new ExcelFileManager("D:\\IdeaProjects\\Z2Data-Part-Risk-Production-Version\\src\\test\\resources\\PartRiskTestData\\ProdEnv_Parameters.xlsx"); }
        else{
            Variables = new ExcelFileManager("D:\\IdeaProjects\\Z2Data-Part-Risk-Production-Version\\src\\test\\resources\\PartRiskTestData\\TestEnv_Parameters.xlsx"); }
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Navigate_To_URL_for_Navigation(Variables.getCellData("URL","Value"));
        Login_Obj.Z2D_SignIn(Variables.getCellData("UserName","Value"), Variables.getCellData("Password","Value"));
    }

    @Test(description = "TS001 || Validate creating alert by selecting LifeCycle & Litigation", priority = 1)
    public void Create_Alert_LifeCycle_Litigation() throws InterruptedException {
        Data_Management_Page DManagement_Obj = new Data_Management_Page(driver);
        Risk_Management_Module Risk_Management_Obj = new Risk_Management_Module(driver);

        DManagement_Obj.Z2D_Move_To_Prod_BOM();
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
        Risk_Management_Obj.Z2D_Click_on_Litigation();
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
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Tear_Down();
    }
}