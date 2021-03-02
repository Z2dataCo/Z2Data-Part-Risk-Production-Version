package SE_TestScenarios;


import SE_Page.Data_Management_Page;
import SE_Page.Login_Page;
import SE_Page.Risk_Management_Module;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AF_2_Fun_Check_Supplier_Report {
    private WebDriver driver;
    private ExcelFileManager Variables;
    private Login_Page Login_Obj;
    private Risk_Management_Module Risk_Management_Obj;
    private Data_Management_Page Data_Management_Obj;

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
    @Test(description = "TS001 || Check Conflict Minerals Reports : Suppliers Reports", priority = 1)
    public void Check_Supplier_Report(String Environment) {

        Data_Management_Obj.Z2D_Move_to_Reports_BOM(Environment);
        Risk_Management_Obj.Z2D_Reports_Open_Supplier_Report();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Z2D_Reports_Report_Window_Title_Visibility();
        Assert.assertTrue(driver.findElement(Risk_Management_Obj.Report_Window_Title).getText().contains("Conflict Mineral Compliance by Supplier"));

        String First_Filter = driver.findElement(Risk_Management_Obj.Reports_First_Filter).getText();
        Risk_Management_Obj.Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Info_Total), First_Filter.replace(" Suppliers", ""));
        Assert.assertTrue(First_Filter.contains(driver.findElement(Risk_Management_Obj.Info_Total).getText()));

        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Z2D_Reports_Second_Filter_to_be_Clickable();
        Risk_Management_Obj.Z2D_Reports_Click_on_2nd_Filter();
        String Sec_Filter = driver.findElement(Risk_Management_Obj.Reports_Second_Filter).getText();
        Risk_Management_Obj.Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Info_Total), Sec_Filter.replace(" Suppliers", ""));
        Assert.assertTrue(Sec_Filter.contains(driver.findElement(Risk_Management_Obj.Info_Total).getText()));

        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Z2D_Reports_Third_Filter_to_be_Clickable();
        Risk_Management_Obj.Z2D_Reports_Click_on_3rd_Filter();
        String Third_Filter = driver.findElement(Risk_Management_Obj.Reports_Third_Filter).getText();
        Risk_Management_Obj.Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Info_Total), Third_Filter.replace(" Suppliers", ""));
        Assert.assertTrue(Third_Filter.contains(driver.findElement(Risk_Management_Obj.Info_Total).getText()));

        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Z2D_Reports_Fourth_Filter_to_be_Clickable();
        Risk_Management_Obj.Z2D_Reports_Click_on_4th_Filter();
        String Fourth_Filter = driver.findElement(Risk_Management_Obj.Reports_Fourth_Filter).getText();
        Risk_Management_Obj.Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Info_Total), Fourth_Filter.replace(" Suppliers", ""));
        Assert.assertTrue(Fourth_Filter.contains(driver.findElement(Risk_Management_Obj.Info_Total).getText()));
    }

    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Obj.Tear_Down();
    }

    @BeforeMethod
    public void BeforeMethod() {
        Login_Obj = new Login_Page(driver);
        Risk_Management_Obj = new Risk_Management_Module(driver);
        Data_Management_Obj = new Data_Management_Page(driver);
    }
}
