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

public class O_2_Fun_Count_Of_Exact_Match {
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


    @Test(description = "TS002 || Validate To Count Exact Match in Scrub Page", priority = 2)
    public void Count_Exact_Match_in_Scrub() {

        Data_Management_Page Data_Management_Obj = new Data_Management_Page(driver);
        Risk_Management_Module Risk_Management_Obj = new Risk_Management_Module(driver);

        Data_Management_Obj.Z2D_Move_to_Scrub_BOM();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_2();
        int FixedNum = Integer.parseInt(driver.findElement(Risk_Management_Obj.FixedNumber).getText());
        if (driver.findElement(Risk_Management_Obj.Last).isEnabled()) {
            int tableRows = Risk_Management_Obj.Z2D_Scrub_Table_Rows();
            Risk_Management_Obj.Z2D_Scrub_Last_Clickability();
            Risk_Management_Obj.Z2D_Scrub_Last_Pagination();
            int PaginationSize = Integer.parseInt(driver.findElement(Risk_Management_Obj.LastPage).getText());
            int Pagination = PaginationSize - 1;
            int SupTotal = Pagination * tableRows;
            int lastPageSize = FixedNum - SupTotal;
            int AllTableRows = lastPageSize + SupTotal;
            Assert.assertEquals(AllTableRows, FixedNum);
            System.out.println(AllTableRows);
            System.out.println(FixedNum);
        } else {
            int tableRows = Risk_Management_Obj.Z2D_Scrub_Table_Rows();
            int Pagination = Integer.parseInt(driver.findElement(Risk_Management_Obj.LastPage).getText());
            int SupTotal = Pagination * tableRows;
            int lastPageSize = FixedNum - SupTotal;
            int AllTableRows = lastPageSize + SupTotal;
            Assert.assertEquals(AllTableRows, FixedNum);
        }
    }

    @AfterClass(alwaysRun = true)
    public void TearDown() {
        driver.quit();
    }
}
