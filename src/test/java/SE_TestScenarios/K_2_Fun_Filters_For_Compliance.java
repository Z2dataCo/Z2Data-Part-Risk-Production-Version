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

public class K_2_Fun_Filters_For_Compliance {
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

    @Test(description = "TS002 || Validate Filter on Compliance Page &  Check table's data", priority = 2)

    public void Filters_For_Compliance()   {
        Data_Management_Page Data_Management_Obj = new Data_Management_Page(driver);
        Risk_Management_Module Risk_Management_Obj = new Risk_Management_Module(driver);

        Data_Management_Obj.Z2D_Move_to_Compliance_BOM();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_2();
        Risk_Management_Obj.Z2D_First_Check_Box_Filter_Clickability();
        Risk_Management_Obj.Z2D_Compliance_Click_on_First_Filter();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_2();
        String FirstTotal = driver.findElement(Risk_Management_Obj.First_Filter_Total).getText();
        Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Total_Filter_Results), FirstTotal);
        String AllTotal = driver.findElement(Risk_Management_Obj.Total_Filter_Results).getText();
        Assert.assertEquals(FirstTotal, AllTotal);

        Risk_Management_Obj.Z2D_Second_Check_Box_Filter_Clickability();
        Risk_Management_Obj.Z2D_Compliance_Click_on_Second_Filter();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_2();
        String SecTotal = driver.findElement(Risk_Management_Obj.Second_Filter_Total).getText();
        Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Showing_Of), "Showing 1-0 of");
        String AllTotal2 = driver.findElement(Risk_Management_Obj.Total_Filter_Results).getText();
        Assert.assertEquals(AllTotal2, SecTotal);
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        driver.quit();
    }
}