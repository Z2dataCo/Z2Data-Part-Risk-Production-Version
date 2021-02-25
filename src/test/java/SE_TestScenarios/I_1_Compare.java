package SE_TestScenarios;


import SE_Page.Compare_Page;
import SE_Page.Landing_Page;
import SE_Page.Login_Page;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class I_1_Compare   {
    private WebDriver driver;
    private ExcelFileManager Variables;

    @BeforeClass(alwaysRun = true)
    @Parameters("Environment")
    public void initialize_Global_Objects_and_Navigate(String Environment) {
        if (Environment.equalsIgnoreCase("Production")) {
            Variables = new ExcelFileManager("D:\\IdeaProjects\\Z2Data-Part-Risk-Production-Version\\src\\test\\resources\\PartRiskTestData\\ProdEnv_Parameters.xlsx"); }
        else{
            Variables = new ExcelFileManager("D:\\IdeaProjects\\Z2Data-Part-Risk-Production-Version\\src\\test\\resources\\PartRiskTestData\\TestEnv_Parameters.xlsx"); }
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.GOOGLE_CHROME);
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Navigate_To_URL_for_Navigation(Variables.getCellData("URL","Value"));
        Login_Obj.Z2D_SignIn(Variables.getCellData("UserName","Value"), Variables.getCellData("Password","Value"));
    }

    @Test(description = "TS001 || Validate To Compare between Item", priority = 1)
    public void Compare_Parts() throws InterruptedException {

        Landing_Page Landing_Obj = new Landing_Page(driver);
        Compare_Page Compare_Obj = new Compare_Page(driver);

        Landing_Obj.Z2D_Open_Compare_Page();
        Landing_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        Compare_Obj.Z2D_Input_Compare_1();
        ElementActions.waitForElementToBePresent(driver,Compare_Obj.Value_Compare1,5,true);
        ElementActions.click(driver,Compare_Obj.Value_Compare1);
        Landing_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        Compare_Obj.Z2D_Left_First_Row_Data_Visibility();
        Compare_Obj.Z2D_Input_Compare_2();
        ElementActions.waitForElementToBePresent(driver,Compare_Obj.Value_Compare2,5,true);
        ElementActions.click(driver,Compare_Obj.Value_Compare2);
        Landing_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
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
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Tear_Down();
    }
}