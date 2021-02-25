package SE_Page;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.tools.io.ExcelFileManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Login_Page {
    private final WebDriver driver;

    public Login_Page(WebDriver driver) {
        this.driver = driver;
    }

    public void Navigate_To_URL_for_Navigation(String Url) {
        driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
        driver.navigate().to(Url);
    }
    public void Tear_Down() {
        BrowserActions.closeCurrentWindow(driver);
    }
    public By Input_Text_Box = By.id("Username");
    public By Input_Pass = By.id("Password");
    public By SignIn_Btn = By.name("button");

    public void Z2D_SignIn(String UserName , String Password) {
        WebDriverWait WebWait = new WebDriverWait(driver, 90);

        driver.findElement(Input_Text_Box).sendKeys(UserName);
        driver.findElement(Input_Pass).sendKeys(Password);
        driver.findElement(SignIn_Btn).click();
        WebWait.until(ExpectedConditions.titleIs("Part Risk | Z2DATA"));

    }
}
