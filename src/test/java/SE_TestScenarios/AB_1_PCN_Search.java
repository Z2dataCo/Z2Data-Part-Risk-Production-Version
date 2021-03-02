package SE_TestScenarios;

import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import SE_Page.PCN_Manager_Page;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AB_1_PCN_Search {
    private WebDriver driver;
    private ExcelFileManager Variables;
    private Landing_Page Landing_Obj;
    private PCN_Manager_Page PCN_Manager_Obj;
    public Login_Page Login_Obj;

    @BeforeClass(alwaysRun = true)
    @Parameters("Environment")
    public void initialize_Global_Objects_and_Navigate(String Environment) {
        if (Environment.equalsIgnoreCase("Production")) {
            Variables = new ExcelFileManager("D:\\IdeaProjects\\Z2Data-Part-Risk-Production-Version\\src\\test\\resources\\PartRiskTestData\\ProdEnv_Parameters.xlsx"); }
        else{
            Variables = new ExcelFileManager("D:\\IdeaProjects\\Z2Data-Part-Risk-Production-Version\\src\\test\\resources\\PartRiskTestData\\TestEnv_Parameters.xlsx"); }
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Obj = new Login_Page(driver);
        Login_Obj.Navigate_To_URL_for_Navigation(Variables.getCellData("URL","Value"));
        Login_Obj.Z2D_SignIn(Variables.getCellData("UserName","Value"), Variables.getCellData("Password","Value"));
    }

    @Parameters("Environment")
    @Test(description = "TS001 || Check MPN Search Functionality using PCN Id & MPN", priority = 1)
    public void PCN_Search(String Environment) throws InterruptedException {


        Landing_Obj.Z2D_Open_PCN_Manager();
        PCN_Manager_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        PCN_Manager_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        ElementActions.isElementDisplayed(driver, PCN_Manager_Obj.Dashboard_Tab_Total_PCNs);
        PCN_Manager_Obj.Z2D_Open_PCNs_Tab();
        PCN_Manager_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        PCN_Manager_Obj.Z2D_Search_PCN_ID(Environment);
        PCN_Manager_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        ElementActions.isElementDisplayed(driver, PCN_Manager_Obj.Results_Table);
        ElementActions.waitForTextToChange(driver,PCN_Manager_Obj.Showing_Of_Total,PCN_Manager_Obj.Total_Results,5);
        String Search_Result = driver.findElement(PCN_Manager_Obj.First_Search_Result).getText();
        Assert.assertTrue(Search_Result.contains(Variables.getCellData("PCN_ID", "Value")));

        PCN_Manager_Obj.Z2D_Search_MPN_ID(Environment);
        PCN_Manager_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        ElementActions.isElementDisplayed(driver, PCN_Manager_Obj.Results_Table);
        ElementActions.waitForTextToChange(driver,PCN_Manager_Obj.Showing_Of_Total,PCN_Manager_Obj.Total_Results,5);
        PCN_Manager_Obj.Z2D_Open_First_Search_Result();
        PCN_Manager_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        ElementActions.waitForElementToBePresent(driver,PCN_Manager_Obj.FSP_Text,5,true);
        ElementActions.waitForTextToChange(driver,PCN_Manager_Obj.FSP_Text,"",5);
        System.out.println(PCN_Manager_Obj.Impacted_MPN_Data() + " this is what is got");
        Assert.assertTrue(PCN_Manager_Obj.Impacted_MPN_Data().contains(Variables.getCellData("MPN_ID", "Value")));
    }
    @AfterClass()
    public void TearDown() {
        Login_Obj.Tear_Down();
    }
    @BeforeMethod
    public void BeforeMethod(){
        Landing_Obj = new Landing_Page(driver);
        PCN_Manager_Obj = new PCN_Manager_Page(driver);
    }

}
