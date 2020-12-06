package SE_Page;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.List;

public class Delete_BOM_Page {
    private WebDriver driver;
    public JavascriptExecutor jse;
    public Delete_BOM_Page(WebDriver driver) {
        this.driver = driver;
    }


    public By Yes_Button = By.xpath("/html/body/modal-container/div/div/div/button[1]");
    public By Showing_of_Status = By.xpath("//div[@class='actionbar-right mr-1']//span[2]");
    public By Total_Results_Shown = By.xpath("//div[@class='actionbar-right mr-1']//span[2]");
    public By Creat_Sub_Folder_Button = By.xpath("//span[contains(text(),'Create Sub Folder')]");
    public By Table_Body = By.xpath("//table[@class='table table-bordered table-striped bg-white mt-05 mb-0']/tbody");
    public List<WebElement> BOMs_Table = driver.findElements(By.xpath("//table[@class='table table-bordered table-striped bg-white mt-05 mb-0']/tbody/tr"));
    int i = 2;

    public void Scroll_To_Middle() {
        jse.executeScript("window.scrollBy(0,2000)");
    }

    public void Scroll_To_Bottom() {
        jse.executeScript("scrollBy(0,2500)");
    }

    public void Z2D_Click_on_Check_Box() {
        ElementActions.click(driver, Showing_of_Status);
    }

    public void Z2D_Deleting_BOMs(WebDriver driver) throws InterruptedException {

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
