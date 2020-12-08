package SE_TestScenarios;

import SE_Page.Data_Management_Page;
import SE_Page.Login_Page;
import SE_Page.Obsolescence_Page;
import SE_Page.Risk_Management_Module;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Z_2_Fun_All_Obsolescence{

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

    @Test(description = "Check that side panel of All Obsolescence PCNs shows all PCNs on the BOM" , priority = 28)
    public void All_ObsolescencePage() throws InterruptedException {

        Data_Management_Page Data_Management_Obj = new Data_Management_Page(driver);
        Risk_Management_Module Risk_Management_Obj = new Risk_Management_Module(driver);
        Obsolescence_Page Obsolescence_Obj = new Obsolescence_Page(driver);

        Data_Management_Obj.Z2D_Open_Data_Management();
        ElementActions.waitForElementToBePresent(driver,Data_Management_Obj.Search_Text_Input,5,true);
        Data_Management_Obj.Z2D_Search();
        Data_Management_Obj.SetFile();
        if (!(" TAP_BOM_Proud_Test" == driver.getPageSource())) {
            Data_Management_Obj.Z2D_Move_To_Prod_BOM();
        } else {
            Data_Management_Obj.Z2D_Click_on_BOM();
        }
        Risk_Management_Obj.Z2D_Dashboard_Open_Reports();
        Obsolescence_Obj.Z2D_Product_Change();
        Obsolescence_Obj.Z2D_All_Obsolescence();
        Thread.sleep(3000);
        Obsolescence_Obj.Z2D_Get_Last_Page_for_All_Obs();
        int CountOfTable = Obsolescence_Obj.Table_Size.size();
        int Count = Integer.parseInt(driver.findElement(Obsolescence_Obj.Fixed_Number_for_All_Obs).getText());
        int CountPagination = Integer.parseInt(driver.findElement(Obsolescence_Obj.Next_Page).getText());
        int CountPage = CountPagination - 1;
        int SubTotal = CountOfTable * CountPage;
        int LastPage = Count - SubTotal;
        int AllOfRow = LastPage + SubTotal;
        Assert.assertEquals(Count, AllOfRow);
        Thread.sleep(3000);
        Obsolescence_Obj.Z2D_Table_of_Data(driver);
        Obsolescence_Obj.Z2D_Close_Slide();
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Tear_Down();
    }
}
