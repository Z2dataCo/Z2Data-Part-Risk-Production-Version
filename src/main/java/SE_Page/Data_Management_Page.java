package SE_Page;

import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;


public class Data_Management_Page {

    public JavascriptExecutor jse;
    private final WebDriver driver ;
    private ExcelFileManager Variables;



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
    public By Table_Name = By.xpath("//div[@id='main_start_page']//th[2]");
    public By Table_User = By.xpath("//div[@id='main_start_page']//th[3]");
    public By Table_Of_file = By.xpath("//div[@id='main_start_page']//th[4]");
    public By Table_Data_Created = By.xpath("//body//th[7]");
    public By Table_Action = By.xpath("//body//th[8]");
    public By Folder_Name = By.xpath("//*[@id=\"reportToHide\"]/div[2]/div[2]/div[3]/table/tbody/tr[4]/td[2]/a");
    public By My_Folder = By.xpath("//*[@id=\"reportToHide\"]/div[2]/div[2]/div[3]/table/tbody/tr[8]/td[2]/a");
    public By My_BOM = By.xpath(" //*[@id=\"reportToHide\"]/div[2]/div[3]/app-subfolders-boms/div[1]/table/tbody/tr[16]/td[2]/a[1]");
    public By of_Suppliers = By.xpath("//*[@id=\"reportToHide\"]/div[2]/div[2]/div[3]/table/thead/tr/th[6]");
    public By Search_Text_Input = By.cssSelector("#divSearchFolders > input");
    public By Folder_Name_Input = By.xpath("//body[1]/div[9]/div[1]/div[1]/div[2]/form[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]");
    public By Test_Folder = By.xpath("//*[@id=\"divSearchFolders\"]/div/ul/li[2]/a");
    public By Create_Folder = By.xpath("//*[@id=\"DMCreatefolder\"]/span/span");
    public By Search_Result = By.xpath("//*[@id='divSearchFolders']//li[2]/a");
    public By Select_BOM = By.xpath("//tbody/tr[2]//td[2]/a[1]");
    public By Select_Proud_Test_BOM = By.xpath("//a[contains(text(),'TAP_BOM_Proud_Test')]");
    public By Parts_Btn = By.xpath("//a[contains(text(),'Parts')]");
    public By Create_Folder_Btn = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/form/button");
    public By BOM_Folder = By.xpath("//tbody/tr[20]/td[2]/a[1]");
    public By BOM_Prod_Test = By.partialLinkText("TAP_BOM_Proud_Te");
    public By Next_Btn = By.linkText("Next");
    public By is_Row = By.xpath("//*[@class='table-responsive']//tbody/tr[1]/td[2]/a");
    public By Delete = By.xpath("//*[@id=\"reportToHide\"]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[8]/div/app-datamanagement-boms-popups/div[1]/a[2]");
    public By Yes_Delete = By.xpath("/html/body/modal-container/div/div/div/button[1]");

    //Delete BOM Elements
    public By Yes_Button = By.xpath("/html/body/modal-container/div/div/div/button[1]");
    public By Showing_of_Status = By.xpath("//div[@class='actionbar-right mr-1']//span[2]");
    public By Total_Results_Shown = By.xpath("//div[@class='actionbar-right mr-1']//span[2]");
    public By Creat_Sub_Folder_Button = By.xpath("//span[contains(text(),'Create Sub Folder')]");
    public By Table_Body = By.xpath("//table[@class='table table-bordered table-striped bg-white mt-05 mb-0']/tbody");
    int i = 2;


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
    public void Z2D_Search_Text_Input_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, Search_Text_Input, 5, true);
    }
    public void Z2D_Table_Body_to_be_Visibility() {
        ElementActions.waitForElementToBePresent(driver, Table_Body, 5, true);
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

    public void Z2D_Select_Folder() {
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


    public void Z2D_Search() {
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

    public void Z2D_Move_To_Prod_BOM(String Environment) {
        if (Environment.equalsIgnoreCase("Production")) {
            Variables = new ExcelFileManager("D:\\IdeaProjects\\Z2Data-Part-Risk-Production-Version\\src\\test\\resources\\PartRiskTestData\\ProdEnv_Parameters.xlsx"); }
        else{
            Variables = new ExcelFileManager("D:\\IdeaProjects\\Z2Data-Part-Risk-Production-Version\\src\\test\\resources\\PartRiskTestData\\TestEnv_Parameters.xlsx"); }
        driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
        driver.get(Variables.getCellData("Pom_Dashboard_URL","Value"));
    }

    public void Z2D_Move_to_Mitigation_BOM() {
        driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
        driver.get(Mitigation_URL);
    }

    public void Z2D_Move_to_Forecast_BOM() {
        driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
        driver.get(ForeCast_URL);
    }

    public void Z2D_Move_to_Compliance_BOM() {
        driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
        driver.get(Compliance_URL);
        WebDriverWait WebWait = new WebDriverWait(driver, 90);
        WebWait.until(ExpectedConditions.titleIs("Part Risk | Z2DATA"));
    }

    public void Z2D_Move_to_Reports_BOM() {
        driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
        driver.get(Reports_URL);
    }

    public void Z2D_Move_to_Scrub_BOM() {
        driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
        driver.get(Scrub_URL);
    }

    public void SetFile() {
        ElementActions.waitForElementToBePresent(driver,Test_Folder,5,true);
        ElementActions.click(driver, Test_Folder);
    }

    public void SetSearchValue() {
        ElementActions.click(driver, Search_Result);
    }

//Delete BOM Methods

    public void Z2D_Click_on_Check_Box() {
        ElementActions.click(driver, Showing_of_Status);
    }

    public void Z2D_Deleting_BOMs( ) throws InterruptedException {

        while (!(driver.findElement(By.xpath("//div[@class='actionbar-right mr-1']//span[2]")).getText()).equals("1")) {
            System.out.println("Looping Here1");
            System.out.println((driver.findElement(Total_Results_Shown).getText()));
            while (!driver.findElement(By.xpath("//table[@class='table table-bordered table-striped bg-white mt-05 mb-0']/tbody/tr[" + i + "]/td[2]/a[1]")).getText().equals("TAP_BOM_Proud_Test")) {
                if (driver.getPageSource().contains(" My folder2")) {
                    String Button_Label = driver.findElement(Creat_Sub_Folder_Button).getText();
                    Assert.assertEquals("Create Sub Folder", Button_Label);
                    System.out.println("Looping Here2");
                    System.out.println((driver.findElement(By.xpath("//table[@class='table table-bordered table-striped bg-white mt-05 mb-0']/tbody/tr[" + i + "]/td[2]/a[1]")).getText()));
                    boolean staleElement2 = true;
                    while (staleElement2) {
                        System.out.println("Looping Here2-1");
                        try {
                            driver.findElement(By.xpath("//tbody//tr[" + i + "]//a[contains(text(),'Delete')]")).click();
                            staleElement2 = false;
                        } catch (StaleElementReferenceException e) {
                            staleElement2 = true;
                        }
                    }
                    Thread.sleep(2000);
                    ElementActions.hoverAndClick(driver, Yes_Button, Yes_Button);
                    Thread.sleep(4000);
                } else {
                    System.out.println("Page has been Reloaded and redirected to Folder Page");
                }
            }
            System.out.println("Looping Here3");
            Thread.sleep(2000);
            i++;
        }

    }


}
