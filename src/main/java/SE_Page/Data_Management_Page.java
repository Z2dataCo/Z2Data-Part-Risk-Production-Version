package SE_Page;

import com.shaft.gui.element.ElementActions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Data_Management_Page {
    private WebDriver driver;
    public JavascriptExecutor jse;

    public void Scroll_To_Bottom() {
        jse.executeScript("scrollBy(0,2500)");
    }
    public void Scroll_To_Middle() {
        jse.executeScript("window.scrollBy(0,2000)");
    }
    Actions action;

    public Data_Management_Page(WebDriver driver) {
        this.driver = driver;
    }

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
    public By Followed_Text = By.xpath("//*[@id=\"z2page-head-bar\"]/div/app-create-alert/button/span");
    public By Folder_Name_Input = By.xpath("//body[1]/div[9]/div[1]/div[1]/div[2]/form[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]");
    public By Test_Folder = By.xpath("//*[@id=\"divSearchFolders\"]/div/ul/li[2]/a");
    public By Graph = By.xpath("//div//div[@class='z2-scorecard-each bg-white pt-05 cursornormal'][1]");
    public By Create_Folder = By.xpath("//*[@id=\"DMCreatefolder\"]/span/span");
    public By Search_Btn = By.id("FolderAutoCompleteSearch");
    public By Search_Result = By.xpath("//*[@id='divSearchFolders']//li[2]/a");
    public By Select_BOM = By.xpath("//tbody/tr[2]//td[2]/a[1]");
    public By Select_Proud_Test_BOM = By.xpath("//a[contains(text(),'TAP_BOM_Proud_Test')]");
    public By Parts_Btn = By.xpath("//a[contains(text(),'Parts')]");
    public By Create_Alert_Btn = By.xpath("//div[@id='z2page-head-bar']/div//button/span[contains(text(),'Create Alert')]");
    public By LifeCycle_Btn = By.xpath("//div[@id='sidepanelCreateAlert']//span[contains(text(),'Lifecycle')]");
    public By Litigation_Btn = By.xpath("//div[@id='sidepanelCreateAlert']//span[contains(text(),'Litigation')]");
    public By Submit_Btn = By.xpath("//button[contains(text(),'Create Alert')]");
    public By Create_Folder_Btn = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/form/button");
    public By BOM_Folder = By.xpath("//tbody/tr[20]/td[2]/a[1]");
    public By BOM = By.xpath("//tbody/tr[1]/td[2]/a[1]");
    public By BOM_Prod_Test = By.partialLinkText("TAP_BOM_Proud_Te");
    public By Compliance_Tab = By.xpath("//a[contains(text(),'Compliance')]");
    public By Unfollow_Btn = By.xpath("//div[@id='z2page-head-bar']/div/app-create-alert/div[1]/a[2]");
    public By Parts = By.linkText("Parts");
    public By Forecast = By.linkText("Forecast");
    public By Mitigation = By.linkText("Mitigation");
    public By Scrub = By.linkText("Scrub");
    public By Spinner2 = By.xpath("//*[@id=\"RemainMainPage\"]/app-risk-manager/app-risk-parts/app-riskpartsmpn/ngx-loading/div/div[2]/div");
    public By Toast_Container = By.id("toast-container");
    public By Next_Page = By.xpath("//*[@id=\"scrub_content\"]/div/div[2]/div[2]/app-z2pagination/div/div/div/div/pagination/ul/li[5]/a");
    public By Next_Btn = By.linkText("Next");
    public By is_Row = By.xpath("//*[@class='table-responsive']//tbody/tr[1]/td[2]/a");
    public By Delete = By.xpath("//*[@id=\"reportToHide\"]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[8]/div/app-datamanagement-boms-popups/div[1]/a[2]");
    public By Yes_Delete = By.xpath("/html/body/modal-container/div/div/div/button[1]");
    //public List<WebElement> Spinner = driver.findElements(By.xpath("//*[@id=\"RemainMainPage\"]/app-risk-manager/app-risk-parts/app-riskpartsmpn/ngx-loading/div/div[2]/div"));
    //public List<WebElement> Table_Rows = driver.findElements(By.xpath("//*[@id=\"scrub_content\"]/div/table/tbody/tr"));

    public void Z2D_Wait_Invisibility_Of_Toast_Container() {
        WebDriverWait Wait = new WebDriverWait(driver, 100);
        Wait.until(ExpectedConditions.invisibilityOf(driver.findElement(Toast_Container)));
    }
    public void Z2D_Spinner_to_Disappear() throws InterruptedException {
        int count = 0;
        while ((driver.findElements(By.xpath("//*[@id=\"RemainMainPage\"]/app-risk-manager/app-risk-parts/app-riskpartsmpn/ngx-loading/div/div[2]/div"))).size() != 0 && count < 40) {
            Thread.sleep(700);
            count++;
        }
    }
    public void Z2D_Table_Rows() {
        driver.findElements(By.xpath("//*[@id=\"scrub_content\"]/div/table/tbody/tr")).size();
    }

    public void Z2D_Open_Data_Management() {
        ElementActions.click(driver,Data_Management_Tab);
        ElementActions.waitForElementToBePresent(driver, Table_Name, 5, true);
        ElementActions.isElementClickable(driver, Table_Name);
    }

    public void Z2D_Open_Scrub() {
        ElementActions.click(driver, Scrub);
    }

    public void Z2D_Open_Parts() {
        ElementActions.click(driver, Parts);
    }

    public void Z2D_Open_Forecast() {
        ElementActions.click(driver, Forecast);
    }

    public void Z2D_Open_Mitigation() {
        ElementActions.click(driver, Mitigation);
    }

    public void Z2D_Click_Search() {
        ElementActions.click(driver, Search_Btn);
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

    public void Z2D_Type_Folder_Name(String text) {
        ElementActions.type(driver, Search_Text_Input, text);
    }

    public void Z2D_Select_Folder() throws InterruptedException {
        Thread.sleep(2000);
        ElementActions.click(driver, Search_Result);
    }
    public void Z2D_is_Clickable_of_Followed_Text(){
        ElementActions.waitForElementToBePresent(driver, Followed_Text,5,true);
    }
    public void Z2D_is_Clickable_of_Unfollow_Btn(){
        ElementActions.waitForElementToBePresent(driver, Unfollow_Btn,5,true);
    }
    public void Z2D_is_Clickable_of_LifeCycle_Btn(){
        ElementActions.waitForElementToBePresent(driver, LifeCycle_Btn,5,true);
    }


    public void DeleteBom() {
        ElementActions.click(driver, Delete);
    }

    public void DeleteConfirmation() {
        ElementActions.click(driver, Yes_Delete);
    }

    public void Z2D_Click_on_BOM_File() {
        ElementActions.click(driver, Select_BOM);
    }

    public void Z2D_Click_on_Parts() {
        ElementActions.click(driver, Parts_Btn);
    }

    public void Z2D_Click_on_Create_Alert(WebDriver driver) {
        ElementActions.click(driver, Create_Alert_Btn);
    }

    public void Z2D_Click_on_LifeCycle() throws InterruptedException {
        while (!driver.findElement(LifeCycle_Btn).isSelected()) {
            ElementActions.click(driver, LifeCycle_Btn);
            Thread.sleep(200);
            break;
        }
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

    public void Z2D_Hover_to_Status(WebDriver driver) throws InterruptedException, IOException {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(2000);
        Scroll_To_Middle();
        TakesScreenshot Screenshot = (TakesScreenshot) driver;
        File scrFile = Screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/Screenshots/FirstScreenshot.png"));
        Thread.sleep(2000);
        action = new Actions(driver);
        action.moveByOffset(270, 488).perform();
        Thread.sleep(2000);
        action.click().build().perform();
    }

    public void Z2D_Click_on_Compliance_Tab() {
        ElementActions.click(driver, Compliance_Tab);
    }

    public void Z2D_Click_Followed_Btn() {
        ElementActions.click(driver, Followed_Text);
    }

    public void Z2D_Click_Unfollow_Btn() {
        ElementActions.click(driver, Unfollow_Btn);
    }

    public void Z2D_Search(String Value) {
        ElementActions.type(driver, Search_Text_Input, Value);
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

    public void Z2D_Move_To_Prod_BOM(WebDriver driver) {
        driver.get("https://parts.z2data.com/RiskManager?BomId=119090");
    }

    public void Z2D_Move_to_Mitigation_Bom(WebDriver driver) throws InterruptedException {
        driver.get("https://parts.z2data.com/RiskManager/Mitigation?BomId=119090");
    }

    public void Z2D_Move_to_Forecast_Bom(WebDriver driver) throws InterruptedException {
        driver.get("https://parts.z2data.com/RiskManager/Forecast?BomId=119090");
    }

    public void Z2D_Move_to_Compliance_Bom(WebDriver driver) throws InterruptedException {
        driver.get("https://parts.z2data.com/RiskManager/Compliance?BomId=119090");
    }

    public void Z2D_Move_to_Reports_Bom(WebDriver driver) throws InterruptedException {
        driver.get("https://parts.z2data.com/RiskManager/Report?BomId=119090");
    }

    public void Z2D_Move_to_Scrub_Bom(WebDriver driver) throws InterruptedException {
        driver.get("https://parts.z2data.com/RiskManager/Scrub?BomId=119090");
    }

    public void SetFile() {
        ElementActions.click(driver, Test_Folder);
    }

    public void SetSearchValue() {
        ElementActions.click(driver, Search_Result);
    }

    public void Z2D_Wait_Text_Not_To_be_Create_Alert(){
        ElementActions.waitForTextToChange(driver,Followed_Text,"Followed",5);

    }
}
