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

public class E_1_Create_Alert_LifeCycle {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void initialize_Global_Objects_and_Navigate() {
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Navigate_To_URL_for_Navigation();
        Login_Obj.Z2D_SignIn();
    }

    @Test(description = "TS001 || Validate creating alert by selecting LifeCycle only", priority = 1)
    public void Create_Alert_LifeCycle() throws InterruptedException {
        Data_Management_Page Data_Management_Obj = new Data_Management_Page(driver);
        Risk_Management_Module Risk_Management_Obj = new Risk_Management_Module(driver);

        Data_Management_Obj.Z2D_Move_To_Prod_BOM();
        Risk_Management_Obj.Z2D_Followed_Text_to_be_Clickable();
        if (driver.findElement(Risk_Management_Obj.Followed_Text).getText().equals("Followed")) {
            Risk_Management_Obj.Z2D_Click_Followed_Btn();
            Risk_Management_Obj.Z2D_Unfollow_Btn_to_be_Clickable();
            Risk_Management_Obj.Z2D_Click_Unfollow_Btn();
            Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Toast_Container();
            Risk_Management_Obj.Z2D_Click_on_Create_Alert();
        } else {
            Risk_Management_Obj.Z2D_Click_on_Create_Alert();

        }
        Risk_Management_Obj.Z2D_LifeCycle_Btn_to_be_Clickable();
        Risk_Management_Obj.Z2D_Click_on_LifeCycle();
        Risk_Management_Obj.Z2D_Click_on_Submit_Btn();
        Risk_Management_Obj.Z2D_Wait_Text_Not_To_be_Create_Alert();
        String Status = driver.findElement(Risk_Management_Obj.Followed_Text).getText();
        Assert.assertEquals(Status, "Followed");
        Risk_Management_Obj.Z2D_Click_Followed_Btn();
        Risk_Management_Obj.Z2D_Unfollow_Btn_to_be_Clickable();
        Risk_Management_Obj.Z2D_Click_Unfollow_Btn();
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Tear_Down();
    }
}