package SE_TestScenarios;

import SE_Page.Data_Management_Page;
import SE_Page.Login_Page;
import SE_Page.PCN_Manager_Page;
import SE_Page.Risk_Management_Module;
import com.github.javafaker.Faker;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class V_2_Fun_Create_Folder_Data_Management{

private WebDriver driver;
Faker faker = new Faker();
String Z2DataFakerFolder = faker.name().firstName() + "1";

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


    @Test(description = "TS002 || Validate To Create Folder In Data Management",priority = 2)
    public void Create_Folder_in_Data_Management() throws InterruptedException {

        Data_Management_Page Data_Management_Obj = new Data_Management_Page(driver);
        Risk_Management_Module Risk_Management_Obj = new Risk_Management_Module(driver);
        PCN_Manager_Page PCN_Manager_Obj = new PCN_Manager_Page(driver);

        Data_Management_Obj.Z2D_Open_Data_Management();
        Data_Management_Obj.Z2D_Create_Folder();
        Data_Management_Obj.Z2D_Folder_Name(Z2DataFakerFolder);
        Data_Management_Obj.Z2D_Submit_Folder();
        PCN_Manager_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Wait_Text_To_be(driver.findElement(Data_Management_Obj.is_Row),Z2DataFakerFolder);
        String istRow = driver.findElement(Data_Management_Obj.is_Row).getText();
        Assert.assertEquals(istRow, Z2DataFakerFolder);
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Toast_Container();
        if (istRow.equals(Z2DataFakerFolder)) {
            Data_Management_Obj.Z2D_Delete_BOM();
            Data_Management_Obj.Z2D_Delete_Confirmation();
            if (!driver.getPageSource().contains(Z2DataFakerFolder)) {
                Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Toast_Container();
                Assert.assertNotEquals(istRow, Z2DataFakerFolder); }
        } else {
            System.out.println("Folder not Exist"); }
    }

    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Tear_Down();
    }
}