package SE_TestScenarios;


import SE_Page.*;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class D_1_PCN_Manager   {
    private WebDriver driver;
    private ExcelFileManager Variables;
    private Landing_Page Landing_Obj;
    private Login_Page Login_Obj;
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

    @Test(description = "TS001 || Validate Scenario using PCN Manager",priority = 1)

    public void PCN_Manager() throws InterruptedException {
        Landing_Obj.Z2D_Open_PCN_Manager();
        Landing_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        PCN_Manager_Obj.Z2D_Dashboard_Tab_Total_PCNs_Visibility();

        if (driver.findElement(PCN_Manager_Obj.Dashboard_Tab_Total_PCNs).isDisplayed()) {
            Assert.assertTrue((driver.findElement(PCN_Manager_Obj.Dashboard_Tab_Total_PCNs).isDisplayed()));
            Assert.assertTrue((driver.findElement(PCN_Manager_Obj.Dashboard_Tab_Requires_Action).isDisplayed()));
            Assert.assertTrue((driver.findElement(PCN_Manager_Obj.Dashboard_Tab_In_Progress).isDisplayed()));
            Assert.assertTrue((driver.findElement(PCN_Manager_Obj.Dashboard_Tab_Completed).isDisplayed()));
        } else {
            System.out.println("Assertion Dashboard Cards is Failed");
        }
        PCN_Manager_Obj.Z2D_Open_Inbox_Tab();
        Landing_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        if (driver.findElement(PCN_Manager_Obj.Inbox_Tab_Filter_Table).isDisplayed()) {
            Assert.assertTrue((driver.findElement(PCN_Manager_Obj.Inbox_Tab_Filter_Table).isDisplayed()));
        } else {
            System.out.println("Assertion for Inbox Tab Filter Table is Failed");
        }
        PCN_Manager_Obj.Z2D_Open_PCNs_Tab();
        Landing_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        if (driver.findElement(PCN_Manager_Obj.PCNs_Tab_Filter_Table).isDisplayed()) {
            Assert.assertTrue((driver.findElement(PCN_Manager_Obj.PCNs_Tab_Filter_Table).isDisplayed()));
        } else {
            System.out.println("Assertion for PCNs Tab Filter Table is Failed");
        }
        PCN_Manager_Obj.Z2D_PCNs_First_PCN_Notification();
        if (driver.findElement(PCN_Manager_Obj.PCNs_First_PCN_Notification_PCN_ID).isDisplayed()) {
            Assert.assertEquals(driver.findElement(PCN_Manager_Obj.PCNs_First_PCN_Notification_PCN_ID).getText(), "Z2 PCN_ID");
        } else {
            System.out.println("Assertion for PCNs Tab First PCN Notification Z2 PCN_ID is Failed");
        }
        PCN_Manager_Obj.Z2D_Back_from_PCN_Notification();
        PCN_Manager_Obj.Z2D_Open_Impacted_Parts_Tab();
        Landing_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        if (driver.findElement(PCN_Manager_Obj.Impacted_Parts_Tab_Filter_Table).isDisplayed()) {
            Assert.assertTrue((driver.findElement(PCN_Manager_Obj.Impacted_Parts_Tab_Filter_Table).isDisplayed()));
        } else {
            System.out.println("Assertion for Impacted Parts Tab Filter Table is Failed");
        }
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