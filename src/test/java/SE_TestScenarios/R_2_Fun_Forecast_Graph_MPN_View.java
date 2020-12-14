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


public class R_2_Fun_Forecast_Graph_MPN_View {
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

    @Test(description = "TS002 || Validate affecting Forecast Graph by filtering the Status & Check table's data", priority = 2)
    public void Forecast_Graph_MPN_View() {

        Data_Management_Page Data_Management_Obj = new Data_Management_Page(driver);
        Risk_Management_Module Risk_Management_Obj = new Risk_Management_Module(driver);

        Data_Management_Obj.Z2D_Move_To_Prod_BOM();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        //Risk_Management_Obj.Z2D_Forecast_Ele_Graph2_to_be_Clickable();
        Risk_Management_Obj.Z2D_Click_Forecast_Tab();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();

        String ActiveFilterValue = driver.findElement(Risk_Management_Obj.Forecast_Ele_First_Filter).getText();
        Risk_Management_Obj.Z2D_Forecast_Click_on_First_Filter();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Z2D_Forecast_Ele_First_Row_Text_Visibility();
        Risk_Management_Obj.Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Forecast_Ele_First_Row_Text), "Active");
        Risk_Management_Obj.Z2D_Forecast_Get_Table_Data(driver, "Active");
        String TotalFilterValue = driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value).getText();
        Risk_Management_Obj.Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value), ActiveFilterValue);
        Assert.assertEquals(TotalFilterValue, ActiveFilterValue);

        String EOLFilterValue = driver.findElement(Risk_Management_Obj.Forecast_Ele_Second_Filter).getText();
        Risk_Management_Obj.Z2D_Forecast_Click_on_Second_Filter();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Z2D_Forecast_Ele_First_Row_Text_Visibility();
        Risk_Management_Obj.Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Forecast_Ele_First_Row_Text), "EOL");
        Risk_Management_Obj.Z2D_Forecast_Get_Table_Data(driver, "EOL");
        String TotalFilterValue2 = driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value).getText();
        Risk_Management_Obj.Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value), EOLFilterValue);
        Assert.assertEquals(TotalFilterValue2, EOLFilterValue);

        String UnknownFilterValue = driver.findElement(Risk_Management_Obj.Forecast_Ele_Third_Filter).getText();
        Risk_Management_Obj.Z2D_Forecast_Click_on_Third_Filter();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Z2D_Forecast_Ele_First_Row_Text_Visibility();
        Risk_Management_Obj.Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Forecast_Ele_First_Row_Text), "Unknown");
        Risk_Management_Obj.Z2D_Forecast_Get_Table_Data(driver, "Unknown");
        String TotalFilterValue3 = driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value).getText();
        Risk_Management_Obj.Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value), UnknownFilterValue);
        Assert.assertEquals(TotalFilterValue3, UnknownFilterValue);
    }

    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Tear_Down();
    }
}
