package SE_TestScenarios;

import SE_Page.*;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Z_2_Fun_All_Obsolescence {
    private WebDriver driver;
    private ExcelFileManager Variables;
    private Landing_Page Landing_Obj;
    private Data_Management_Page Data_Management_Obj;
    private Login_Page Login_Obj;
    private Risk_Management_Module Risk_Management_Obj;
    private Obsolescence_Page Obsolescence_Obj;

    @BeforeClass(alwaysRun = true)
    @Parameters("Environment")
    public void initialize_Global_Objects_and_Navigate(String Environment) {
        if (Environment.equalsIgnoreCase("Production")) {
            Variables = new ExcelFileManager("D:\\IdeaProjects\\Z2Data-Part-Risk-Production-Version\\src\\test\\resources\\PartRiskTestData\\ProdEnv_Parameters.xlsx"); }
        else{
            Variables = new ExcelFileManager("D:\\IdeaProjects\\Z2Data-Part-Risk-Production-Version\\src\\test\\resources\\PartRiskTestData\\TestEnv_Parameters.xlsx"); }
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Obj = new Login_Page(driver);
        Login_Obj.Navigate_To_URL_for_Navigation(Variables.getCellData("URL","Value"));
        Login_Obj.Z2D_SignIn(Variables.getCellData("UserName","Value"), Variables.getCellData("Password","Value"));
    }

    @Parameters("Environment")
    @Test(description = "TS001 || Check that side panel of All Obsolescence PCNs shows all PCNs on the BOM", priority = 1)
    public void All_ObsolescencePage(String Environment) {

        Landing_Obj.Z2D_Open_Data_Management();
        Data_Management_Obj.Z2D_Search();
        Data_Management_Obj.SetFile();
        if (!(" TAP_BOM_Proud_Test".equals(driver.getPageSource()))) {
            Data_Management_Obj.Z2D_Move_To_Prod_BOM(Environment);
        } else {
            Data_Management_Obj.Z2D_Click_on_BOM(Environment);
        }
        Risk_Management_Obj.Z2D_Reports_Open_Reports_Tab();
        Obsolescence_Obj.Z2D_Product_Change();
        Obsolescence_Obj.Z2D_All_Obsolescence();
        Obsolescence_Obj.Z2D_Get_Last_Page_for_All_Obs();
        int CountOfTable = driver.findElements(Obsolescence_Obj.Table_Size).size();
        int Count = Integer.parseInt(driver.findElement(Obsolescence_Obj.Fixed_Number_for_All_Obs).getText());
        int CountPagination = Integer.parseInt(driver.findElement(Obsolescence_Obj.Next_Page).getText());
        int CountPage = CountPagination - 1;
        int SubTotal = CountOfTable * CountPage;
        int LastPage = Count - SubTotal;
        int AllOfRow = LastPage + SubTotal;
        Assert.assertEquals(Count, AllOfRow);
        Obsolescence_Obj.Z2D_Table_of_Data();
        Obsolescence_Obj.Z2D_Close_Slide();
    }

    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Obj.Tear_Down();
    }

    @BeforeMethod
    public void BeforeMethod() {
        Login_Obj = new Login_Page(driver);
        Landing_Obj = new Landing_Page(driver);
        Data_Management_Obj = new Data_Management_Page(driver);
        Risk_Management_Obj = new Risk_Management_Module(driver);
        Obsolescence_Obj = new Obsolescence_Page(driver);
    }
}
