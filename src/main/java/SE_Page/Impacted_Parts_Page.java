package SE_Page;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Impacted_Parts_Page {
    private WebDriver driver;
    public JavascriptExecutor jse;
    public Impacted_Parts_Page(WebDriver driver) {
        this.driver = driver;
    }


    public By Search_Btn = By.xpath("//body/div[@id='main_start_page']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/a[1]");
    public By Supplier_CheckBox = By.xpath("//*[@id=\"DivAlertsFilterPCN\"]/div[1]/div[2]/div[1]/div/table/tbody/tr/td[4]/div/fieldset[1]/div/label/span/span");

    public void Z2D_Select_Supplier() {
        ElementActions.click(driver, Supplier_CheckBox);
    }
}