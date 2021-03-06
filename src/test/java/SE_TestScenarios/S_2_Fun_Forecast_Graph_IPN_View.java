package SE_TestScenarios;


import SE_Page.Data_Management_Page;
import SE_Page.Login_Page;
import SE_Page.Obsolescence_Page;
import SE_Page.Risk_Management_Module;
import Utilities_Test.Constants_Test;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class S_2_Fun_Forecast_Graph_IPN_View {
    private WebDriver driver;
    private ExcelFileManager Variables;
    private Data_Management_Page Data_Management_Obj;
    private Login_Page Login_Obj;
    private Risk_Management_Module Risk_Management_Obj;
    private Obsolescence_Page Obsolescence_Obj;

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
    @Test(description = "TS001 || Validate Forecast tab Table IPN View Check table's data", priority = 1)
    public void ForeCast_Graph_IPN_View(String Environment) throws InterruptedException {

        Data_Management_Obj.Z2D_Move_to_Forecast_BOM(Environment);
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Z2D_Switchers_Pipeline_to_be_Clickable();
        Risk_Management_Obj.Z2D_Select_Switcher();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        ElementActions.waitForElementToBePresent(driver, Risk_Management_Obj.Forecast_Ele_First_Filter, 5, true);
        String Multi_Source_Filter_Value = driver.findElement(Risk_Management_Obj.Forecast_Ele_First_Filter).getText();
        Risk_Management_Obj.Z2D_Forecast_Click_on_First_Filter();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value), Multi_Source_Filter_Value);
        String TotalFilterValue = driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value).getText();
        Assert.assertEquals(TotalFilterValue, Multi_Source_Filter_Value);
        if (TotalFilterValue.equals("0")) {
            System.out.println("No Data for the Selected Filter");
        } else {
            String First_Row_Name = driver.findElement(Risk_Management_Obj.Forecast_Ele_First_Table_Data).getText();
            Risk_Management_Obj.Z2D_Forecast_Click_on_First_Result();
            String Opened_File_Name = driver.findElement(Risk_Management_Obj.Forecast_Ele_File_Name).getText();
            Assert.assertTrue(Opened_File_Name.contains(First_Row_Name), "Opened File is the same as Selected");
        }

        String Single_Source_Filter_Value = driver.findElement(Risk_Management_Obj.Forecast_Ele_Second_Filter).getText();
        Risk_Management_Obj.Z2D_Forecast_Second_Filter_to_be_Clickable();

        Risk_Management_Obj.Z2D_Forecast_Click_on_Second_Filter();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value), Single_Source_Filter_Value);
        String TotalFilterValue2 = driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value).getText();
        Assert.assertEquals(TotalFilterValue2, Single_Source_Filter_Value);
        if (TotalFilterValue2.equals("0")) {
            System.out.println("No Data for the Selected Filter");
        } else {
            String First_Row_Name = driver.findElement(Risk_Management_Obj.Forecast_Ele_First_Table_Data).getText();
            Risk_Management_Obj.Z2D_Forecast_Click_on_First_Result();
            String Opened_File_Name = driver.findElement(Risk_Management_Obj.Forecast_Ele_File_Name).getText();
            Assert.assertTrue(Opened_File_Name.contains(First_Row_Name), "Opened File is the same as Selected");
        }

        String NA_Source_Filter_Value = driver.findElement(Risk_Management_Obj.Forecast_Ele_Fifth_Filter).getText();
        Risk_Management_Obj.Z2D_Forecast_Click_on_Fifth_Filter();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value), NA_Source_Filter_Value);
        String TotalFilterValue3 = driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value).getText();
        Assert.assertEquals(TotalFilterValue3, NA_Source_Filter_Value);
        if (TotalFilterValue3.equals("0")) {
            System.out.println("No Data for the Selected Filter");
        } else {
            ElementActions.waitForElementToBePresent(driver, Risk_Management_Obj.Forecast_Ele_First_Table_Data, 5, true);
            String First_Row_Name = driver.findElement(Risk_Management_Obj.Forecast_Ele_First_Table_Data).getText();
            Risk_Management_Obj.Z2D_Forecast_Click_on_First_Result();
            String Opened_File_Name = driver.findElement(Risk_Management_Obj.Forecast_Ele_File_Name).getText();
            Assert.assertTrue(Opened_File_Name.contains(First_Row_Name), "Opened File is the same as Selected");
            Obsolescence_Obj.Z2D_Close_Slide_Visibility();
            Obsolescence_Obj.Z2D_Close_Slide();
        }
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
        Obsolescence_Obj = new Obsolescence_Page(driver);
    }
}
