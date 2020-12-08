package SE_TestScenarios;

import SE_Page.Data_Management_Page;
import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import com.shaft.gui.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static SE_Page.Risk_Management_Module.Switch_Tabs;

public class AD_1_Check_Dashboard_Data {

    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void initialize_Global_Objects_and_Navigate() {
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Navigate_To_URL_for_Navigation();
    }

    @Test(description = "TS001 || Login to Z2Data Part Risk", priority = 1)
    public void Login() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Z2D_SignIn();
    }


    @Test(description = "TS002 || Check Dashboard Data", priority = 2)
    public void Dashboard_Data() throws InterruptedException {

        Landing_Page Landing_Obj = new Landing_Page(driver);
        Data_Management_Page Data_Management_Obj = new Data_Management_Page(driver);
        Risk_Management_Module Risk_Management_Obj = new Risk_Management_Module(driver);


        Landing_Obj.Z2D_Open_Data_Management();
        Data_Management_Obj.Z2D_Type_Folder_Name();
        Data_Management_Obj.Z2D_Select_Folder();
        Data_Management_Obj.Z2D_Open_BOM();
        Switch_Tabs();
        Risk_Management_Obj.Z2D_Open_Parts();
        Risk_Management_Obj.Z2D_Spinner_to_Disappear();
        int FixedNum = Integer.parseInt(driver.findElement(Risk_Management_Obj.fixednumber).getText());
        if (driver.findElement(Risk_Management_Obj.Last).isEnabled()) {
            int tableRows = Risk_Management_Obj.Z2D_Rows_Number();
            Risk_Management_Obj.Z2D_Spinner_to_Disappear();
            Risk_Management_Obj.Z2D_Scrub_Last_Pagination();
            Risk_Management_Obj.Z2D_Spinner_to_Disappear();
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
        Risk_Management_Obj.Z2D_Spinner_to_Disappear();
        int FixedNum1 = Integer.parseInt(driver.findElement(Risk_Management_Obj.fixednumber).getText());
        if (driver.findElement(Risk_Management_Obj.Last).isEnabled()) {
            int tableRows = Risk_Management_Obj.Z2D_Rows_Number();
            Thread.sleep(3000);
            Risk_Management_Obj.Z2D_Scrub_Last_Pagination();
            Risk_Management_Obj.Z2D_Spinner_to_Disappear();
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
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Tear_Down();
    }

}