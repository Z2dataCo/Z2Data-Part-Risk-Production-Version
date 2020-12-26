package SE_Page;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.hotkey.Keys;
import org.testng.Assert;

import java.util.ArrayList;


public class Risk_Management_Module {
    private final WebDriver driver;
    public JavascriptExecutor jse;

    public Risk_Management_Module(WebDriver driver) {
        this.driver = driver;
        jse= (JavascriptExecutor) driver;
    }

    public void Scroll_To_Middle() {
        jse.executeScript("window.scrollBy(0,1000)");
    }

    public void Scroll_to_Element(By element) throws InterruptedException {
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
    }

    public void Scroll_To_Bottom() {
        jse.executeScript("scrollBy(0,2500)");
    }



    public By Dashboard_Tab = By.xpath("//a[contains(text(),'Dashboard')]");
    public By Scrub_Tab = By.xpath("//a[contains(text(),'Scrub')]");
    public By Parts_Tab = By.xpath("//*[@id=\"RemainMainPage\"]/app-risk-manager/div/div//li[3]/a");
    public By Forecast_Tab = By.xpath("//a[contains(text(),'Forecast')]");
    public By Compliance_Tab = By.xpath("//a[contains(text(),'Compliance')]");
    public By Mitigation_Tab = By.xpath("//a[contains(text(),'Mitigation')]");
    public By Reports_Tab = By.xpath("//a[contains(text(),'Reports')]");
    public By Select_BOM = By.xpath("//tbody/tr[2]//td[2]/a[1]");
    public By High_Risk_Card = By.xpath("//*[@id=\"dashboard_content\"]//app-dashboard-risk/div/div[1]/div[1]");
    public By Spinner_Zezo = By.id("progressDiv");
    public By Compliance_Card = By.xpath("//*[@id=\"dashboard_content\"]//app-dashboard-risk/div/div[2]/div[1]");
    public By Market_Availability_Card = By.xpath("//*[@id=\"dashboard_content\"]//app-dashboard-risk/div/div[3]/div[1]");
    public By Total_Card = By.xpath("//*[@id=\"scrub_content\"]/div/div[1]/div[1]/div/div[1]/div[2]/div[1]/div[1]/span");
    public By Exact_Matches = By.xpath("//*[@id=\"scrub_content\"]/div/div[1]/div[1]/div/div[2]/div[1]");
    public By Switchers_Pipeline = By.xpath("//*[@id=\"RemainMainPage\"]/app-risk-manager/div[2]/div/div/div/div/label/div/div");
    public By First_CheckBox = By.xpath("//*[@id=\"partsMPNTabTBodyTblId\"]/tr[1]/td[1]/input");
    public By First_Table_Data = By.xpath("//*[@id=\"partsMPNTabTBodyTblId\"]/tr[1]/td[4]/div");
    public By First_CheckBox_Comp = By.xpath("//*[@id=\"riskProductCompliance\"]/div[4]//tbody/tr[1]/td[1]/input");
    public By First_Table_Data_Comp = By.xpath("//*[@id=\"riskProductCompliance\"]/div[4]//tbody/tr[1]/td[4]/div");
    public By Total_Card_Mitigation = By.xpath("//div[contains(text(),'Total')]");
    public By Unknown_Card = By.xpath("//*[@id=\"RemainMainPage\"]/app-risk-manager/app-risk-mitigation/app-riskmitigationipn/div[1]/div[1]/div/div/div[2]/div[1]");
    public By Preview_Button = By.xpath("//*[@id=\"z2-2cols-sub-2cols-left\"]/div/app-myreports/div[3]/div[2]/div/div[2]/button[1]");
    public By First_Report = By.xpath("//*[@id=\"z2-2cols-sub-2cols-left\"]/div//div[3]/div[2]/div/div[1]/h3");
    public By Followed_Text = By.xpath("//*[@id=\"z2page-head-bar\"]/div/app-create-alert/button/span");
    public By Unfollow_Btn = By.xpath("//div[@id='z2page-head-bar']/div/app-create-alert/div[1]/a[2]");
    public By LifeCycle_Btn = By.xpath("//div[@id='sidepanelCreateAlert']//span[contains(text(),'Lifecycle')]");
    public By Toast_Container = By.id("toast-container");
    public By Create_Alert_Btn = By.xpath("//div[@id='z2page-head-bar']/div//button/span[contains(text(),'Create Alert')]");
    public By Litigation_Btn = By.xpath("//div[@id='sidepanelCreateAlert']//span[contains(text(),'Litigation')]");
    public By Submit_Btn = By.xpath("//button[contains(text(),'Create Alert')]");

