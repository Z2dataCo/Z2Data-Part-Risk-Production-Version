package SE_TestScenarios;

import SE_Page.*;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class X_2_Fun_Delete_BOMs {
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

    @Test(description = "Deleting Created BOMs" , priority = 2)
    public void Delete_BOMs() throws InterruptedException {

        Data_Management_Page Data_Management_Obj = new Data_Management_Page(driver);
        Delete_BOM_Page Delete_Bom_Obj = new Delete_BOM_Page(driver);

        Data_Management_Obj.Z2D_Open_Data_Management();
        Data_Management_Obj.Z2D_Type_Folder_Name();
        Data_Management_Obj.Z2D_Select_Folder();
        Delete_Bom_Obj.Z2D_Click_on_Check_Box();
        int Rows_Size = Delete_Bom_Obj.BOMs_Table.size();
        //System.out.println("Number of Tables Row : " + Rows_Size);
        ElementActions.waitForElementToBePresent(driver,Delete_Bom_Obj.Table_Body,5,true);
        Delete_Bom_Obj.Z2D_Deleting_BOMs(driver);
        //System.out.println("All testing BOMs have been deleted successfully except : (TAP_Bom_Proud_Test)");
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Tear_Down();
    }
}

