package SE_Page;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Submit_Ticket_Page {
    private final WebDriver driver;
    public JavascriptExecutor jse;
    public Submit_Ticket_Page(WebDriver driver) {
        this.driver = driver;
    }
    public By Click_Data = By.xpath("//body/div[@id='dropbg']/div/div/div/div[@id='initdiv']/div/div/div/div[1]");
    public By Submit_Issue_Btn = By.id("HeaderSubmitTicket");
    public By Subject_Area = By.xpath("//div[@id='dropbg']//div//div//div//div[@id='initdiv']//div//div//input[@id='submit_txt_ticketSubject']");
    public By Body = By.xpath("//div[@id='dropbg']//div//div//div//div[@id='initdiv']//div//div//textarea[@id='submit_txt_ticketBody']");
    public By Support_Btn = By.xpath("//div[@id='dropbg']//button[@class='btn-submiticketsend inpanelaction'][contains(text(),'Send Support Ticket')]");
    public By Close_Btn = By.xpath("//div[@id='dropbg']//div//div//div//div[@id='successdiv']//button");

    public void Z2D_Type_Of_Issue() {
        ElementActions.click(driver, Click_Data);
    }

    public void Z2D_Open_Submit_Ticket() {
        ElementActions.click(driver, Submit_Issue_Btn);
    }

    public void Z2D_Enter_Issue_Data( ) {
        ElementActions.type(driver, Subject_Area, "Test Automation");
        ElementActions.type(driver, Body, "Issue Description");
        ElementActions.click(driver, Support_Btn);
    }

    public void Z2D_Close_Ticket() {
        ElementActions.click(driver, Close_Btn);
    }
}