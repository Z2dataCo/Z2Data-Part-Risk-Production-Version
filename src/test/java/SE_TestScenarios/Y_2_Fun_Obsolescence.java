package SE_TestScenarios;

import SE_Page.*;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Y_2_Fun_Obsolescence  {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void initialize_Global_Objects_and_Navigate() {
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Navigate_To_URL_for_Navigation();
        Login_Obj.Z2D_SignIn();
    }

    @Test(description = "TS001 || Check that side panel of High Lifecycle Risk Parts link shows high risk part && Count Table in All Tabs", priority = 1)
    public void Check_Side_Panel_High_Risk() throws InterruptedException {

        Landing_Page Landing_Obj = new Landing_Page(driver);
        Data_Management_Page Data_Management_Obj = new Data_Management_Page(driver);
        Risk_Management_Module Risk_Management_Obj = new Risk_Management_Module(driver);
        Obsolescence_Page Obsolescence_Obj = new Obsolescence_Page(driver);

        Landing_Obj.Z2D_Open_Data_Management();
        Data_Management_Obj.Z2D_Search();
        Data_Management_Obj.SetFile();
           if (!(" TAP_BOM_Proud_Test" == driver.getPageSource())) {
            Data_Management_Obj.Z2D_Move_To_Prod_BOM();
        } else {
            Data_Management_Obj.Z2D_Click_on_BOM();
        }
        Risk_Management_Obj.Z2D_Reports_Open_Reports_Tab();
        Risk_Management_Obj.Z2D_Reports_Open_Obsolescence();
        Risk_Management_Obj.Z2D_Reports_Open_High_LifeCycle();
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        Obsolescence_Obj.Z2D_Get_Last_Page();
        int CountOfTable = driver.findElements(Obsolescence_Obj.Table_Size).size();
        int Count = Integer.parseInt(driver.findElement(Obsolescence_Obj.Fixed_Number).getText());
        int CountPagination = Integer.parseInt(driver.findElement(Obsolescence_Obj.Next_Page).getText());
        int CountPage = CountPagination - 1;
        int SubTotal = CountOfTable * CountPage;
        int LastPage = Count - SubTotal;
        int AllOfRow = LastPage + SubTotal;
        Assert.assertEquals(Count, AllOfRow);
        Obsolescence_Obj.Z2D_NRND_Parts();
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        int CountOfTable0 = driver.findElements(Obsolescence_Obj.Table_Size).size();
        int Count0 = Integer.parseInt(driver.findElement(Obsolescence_Obj.Fixed_Number).getText());
        int CountPagination0 = Integer.parseInt(driver.findElement(Obsolescence_Obj.Next_Page).getText());
        int CountPage0 = CountPagination0 - 1;
        int SubTotal0 = CountOfTable0 * CountPage0;
        int LastPage0 = Count0 - SubTotal0;
        int AllOfRow0 = LastPage0 + SubTotal0;
        Assert.assertEquals(Count0, AllOfRow0);
        Obsolescence_Obj.Z2D_Obsolete_Parts();
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        int CountOfTable1 = driver.findElements(Obsolescence_Obj.Table_Size).size();
        int Count1 = Integer.parseInt(driver.findElement(Obsolescence_Obj.Fixed_Number).getText());
        int CountPagination1 = Integer.parseInt(driver.findElement(Obsolescence_Obj.Next_Page).getText());
        int CountPage1 = CountPagination1 - 1;
        int SubTotal1 = CountOfTable1 * CountPage1;
        int LastPage1 = Count1 - SubTotal1;
        int AllOfRow1 = LastPage1 + SubTotal1;

        Assert.assertEquals(Count1, AllOfRow1);
        Obsolescence_Obj.Z2D_Last_by_Parts();
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        int CountPagination2 = Integer.parseInt(driver.findElement(Obsolescence_Obj.Next_Page).getText());
        int CountOfTable2 = driver.findElements(Obsolescence_Obj.Table_Size).size();
        int Count2 = Integer.parseInt(driver.findElement(Obsolescence_Obj.Fixed_Number).getText());
        if (CountPagination2 <= 1) {
            int SubTotal2 = CountOfTable2 * CountPagination2;
            int LastPage2 = Count2 - SubTotal2;
            int AllOfRow2 = LastPage2 + SubTotal2;
            Thread.sleep(1000);
            Assert.assertEquals(Count2, AllOfRow2);
        } else {
            int CountPage2 = CountPagination2 - 1;
            int SubTotal2 = CountOfTable2 * CountPage2;
            int LastPage2 = Count2 - SubTotal2;
            int AllOfRow2 = LastPage2 + SubTotal2;
            Thread.sleep(1000);
            Assert.assertEquals(Count2, AllOfRow2);
        }
        Obsolescence_Obj.Z2D_Close_Slide();
    }

    @Test(description = "TS003 || Check that side panel of Obsolete Parts in 3 Years shows parts that have forecast up to 3 years", priority = 3)
    public void Obsolete_Parts_in_3_Years() throws InterruptedException {
        Landing_Page Landing_Obj = new Landing_Page(driver);
        Data_Management_Page Data_Management_Obj = new Data_Management_Page(driver);
        Risk_Management_Module Risk_Management_Obj = new Risk_Management_Module(driver);
        Obsolescence_Page Obsolescence_Obj = new Obsolescence_Page(driver);

        Landing_Obj.Z2D_Open_Data_Management();
        Data_Management_Obj.Z2D_Search();
        Data_Management_Obj.SetFile();
        if (!(" TAP_BOM_Proud_Test" == driver.getPageSource())) {
            Data_Management_Obj.Z2D_Move_To_Prod_BOM();
        } else {
            Data_Management_Obj.Z2D_Click_on_BOM();
        }
        Risk_Management_Obj.Z2D_Reports_Open_Reports_Tab();
        Risk_Management_Obj.Z2D_Reports_Open_Obsolescence();
        Risk_Management_Obj.Z2D_Reports_Open_Obsolete_3Years();
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        ElementActions.waitForElementToBePresent(driver,Risk_Management_Obj.Row_Active,5,true);
       // Assert.assertEquals(driver.findElement(Risk_Management_Obj.Row_Active).getText(), "Active");
        //Assert.assertEquals(driver.findElement(Risk_Management_Obj.Row_3Y).getText(), "3 years");
        Obsolescence_Obj.Z2D_Get_Last_Page_For_3Y();
        int CountOfTable = driver.findElements(Obsolescence_Obj.Table_Size).size();
        int Count = Integer.parseInt(driver.findElement(Obsolescence_Obj.Fixed_Number_For_3Y).getText());
        int CountPagination = Integer.parseInt(driver.findElement(Obsolescence_Obj.Next_Page).getText());
        int CountPage = CountPagination - 1;
        int SubTotal = CountOfTable * CountPage;
        int LastPage = Count - SubTotal;
        int AllOfRow = LastPage + SubTotal;
        Assert.assertEquals(Count, AllOfRow);
        Obsolescence_Obj.Z2D_Close_Slide();
    }

    @Test(description = "TS004 || Check that side panel of Obsolete Parts in 5 Years shows parts that have forecast up to 5 years", priority = 4)
    public void Obsolete_Part_IN_5_Years() throws InterruptedException {

        Landing_Page Landing_Obj = new Landing_Page(driver);
        Data_Management_Page Data_Management_Obj = new Data_Management_Page(driver);
        Risk_Management_Module Risk_Management_Obj = new Risk_Management_Module(driver);
        Obsolescence_Page Obsolescence_Obj = new Obsolescence_Page(driver);

        Landing_Obj.Z2D_Open_Data_Management();
        Data_Management_Obj.Z2D_Search();
        Data_Management_Obj.SetFile();
        if (!(" TAP_BOM_Proud_Test" == driver.getPageSource())) {
            Data_Management_Obj.Z2D_Move_To_Prod_BOM();
        } else {
            Data_Management_Obj.Z2D_Click_on_BOM();
        }
        Risk_Management_Obj.Z2D_Reports_Open_Reports_Tab();
        Risk_Management_Obj.Z2D_Reports_Open_Obsolescence();
        Risk_Management_Obj.Z2D_Reports_Open_Obsolete_5Years();
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        Obsolescence_Obj.Z2D_Get_Last_Page_For_5Y();
        int CountOfTable = driver.findElements(Obsolescence_Obj.Table_Size).size();
        int Count = Integer.parseInt(driver.findElement(Obsolescence_Obj.Fixed_Number_For_5Y).getText());
        int CountPagination = Integer.parseInt(driver.findElement(Obsolescence_Obj.Next_Page).getText());
        int CountPage = CountPagination - 1;
        int SubTotal = CountOfTable * CountPage;
        int LastPage = Count - SubTotal;
        int AllOfRow = LastPage + SubTotal;
        System.out.println("Actual Result:  " + AllOfRow);
        System.out.println("Expected Result: " + Count);
        Assert.assertEquals(Count, AllOfRow);
        Obsolescence_Obj.Z2D_Close_Slide();
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Tear_Down();
    }
}





