package SE_TestScenarios;


import SE_Page.*;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class N_2_Fun_Impacted_Parts   {
    private WebDriver driver;
    private ExcelFileManager Variables;
    private Login_Page Login_Obj;
    private Landing_Page Landing_Obj;
    private PCN_Manager_Page PCN_Manager_Obj;


    @BeforeClass(alwaysRun = true)
    @Parameters("Environment")
    public void initialize_Global_Objects_and_Navigate(String Environment) {
        if (Environment.equalsIgnoreCase("Production")) {
            Variables = new ExcelFileManager("D:\\IdeaProjects\\Z2Data-Part-Risk-Production-Version\\src\\test\\resources\\PartRiskTestData\\ProdEnv_Parameters.xlsx"); }
        else{
            Variables = new ExcelFileManager("D:\\IdeaProjects\\Z2Data-Part-Risk-Production-Version\\src\\test\\resources\\PartRiskTestData\\TestEnv_Parameters.xlsx"); }
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Obj.Navigate_To_URL_for_Navigation(Variables.getCellData("URL","Value"));
        Login_Obj.Z2D_SignIn(Variables.getCellData("UserName","Value"), Variables.getCellData("Password","Value"));
    }

    @Test(description = "TS001 || Validate To Check ability to view impacted parts in PCN", priority = 1)
    public void Impacted_Parts() throws InterruptedException {

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
        PCN_Manager_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        PCN_Manager_Obj.Z2D_Select_Supplier();
        Assert.assertEquals(driver.findElement(PCN_Manager_Obj.Search_Btn).getText(), "Search");
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Obj.Tear_Down();
    }

    @BeforeMethod
    public void BeforeMethod() {
        Login_Obj = new Login_Page(driver);
        Landing_Obj = new Landing_Page(driver);
        PCN_Manager_Obj = new PCN_Manager_Page(driver);
    }
}