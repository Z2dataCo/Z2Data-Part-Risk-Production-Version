package SE_TestScenarios;

import SE_Page.Data_Management_Page;
import SE_Page.Login_Page;
import SE_Page.PCN_Manager_Page;
import SE_Page.Risk_Management_Module;
import com.github.javafaker.Faker;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class U_2_Fun_Create_Report {
    Faker faker = new Faker();
    String Name = faker.name().firstName() + "1";
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

    @Parameters("Environment")
    @Test(description = "TS001 || Validate To Create , Review Report And Download", priority = 1)
    public void Create_Report_Download(String Environment) throws InterruptedException {
        Data_Management_Page Data_Management_Obj = new Data_Management_Page(driver);
        Risk_Management_Module Risk_Management_Obj = new Risk_Management_Module(driver);
        PCN_Manager_Page PCN_Manager_Obj = new PCN_Manager_Page(driver);

        Data_Management_Obj.Z2D_Move_to_Reports_BOM(Environment);
        ElementActions.waitForElementToBePresent(driver,Risk_Management_Obj.Create_Report,10,true);
        Risk_Management_Obj.Z2D_Reports_Open_Create_Report();
        Risk_Management_Obj.Z2D_Reports_Select_Parameter();
        Risk_Management_Obj.Z2D_Reports_Save_Report();
        Risk_Management_Obj.Z2D_Reports_Enter_Report_Name(Name);
        Risk_Management_Obj.Z2D_Reports_Confirm_Report();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Toast_Container();
        Risk_Management_Obj.Z2D_Reports_Preview_Report();
        PCN_Manager_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        ElementActions.waitForElementToBePresent(driver,Risk_Management_Obj.Report_Window_Title,5,true);
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.Report_Window_Title).getText(), ("Report Preview"));
        Assert.assertEquals(driver.findElement(Risk_Management_Obj.Download_Btn).getText(), ("Download"));
        //Risk_Management_Obj.Z2D_Reports_Download_Report();
        Risk_Management_Obj.Z2D_Reports_Close_Preview();
        Risk_Management_Obj.Z2D_Reports_CustomReport();
        Risk_Management_Obj.Z2D_Reports_Open_list();
        Risk_Management_Obj.Z2D_Reports_Delete_Report();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Toast_Container();
        driver.navigate().refresh();
        ElementActions.waitForElementToBePresent(driver,Risk_Management_Obj.FirstRow,5,true);
        Assert.assertNotEquals(driver.findElement(Risk_Management_Obj.FirstRow).getText(), Name, "Verify to delete Report");
        System.out.println("Report: " + Name + " Is Deleted");
}
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        driver.quit();
    }
}

