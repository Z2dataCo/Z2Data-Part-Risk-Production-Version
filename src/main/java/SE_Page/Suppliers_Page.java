package SE_Page;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Suppliers_Page {
    private final WebDriver driver;
    public JavascriptExecutor jse;
    public Suppliers_Page(WebDriver driver) {
        this.driver = driver;
    }
    public By SuppName = By.xpath("//*[@id=\"RemainMainPage\"]/app-browsesuppliers/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[1]/a");
    public By Search_Btn = By.xpath("//*[@id=\"RemainMainPage\"]/app-browsesuppliers/div/div[1]/div/div/div[1]/div/span/a");
    public By Search_Input = By.xpath("//*[@id=\"supplier_autocom_\"]");

    public void Z2D_Enter_Supplier( ) {
        ElementActions.type(driver, Search_Input, "Toshiba");
    }
    public void Z2D_Wait_Disappear_Z2Data_Spinner_0() throws InterruptedException {
        int count = 0;
        while ((driver.findElements(By.xpath("//*[@id=\"RemainMainPage\"]/app-risk-manager/app-risk-parts/app-riskpartsmpn/ngx-loading/div/div[2]/div"))).size() != 0 && count < 40) {
            Thread.sleep(700);
            count++;
        }
    }

    public void Z2D_Click_Search() {
        boolean Intercepted = true;
        while (Intercepted) {
            try {
                ElementActions.click(driver, Search_Btn);
                Intercepted = false;
            } catch (ElementClickInterceptedException e) {
                Intercepted = true;
            }
        }
    }
}
