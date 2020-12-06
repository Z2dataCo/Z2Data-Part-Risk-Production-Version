package SE_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Advanced_Crosses_Page {
    private WebDriver driver;
    public JavascriptExecutor jse;
    public Advanced_Crosses_Page(WebDriver driver) {
        this.driver = driver;
    }

    public By Total = By.xpath("//*[@id=\"RemainMainPage\"]/adv-cross/div[1]/div/div[2]/div/div[1]/div");
    public By Drop_in = By.xpath("//*[@id=\"RemainMainPage\"]/adv-cross/div[1]/div/div[2]/div/div[2]/div/div");
    public By Drop_in_Same_Supplier = By.xpath("//*[@id=\"RemainMainPage\"]/adv-cross/div[1]/div/div[2]/div/div[3]/div/div/div[1]");
    public By Different_Input = By.xpath("//*[@id=\"RemainMainPage\"]/adv-cross/div[1]/div/div[2]/div/div[4]/div/div");
    public By Similar_Different_Package = By.xpath("//*[@id=\"RemainMainPage\"]/adv-cross/div[1]/div/div[2]/div/div[5]/div/div");

}