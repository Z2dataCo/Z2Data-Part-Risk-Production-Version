package SE_Page;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Submit_Ticket_Page {
    private WebDriver driver;
    public JavascriptExecutor jse;
    public Submit_Ticket_Page(WebDriver driver) {
        this.driver = driver;
    }
    public By Verification_MSG = By.xpath("//div[@id='dropbg']//div//div//div//div[@id='successdiv']//div//h3");
    public By Click_Data = By.xpath("//body/div[@id='dropbg']/div/div/div/div[@id='initdiv']/div/div/div/div[1]");
    public By Submit_Issue_Btn = By.id("HeaderSubmitTicket");
    public By Tool = By.xpath("//*[@id=\"initdiv\"]/div[1]/div[2]/div/div[2]");
    public By Suggestion = By.xpath("//*[@id=\"initdiv\"]/div[1]/div[2]/div/div[3]");
    public By Other = By.xpath("//*[@id=\"initdiv\"]/div[1]/div[2]/div/div[4]");
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

    public void Z2D_Enter_Issue_Data(String subject, String body) {
        ElementActions.type(driver, Subject_Area, subject);
        ElementActions.type(driver, Body, body);
        ElementActions.click(driver, Support_Btn);
    }

    public void Z2D_Close_Ticket() {
        ElementActions.click(driver, Close_Btn);
    }
}