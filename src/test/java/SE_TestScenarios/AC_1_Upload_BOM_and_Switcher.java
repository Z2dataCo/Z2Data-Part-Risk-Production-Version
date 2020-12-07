package SE_TestScenarios;

import SE_Page.*;
import com.shaft.gui.browser.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

public class AC_1_Upload_BOM_and_Switcher {
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

    @Test(description = "TS002 || Validate User Upload BOM", priority = 2)
    public void Upload_BOM_and_Switcher() throws AWTException, InterruptedException {
        Landing_Page Landing_Obj = new Landing_Page(driver);
        Upload_BOM_Page Upload_BOM_Obj = new Upload_BOM_Page(driver);
        Risk_Management_Module Risk_Management_Obj = new Risk_Management_Module(driver);


        Landing_Obj.Z2D_Upload_BOM();
        Upload_BOM_Obj.Z2D_Click_Next_Visibility();

        while (!(driver.findElement(By.xpath("//thead/tr[1]/td[2]"))).isDisplayed()) {
            System.out.println("im Here1");
            Upload_BOM_Obj.Z2D_Click_Next();
        }
        System.out.println("Done");
        Upload_BOM_Obj.Z2D_Wait_General_Spinner_Disappear();
        Upload_BOM_Obj.Z2D_Select_Type();
        Upload_BOM_Obj.Z2D_Supplier_Selection();
        Upload_BOM_Obj.Z2D_Select_Type();
        Upload_BOM_Obj.Z2D_MPN_Select();
        Upload_BOM_Obj.Z2D_Open_Column();
        Upload_BOM_Obj.Z2D_Supplier_Selection();
        Upload_BOM_Obj.Z2D_Open_Column();
        Upload_BOM_Obj.Z2D_Mapped_IPN_Clickability();
        Upload_BOM_Obj.Z2D_Mapped_IPN();
        Upload_BOM_Obj.Z2D_Next_Step_Clickability();
        Upload_BOM_Obj.Z2D_Second_Step();
        Upload_BOM_Obj.Z2D_Select_Folder();
        Upload_BOM_Obj.Z2D_Selected_Folder();
        Upload_BOM_Obj.Z2D_Finish();
        Upload_BOM_Obj.Z2D_Wait_General_Spinner_Disappear();

        Risk_Management_Obj.Z2D_Dashboard_Tab_Visibility();
        Assert.assertEquals((driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]"))).getText(), "Dashboard");
        Risk_Management_Obj.Z2D_Spinner_to_Disappear();

        Risk_Management_Obj.Z2D_Scrub_Tab_Visibility();
        Risk_Management_Obj.Z2D_Click_Scrub_Tab();
        Assert.assertEquals((driver.findElement(By.xpath("//a[contains(text(),'Scrub')]"))).getText(), "Scrub");
        Risk_Management_Obj.Z2D_Spinner_to_Disappear();

        Risk_Management_Obj.Z2D_Parts_Tab_Visibility();
        Risk_Management_Obj.Z2D_Click_Parts_Tab();
        Assert.assertEquals((driver.findElement(By.xpath("//*[@id=\"RemainMainPage\"]/app-risk-manager/div/div//li[3]/a"))).getText(), "Parts");
        Risk_Management_Obj.Z2D_Spinner_to_Disappear();
        Risk_Management_Obj.Z2D_Select_Switcher();
        Risk_Management_Obj.Z2D_Spinner_to_Disappear();
        Risk_Management_Obj.Z2D_Select_Switcher();
        Risk_Management_Obj.Z2D_Spinner_to_Disappear();

        Risk_Management_Obj.Z2D_Forecast_Tab_Visibility();
        Risk_Management_Obj.Z2D_Click_Forecast_Tab();
        Assert.assertEquals((driver.findElement(By.xpath("//a[contains(text(),'Forecast')]"))).getText(), "Forecast");
        Risk_Management_Obj.Z2D_Spinner_to_Disappear();
        Risk_Management_Obj.Z2D_Select_Switcher();
        Risk_Management_Obj.Z2D_Spinner_to_Disappear();
        Risk_Management_Obj.Z2D_Select_Switcher();
        Risk_Management_Obj.Z2D_Spinner_to_Disappear();

        Risk_Management_Obj.Z2D_Compliance_Tab_Visibility();
        Risk_Management_Obj.Z2D_Click_Compliance_Tab();
        Assert.assertEquals((driver.findElement(By.xpath("//a[contains(text(),'Compliance')]"))).getText(), "Compliance");
        Risk_Management_Obj.Z2D_Spinner_to_Disappear();

        Risk_Management_Obj.Z2D_Mitigation_Tab_Visibility();
        Risk_Management_Obj.Z2D_Click_Mitigation_Tab();
        Assert.assertEquals((driver.findElement(By.xpath("//a[contains(text(),'Mitigation')]"))).getText(), "Mitigation");
        Risk_Management_Obj.Z2D_Spinner_to_Disappear();
        Risk_Management_Obj.Z2D_Select_Switcher();
        Risk_Management_Obj.Z2D_Spinner_to_Disappear();
        Risk_Management_Obj.Z2D_Select_Switcher();
        Risk_Management_Obj.Z2D_Spinner_to_Disappear();

        Risk_Management_Obj.Z2D_Reports_Tab_Visibility();
        Risk_Management_Obj.Z2D_Click_Reports_Tab();
        Assert.assertEquals((driver.findElement(By.xpath("//a[contains(text(),'Reports')]"))).getText(), "Reports");
        Risk_Management_Obj.Z2D_Spinner_to_Disappear();
    }
}