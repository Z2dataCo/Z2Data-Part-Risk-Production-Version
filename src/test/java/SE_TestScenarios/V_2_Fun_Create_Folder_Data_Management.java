package SE_TestScenarios;

import SE_Page.Data_Management_Page;
import SE_Page.Login_Page;
import SE_Page.Risk_Management_Module;
import Utilities_Test.Constants_Test;
import com.github.javafaker.Faker;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class V_2_Fun_Create_Folder_Data_Management {

    Faker faker = new Faker();
    String Z2DataFakerFolder = faker.name().firstName() + "1";
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

    @Test(description = "TS001 || Validate To Create Folder In Data Management", priority = 1)
    public void Create_Folder_in_Data_Management() {

        Data_Management_Obj.Z2D_Open_Data_Management();
        Data_Management_Obj.Z2D_Create_Folder();
        Data_Management_Obj.Z2D_Folder_Name(Z2DataFakerFolder);
        Data_Management_Obj.Z2D_Submit_Folder();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Toast_Container();
        Risk_Management_Obj.Wait_Text_To_be(driver.findElement(Data_Management_Obj.is_Row), Z2DataFakerFolder);
        String istRow = driver.findElement(Data_Management_Obj.is_Row).getText();
        Assert.assertEquals(istRow, Z2DataFakerFolder);
        if (istRow.equals(Z2DataFakerFolder)) {
            Data_Management_Obj.Z2D_Delete_BOM();
            Data_Management_Obj.Z2D_Delete_Confirmation();
            Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Toast_Container();
            String First_Folder_Name = driver.findElement(Data_Management_Obj.is_Row).getText();
            Assert.assertNotEquals(First_Folder_Name, Z2DataFakerFolder);
        } else {
            System.out.println("Folder not Exist");
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
    }
}