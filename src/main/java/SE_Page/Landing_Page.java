package SE_Page;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
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
    public By Supplier_Check_Box = By.xpath("//*[@id='DivPartDataFilter']//*[@id=\"z2parametric-all\"]/div/div[2]/div[2]/div[1]");
    public By SpinnerZezo = By.id("progressDiv");
    public By MY_Account = By.xpath("//div//div[@class='usericon']");
    public By Logout = By.xpath("//body/div[@id='dropbg']/div[1]/div[2]/div[2]/a[3]/span[1]");
    public By Landing_Search_Menu = By.xpath("//*[@id=\"main-search-bar\"]/div[1]");
    public By Part_Number = By.xpath("//div[@id='dropbg']//a[contains(text(),'Part Number')]");
    public By Search_Btn = By.xpath("//button[@id='btnautoSearch']");
    public By Parametric_Menu = By.xpath("/html/body/div[3]/div[1]/ul/li[1]/a");
    public By Product = By.xpath("/html/body/div[3]/div[1]/ul/li[1]/div/div/div[1]/ul/li[1]/a");
    public By SupElement = By.xpath("//*[@id=\"ca1_Semiconductors\"]/ul/li[1]/ul/li/div[1]/div/div/a");
    public By Adv_Crosses_Value = By.xpath("//div[@class='z2-searchbox-curcat dropcloned']//li[6]");
    public By IPN = By.xpath("//div[@id='dropbg']//a[@class='dropdown-item main-category'][normalize-space()='IPN']");
    public By Compare_Tab = By.linkText("Compare");
    public By More_Tab = By.xpath("//a[contains(text(),'More')]");
    public By Suppliers = By.xpath("//a[contains(text(),'Suppliers')]");
    public By PCN_Manager_Tab = By.linkText("PCN Manager");
    public By btn_search = By.xpath("//*[@id=\"btnautoSearch\"]/i");
    public By Remove_File = By.xpath("//a[contains(text(),'Remove file')]");
    // Advanced Crosses Elements
    public By Total = By.xpath("//*[@id=\"RemainMainPage\"]/adv-cross/div[1]/div/div[2]/div/div[1]/div");
    public By Drop_in = By.xpath("//*[@id=\"RemainMainPage\"]/adv-cross/div[1]/div/div[2]/div/div[2]/div/div");
    public By Drop_in_Same_Supplier = By.xpath("//*[@id=\"RemainMainPage\"]/adv-cross/div[1]/div/div[2]/div/div[3]/div/div/div[1]");
    public By Different_Input = By.xpath("//*[@id=\"RemainMainPage\"]/adv-cross/div[1]/div/div[2]/div/div[4]/div/div");
    public By Similar_Different_Package = By.xpath("//*[@id=\"RemainMainPage\"]/adv-cross/div[1]/div/div[2]/div/div[5]/div/div");

    public void Z2D_Adv_Crosses_Value_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, Adv_Crosses_Value, 5, true);
    }

    public void Z2D_Supplier_Check_Box_to_be_Clickable() {
        ElementActions.waitForElementToBePresent(driver, Supplier_Check_Box, 5, true);
    }

    public void Z2D_IPN_Value_Visibility() {
        ElementActions.waitForElementToBePresent(driver, IPN_Value, 5, true);
    }


    public void Z2D_Wait_Disappear_Z2Data_Spinner_0() throws InterruptedException {
        int count = 0;
        while ((driver.findElements(By.xpath("//*[@id=\"progressDiv\"]/div/div/div[2]")).size() != 0 && count < 40)) {
            Thread.sleep(700);
            count++;
        }
    }

    public void Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1() {
        WebDriverWait Wait = new WebDriverWait(driver, 100);
        Wait.until(ExpectedConditions.invisibilityOf(driver.findElement(SpinnerZezo)));
    }
    

    public void Z2D_Upload_BOM() throws AWTException {
        ElementActions.click(driver, Upload_BOM_Btn);
        StringSelection strSelection = new StringSelection(System.getProperty("user.dir") + "\\src\\test\\resources\\BOMs\\TABOM1.xlsx");
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
        ElementActions.click(driver, Landing_Search_Menu);
        ElementActions.click(driver, Part_Number);
        ElementActions.type(driver, Search_Input, SearchValue);
        ElementActions.click(driver, Search_Btn);
    }

    public void Z2D_Advanced_Crosses_Input_Search() {
        ElementActions.type(driver, Search_Input, "bav");
    }

    public void Z2D_Part_Number_Input_Search() {
        ElementActions.type(driver, Search_Input, "bav99");
    }

    public void Z2D_IPN_Input_Search() {
        ElementActions.type(driver, Search_Input, "0.9902785216");
    }

    public void Search_using_Parametric() {
        ElementActions.click(driver, Parametric_Menu);
        ElementActions.click(driver, Product);
        ElementActions.click(driver, SupElement);
    }

    public void Z2D_Open_Data_Management() {
        ElementActions.waitForElementToBePresent(driver,Data_Management_Tab,5,true);
        ElementActions.click(driver, Data_Management_Tab);
    }

    public void Z2D_Open_Landing_Search_Menu() {
        ElementActions.click(driver, Landing_Search_Menu);
    }

    public void Z2D_Adv_Crosses() {
        ElementActions.click(driver, Adv_Crosses_Value);
    }

    public void Z2D_Adv_Product() {
        ElementActions.waitForElementToBePresent(driver,Value,5,true);
        (driver.findElement(Value)).click();
        //ElementActions.click(driver, Value);
        WebDriverWait WebWait = new WebDriverWait(driver, 90);
        WebWait.until(ExpectedConditions.titleIs("Part Risk | Z2DATA"));
        ElementActions.waitForElementToBePresent(driver,Total,50,true);
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
        ElementActions.click(driver, Supplier_Check_Box);
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