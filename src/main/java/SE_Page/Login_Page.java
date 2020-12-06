package SE_Page;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Login_Page {
    private WebDriver driver;
    public String URL_for_Navigation = "https://parts.z2data.com";
    public String Target_URL_Login = "https://login.z2data.com/Account/Login?ReturnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3DB8DD7908-F019-4E1B-9620-EEBD0052F069%26redirect_uri%3Dhttps%253A%252F%252Fparts.z2data.com%252Fsignin-oidc%26response_mode%3Dform_post%26response_type%3Did_token%26scope%3Dopenid%2520profile%26state%3DOpenIdConnect.AuthenticationProperties%253Dq7dt_mz9RoDhY4EQXe-T1emrW_kq56wh3weRN28sefk35mtbS8jZ-VXAlJzhR0WqNnOZcD5vaEgFttdgppZlBmJHl-cw6hYtMp1jre_YDQJW1b1sV4BIPRtOt9dXTzuB0usVuuotxlGL04zjoHXA1TsG2xavStwKwgYJ6gPS4C6zxQvgod1F19NH3tU2RXvbHTKKZN13Q_uQCDJnP8F-1Jg8NsfttiUNQms44iZReeg%26nonce%3D637426197058172630.MjBiYjUwMjEtOWQ1Zi00YmI5LWI4M2UtOWZjN2Y1YTllNGNlMTdlMmVhZDctMjA3ZC00OTc4LWEyZDAtMGI3ZjdjYjZlMzcz%26x-client-SKU%3DID_NET461%26x-client-ver%3D5.3.0.0";

    public Login_Page(WebDriver driver) {
        this.driver = driver;
    }

    public JavascriptExecutor jse;

    public void navigateToURLForNavigationL() {
        BrowserActions.navigateToURL(driver,URL_for_Navigation,Target_URL_Login);
    }

    public By Verify_Redirect = By.xpath("//*[@id=\"main_start_page\"]/div/h2");
    public By Verify_Open = By.xpath("/html/body/div/div/div/div[1]/div[2]/form/button");
    public By Input_Text_Box = By.id("Username");
    public By Input_Pass = By.id("Password");
    public By SignIn_Btn = By.name("button");

    public void Z2D_SignIn() {
        ElementActions.type(driver, Input_Text_Box, "Z2D.PR1@z2data.com");
        ElementActions.type(driver, Input_Pass, "Z2D.PR1@z2data.com");
        ElementActions.click(driver, SignIn_Btn);
    }
}
