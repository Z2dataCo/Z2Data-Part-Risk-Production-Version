package SE_Page;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Landing_Page {
    private WebDriver driver;
    public JavascriptExecutor jse;

    public Landing_Page(WebDriver driver) {
        this.driver = driver;
    }

    public By Z2data_Logo_1 = By.xpath("//body/div[2]/div[1]/a[1]");
    public By Z2data_Logo_2 = By.xpath("/html/body/div[1]/div[1]/span");
    public By Verification_MSG = By.xpath("//*[@id=\"tblPartData\"]/tr/td[3]/a");
    public By Upload_BOM_Btn = By.id("UploadBOMTrigger");
    public By Part_Name = By.xpath("//*[@id=\"z2page-head-bar\"]/div/h1/span/span");
    public By Search_Input = By.id("txtMainBarSearch");
    public By Data_Management_Tab = By.linkText("Data Management");
    public By Value = By.xpath("//*[@id=\"ui-id-3\"]");
    public By IPN_Value = By.xpath("/html[1]/body[1]/ul[2]/li[2]/a[1]");
    public By Supp_ChkBox = By.xpath("//*[@id=\"z2parametric-all\"]/div/div[2]/div[2]/div[1]/label/span[1]");
    public By SpinnerZezo = By.id("progressDiv");
    public By MY_Account = By.xpath("//div//div[@class='usericon']");
    public By Logout = By.xpath("//body/div[@id='dropbg']/div[1]/div[2]/div[2]/a[3]/span[1]");
    public By DDL_Type_Of_Search = By.xpath("//*[@id=\"main-search-bar\"]/div[1]");
    public By Part_Number = By.xpath("//div[@id='dropbg']//a[contains(text(),'Part Number')]");
    public By Search_Btn = By.xpath("//button[@id='btnautoSearch']");
    public By Parametric_Menu = By.xpath("/html/body/div[3]/div[1]/ul/li[1]/a");
    public By Product = By.xpath("/html/body/div[3]/div[1]/ul/li[1]/div/div/div[1]/ul/li[1]/a");
    public By SupElement = By.xpath("//*[@id=\"ca1_Semiconductors\"]/ul/li[1]/ul/li/div[1]/div/div/a");
    public By Adv_Crosses_Value = By.xpath("//*[@id=\"scopeOptionDiv\"]/ul/li[6]/a");
    public By IPN = By.xpath("//*[@id=\"scopeOptionDiv\"]/ul/li[2]/a");
    public By Compare_Tab = By.linkText("Compare");
    public By More_Tab = By.xpath("//a[contains(text(),'More')]");
    public By Suppliers = By.xpath("//a[contains(text(),'Suppliers')]");
    public By PCN_Manager_Tab = By.linkText("PCN Manager");
    public By btn_search = By.xpath("//*[@id=\"btnautoSearch\"]/i");
    public By Remove_File = By.xpath("//a[contains(text(),'Remove file')]");

    //public List<WebElement> GeneralSpinner = driver.findElement(By.xpath("//*[@id=\"progressDiv\"]/div/div/div[2]"));
    //public List<WebElement> SpinnerZezo2 =
    public void Z2D_is_Clickable_of_Adv_Crosses_Value(){
        ElementActions.waitForElementToBePresent(driver, Adv_Crosses_Value,5,true);
    }
    public void Z2D_Wait_General_Spinner_Disappear( ) throws InterruptedException {
        int count = 0;
        while ((driver.findElements(By.xpath("//*[@id=\"progressDiv\"]/div/div/div[2]")).size() != 0 && count < 40)) {
            Thread.sleep(700);
            count++;
        }
    }
    public void Z2D_Wait_Invisibility_Of_Spinner_Zezo_1() {
        WebDriverWait Wait = new WebDriverWait(driver, 100);
        Wait.until(ExpectedConditions.invisibilityOf(driver.findElement(SpinnerZezo)));
    }
    public void Z2D_Wait_Invisibility_Of_Spinner_Zezo_2() {
        WebDriverWait Wait = new WebDriverWait(driver, 100);
        Wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//div[@id='dropbg']//div[@style='border-radius: 3px; background-color: rgba(0, 18, 59, 0.6);']"))));
    }

    public void Z2D_Upload_BOM(String Z2DataFilePath) throws AWTException {
        ElementActions.click(driver, Upload_BOM_Btn);
        StringSelection strSelection = new StringSelection(Z2DataFilePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(strSelection, null);
        Robot robot = new Robot();
        robot.delay(300);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(200);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    public void Z2D_Return_To_Landing_Page() {
        ElementActions.click(driver, Z2data_Logo_1);
    }

    public void Z2D_Return_landing_Page() {
        ElementActions.click(driver, Z2data_Logo_2);
    }

    public void Z2D_Select_Part_Number(String SearchValue) {
        ElementActions.click(driver, DDL_Type_Of_Search);
        ElementActions.click(driver, Part_Number);
        ElementActions.type(driver, Search_Input, SearchValue);
        ElementActions.click(driver, Search_Btn);
    }

    public void Z2D_input_Search( ) {
        ElementActions.type(driver, Search_Input, "bav");
    }

    public void Search_using_Parametric() {
        ElementActions.click(driver, Parametric_Menu);
        ElementActions.click(driver, Product);
        ElementActions.click(driver, SupElement);
    }

    public void Z2D_Open_Data_Management() {
        ElementActions.click(driver, Data_Management_Tab);
    }

    public void Z2D_Open_DDL_Menu() {
        ElementActions.click(driver, DDL_Type_Of_Search);
    }

    public void Z2D_Adv_Crosses() {
        ElementActions.click(driver, Adv_Crosses_Value);
    }

    public void Z2D_Adv_Product() {
        ElementActions.click(driver, Value);
    }

    public void Z2D_IPN_DDL() {
        ElementActions.click(driver, IPN);
    }

    public void Z2D_IPN_Value() {
        ElementActions.click(driver, IPN_Value);
    }

    public void Z2D_Open_Compare_Page() {
        ElementActions.click(driver, Compare_Tab);
    }

    public void Z2D_More_Menu() {
        ElementActions.click(driver, More_Tab);
    }

    public void Z2D_Select_Supplier() {
        ElementActions.click(driver, Suppliers);
    }

    public void Z2D_Open_PCN_Manager() {
        ElementActions.click(driver, PCN_Manager_Tab);
    }

    public void Z2D_Check_Supplier() {
        ElementActions.click(driver, Supp_ChkBox);
    }

    public void Z2D_Click_Search() {
        ElementActions.click(driver, btn_search);
    }

    public void Z2D_Click_My_Account() {
        ElementActions.click(driver, MY_Account);
    }

    public void Z2D_Logout() {
        ElementActions.click(driver, Logout);
    }




}