    //Dashboard Page
    public By H1_Life_Forecast = By.xpath("//*[@id=\"dashboard_content\"]/div/div/div[1]/div[2]/div[1]/app-dashboard-forecast/div/div[1]/div[1]/span");
    public By Switches_Dashboard = By.xpath("//*[@id=\"dashboard_content\"]/div/div/div[1]/div[2]/div[1]/app-dashboard-forecast/div/div[1]/div[2]/div/label/div");
    public By Reports = By.linkText("Reports");
    public By High_Risk = By.xpath("//*[@id=\"dashboard_content\"]/div/div/div[1]/app-dashboard-risk/div/div[1]/div[2]/div/a");
    public By IPNs_Count = By.xpath("//*[@id=\"dashboard_content\"]/div/div/div[2]/app-dashboard-bominfo/table[1]/tbody/tr[1]/td[2]/span");

    //Scrub Page
    public By Table = By.xpath("//*[@id=\"scrub_content\"]/div/table/tbody");
    public By Scrub_Exact_Matches = By.xpath("//*[@id=\"scrub_content\"]/div/div[1]/div[1]/div/div[2]");
    public By FixedNumber = By.xpath("//*[@id=\"scrub_content\"]/div/div[2]/div[2]/app-z2pagination/span/span[2]");
    public By Last = By.xpath("//a[contains(text(),'Last')]");
    public By LastPage = By.xpath("//li[.='Next']/preceding-sibling::li[position()<2] ");

    //Parts Page
    public By Parts = By.linkText("Parts");
    public By Number_Of_Parts = By.xpath("//body/div[@id='main_start_page']/app-root[1]/div[3]/app-risk-manager[1]/app-risk-parts[1]/app-riskpartsmpn[1]/div[2]/div[1]/div[2]/div[1]/app-z2pagination[1]/span[1]/span[2]");
    public By Uploaded_IPN = By.xpath("//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[3]");
    public By Uploaded_MPN = By.xpath("//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[4]");
    public By Uploaded_Supplier = By.xpath("//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[5]");
    public By IPN = By.xpath("//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[7]");
    public By Part_Number = By.xpath("//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[8]");
    public By Supplier = By.xpath("//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[9]");
    public By Product = By.xpath("//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[10]");
    public By Description = By.xpath("//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[11]");
    public By Package = By.xpath("//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[12]");
    public By LifeCycle = By.xpath("//thead/tr[@id='partsMPNTabTHeadTrTblId']/th[13]");
    public By RoHos = By.xpath("//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[14]");
    public By Crosses = By.xpath("//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[15]");
    public By Inventory = By.xpath("//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[16]");
    public By PCN = By.xpath("//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[17]");
    public By PartScore = By.xpath("//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[18]");
    public By Tags = By.xpath("//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[19]");
    public By IPN_Table_Header = By.xpath("//body[1]/div[5]/app-root[1]/div[3]/app-risk-manager[1]/app-risk-parts[1]/app-riskpartsipn[1]/div[2]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[1]");
    public By Product_Table_Header = By.xpath("//th[contains(text(),'Product')]");
    public By Description_Table_Header = By.xpath("//th[contains(text(),'Description')]");
    public By ofMPNs_Table_Header = By.xpath("//th[contains(text(),'# of MPNs')]");
    public By OfSource_Table_Header = By.xpath("//th[contains(text(),'# of Sources')]");
    public By IPN_LifeCycle_Table_Header = By.xpath("//thead/tr[1]/th[6]");
    public By Multi_Sourcing_Table_Header = By.xpath("//thead/tr[1]/th[7]");
    public By Package_Table_Header = By.xpath("//thead/tr[1]/th[8]");
    public By RoHS_Table_Header = By.xpath("//thead/tr[1]/th[9]");
    public By Lead_Finish_Table_Header = By.xpath("//thead/tr[1]/th[10]");
    public By Dimension_Table_Header = By.xpath("//thead/tr[1]/th[11]");
    public By Crosses_Table_Header = By.xpath("//thead/tr[1]/th[12]");
    public By IPN_Lifecycl_Forecast_Table_Header = By.xpath("//thead/tr[1]/th[13]");
    public By IPN_Risk_Table_Header = By.xpath("//thead/tr[1]/th[14]");
    public By AVX_Filter = By.xpath("//*[@id=\"z2parametric-all\"]/div/div[1]/div[2]/div[1]/label/span[1]");
    public By Fuses_Filter = By.xpath("//*[@id=\"z2parametric-all\"]/div/div[2]/div[2]/div[2]/label/span[1]");
    //public List<WebElement> Rowsnum = driver.findElements(By.xpath("//*[@id=\"partsMPNTabTblId\"]/tbody/tr"));
    public By fixednumber = By.xpath("//*[@id=\"Information\"]/app-z2pagination/span/span[2]");

