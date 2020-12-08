package SE_Page;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Obsolescence_Page {

    private WebDriver driver;
    public JavascriptExecutor jse;
    public Obsolescence_Page(WebDriver driver) {
        this.driver = driver;
    }

    public By High_LifeCycle_Risk = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div[1]");
    public By NRND_Parts = By.cssSelector("#dropbg > div > div > div.sidepanel-content.mt-1 > div.z2-scorecard.scorecard-parts.d-flex.align-items-start > div.z2-scorecard-each.risk-red.max-width-200.filterinScrub.NRND");
    public By Obsolete_Parts = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div[3]");
    public By Last_Buy_Parts = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div[4]");
    public By Last = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/div[2]/div[2]/app-z2pagination/div/div/div/div/pagination/ul/li[9]/a");
    public By Next_Page = By.xpath("//div[@id='dropbg']//li[@class='pagination-next page-item disabled']/preceding-sibling::li[position()<2]");
    public By Fixed_Number = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/div[2]/div[2]/app-z2pagination/span/span[2]");
    public By LastPage_3Y = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/div/div[1]/div[2]/app-z2pagination/div/div/div/div/pagination/ul/li[9]/a");
    public By LastPage_5Y = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div[2]/app-z2pagination/div/div/div/div/pagination/ul/li[9]/a");
    public By Fixed_Number_For_3Y = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/div/div[1]/div[2]/app-z2pagination/span/span[2]");
    public By Close_Slide = By.xpath("//*[@id=\"dropbg\"]/div/div/div[1]/div[2]/i");
    public By Fixed_Number_For_5Y = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div[2]/app-z2pagination/span/span[2]");
    public By All_Obsolescence = By.linkText("All Obsolescence PCNs");
    public By Product_Change_Notices = By.xpath("//*[@id=\"z2-2cols-leftpanel\"]/ul/li[6]/a/div[2]");
    public By Last_Page_All_Obs = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/div/div[2]/app-z2pagination/div/div/div/div/pagination/ul/li[9] ");
    public By Fixed_Number_for_All_Obs = By.xpath("//*[@id=\"dropbg\"]/div/div/div[2]/div/div[2]/app-z2pagination/span/span[2]");
    public List<WebElement> Table_Size = driver.findElements(By.xpath("//table/tbody/tr"));
    public List<WebElement> New_Data = driver.findElements(By.xpath("c"));

    public void Z2D_Open_High_LifeCycle() {
        ElementActions.click(driver, High_LifeCycle_Risk);
    }

    public void Z2D_NRND_Parts() {
        ElementActions.click(driver, NRND_Parts);
    }

    public void Z2D_Obsolete_Parts() {
        ElementActions.click(driver, Obsolete_Parts);
    }

    public void Z2D_Last_by_Parts() {
        ElementActions.click(driver, Last_Buy_Parts);
    }

    public void Z2D_Get_Last_Page() {
        ElementActions.click(driver, Last);
    }

    public void Z2D_Get_Last_Page_For_3Y() {
        ElementActions.click(driver, LastPage_3Y);
    }

    public void Z2D_Close_Slide() {
        ElementActions.click(driver, Close_Slide);
    }
    public void Z2D_Close_Slide_Visibility() {
        ElementActions.waitForElementToBePresent(driver, Close_Slide, 5, true);
    }

    public void Z2D_Get_Last_Page_For_5Y() {
        ElementActions.click(driver, LastPage_5Y);
    }

    public void Z2D_All_Obsolescence() {
        ElementActions.click(driver, All_Obsolescence);
    }

    public void Z2D_Product_Change() {
        ElementActions.click(driver, Product_Change_Notices);
    }

    public void Z2D_Get_Last_Page_for_All_Obs() {
        ElementActions.click(driver, Last_Page_All_Obs);
    }

    public void Z2D_Table_of_Data(WebDriver driver) {
        for (int i = 1; i <= New_Data.size(); i++) {
            System.out.println(New_Data);
            String Data = driver.findElement(By.xpath("//table[@class='z2tableM table hoverrows table-bordered table-middle bigtitle text-left']/tbody/tr[" + i + "]/td[3]")).getText();
            Assert.assertTrue(Data.contains("Obsolescence"));
        }
    }
}