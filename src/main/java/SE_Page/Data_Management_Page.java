package SE_Page;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class Data_Management_Page {

    public JavascriptExecutor jse;
    Actions action;
    private final WebDriver driver;
    public void Scroll_To_Bottom() {
        jse.executeScript("scrollBy(0,2500)");
    }
    public void Scroll_To_Middle() {
        jse.executeScript("window.scrollBy(0,2000)");
    }
    public Data_Management_Page(WebDriver driver) {
        this.driver = driver;
    }
    public String ForeCast_URL = "https://parts.z2data.com/RiskManager/Forecast?BomId=119090";
    public String Compliance_URL = "https://parts.z2data.com/RiskManager/Compliance?BomId=119090";
    public String Mitigation_URL = "https://parts.z2data.com/RiskManager/Mitigation?BomId=119090";
    public String Reports_URL = "https://parts.z2data.com/RiskManager/Report?BomId=119090";
    public String Scrub_URL = "https://parts.z2data.com/RiskManager/Scrub?BomId=119090";
    public String Prod_URL = "https://parts.z2data.com/RiskManager?BomId=119090";

    public By Data_Management_Tab = By.xpath("//a[contains(text(),'Data Management')]");
    public By Verification = By.xpath("//*[@id=\"z2page-head-bar\"]/div/h1/span/span");
    public By Verify_BOMs = By.xpath("//*[@id=\"z2-2cols-leftpanel\"]/ul/li/a[1]/div[2]");
    public By Verify_AVL = By.xpath("//*[@id=\"z2-2cols-leftpanel\"]/ul/li/a[2]/div[2]");
    public By Part_Correction = By.xpath("//*[@id=\"z2-2cols-leftpanel\"]/ul/li/a[3]/div[2]");
    public By Data_Setting = By.xpath("//*[@id=\"z2-2cols-leftpanel\"]/ul/li/a[4]/div[2]");
    public By Table_Name = By.xpath("//div[@id='main_start_page']//th[2]");
    public By Table_User = By.xpath("//div[@id='main_start_page']//th[3]");
    public By Table_Of_file = By.xpath("//div[@id='main_start_page']//th[4]");
    public By Table_Of_Parts = By.xpath("//div[@id='main_start_page']//th[5]");
    public By Table_Of_Supplier = By.xpath("//body//th[6]");
    public By Table_Data_Created = By.xpath("//body//th[7]");
    public By Table_Action = By.xpath("//body//th[8]");
    public By Folder_Name = By.xpath("//*[@id=\"reportToHide\"]/div[2]/div[2]/div[3]/table/tbody/tr[4]/td[2]/a");
    public By Upload_BOM_Folder = By.xpath("//div[@id='reportToHide']//div//div//div//div//app-uploadbom//a");
    public By My_Folder = By.xpath("//*[@id=\"reportToHide\"]/div[2]/div[2]/div[3]/table/tbody/tr[8]/td[2]/a");
    public By My_BOM = By.xpath(" //*[@id=\"reportToHide\"]/div[2]/div[3]/app-subfolders-boms/div[1]/table/tbody/tr[16]/td[2]/a[1]");
    public By of_Suppliers = By.xpath("//*[@id=\"reportToHide\"]/div[2]/div[2]/div[3]/table/thead/tr/th[6]");
    public By Search_Text_Input = By.cssSelector("#divSearchFolders > input");
    public By Folder_Name_Input = By.xpath("//body[1]/div[9]/div[1]/div[1]/div[2]/form[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]");
    public By Test_Folder = By.xpath("//*[@id=\"divSearchFolders\"]/div/ul/li[2]/a");
    public By Graph = By.xpath("//div//div[@class='z2-scorecard-each bg-white pt-05 cursornormal'][1]");
    public By Create_Folder = By.xpath("//*[@id=\"DMCreatefolder\"]/span/span");
    public By Search_Btn = By.id("FolderAutoCompleteSearch");
    public By Search_Result = By.xpath("//*[@id='divSearchFolders']//li[2]/a");
    public By Select_BOM = By.xpath("//tbody/tr[2]//td[2]/a[1]");
    public By Select_Proud_Test_BOM = By.xpath("//a[contains(text(),'TAP_BOM_Proud_Test')]");
    public By Parts_Btn = By.xpath("//a[contains(text(),'Parts')]");
    public By Create_Folder_Btn = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/form/button");
    public By BOM_Folder = By.xpath("//tbody/tr[20]/td[2]/a[1]");
    public By BOM = By.xpath("//tbody/tr[1]/td[2]/a[1]");
    public By BOM_Prod_Test = By.partialLinkText("TAP_BOM_Proud_Te");
    public By Forecast = By.linkText("Forecast");
    public By Mitigation = By.linkText("Mitigation");
    public By Scrub = By.linkText("Scrub");
    public By Spinner2 = By.xpath("//*[@id=\"RemainMainPage\"]/app-risk-manager/app-risk-parts/app-riskpartsmpn/ngx-loading/div/div[2]/div");
    public By Next_Page = By.xpath("//*[@id=\"scrub_content\"]/div/div[2]/div[2]/app-z2pagination/div/div/div/div/pagination/ul/li[5]/a");
    public By Next_Btn = By.linkText("Next");
    public By is_Row = By.xpath("//*[@class='table-responsive']//tbody/tr[1]/td[2]/a");
    public By Delete = By.xpath("//*[@id=\"reportToHide\"]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[8]/div/app-datamanagement-boms-popups/div[1]/a[2]");
    public By Yes_Delete = By.xpath("/html/body/modal-container/div/div/div/button[1]");
    //public List<WebElement> Spinner = driver.findElements(By.xpath("//*[@id=\"RemainMainPage\"]/app-risk-manager/app-risk-parts/app-riskpartsmpn/ngx-loading/div/div[2]/div"));

    public void Z2D_Wait_Disappear_Z2Data_Spinner_0() throws InterruptedException {
        int count = 0;
        while ((driver.findElements(By.xpath("//*[@id=\"RemainMainPage\"]/app-risk-manager/app-risk-parts/app-riskpartsmpn/ngx-loading/div/div[2]/div"))).size() != 0 && count < 40) {
            Thread.sleep(700);
            count++;
        }
    }

    public void Z2D_Open_Data_Management() {
        ElementActions.click(driver, Data_Management_Tab);
        ElementActions.waitForElementToBePresent(driver, Table_Name, 5, true);
        ElementActions.isElementClickable(driver, Table_Name);
    }

    public void Z2D_Open_Folders() {
        ElementActions.click(driver, Folder_Name);
    }

    public void Z2D_Open_My_Folder() {
        ElementActions.click(driver, My_Folder);
    }

    public void Z2D_Open_My_BOM() {
        ElementActions.click(driver, My_BOM);
    }

    public void Z2D_Create_Folder() {
        ElementActions.click(driver, Create_Folder);
    }

    public void Z2D_Submit_Folder() {
        ElementActions.click(driver, Create_Folder_Btn);
    }

    public void Z2D_Folder_Name(String name) {
        ElementActions.type(driver, Folder_Name_Input, name);
    }

    public void Z2D_Open_BOM_Folder() {
        ElementActions.click(driver, BOM_Folder);
    }

    public void Z2D_Open_BOM() {
        ElementActions.click(driver, Select_BOM);
    }

    public void Z2D_Type_Folder_Name() {
        ElementActions.type(driver, Search_Text_Input, "TAP_BOM");
    }

    public void Z2D_Select_Folder()  {
        ElementActions.click(driver, Search_Result);
    }

    public void Z2D_Delete_BOM() {
        ElementActions.click(driver, Delete);
    }

    public void Z2D_Delete_Confirmation() {
        ElementActions.click(driver, Yes_Delete);
    }

    public void Z2D_Click_on_BOM_File() {
        ElementActions.click(driver, Select_BOM);
    }

    public void Z2D_Click_on_Parts() {
        ElementActions.click(driver, Parts_Btn);
    }


    public void Z2D_Search( ) {
        ElementActions.type(driver, Search_Text_Input, "TAP_BOM");
    }

    public void NextPagination() {
        ElementActions.click(driver, Next_Btn);
    }

    public void Bom_Pro() {
        ElementActions.click(driver, BOM_Prod_Test);
    }

    public void Z2D_Click_on_BOM() {
        ElementActions.click(driver, Select_Proud_Test_BOM);
    }

    public void Z2D_Move_To_Prod_BOM( ) {
        driver.get(Prod_URL);
    }

    public void Z2D_Move_to_Mitigation_BOM( )   {
        driver.get(Mitigation_URL);
    }

    public void Z2D_Move_to_Forecast_BOM( )   {
        driver.get(ForeCast_URL);
    }

    public void Z2D_Move_to_Compliance_BOM( )   {
        driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
        driver.get(Compliance_URL);
        WebDriverWait WebWait = new WebDriverWait(driver, 90);
        WebWait.until(ExpectedConditions.titleIs("Part Risk | Z2DATA"));
    }

    public void Z2D_Move_to_Reports_BOM( )   {
        driver.get(Reports_URL);
    }

    public void Z2D_Move_to_Scrub_BOM( )   {
        driver.get(Scrub_URL);
    }

    public void SetFile() {
        ElementActions.click(driver, Test_Folder);
    }

    public void SetSearchValue() {
        ElementActions.click(driver, Search_Result);
    }


}