    //Forecast Page
    public By Forecast_Ele_First_Filter = By.xpath("//tbody/tr[1]/td[2]/a");
    public By Forecast_Ele_Second_Filter = By.xpath("//tbody/tr[2]/td[5]/a");
    public By Forecast_Ele_Third_Filter = By.xpath("//tbody/tr[3]/td[4]/a");
    public By Forecast_Ele_Fifth_Filter = By.xpath("//tbody/tr[5]/td[2]/a");
    public By Forecast_Ele_First_Table_Data = By.xpath("//div[@class='z2tablemost']//tbody/tr[1]/td[1]//span");
    public By Forecast_Ele_File_Name = By.xpath("//*[@id=\"dropbg\"]/div/div/div[1]/div[1]/div[1]");
    public By Forecast_Ele_Graph2 = By.xpath("//*[@id=\"dashboard_content\"]/div/div/div[1]/app-dashboard-risk/div/div[1]");
    public By Forecast_Ele_Total_Value = By.xpath("//app-z2pagination/span/span[2]");
    public By ForeCast_Tab = By.xpath("//a[contains(text(),'Forecast')]");
    public By Spinner2 = By.xpath("//div[@style='border-color: silver silver silver rgb(51, 122, 183);']");
    public By Forecast_Ele_First_Row_Text = By.xpath("//div[@class='z2tablemost']//table/tbody/tr[1]/td[14]");

    //Compliance Page
    public By First_Filter_Total = By.xpath("//*[@id=\"z2parametric-all\"]/div/div[1]/div[2]/div[1]/label/span[2]");
    public By Second_Filter_Total = By.xpath("//*[@id=\"z2parametric-all\"]/div/div[3]/div[2]/div[2]/label/span[2]");
    public By Total_Filter_Results = By.className("CrossRef_2_InfoTotal");
    public By Showing_Of = By.className("CrossRef_2_Info");
    public By First_Check_Box_Filter = By.xpath("//*[@id=\"z2parametric-all\"]/div/div[1]/div[2]/div[1]/label/span[1]");
    public By Second_Check_Box_Filter = By.xpath("//*[@id=\"z2parametric-all\"]/div/div[3]/div[2]/div[2]/label/span[1]");


    //Mitigation Page
    public By Switchers = By.xpath("//*[@id=\"RemainMainPage\"]/app-risk-manager/div[2]/div/div/div/div/label/div");
    public By Drop_Crosses = By.xpath("/tbody/tr[10]/td[4]/div[1]/a[1]");
    public By Add_Crosses = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/table[2]/tbody/tr[2]/td[1]/button");
    public By Active_Parts = By.xpath("//div[@class='z2-scorecard scorecard-parts']/div[2]/div[2]/div[1]");
    public By NRND_Parts = By.xpath("//div[@class='z2-scorecard scorecard-parts']/div[3]/div[2]/div[1]");
    public By End_Of_Life_Parts = By.xpath("//div[@class='z2-scorecard scorecard-parts']/div[4]/div[2]/div[1]");
    public By Selected_Part_Number = By.xpath("//tbody//tr[10]/td[1]//a/span");
    public By View_Drop_Crosses_Button = By.xpath("//tbody//tr[10]/td[4]//div[1]/a");
    public By Recommendation_Option = By.xpath("//*[@id=\"mitiMPNTable\"]/tbody/tr[8]/td[4]/div/div/span");
    public By View_Replacement_Button = By.xpath("//tbody//tr[10]/td[4]//div[2]/a");
    public By Suggested_Part_Label = By.xpath("//div[@id='dropbg']//table[2]/tbody/tr[1]/td[2]/div");
    public By Add_Part_Button = By.xpath("//*[@id]//tr[1]//button[contains(text(),'Add Part ')]");
    public By Added_Part_Label = By.xpath("//tbody//tr[10]/td[3]//ul/div[2]//a/span");
    public By Card_Close_Button = By.xpath("//tbody/tr[10]/td[3]//div[1]/div[1]/span[1]");
    public By Table_Body = By.xpath("//table[@class='table table-bordered table-middle text-left bg-white tablehascards']//tbody");
    public By Added_Part_Label_List = By.xpath("//tbody//tr[10]/td[3]//ul/div[2]//a/span");

