package SE_TestScenarios;

import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import SE_Page.PCN_Manager_Page;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AB_1_PCN_Search {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void initialize_Global_Objects_and_Navigate() {
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Navigate_To_URL_for_Navigation();
        Login_Obj.Z2D_SignIn();
    }

    @Test(description = "TS001 || Check MPN Search Functionality using PCN Id & MPN", priority = 1)
    public void PCN_Search() throws InterruptedException {

        Landing_Page Landing_Obj = new Landing_Page(driver);
        PCN_Manager_Page PCN_Manager_Obj = new PCN_Manager_Page(driver);

        Landing_Obj.Z2D_Open_PCN_Manager();
        PCN_Manager_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        PCN_Manager_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        ElementActions.isElementDisplayed(driver, PCN_Manager_Obj.Dashboard_Tab_Total_PCNs);
        PCN_Manager_Obj.Z2D_Open_PCNs_Tab();
        PCN_Manager_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        PCN_Manager_Obj.Z2D_Search_PCN_ID();
        PCN_Manager_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        ElementActions.isElementDisplayed(driver, PCN_Manager_Obj.Results_Table);
        ElementActions.waitForTextToChange(driver,PCN_Manager_Obj.Showing_Of_Total,PCN_Manager_Obj.Total_Results,5);
        String Search_Result = driver.findElement(PCN_Manager_Obj.First_Search_Result).getText();
        Assert.assertTrue(Search_Result.contains(PCN_Manager_Obj.PCN_ID));

        PCN_Manager_Obj.Z2D_Search_MPN_ID();
        PCN_Manager_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        ElementActions.isElementDisplayed(driver, PCN_Manager_Obj.Results_Table);
        ElementActions.waitForTextToChange(driver,PCN_Manager_Obj.Showing_Of_Total,PCN_Manager_Obj.Total_Results,5);
        PCN_Manager_Obj.Z2D_Open_First_Search_Result();
        PCN_Manager_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        ElementActions.waitForElementToBePresent(driver,PCN_Manager_Obj.FSP_Text,5,true);
        ElementActions.waitForTextToChange(driver,PCN_Manager_Obj.FSP_Text,"",5);
        String Impacted_MPN_Data = driver.findElement(PCN_Manager_Obj.Impacted_MPN_Results).getText();
        Assert.assertTrue(Impacted_MPN_Data.contains(PCN_Manager_Obj.MPN_ID));
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Tear_Down();
    }

}
