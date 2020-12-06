package SE_TestScenarios;


import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import SE_Page.PCN_Manager_Page;
import com.shaft.gui.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class D_1_PCN_Manager   {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void initialize_Global_Objects_and_Navigate() {
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.navigateToURLForNavigationL();
    }

    @Test(description = "TS001 || Login to Z2Data Part Risk",priority = 1)
    public void Login() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Z2D_SignIn();
    }


    @Test(description = "TS002 || Validate Scenario using PCN Manager",priority = 2)

    public void PCN_Manager() throws InterruptedException {
        Landing_Page Landing_Obj = new Landing_Page(driver);
        PCN_Manager_Page PCN_ManagerObj = new PCN_Manager_Page(driver);

        Landing_Obj.Z2D_Open_PCN_Manager();
        Landing_Obj.Z2D_Wait_General_Spinner_Disappear();
        PCN_ManagerObj.Z2D_Dashboard_Tab_Total_PCNs_Visibility();

        if (driver.findElement(PCN_ManagerObj.Dashboard_Tab_Total_PCNs).isDisplayed()) {
            Assert.assertTrue((driver.findElement(PCN_ManagerObj.Dashboard_Tab_Total_PCNs).isDisplayed()));
            Assert.assertTrue((driver.findElement(PCN_ManagerObj.Dashboard_Tab_Requires_Action).isDisplayed()));
            Assert.assertTrue((driver.findElement(PCN_ManagerObj.Dashboard_Tab_In_Progress).isDisplayed()));
            Assert.assertTrue((driver.findElement(PCN_ManagerObj.Dashboard_Tab_Completed).isDisplayed()));
        } else {
            System.out.println("Assertion Dashboard Cards is Failed");
        }
        //WaitAllElement();
        PCN_ManagerObj.Z2D_Open_Inbox_Tab();
        Landing_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_1();
        if (driver.findElement(PCN_ManagerObj.Inbox_Tab_Filter_Table).isDisplayed()) {
            Assert.assertTrue((driver.findElement(PCN_ManagerObj.Inbox_Tab_Filter_Table).isDisplayed()));
        } else {
            System.out.println("Assertion for Inbox Tab Filter Table is Failed");
        }
        //WaitAllElement();
        PCN_ManagerObj.Z2D_Open_PCNs_Tab();
        Landing_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_1();
        if (driver.findElement(PCN_ManagerObj.PCNs_Tab_Filter_Table).isDisplayed()) {
            Assert.assertTrue((driver.findElement(PCN_ManagerObj.PCNs_Tab_Filter_Table).isDisplayed()));
        } else {
            System.out.println("Assertion for PCNs Tab Filter Table is Failed");
        }
        //WaitAllElement();
        PCN_ManagerObj.Z2D_PCNs_First_PCN_Notification();
        if (driver.findElement(PCN_ManagerObj.PCNs_First_PCN_Notification_PCN_ID).isDisplayed()) {
            Assert.assertEquals(driver.findElement(PCN_ManagerObj.PCNs_First_PCN_Notification_PCN_ID).getText(), "Z2 PCN_ID");
        } else {
            System.out.println("Assertion for PCNs Tab First PCN Notification Z2 PCN_ID is Failed");
        }
        Thread.sleep(3000);
        PCN_ManagerObj.Z2D_Back_from_PCN_Notification();
        PCN_ManagerObj.Z2D_Open_Impacted_Parts_Tab();
        Landing_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_1();
        if (driver.findElement(PCN_ManagerObj.Impacted_Parts_Tab_Filter_Table).isDisplayed()) {
            Assert.assertTrue((driver.findElement(PCN_ManagerObj.Impacted_Parts_Tab_Filter_Table).isDisplayed()));
        } else {
            System.out.println("Assertion for Impacted Parts Tab Filter Table is Failed");
        }
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        driver.quit();
    }
}