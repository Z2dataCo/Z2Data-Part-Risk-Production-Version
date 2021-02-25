package SE_TestScenarios;


import SE_Page.Data_Management_Page;
import SE_Page.Login_Page;
import SE_Page.Risk_Management_Module;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class T_2_Fun_Mitigation_Filters_and_Data_MPN_View   {
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
    @Test(description = "TS001 || Check Mitigation Filters & Data in MPN View", priority = 1)
    public void Mitigation_Filters_and_Data_MPN_View(String Environment) throws InterruptedException {
        Data_Management_Page Data_Management_Obj = new Data_Management_Page(driver);
        Risk_Management_Module Risk_Management_Obj = new Risk_Management_Module(driver);

        Data_Management_Obj.Z2D_Move_to_Mitigation_BOM(Environment);
        //Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        ElementActions.waitForElementToBePresent(driver,Risk_Management_Obj.NRND_Parts,5,true);
        String NRND_Parts = driver.findElement(Risk_Management_Obj.NRND_Parts).getText().replace(" Parts","");
        String End_of_Life_Parts = driver.findElement(Risk_Management_Obj.End_Of_Life_Parts).getText().replace(" Parts","");
        Risk_Management_Obj.Z2D_Mitigation_Scroll();
        while (driver.findElements(Risk_Management_Obj.Added_Part_Label_List).size() != 0) {
            Risk_Management_Obj.Z2D_Mitigation_Click_on_Close_Button();
        }
        Risk_Management_Obj.Z2D_Mitigation_View_Drop_Crosses_Button_Visibility();
        Risk_Management_Obj.Z2D_Mitigation_Click_on_Drop_in_Crosses();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Z2D_Mitigation_Suggested_Part_Label_Visibility();
        String Crosses_Part_Label = driver.findElement(Risk_Management_Obj.Suggested_Part_Label).getText();
        Risk_Management_Obj.Z2D_Mitigation_Click_on_Add_Part_Button();
        String Added_part_Label = driver.findElement(Risk_Management_Obj.Added_Part_Label).getText();
        Assert.assertEquals(Crosses_Part_Label, Added_part_Label);
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Toast_Container();
        Risk_Management_Obj.Z2D_Mitigation_Click_on_Close_Button();

        Risk_Management_Obj.Z2D_Mitigation_Click_on_View_Replacement_Button();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Z2D_Mitigation_Suggested_Part_Label_Visibility();
        String Replacement_Part_Label = driver.findElement(Risk_Management_Obj.Suggested_Part_Label).getText();
        Risk_Management_Obj.Z2D_Mitigation_Click_on_Add_Part_Button();
        String Added_part_Label2 = driver.findElement(Risk_Management_Obj.Added_Part_Label).getText();
        Assert.assertEquals(Replacement_Part_Label, Added_part_Label2);
        Risk_Management_Obj.Z2D_Mitigation_Click_on_Close_Button();

//has been Commented because of Bug ***********************
        // String Active_Parts = MitigationObj.Active_Parts.getText();
        //  System.out.println("Active_Filter_Value : " + Active_Parts);
        //  MitigationObj.Z2D_Click_on_Active_Filter();
        //  Wait_Element_Invisibility(driver.findElement((LandObj.SpinnerZezo);
        //  Risk_Management_Obj.Wait_Text_To_be(ForeCastObj.TotalValue,Active_Parts);
        //   String TotalFilterValue = ForeCastObj.TotalValue.getText();
        //System.out.println("Total Filter Value : " + TotalFilterValue);
        //    Assert.assertEquals(TotalFilterValue + " Parts",Active_Parts );
//has been Commented because of Bug ***********************

       // String NRND_Parts = driver.findElement(Risk_Management_Obj.NRND_Parts).getText();
        System.out.println("NRND_Filter_Value : " + NRND_Parts);
        Risk_Management_Obj.Z2D_Mitigation_NRND_Parts_to_be_Clickable();
        Risk_Management_Obj.Z2D_Mitigation_Click_on_NRND_Filter();
        Risk_Management_Obj.Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        Risk_Management_Obj.Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value), NRND_Parts);
        String TotalFilterValue2 = driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value).getText();
        System.out.println("Total Filter Value : " + TotalFilterValue2);
        Assert.assertEquals(TotalFilterValue2 , NRND_Parts);

      //  String End_of_Life_Parts = driver.findElement(Risk_Management_Obj.End_Of_Life_Parts).getText();
        System.out.println("End_Of_Life_Parts : " + End_of_Life_Parts);
        Risk_Management_Obj.Z2D_Mitigation_End_Of_Life_Parts_to_be_Clickable();
        Risk_Management_Obj.Z2D_Mitigation_Click_on_End_of_Life_Filter();
        Risk_Management_Obj.Z2D_Wait_Disappear_Z2Data_Spinner_0();
        Risk_Management_Obj.Wait_Text_To_be(driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value), End_of_Life_Parts);
        String TotalFilterValue3 = driver.findElement(Risk_Management_Obj.Forecast_Ele_Total_Value).getText();
        System.out.println("Total Filter Value : " + TotalFilterValue3);
        Assert.assertEquals(TotalFilterValue3 , End_of_Life_Parts);
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        Login_Page Login_Obj = new Login_Page(driver);
        Login_Obj.Tear_Down();
    }
}