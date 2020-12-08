package SE_TestScenarios;

import Com.PartRisk.Pages.Data_Management_Page;
import Com.PartRisk.Pages.Delete_BOM_Page;
import Com.PartRisk.Pages.Landing_Page;
import SE_Page.Data_Management_Page;
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
    @Test(description = "TS002 || Deleting Created BOMs", priority = 2)
    public void Delete_BOMs() throws InterruptedException {

        Landing_Page Landing_Obj = new Landing_Page(driver);
        Data_Management_Page Data_Management_Obj = new Data_Management_Page(driver);

        Landing_Obj.Z2D_Open_Data_Management();
        Data_Management_Obj.Z2D_Search_Text_Input_to_be_Clickable();
        Data_Management_Obj.Z2D_Type_Folder_Name();
        boolean staleElement = true;
        while (staleElement) {
            try {
                Data_Management_Obj.Z2D_Select_Folder();
                staleElement = false;
            } catch (StaleElementReferenceException e) {
                staleElement = true;
            }
        }
        Data_Management_Obj.Z2D_Click_on_Check_Box();
        int Rows_Size = Data_Management_Obj.BOMs_Table.size();
        //System.out.println("Number of Tables Row : " + Rows_Size);
        Data_Management_Obj.Z2D_Table_Body_to_be_Visibility();
        Data_Management_Obj.Z2D_Deleting_BOMs();
        //System.out.println("All testing BOMs have been deleted successfully except : (TAP_Bom_Proud_Test)");
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Tear_Down();
    }
}

