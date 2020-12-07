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
        Login_Obj.navigateToURLForNavigationL();
    }

    @Test(description = "TS001 || Login to Z2Data Part Risk", priority = 1)
    public void Login() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Z2D_SignIn();
    }

    @Test(description = "TS002 || Check MPN Search Functionality using PCN Id & MPN", priority = 2)
    public void PCN_Search() throws InterruptedException {

        Landing_Page Landing_Obj = new Landing_Page(driver);
        PCN_Manager_Page PCN_Manager_Obj = new PCN_Manager_Page(driver);

        Landing_Obj.Z2D_Open_PCN_Manager();
        PCN_Manager_Obj.Z2D_Wait_General_Spinner_Disappear();
        PCN_Manager_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_1();
        ElementActions.isElementDisplayed(driver, PCN_Manager_Obj.Dashboard_Tab_Total_PCNs);
        PCN_Manager_Obj.Z2D_Open_PCNs_Tab();
        PCN_Manager_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_1();
        PCN_Manager_Obj.Z2D_Search_PCN_ID();
        PCN_Manager_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_1();
        ElementActions.isElementDisplayed(driver, PCN_Manager_Obj.Results_Table);
        Wait_Text_To_be(driver.findElement(PCN_Manager_Obj.Showing_Of_Total), "Showing 1-3 of");
        String Search_Result = driver.findElement(PCN_Manager_Obj.First_Search_Result).getText();
        Assert.assertTrue(Search_Result.contains("PD22748X"));

        PCN_Manager_Obj.Z2D_Search_PCN_ID();
        PCN_Manager_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_1();
        ElementActions.isElementDisplayed(driver, PCN_Manager_Obj.Results_Table);
        Wait_Text_Not_To_be(driver.findElement(PCN_Manager_Obj.Showing_Of_Total), "Showing 1-21 of");
        PCN_Manager_Obj.Z2D_Open_First_Search_Result();
        PCN_Manager_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_1();
        Wait_Text_To_be(driver.findElement(PCN_Manager_Obj.FSP_Text), "FSP Power Solution GmbH");
        PCN_Manager_Obj.Z2D_Move_To_Impacted_MPN();
        String Impacted_MPN_Data = driver.findElement(PCN_Manager_Obj.Impacted_MPN_Results).getText();
        Assert.assertTrue(Impacted_MPN_Data.contains("FSP012-FHEN2"));
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        driver.quit();
    }

}
