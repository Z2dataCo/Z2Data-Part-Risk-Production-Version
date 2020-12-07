package SE_TestScenarios;


import SE_Page.Compare_Page;
import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class I_1_Compare   {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void initialize_Global_Objects_and_Navigate() {
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.navigateToURLForNavigationL();
    }

    @Test(description = "TS001 || Login to Z2Data Part Risk", priority = 1)
    public void Login() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Z2D_SignIn();
    }

    @Test(description = "TS002 || Validate To Compare between Item", priority = 2)
    public void Compare_Parts() throws InterruptedException {

        Landing_Page Landing_Obj = new Landing_Page(driver);
        Compare_Page Compare_Obj = new Compare_Page(driver);

        Landing_Obj.Z2D_Open_Compare_Page();
        Landing_Obj.Z2D_Wait_General_Spinner_Disappear();
        Compare_Obj.Z2D_Input_Compare_1();
        boolean Stale_Element = true;
        while (Stale_Element) {
            try {
                ElementActions.hoverAndClick(driver,Compare_Obj.Value_Compare1,Compare_Obj.Value_Compare1);
                Stale_Element = false;
            } catch (Exception e) {
            }
        }
        Landing_Obj.Z2D_Wait_General_Spinner_Disappear();
        Compare_Obj.Z2D_Left_First_Row_Data_Visibility();
        Compare_Obj.Z2D_Input_Compare_2();
        boolean Stale_Element1 = true;
        while (Stale_Element1) {
            try {
                ElementActions.hoverAndClick(driver,Compare_Obj.Value_Compare2,Compare_Obj.Value_Compare2);
                Stale_Element1 = false;
            } catch (Exception e) {
            }
        }
        Landing_Obj.Z2D_Wait_General_Spinner_Disappear();
        Compare_Obj.Z2D_Right_First_Row_Data_Visibility();
        Compare_Obj.Z2D_Select_Differences();
        Compare_Obj.Z2D_Select_Similarities();

        for (int i = 1; i <= 8; i++) {
            if (driver.findElement(By.xpath("//*[@class='tbodyfeatureParts-6']//tr[" + i + "]/td[2]/span")).getAttribute("class").equals("similarit-val")) {
                Assert.assertEquals(
                        driver.findElement(By.xpath("//*[@class='tbodyfeatureParts-6']//tr[" + i + "]/td[2]/span")).getText(),
                        driver.findElement(By.xpath("//*[@class='tbodyfeatureParts-6']//tr[" + i + "]/td[3]/span")).getText());
                System.out.println("Similarities : ");
                System.out.println(driver.findElement(By.xpath("//*[@class='tbodyfeatureParts-6']//tr[" + i + "]/td[2]/span")).getText());
                System.out.println(driver.findElement(By.xpath("//*[@class='tbodyfeatureParts-6']//tr[" + i + "]/td[3]/span")).getText());
            } else {
                Assert.assertNotEquals(
                        driver.findElement(By.xpath("//*[@class='tbodyfeatureParts-6']//tr[" + i + "]/td[2]/span")).getText(),
                        driver.findElement(By.xpath("//*[@class='tbodyfeatureParts-6']//tr[" + i + "]/td[3]/span")).getText());
                System.out.println("Differences : ");
                System.out.println(driver.findElement(By.xpath("//*[@class='tbodyfeatureParts-6']//tr[" + i + "]/td[2]/span")).getText());
                System.out.println(driver.findElement(By.xpath("//*[@class='tbodyfeatureParts-6']//tr[" + i + "]/td[3]/span")).getText());
            }

        }
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        driver.quit();
    }
}