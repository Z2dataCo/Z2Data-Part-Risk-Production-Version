package SE_Page;

import Utilities_Main.Constants_Main;
import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PCN_Manager_Page {

    private final WebDriver driver;
    private ExcelFileManager Variables;
    public PCN_Manager_Page(WebDriver driver) {
        this.driver = driver;
    }

    public String Total_Results = "Showing 1-21 of";

    public By Dashboard_Tab_Total_PCNs = By.xpath("//body/div[@id='main_start_page']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h1[1]");
    public By Dashboard_Tab_Requires_Action = By.xpath("//body/div[@id='main_start_page']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/h1[1]");
    public By Dashboard_Tab_In_Progress = By.xpath("//body/div[@id='main_start_page']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/h1[1]");
    public By Dashboard_Tab_Completed = By.xpath("//body/div[@id='main_start_page']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/h1[1]");
    public By Inbox_Tab = By.xpath("//body/div[@id='main_start_page']/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]");
    public By Inbox_Tab_Filter_Table = By.xpath("//*[@id=\"DivInBoxFilterPCN\"]/div[1]/div[2]");
    public By PCNs_Tab = By.xpath("//body/div[@id='main_start_page']/div[1]/div[2]/div[1]/div[1]/ul[1]/li[3]/a[1]");
    public By PCNs_Tab_Filter_Table = By.xpath("//*[@id=\"DivPcnsTabFilterPCN\"]/div[1]/div[2]");
    public By PCNs_Select_First_PCN_Notification = By.xpath("//*[@id=\"3760\"]/td[1]");
    public By PCNs_First_PCN_Notification_PCN_ID = By.xpath("//td[contains(text(),'Z2 PCN_ID')]");
    public By PCNs_Notification_Back = By.xpath("/html[1]/body[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h4[1]/a[1]");
    public By Impacted_Parts_Tab = By.xpath("//a[contains(text(),'Impacted Parts')]");
    public By Impacted_Parts_Tab_Filter_Table = By.xpath("//*[@id=\"DivAlertsFilterPCN\"]/div[1]/div[2]/div[1]/div");
    public By Search_Field = By.id("PCNSearchText");
    public By Search_button = By.xpath("//*[@id=\"DivPcnsTabFilterPCN\"]/div[3]/div/div/span/a");
    public By Results_Table = By.id("tblPagePCN");
    public By First_Search_Result = By.xpath("//table[@id='tblPagePCN']/tbody/tr[1]/td[4]/div[1]/span");
    public By Showing_Of_Total = By.xpath("//div[@id=\"PCNManagerPCNTab\"]/div[2]/div[1]/div[1]/div/span[1]");
    public By Impacted_MPN_Results = By.xpath("//a[normalize-space()='FSP012-FHEN2']");
    public By FSP_Text = By.xpath("//*[@id=\"PCNManagerPCNTab\"]/div[3]/div/div/div/div[1]/div/div[2]/h4/span[2]");
    public By Z2Data_Spinner_1 = By.id("progressDiv");
    // Impacted Parts
    public By Search_Btn = By.xpath("//body/div[@id='main_start_page']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/a[1]");
    public By Supplier_CheckBox = By.xpath("//*[@id=\"DivAlertsFilterPCN\"]/div[1]/div[2]/div[1]/div/table/tbody/tr/td[4]/div/fieldset[1]/div/label/span/span");


    public void Z2D_Wait_Disappear_Z2Data_Spinner_0() throws InterruptedException {
        int count = 0;
        while ((driver.findElements(By.xpath("//*[@id=\"progressDiv\"]/div/div/div[2]")).size() != 0 && count < 40)) {
            count++;
        }
    }

    public void Z2D_Wait_Invisibility_Of_Z2Data_Spinner_1() {
        WebDriverWait Wait = new WebDriverWait(driver, 100);
        Wait.until(ExpectedConditions.invisibilityOf(driver.findElement(Z2Data_Spinner_1)));
    }

    public void Z2D_Open_Inbox_Tab() {
        ElementActions.click(driver, Inbox_Tab);
    }

    public void Z2D_Open_PCNs_Tab() {
        ElementActions.click(driver, PCNs_Tab);
    }

    public void Z2D_Back_from_PCN_Notification() {
        ElementActions.click(driver, PCNs_Notification_Back);
    }

    public void Z2D_Open_Impacted_Parts_Tab() {
        ElementActions.click(driver, Impacted_Parts_Tab);
        boolean Intercepted = true;
        while (Intercepted) {
            try {
                ElementActions.click(driver, Impacted_Parts_Tab);
                Intercepted = false;
            } catch (ElementNotInteractableException e) {
                Intercepted = true;
            }
        }
    }

    public void Z2D_PCNs_First_PCN_Notification() {
        ElementActions.click(driver, PCNs_Select_First_PCN_Notification);
    }

    public void Z2D_Open_First_Search_Result() {
        ElementActions.click(driver, First_Search_Result);
    }

    public void Z2D_Search_PCN_ID(String Environment) {
        if (Environment.equalsIgnoreCase("Production")) {
            Variables = new ExcelFileManager(Constants_Main.Prod_Data_Path);
            ElementActions.type(driver, Search_Field, Variables.getCellData("PCN_ID", "Value"));
        }
        else {
            Variables = new ExcelFileManager(Constants_Main.Test_Data_Path);
            ElementActions.type(driver, Search_Field, Variables.getCellData("PCN_ID", "Value"));
        }
            ElementActions.click(driver, Search_button);
    }



    public void Z2D_Search_MPN_ID(String Environment) {
        if (Environment.equalsIgnoreCase("Production")) {
            Variables = new ExcelFileManager(Constants_Main.Prod_Data_Path);
            ElementActions.type(driver, Search_Field, Variables.getCellData("MPN_ID", "Value"));
        }
        else {
            Variables = new ExcelFileManager(Constants_Main.Test_Data_Path);
            ElementActions.type(driver, Search_Field, Variables.getCellData("MPN_ID", "Value"));
        }
        ElementActions.click(driver, Search_button);
    }

    public void Z2D_Dashboard_Tab_Total_PCNs_Visibility() {
        ElementActions.waitForElementToBePresent(driver, Dashboard_Tab_Total_PCNs, 5, true);
    }
    // Impacted Parts Methods
    public void Z2D_Select_Supplier() {
        ElementActions.click(driver, Supplier_CheckBox);
    }

    public String Impacted_MPN_Data() {
        return  driver.findElement(Impacted_MPN_Results).getText();
        }

    public String Search_Result(){ return driver.findElement(First_Search_Result).getText(); }
}



