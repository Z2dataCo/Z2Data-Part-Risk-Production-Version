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


public class P_2_Fun_MPN_View {
    private WebDriver driver;
    private ExcelFileManager Variables;
    private Login_Page Login_Obj;
    private Landing_Page Landing_Obj;
    private Risk_Management_Module Risk_Management_Obj;
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

    @Test(description = "TS001 || Check selecting any status will affect on forecast graph ( MPN View )", priority = 1)
    public void MPN_View() throws InterruptedException {

        Landing_Obj.Z2D_Open_Data_Management();
        Data_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        Data_Management_Obj.Z2D_Search();
        Data_Management_Obj.SetFile();
        Data_Management_Obj.Z2D_Open_BOM();
        Risk_Management_Obj.Switch_Tabs();
        Risk_Management_Obj.Z2D_Parts_to_be_Clickable();
        Risk_Management_Obj.Z2D_Open_Parts();
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        Assert.assertEquals(Risk_Management_Obj.TableData(),"Uploaded IPN");
        Assert.assertEquals(Risk_Management_Obj.TableData2(),"Uploaded MPN");
        Assert.assertEquals(Risk_Management_Obj.TableData3(),"Uploaded Supplier");
        Assert.assertEquals(Risk_Management_Obj.TableData4(),"IPN");
        Assert.assertEquals(Risk_Management_Obj.TableData5(),"Part Number");
        Assert.assertEquals(Risk_Management_Obj.TableData6(),"Supplier");
        Assert.assertEquals(Risk_Management_Obj.TableData7(),"Product");
        Assert.assertEquals(Risk_Management_Obj.TableData8(),"Description");
        Assert.assertEquals(Risk_Management_Obj.TableData9(),"Package");
        Assert.assertEquals(Risk_Management_Obj.TableData10(),"Lifecycle");
        Assert.assertEquals(Risk_Management_Obj.TableData11(),"RoHS");
        Assert.assertEquals(Risk_Management_Obj.TableData12(),"Crosses / Replacements");
        Assert.assertEquals(Risk_Management_Obj.TableData13(),"Inventory");
        Assert.assertEquals(Risk_Management_Obj.TableData14(),"PCN");
        Assert.assertEquals(Risk_Management_Obj.TableData15(),"Part Score");
        Assert.assertEquals(Risk_Management_Obj.TableData16(),"Tags");
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
    }
}