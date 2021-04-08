package SE_TestScenarios;

import SE_Page.Data_Management_Page;
import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import SE_Page.Risk_Management_Module;
import Utilities_Test.Constants_Test;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AD_1_Check_Dashboard_Data {
    private WebDriver driver;
    private ExcelFileManager Variables;
    private Landing_Page Landing_Obj;
    private Risk_Management_Module Risk_Management_Obj;
    private Login_Page Login_Obj;
    private Data_Management_Page Data_Management_Obj;


    @BeforeClass(alwaysRun = true)
    @Parameters("Environment")
    public void initialize_Global_Objects_and_Navigate(String Environment) {
        if (Environment.equalsIgnoreCase("Production")) {
            Variables = new ExcelFileManager(Constants_Test.Prod_Data_Path);
        } else {
            Variables = new ExcelFileManager(Constants_Test.Test_Data_Path);
        }
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Obj = new Login_Page(driver);
        Login_Obj.Navigate_To_URL_for_Navigation(Variables.getCellData("URL", "Value"));
        Login_Obj.Z2D_SignIn(Variables.getCellData("UserName", "Value"), Variables.getCellData("Password", "Value"));
    }

    @Test(description = "TS001 || Check Dashboard Data", priority = 1)
    public void Dashboard_Data() throws InterruptedException {

        Landing_Obj.Z2D_Open_Data_Management();
        Data_Management_Obj.Z2D_Type_Folder_Name();
        Data_Management_Obj.Z2D_Select_Folder();
        Data_Management_Obj.Z2D_Open_BOM();
        Risk_Management_Obj.Switch_Tabs();
        Risk_Management_Obj.Z2D_Open_Parts();
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        int FixedNum = Integer.parseInt(driver.findElement(Risk_Management_Obj.fixednumber).getText());
        if (driver.findElement(Risk_Management_Obj.Last).isEnabled()) {
            int tableRows = Risk_Management_Obj.Z2D_Rows_Number();
            Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
            Risk_Management_Obj.Z2D_Scrub_Last_Pagination();
            Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
            int PaginationSize = Integer.parseInt(driver.findElement(Risk_Management_Obj.LastPage).getText());
            int Pagination = PaginationSize - 1;
            int SupTotal = Pagination * tableRows;
            int lastPageSize = FixedNum - SupTotal;
            int AllTableRows = lastPageSize + SupTotal;
            Assert.assertEquals(AllTableRows, FixedNum);
            System.out.println("Expected Result: " + AllTableRows);
            System.out.println("Actual Result: " + FixedNum);
        } else {
            int tableRows = Risk_Management_Obj.Z2D_Rows_Number();
            int Pagination = Integer.parseInt(driver.findElement(Risk_Management_Obj.LastPage).getText());
            int SupTotal = Pagination * tableRows;
            int lastPageSize = FixedNum - SupTotal;
            int AllTableRows = lastPageSize + SupTotal;
            Assert.assertEquals(AllTableRows, FixedNum);
            System.out.println("Expected Result Is: " + AllTableRows);
            System.out.println("Actual Result Is: " + FixedNum);
        }
        Risk_Management_Obj.Z2D_Click_Dashboard_Tab();
        Risk_Management_Obj.Z2D_Dashboard__HighRisk();
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        int FixedNum1 = Integer.parseInt(driver.findElement(Risk_Management_Obj.fixednumber).getText());
        if (driver.findElement(Risk_Management_Obj.Last).isEnabled()) {
            int tableRows = Risk_Management_Obj.Z2D_Rows_Number();
            Thread.sleep(3000);
            Risk_Management_Obj.Z2D_Scrub_Last_Pagination();
            Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
            int PaginationSize = Integer.parseInt(driver.findElement(Risk_Management_Obj.LastPage).getText());
            int Pagination = PaginationSize - 1;
            int SupTotal = Pagination * tableRows;
            int lastPageSize = FixedNum1 - SupTotal;
            int AllTableRows = lastPageSize + SupTotal;
            Assert.assertEquals(AllTableRows, FixedNum1);
            System.out.println("High Risk Expected Result: " + AllTableRows);
            System.out.println("High Risk Actual Result: " + FixedNum1);
        } else {
            int tableRows = Risk_Management_Obj.Z2D_Rows_Number();
            int Pagination = Integer.parseInt(driver.findElement(Risk_Management_Obj.LastPage).getText());
            int SupTotal = Pagination * tableRows;
            int lastPageSize = FixedNum1 - SupTotal;
            int AllTableRows = lastPageSize + SupTotal;
            Assert.assertEquals(AllTableRows, FixedNum1);
            System.out.println("High Risk Expected Result Is: " + AllTableRows);
            System.out.println("High Risk Actual Result Is: " + FixedNum1);
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
        Risk_Management_Obj = new Risk_Management_Module(driver);
        Data_Management_Obj = new Data_Management_Page(driver);
    }
}