package SE_TestScenarios;


import SE_Page.Data_Management_Page;
import SE_Page.Login_Page;
import SE_Page.Risk_Management_Module;
import Utilities_Test.Constants_Test;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class R_2_Fun_Forecast_Graph_MPN_View {
    private WebDriver driver;
    private ExcelFileManager Variables;
    private Data_Management_Page Data_Management_Obj;
    private Login_Page Login_Obj;
    private Risk_Management_Module Risk_Management_Obj;

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

    @Parameters("Environment")
    @Test(description = "TS001 || Validate affecting Forecast Graph by filtering the Status & Check table's data", priority = 1)
    public void Forecast_Graph_MPN_View(String Environment) throws InterruptedException {

        Data_Management_Obj.Z2D_Move_To_Prod_BOM(Environment);
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        //Risk_Management_Obj.Z2D_Forecast_Ele_Graph2_to_be_Clickable();
        Risk_Management_Obj.Z2D_Click_Forecast_Tab();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();

        String ActiveFilterValue = driver.findElement(Risk_Management_Obj.Forecast_Ele_First_Filter).getText();
        Risk_Management_Obj.Z2D_Forecast_Click_on_First_Filter();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Z2D_Forecast_Ele_First_Row_Text_Visibility();
        Risk_Management_Obj.Scroll_to_Element(driver,driver.findElement(Risk_Management_Obj.Forecast_Ele_First_Row_Text));
        Risk_Management_Obj.Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Forecast_Ele_First_Row_Text), "Active");
        Risk_Management_Obj.Z2D_Forecast_Get_Table_Data(driver, "Active");
        String TotalFilterValue = driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value).getText();
        Risk_Management_Obj.Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value), ActiveFilterValue);
        Assert.assertEquals(TotalFilterValue, ActiveFilterValue);

        String EOLFilterValue = driver.findElement(Risk_Management_Obj.Forecast_Ele_Second_Filter).getText();
        Risk_Management_Obj.Z2D_Forecast_Click_on_Second_Filter();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Z2D_Forecast_Ele_First_Row_Text_Visibility();
        ElementActions.hover(driver,Risk_Management_Obj.Forecast_Ele_First_Filter);
        Risk_Management_Obj.Scroll_to_Element(driver,driver.findElement(Risk_Management_Obj.Forecast_Ele_First_Row_Text));
        Risk_Management_Obj.Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Forecast_Ele_First_Row_Text), "EOL");
        Risk_Management_Obj.Z2D_Forecast_Get_Table_Data(driver, "EOL");
        String TotalFilterValue2 = driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value).getText();
        Risk_Management_Obj.Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value), EOLFilterValue);
        Assert.assertEquals(TotalFilterValue2, EOLFilterValue);

        String UnknownFilterValue = driver.findElement(Risk_Management_Obj.Forecast_Ele_Third_Filter).getText();
        Risk_Management_Obj.Z2D_Forecast_Click_on_Third_Filter();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Z2D_Forecast_Ele_First_Row_Text_Visibility();
        ElementActions.hover(driver,Risk_Management_Obj.Forecast_Ele_First_Filter);
        Risk_Management_Obj.Scroll_to_Element(driver,driver.findElement(Risk_Management_Obj.Forecast_Ele_First_Row_Text));
        Risk_Management_Obj.Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Forecast_Ele_First_Row_Text), "Unknown");
        Risk_Management_Obj.Z2D_Forecast_Get_Table_Data(driver, "Unknown");
        String TotalFilterValue3 = driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value).getText();
        Risk_Management_Obj.Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value), UnknownFilterValue);
        Assert.assertEquals(TotalFilterValue3, UnknownFilterValue);
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
