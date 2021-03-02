package SE_TestScenarios;


import SE_Page.Data_Management_Page;
import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import SE_Page.Risk_Management_Module;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class P_2_Fun_MPN_View   {
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
            Variables = new ExcelFileManager("D:\\IdeaProjects\\Z2Data-Part-Risk-Production-Version\\src\\test\\resources\\PartRiskTestData\\ProdEnv_Parameters.xlsx"); }
        else{
            Variables = new ExcelFileManager("D:\\IdeaProjects\\Z2Data-Part-Risk-Production-Version\\src\\test\\resources\\PartRiskTestData\\TestEnv_Parameters.xlsx"); }
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Obj = new Login_Page(driver);
        Login_Obj.Navigate_To_URL_for_Navigation(Variables.getCellData("URL","Value"));
        Login_Obj.Z2D_SignIn(Variables.getCellData("UserName","Value"), Variables.getCellData("Password","Value"));
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
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.Uploaded_IPN).getText(), "Uploaded IPN");
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.Uploaded_MPN).getText(), "Uploaded MPN");
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.Uploaded_Supplier).getText(), "Uploaded Supplier");
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.IPN).getText(), "IPN");
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.Part_Number).getText(), "Part Number");
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.Supplier).getText(), "Supplier"); //hna
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.Product).getText(), "Product");
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.Description).getText(), "Description");
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.Package).getText(), "Package");
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.LifeCycle).getText(), "Lifecycle");
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.RoHos).getText(), "RoHS");
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.Crosses).getText(), "Crosses");
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.Inventory).getText(), "Inventory");
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.PCN).getText(), "PCN");
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.PartScore).getText(), "Part Score");
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.Tags).getText(), "Tags");
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