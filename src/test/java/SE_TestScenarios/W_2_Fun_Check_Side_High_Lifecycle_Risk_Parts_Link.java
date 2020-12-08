package SE_TestScenarios;

import SE_Page.*;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class W_2_Fun_Check_Side_High_Lifecycle_Risk_Parts_Link {
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
    @Test(description = "Check that side panel of Obsolete Parts in 3 Years shows parts that have forecast up to 3 years" , priority = 2)
    public void Check_Side_Panel_High_Risk() throws InterruptedException {

        Data_Management_Page Data_Management_Obj = new Data_Management_Page(driver);
        Risk_Management_Module Risk_Management_Obj = new Risk_Management_Module(driver);
        Obsolescence_Page Obsolescence_Obj = new Obsolescence_Page(driver);

        Data_Management_Obj.Z2D_Open_Data_Management();
        ElementActions.waitForElementToBePresent(driver,Data_Management_Obj.Search_Text_Input,5,true);
        //Wait_Element_Visible(DManagementObj.Search_Text_Input);
        Data_Management_Obj.Z2D_Search();
        Data_Management_Obj.SetFile();
        Thread.sleep(1000);
        Data_Management_Obj.Z2D_Open_BOM();
        Thread.sleep(2000);
        if (!(" TAP_BOM_Proud_Test" == driver.getPageSource())) {
            Data_Management_Obj.Z2D_Move_To_Prod_BOM();
        } else {
            Data_Management_Obj.Z2D_Click_on_BOM();
        }
        Risk_Management_Obj.Z2D_Dashboard_Open_Reports();
        Risk_Management_Obj.Z2D_Reports_Open_Obsolescence();
        Risk_Management_Obj.Z2D_Reports_Open_High_LifeCycle();
        if ("High Lifecycle Risk Parts" == driver.getPageSource()) {
            if ((driver.findElement(Obsolescence_Obj.Last).isEnabled()))
                Obsolescence_Obj.Z2D_Open_High_LifeCycle();
        }
        Data_Management_Obj.Z2D_Spinner_to_Disappear();
        Obsolescence_Obj.Z2D_Get_Last_Page();
        int CountOfTable = Obsolescence_Obj.Table_Size.size();
        int Count = Integer.parseInt(driver.findElement(Obsolescence_Obj.Fixed_Number).getText());
        int CountPagination = Integer.parseInt(driver.findElement(Obsolescence_Obj.Next_Page).getText());
        int CountPage = CountPagination - 1;
        int SubTotal = CountOfTable * CountPage;
        int LastPage = Count - SubTotal;
        int AllOfRow = LastPage + SubTotal;
        Assert.assertEquals(Count, AllOfRow);
        Thread.sleep(2000);
        Obsolescence_Obj.Z2D_NRND_Parts();
        Data_Management_Obj.Z2D_Spinner_to_Disappear();
        int CountOfTable0 = Obsolescence_Obj.Table_Size.size();
        int Count0 = Integer.parseInt(driver.findElement(Obsolescence_Obj.Fixed_Number).getText());
        int CountPagination0 = Integer.parseInt(driver.findElement(Obsolescence_Obj.Next_Page).getText());
        int CountPage0 = CountPagination0 - 1;
        int SubTotal0 = CountOfTable0 * CountPage0;
        int LastPage0 = Count0 - SubTotal0;
        int AllOfRow0 = LastPage0 + SubTotal0;
        //System.out.println(AllOfRow0);
        //System.out.println(Count0);
        Assert.assertEquals(Count0, AllOfRow0);
        Risk_Management_Obj.Switch_Tabs();
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Tear_Down();
    }
}




