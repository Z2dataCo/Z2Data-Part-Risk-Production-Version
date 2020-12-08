package SE_TestScenarios;

import Com.PartRisk.Pages.Data_Management_Page;
import Com.PartRisk.Pages.Delete_BOM_Page;
import Com.PartRisk.Pages.Landing_Page;
import SE_Page.Data_Management_Page;
import SE_Page.Delete_BOM_Page;
import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import com.shaft.gui.browser.BrowserFactory;
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
    @Test(priority = 24)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deleting Created BOMs")
    public void Delete_BOMs() throws InterruptedException {

        Landing_Page Landing_Obj = new Landing_Page(driver);
        Data_Management_Page Data_Management_Obj = new Data_Management_Page(driver);
        Delete_BOM_Page Delete_BOM_Obj = new Delete_BOM_Page(driver);

        LandObj.Z2D_Open_Data_Management();
        Wait_Element_Clickable(DManagementObj.Search_Text_Input);
        DManagementObj.Z2D_Type_Folder_Name(Z2DataFolderName);
        boolean staleElement = true;
        while (staleElement) {
            try {
                DManagementObj.Z2D_Select_Folder();
                staleElement = false;
            } catch (StaleElementReferenceException e) {
                staleElement = true;
            }
        }
        Delete_BOM_Obj.Z2D_Click_on_Check_Box();
        int Rows_Size = Delete_BOM_Obj.BOMs_Table.size();
        //System.out.println("Number of Tables Row : " + Rows_Size);
        Wait_Element_Visible(Delete_BOM_Obj.Table_Body);
        Delete_BOM_Obj.Z2D_Deleting_BOMs(driver);
        //System.out.println("All testing BOMs have been deleted successfully except : (TAP_Bom_Proud_Test)");
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Tear_Down();
    }
}

