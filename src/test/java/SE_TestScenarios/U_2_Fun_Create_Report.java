package SE_TestScenarios;

import SE_Page.*;
import com.github.javafaker.Faker;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class U_2_Fun_Create_Report {
    Faker faker = new Faker();
    String Name = faker.name().firstName() + "1";
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

    @Test(description = "TS002 || Validate To Create , Review Report And Download", priority = 2)
    public void Create_Report_Download() throws InterruptedException {
        Data_Management_Page Data_Management_Obj = new Data_Management_Page(driver);
        Risk_Management_Module Risk_Management_Obj = new Risk_Management_Module(driver);
        PCN_Manager_Page PCN_Manager_Obj = new PCN_Manager_Page(driver);

        Data_Management_Obj.Z2D_Move_to_Reports_BOM();
        Risk_Management_Obj.Z2D_Reports_Open_Create_Report();
        Risk_Management_Obj.Z2D_Reports_Select_Parameter();
        Risk_Management_Obj.Z2D_Reports_Save_Report();
        Risk_Management_Obj.Z2D_Reports_Enter_Report_Name(Name);
        Risk_Management_Obj.Z2D_Reports_Confirm_Report();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Toast_Container();
        Risk_Management_Obj.Z2D_Reports_Click_on_Saved_Reports_List();
        if ((driver.findElement(Risk_Management_Obj.First_Report_Name).getText().equals(Name))){
        String Saved_Report = driver.findElement(Risk_Management_Obj.First_Report_Name).getText();
        Assert.assertEquals(Saved_Report, Name);}
        else {
            Risk_Management_Obj.Z2D_Reports_Re_Click_on_Saved_Reports_List();
            String Saved_Report = driver.findElement(Risk_Management_Obj.First_Report_Name).getText();
            Assert.assertEquals(Saved_Report, Name);}

        Risk_Management_Obj.Z2D_Reports_Preview_Report();
        PCN_Manager_Obj.Z2D_Wait_Invisibility_Of_Spinner_Zezo_1();
        ElementActions.waitForElementToBePresent(driver,Risk_Management_Obj.Report_Window_Title,5,true);
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.Report_Window_Title).getText(), ("Report Preview"));
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.Download_Btn).getText(), ("Download"));
        Risk_Management_Obj.Z2D_Reports_Download_Report();
        Risk_Management_Obj.Z2D_Reports_Close_Preview();
        Risk_Management_Obj.Z2D_Reports_CustomReport();
        Risk_Management_Obj.Z2D_Reports_Openlist();
        Risk_Management_Obj.Z2D_Reports_Delete_Report();
        Thread.sleep(3000);
        Assert.assertNotEquals(driver.findElement(Risk_Management_Obj.FirstRow).getText(), Name, "Verify to delete Report");
        System.out.println("Report: " + Name + " Is Deleted");
}
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        driver.quit();
    }
}