    //Reports Page
    public By Check_Box1 = By.xpath("//span[contains(text(),'Z2 Part Number')]");
    public By Check_Box2 = By.xpath("//span[contains(text(),'Product Name')]");
    public By DDL_Report = By.xpath("//*[@placeholder='Saved Reports']");
    public By Index0 = By.xpath("//*[@id=\"z2-2cols-sub-2cols-left\"]/div/app-createreport/app-run-create-reports/div[1]/div[1]/div[2]/select/option[2]");
    public By Close_Preview = By.xpath("//div[@id='dropbg']/div/div/div[1]/div[2]/i");
    public By Download_Btn = By.xpath("//*[@id=\"dropbg\"]/div/div/button");
    public By Obsolescence = By.xpath("//*[@id=\"z2-2cols-leftpanel\"]/ul/li[5]/a/div[2]");
    public By High_Lifecycle_RiskParts = By.xpath("//a[contains(text(),'High Lifecycle Risk Parts')]");
    public By ObsoleteParts_3Y = By.linkText("Obsolete Parts in 3 Years");
    public By ObsoleteParts_5Y = By.linkText("Obsolete Parts in 5 Years");
    public By Row_Active = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/div/div[2]/table/tbody/tr[32]/td[5]/div");
    public By Row_3Y = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/div/div[2]/table/tbody/tr[18]/td[8]/div");
    public By Create_Report = By.xpath("//*[@id=\"z2-2cols-leftpanel\"]/ul/li[3]/a/div[2]");
    public By Save_Report = By.xpath("//body/div[@id='main_start_page']/app-root[1]/div[3]/app-risk-manager[1]/app-riskreport[1]/div[1]/app-riskreportmpn[1]/div[1]/div[2]/div[1]/div[1]/div[1]/app-createreport[1]/app-run-create-reports[1]/div[1]/div[1]/div[1]/button[1]");
    public By Report_Name = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div[2]/input");
    public By Confirm_Report = By.xpath("//body/div[@id='dropbg']/div[1]/div[1]/div[2]/button[1]");
    public By Preview = By.xpath("//*[@class='pull-left width-80-per']/button[3]");
    public By Conflict_Minerals_Tab = By.xpath("//*[@id=\"z2-2cols-leftpanel\"]/ul/li[7]/a");
    public By Smelters_Report_button = By.xpath("//a[contains(text(),'Smelters Report')]");
    public By Report_Window_Title = By.xpath("//*[@id=\"dropbg\"]/div/div/div[1]/div[1]/div[1]/div[1]");
    public By Export_Button = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div//button");
    public By Export_Selection = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div/div//a[1]");
    public By Supplier_Report_Button = By.xpath("//a[contains(text(),'CM Compliance by Supplier')]");
    public By Compliance_By_MPN_Report_Button = By.xpath("//a[contains(text(),'MPN Conflict Minerals Report')]");
    public By Minerals_Metal_Report_Button = By.xpath("//a[contains(text(),'Conflict Minerals Metal')]");
    public By Reports_First_Filter = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div[1]/div[2]/div");
    public By Reports_Second_Filter = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div[2]/div[2]/div");
    public By Reports_Third_Filter = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div[3]/div[2]/div");
    public By Reports_Fourth_Filter = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div[4]/div[2]/div");
    public By Info_Total = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/div[2]//app-z2pagination/span/span[2]");
    public By First_Report_Name = By.xpath("//*[@placeholder='Saved Reports']/option[2]");
    public By CusReport = By.xpath("//*[@id=\"z2-2cols-leftpanel\"]/ul/li[2]/a/div[2]");
    public By Report_List = By.xpath("//*[@id=\"z2-2cols-sub-2cols-left\"]/div/app-myreports/div[3]/div[2]/div/div[2]/div/div/i");
    public By DeleteReport = By.xpath("//*[@id=\"z2-2cols-sub-2cols-left\"]/div/app-myreports/div[3]/div[2]/div/div[2]/div/div/popover-container/div[2]/div/div[1]/div[1]/a[2]/div[2]");
    public By FirstRow = By.xpath("//*[@id=\"z2-2cols-sub-2cols-left\"]/div/app-myreports/div[3]/div[2]/div/div[1]/h3");
    public By ConflictMinerals = By.xpath("//*[@id=\"z2-2cols-leftpanel\"]/ul/li[7]/a");
    public By ConflictMetals = By.xpath("//*[@id=\"E486C921-1091-4106-AF87-9FA806D3C9CD\"]/div/div[4]/div/div/div/a");
    public By Tungsten = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/div[2]/table/thead/tr/th[6]");


