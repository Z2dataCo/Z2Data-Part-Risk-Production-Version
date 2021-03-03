package SE_TestScenarios;


import SE_Page.Data_Management_Page;
import SE_Page.Login_Page;
import SE_Page.Risk_Management_Module;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class K_2_Fun_Filters_For_Compliance {
    private WebDriver driver;
    private ExcelFileManager Variables;
    private Login_Page Login_Obj;
    private Data_Management_Page Data_Management_Obj;
    private Risk_Management_Module Risk_Management_Obj;

    @BeforeClass(alwaysRun = true)
    @Parameters("Environment")
    public void initialize_Global_Objects_and_Navigate(String Environment) {
        if (Environment.equalsIgnoreCase("Production")) {
            Variables = new ExcelFileManager("D:\\IdeaProjects\\Z2Data-Part-Risk-Production-Version\\src\\test\\resources\\PartRiskTestData\\ProdEnv_Parameters.xlsx");
        } else {
            Variables = new ExcelFileManager("D:\\IdeaProjects\\Z2Data-Part-Risk-Production-Version\\src\\test\\resources\\PartRiskTestData\\TestEnv_Parameters.xlsx");
        }
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Obj = new Login_Page(driver);
        Login_Obj.Navigate_To_URL_for_Navigation(Variables.getCellData("URL", "Value"));
        Login_Obj.Z2D_SignIn(Variables.getCellData("UserName", "Value"), Variables.getCellData("Password", "Value"));
    }

    @Parameters("Environment")
    @Test(description = "TS001 || Validate Filter on Compliance Page &  Check table's data", priority = 1)
    public void Filters_For_Compliance(String Environment) {

        Data_Management_Obj.Z2D_Move_to_Compliance_BOM(Environment);
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_2();
        ElementActions.waitForElementToBePresent(driver, Risk_Management_Obj.Total_Filter_Results, 5, true);
        ElementActions.waitForTextToChange(driver, (Risk_Management_Obj.Total_Filter_Results), "0", 15);
        String Total_Filter_Value = driver.findElement(Risk_Management_Obj.Total_Filter_Results).getText();
//Risk_Management_Obj.Z2D_First_Check_Box_Filter_Clickability();
        Risk_Management_Obj.Z2D_Compliance_Click_on_First_Filter();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_2();
        String FirstTotal = driver.findElement(Risk_Management_Obj.First_Filter_Total).getText();
        ElementActions.waitForTextToChange(driver, (Risk_Management_Obj.Total_Filter_Results), Total_Filter_Value, 15);

        //Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Total_Filter_Results), FirstTotal);
        String AllTotal = driver.findElement(Risk_Management_Obj.Total_Filter_Results).getText();
        Assert.assertEquals(FirstTotal, AllTotal);

        //Risk_Management_Obj.Z2D_Second_Check_Box_Filter_Clickability();
        Risk_Management_Obj.Z2D_Compliance_Click_on_Second_Filter();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_2();
        String SecTotal = driver.findElement(Risk_Management_Obj.Second_Filter_Total).getText();
        ElementActions.waitForTextToChange(driver, (Risk_Management_Obj.Total_Filter_Results), AllTotal, 15);
        // Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Showing_Of), "Showing 1-0 of");
        String AllTotal2 = driver.findElement(Risk_Management_Obj.Total_Filter_Results).getText();
        Assert.assertEquals(AllTotal2, SecTotal);
    }

    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Obj.Tear_Down();
    }

    @BeforeMethod
    public void BeforeMethod() {
        Login_Obj = new Login_Page(driver);
        Data_Management_Obj = new Data_Management_Page(driver);
        Risk_Management_Obj = new Risk_Management_Module(driver);
    }
}