    //Risk Management Methods
    public void Z2D_Followed_Text_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, Followed_Text, 5, true);
    }

    public void Z2D_Unfollow_Btn_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, Unfollow_Btn, 5, true);
    }

    public void Z2D_LifeCycle_Btn_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, LifeCycle_Btn, 5, true);
    }

    public void Z2D_Click_Followed_Btn() {
        ElementActions.click(driver, Followed_Text);
    }

    public void Z2D_Click_Unfollow_Btn() {
        ElementActions.click(driver, Unfollow_Btn);
    }

    public void Switch_Tabs() {
        ArrayList<String> tab2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab2.get(0));
        driver.close();
        driver.switchTo().window(tab2.get(1));
    }

    public void Z2D_Click_on_LifeCycle() throws InterruptedException {
        while (!driver.findElement(LifeCycle_Btn).isSelected()) {
            ElementActions.click(driver, LifeCycle_Btn);
            Thread.sleep(200);
            break;
        }
    }

    public void Z2D_Wait_Invisibility_Of_Toast_Container() {
        WebDriverWait Wait = new WebDriverWait(driver, 100);
        Wait.until(ExpectedConditions.invisibilityOf(driver.findElement(Toast_Container)));
    }

    public void Z2D_Click_on_Create_Alert() {
        ElementActions.click(driver, Create_Alert_Btn);
    }

    public void Z2D_Click_on_Litigation() throws InterruptedException {
        while (!driver.findElement(Litigation_Btn).isSelected()) {
            ElementActions.click(driver, Litigation_Btn);
            Thread.sleep(200);
            break;
        }
    }

    public void Z2D_Click_on_Submit_Btn() {
        ElementActions.click(driver, Submit_Btn);
    }

    public void Z2D_Wait_Text_Not_To_be_Create_Alert() {
        ElementActions.waitForTextToChange(driver, Followed_Text, "Create Alert", 5);

    }

    public void Z2D_Wait_Disappear_Z2Data_Spinner_0() throws InterruptedException {
        int count = 0;
        while ((driver.findElements(By.xpath("//*[@id=\"RemainMainPage\"]/app-risk-manager/app-risk-parts/app-riskpartsmpn/ngx-loading/div/div[2]/div"))).size() != 0 && count < 40) {
            Thread.sleep(700);
            count++;
        }
    }

    public void Z2D_Switchers_Pipeline_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, Switchers_Pipeline, 5, true);
    }

    public void Z2D_Active_Parts_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, Active_Parts, 5, true);
    }

    public void Z2D_Preview_Button_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, Preview_Button, 5, true);
    }

    public void Z2D_First_Total_Card_Mitigation_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, Total_Card_Mitigation, 5, true);
    }

    public void Z2D_First_CheckBox_Comp_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, First_CheckBox_Comp, 5, true);
    }

    public void Z2D_High_Risk_Card_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, High_Risk_Card, 5, true);
    }

    public void Z2D_Total_Card_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, Total_Card, 5, true);
    }


    public void Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1() {
        WebDriverWait Wait = new WebDriverWait(driver, 100);
        Wait.until(ExpectedConditions.invisibilityOf(driver.findElement(Spinner_Zezo)));
    }

    public void Z2D_Wait_Invisibility_Of_Z2Data_Spinner_2() {
        WebDriverWait Wait = new WebDriverWait(driver, 100);
        Wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//div[@id='dropbg']//div[@style='border-radius: 3px; background-color: rgba(0, 18, 59, 0.6);']"))));
    }

    public void Z2D_Click_Dashboard_Tab() {
        ElementActions.hover(driver, Dashboard_Tab);
        ElementActions.click(driver, Dashboard_Tab);
    }

    public void Z2D_Dashboard_Tab_Visibility() {
        ElementActions.waitForElementToBePresent(driver, Dashboard_Tab, 5, true);
    }

    public void Z2D_Click_Scrub_Tab() {
        ElementActions.click(driver, Scrub_Tab);
    }

    public void Z2D_Scrub_Tab_Visibility() {
        ElementActions.waitForElementToBePresent(driver, Scrub_Tab, 5, true);
    }

    public void Z2D_Click_Forecast_Tab() {
        ElementActions.click(driver, Forecast_Tab);
    }

    public void Z2D_Forecast_Tab_Visibility() {
        ElementActions.waitForElementToBePresent(driver, Forecast_Tab, 5, true);
    }

    public void Z2D_Click_Compliance_Tab() {
        ElementActions.click(driver, Compliance_Tab);
    }

    public void Z2D_Compliance_Tab_Visibility() {
        ElementActions.waitForElementToBePresent(driver, Compliance_Tab, 5, true);
    }

    public void Z2D_Click_Mitigation_Tab() {
        ElementActions.click(driver, Mitigation_Tab);
    }

    public void Z2D_Mitigation_Tab_Visibility() {
        ElementActions.waitForElementToBePresent(driver, Mitigation_Tab, 5, true);
    }

    public void Z2D_Click_Reports_Tab() {
        ElementActions.click(driver, Reports_Tab);
    }

    public void Z2D_Reports_Tab_Visibility() {
        ElementActions.waitForElementToBePresent(driver, Reports_Tab, 5, true);
    }

    public void Z2D_Click_Parts_Tab() {
        //ElementActions.hover(driver, Parts_Tab);
        ElementActions.click(driver, Parts_Tab);
        Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1();
        ElementActions.isElementClickable(driver, First_CheckBox);
    }

    public void Z2D_Parts_Tab_Visibility() {
        ElementActions.waitForElementToBePresent(driver, Parts_Tab, 5, true);
    }

    public void Z2D_Select_Switcher() throws InterruptedException {
        Thread.sleep(1000);
        ElementActions.click(driver, Switchers_Pipeline);
    }

    //Dashboard Page Method

    public void Z2D_Dashboard_Switches() {
        ElementActions.click(driver, Switches_Dashboard);
    }

    public void Z2D_Dashboard__HighRisk() {
        ElementActions.click(driver, High_Risk);
    }

    //Parts Page Method
    public int Z2D_Rows_Number() {
        driver.findElements(By.xpath("//*[@id=\"partsMPNTabTblId\"]/tbody/tr")).size();
        return 0;
    }

    public void Z2D_Open_Parts() {
        ElementActions.click(driver, Parts);
    }

    public void Z2D_Parts_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, Parts, 5, true);
    }

    public void Z2D_Parts_Check_AVX() {
        ElementActions.click(driver, AVX_Filter);
    }

    public void Z2D_Parts_Check_Fuses() {
        ElementActions.click(driver, Fuses_Filter);
    }

    public void Z2D_IPN_Table_Header_Visibility() {
        ElementActions.waitForElementToBePresent(driver, IPN_Table_Header, 5, true);
    }


    // Scrub Page Methods
    public void Z2D_Scrub_Last_Pagination() {
        ElementActions.click(driver, Last);
    }

    public int Z2D_Scrub_Table_Rows() {
        driver.findElements(By.xpath("//*[@id=\"scrub_content\"]/div/table/tbody/tr")).size();
        return 0;
    }

    public void Z2D_Scrub_Last_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, Last, 5, true);
    }


    //Forecast Page Methods

    public void Z2D_Forecast_Ele_Graph2_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, Forecast_Ele_Graph2, 5, true);
    }

    public void Z2D_Forecast_Ele_First_Row_Text_Visibility() {
        ElementActions.waitForElementToBePresent(driver, Forecast_Ele_First_Row_Text, 5, true);
    }

    public void Z2D_Forecast_Click_on_Graph() {
        ElementActions.click(driver, Forecast_Ele_Graph2);
    }

    public void Z2D_Forecast_Click_on_Forecast_Tab() {
        ElementActions.click(driver, ForeCast_Tab);
    }

    public void Z2D_Forecast_Click_on_First_Filter() {
        Scroll_To_Middle();
        ElementActions.click(driver, Forecast_Ele_First_Filter);
    }

    public void Z2D_Forecast_Click_on_Second_Filter() {
        ElementActions.click(driver, Forecast_Ele_Second_Filter);
    }

    public void Z2D_Forecast_Click_on_Third_Filter() {
        ElementActions.click(driver, Forecast_Ele_Third_Filter);
    }

    public void Z2D_Forecast_Click_on_Fifth_Filter() {
        ElementActions.click(driver, Forecast_Ele_Fifth_Filter);

    }

    public void Z2D_Forecast_Click_on_First_Result() {
        ElementActions.click(driver, Forecast_Ele_First_Table_Data);
    }

    public int Z2D_Forecast_Table_Columns() {
        driver.findElements(By.xpath("//div[@class='z2tablemost']//table/tbody/tr[1]/td")).size();
        return 0;
    }

    public int Z2D_Forecast_Table_Rows() {
        driver.findElements(By.xpath("//div[@class='z2tablemost']//table/tbody/tr")).size();
        return 0;
    }

    public void Z2D_Forecast_Get_Table_Data(WebDriver driver, String Assertion) {
        int Row_Size = Z2D_Forecast_Table_Rows();
        int Column_Size = Z2D_Forecast_Table_Columns();
        System.out.println("number of Rows are" + Row_Size);
        System.out.println("number of Columns are" + Column_Size);
        for (int i = 1; i <= Row_Size; i++) {
            String Life_Cycle_Column_Data = driver.findElement(By.xpath("//div[@class='z2tablemost']//table/tbody/tr[" + i + "]/td[14]")).getText();
            Assert.assertEquals(Life_Cycle_Column_Data, Assertion);
        }
    }

    public void Z2D_Forecast_First_Filter_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, Forecast_Ele_First_Filter, 5, true);
    }

    public void Z2D_Forecast_Second_Filter_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, Forecast_Ele_Second_Filter, 5, true);
    }

    public void Z2D_Forecast_Third_Filter_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, Forecast_Ele_Third_Filter, 5, true);
    }

    public void Z2D_Forecast_Fifth_Filter_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, Forecast_Ele_Fifth_Filter, 5, true);
    }

    //Compliance Page Methods
    public void Z2D_Compliance_Click_on_First_Filter() {
        ElementActions.click(driver, First_Check_Box_Filter);
    }

    public void Z2D_First_Check_Box_Filter_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, First_Check_Box_Filter, 5, true);
    }


    public void Z2D_Compliance_Click_on_Second_Filter() {
        boolean Intercepted = true;
        while (Intercepted) {
            try {
                ElementActions.click(driver, Second_Check_Box_Filter);
                Intercepted = false;
            } catch (ElementClickInterceptedException e) {
                Intercepted = true;
            }

        }
    }

    public void Z2D_Second_Check_Box_Filter_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, Second_Check_Box_Filter, 5, true);
    }

    //Mitigation Page Methods

    public void Z2D_Mitigation_Open_Drop_INCrosses() throws InterruptedException {
        Scroll_To_Bottom();
        Thread.sleep(3000);
        ElementActions.click(driver, Drop_Crosses);
    }

    public void Z2D_Mitigation_Add_Crosses() {
        ElementActions.click(driver, Add_Crosses);
    }

    public void Z2D_Mitigation_Click_on_Mitigation_Tab() {
        ElementActions.click(driver, Mitigation_Tab);
    }

    public void Z2D_Mitigation_Click_on_Active_Filter() {
        ElementActions.click(driver, Active_Parts);
    }

    public void Z2D_Mitigation_Click_on_NRND_Filter() {
        ElementActions.click(driver, NRND_Parts);
    }

    public void Z2D_Mitigation_NRND_Parts_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, NRND_Parts, 5, true);
    }

    public void Z2D_Mitigation_Click_on_End_of_Life_Filter() {
        ElementActions.click(driver, End_Of_Life_Parts);
    }

    public void Z2D_Mitigation_End_Of_Life_Parts_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, End_Of_Life_Parts, 5, true);
    }
    public void Z2D_Mitigation_Suggested_Part_Label_Visibility() {
        ElementActions.waitForElementToBePresent(driver, Suggested_Part_Label, 10, true);
    }
    public void Z2D_Mitigation_View_Drop_Crosses_Button_Visibility() {
        ElementActions.waitForElementToBePresent(driver, View_Drop_Crosses_Button, 5, true);
    }


    public void Z2D_Mitigation_Click_on_Drop_in_Crosses() {
        ElementActions.click(driver, View_Drop_Crosses_Button);
    }

    public void Z2D_Mitigation_Click_on_Add_Part_Button() throws InterruptedException {
        Thread.sleep(1000);
        ElementActions.click(driver, Add_Part_Button);
    }

    public void Z2D_Mitigation_Click_on_Close_Button() throws InterruptedException {
        boolean Intercepted = true;
        while (Intercepted) {
            try {
                ElementActions.click(driver, Card_Close_Button);
                Thread.sleep(200);
                Intercepted = false;
            } catch (ElementNotInteractableException e) {
                Intercepted = true;
            }
        }
    }

    public void Z2D_Mitigation_Scroll() throws InterruptedException {
        ElementActions.waitForElementToBePresent(driver,Recommendation_Option,5,true);
        jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(Recommendation_Option));
        Thread.sleep(500);
    }

    public void Z2D_Mitigation_Click_on_View_Replacement_Button() {
        boolean Intercepted = true;
        while (Intercepted) {
            try {
                ElementActions.click(driver, View_Replacement_Button);
                Thread.sleep(200);
                Intercepted = false;
            } catch (ElementClickInterceptedException | InterruptedException e) {
                Intercepted = true;
            }
        }
    }

    //Reports Page Methods
    public void Z2D_Reports_Export_Button_Visibility() {
        ElementActions.waitForElementToBePresent(driver, Export_Button, 5, true);
    }
    public void Z2D_Reports_Report_Window_Title_Visibility() {
        ElementActions.waitForElementToBePresent(driver, Report_Window_Title, 5, true);
    }

    public void Z2D_Reports_Open_Reports_Tab() {
        ElementActions.click(driver, Reports);
    }

    public void Z2D_Reports_Open_Create_Report() {
        ElementActions.click(driver, Create_Report);
    }

    public void Z2D_Reports_Select_Parameter() throws InterruptedException {
        ElementActions.click(driver, Check_Box1);
        ElementActions.click(driver, Check_Box2);
    }

    public void Z2D_Reports_Save_Report() {
        ElementActions.click(driver, Save_Report);
    }

    public void Z2D_Reports_Enter_Report_Name(String Name) {
        ElementActions.type(driver, Report_Name, Name);
    }

    public void Z2D_Reports_Confirm_Report() {
        ElementActions.click(driver, Confirm_Report);
    }

    public void Z2D_Reports_Preview_Report() {
        ElementActions.click(driver, Preview);
    }

    public void Z2D_Reports_Close_Preview() {
        ElementActions.click(driver, Close_Preview);
    }

    public void Z2D_Reports_Download_Report() {
        ElementActions.click(driver, Download_Btn);
    }

    public void Z2D_Reports_Open_Obsolescence() {
        ElementActions.click(driver, Obsolescence);
    }

    public void Z2D_Reports_Open_High_LifeCycle() {
        ElementActions.click(driver, High_Lifecycle_RiskParts);
    }

    public void Z2D_Reports_Open_Obsolete_3Years() {
        ElementActions.click(driver, ObsoleteParts_3Y);
    }

    public void Z2D_Reports_Open_Obsolete_5Years() {
        ElementActions.click(driver, ObsoleteParts_5Y);
    }

    public void Z2D_Reports_Open_Smelters_Report() {
        ElementActions.click(driver, Conflict_Minerals_Tab);
        ElementActions.click(driver, Smelters_Report_button);
    }

    public void Z2D_Reports_Export_Report_Excel() {
        ElementActions.click(driver, Export_Button);
        ElementActions.click(driver,Export_Selection);
    }

    public void Z2D_Reports_Open_Supplier_Report() {
        ElementActions.click(driver, Conflict_Minerals_Tab);
        ElementActions.click(driver, Supplier_Report_Button);
    }

    public void Z2D_Reports_Open_Compliance_MPN_Report() {
        ElementActions.click(driver, Conflict_Minerals_Tab);
        ElementActions.click(driver, Compliance_By_MPN_Report_Button);
    }

    public void Z2D_Reports_Open_Minerals_Metal_Report() {
        ElementActions.click(driver, Conflict_Minerals_Tab);
        ElementActions.click(driver, Minerals_Metal_Report_Button);
    }

    public void Z2D_Reports_Click_on_2nd_Filter() {
        ElementActions.click(driver, Reports_Second_Filter);
    }
    public void Z2D_Reports_Second_Filter_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, Reports_Second_Filter, 5, true);
    }
    public void Z2D_Reports_Third_Filter_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, Reports_Third_Filter, 5, true);
    }
    public void Z2D_Reports_Fourth_Filter_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, Reports_Fourth_Filter, 5, true);
    }


    public void Z2D_Reports_Click_on_3rd_Filter() {
        ElementActions.click(driver, Reports_Third_Filter);
    }

    public void Z2D_Reports_Click_on_4th_Filter() {
        ElementActions.click(driver, Reports_Fourth_Filter);
    }

    public void Z2D_Reports_Click_on_Saved_Reports_List() {
        ElementActions.click(driver,DDL_Report);
    }

    public void Z2D_Reports_Re_Click_on_Saved_Reports_List() {
        ElementActions.keyPress(driver, DDL_Report, Keys.ESC);
        ElementActions.click(driver,DDL_Report);
    }


    public void Z2D_Reports_Open_list() {
        ElementActions.click(driver, Report_List);
    }

    public void Z2D_Reports_Delete_Report() {
        ElementActions.click(driver, DeleteReport);
    }

    public void Z2D_Reports_CustomReport() {
        ElementActions.click(driver, CusReport);
    }

    public void Z2D_Reports_Open_Conflict_Minerals() {
        ElementActions.click(driver, ConflictMinerals);
    }

    public void Z2D_Reports_Open_Con_Metals() {
        ElementActions.click(driver, ConflictMetals);
    }

    public void Wait_Text_To_be(WebElement element, String Text) {
        WebDriverWait Wait = new WebDriverWait(driver, 100);
        Wait.until(ExpectedConditions.textToBePresentInElement(element, Text));
    }
}

