package SE_Page;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Compare_Page {

    private WebDriver driver;
    public JavascriptExecutor jse;
    public Compare_Page(WebDriver driver) {
        this.driver = driver;
    }
    public By Compare1 = By.id("part_autocom_0");
    public By Compare2 = By.id("part_autocom_1");
    public By Value_Compare1 = By.xpath("//li[1]//a[@class='z2tableA-singline ui-menu-item-wrapper'][1]");
    public By Value_Compare2 = By.xpath("//body[1]/div[5]/app-root[1]/div[3]/app-compare[1]/div[1]/div[1]/app-compareparts[1]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[3]/div[1]/app-part-autocomplete[1]/div[1]/div[1]/ul[1]/li[1]/a[1]");
    public By Differences = By.xpath("//*[@id=\"headerEl\"]/div/div/a[2]");
    public By Similarities = By.xpath("//*[@id=\"headerEl\"]/div/div/a[3]");
    public By Right_First_Row_Data = By.xpath("//*[@class='tbodyfeatureParts-0']//tr[1]/td[3]/span");
    public By Left_First_Row_Data = By.xpath("//*[@class='tbodyfeatureParts-0']//tr[1]/td[2]/span");

    public void Z2D_Input_Compare_1( ) {
        ElementActions.type(driver, Compare1, "bav10");
    }

    public void Z2D_Input_Compare_2( ) {
        ElementActions.type(driver, Compare2, "bav20");
    }

    public void Z2D_Select_Differences() {
        ElementActions.click(driver, Differences);
    }

    public void Z2D_Select_Similarities() {
        ElementActions.click(driver, Similarities);
    }
    public void Z2D_Left_First_Row_Data_Visibility(){
        ElementActions.waitForElementToBePresent(driver, Left_First_Row_Data,5,true);
    }
    public void Z2D_Right_First_Row_Data_Visibility(){
        ElementActions.waitForElementToBePresent(driver, Right_First_Row_Data,5,true);
    }
    /*public void Z2D_Set_Value_1(){ElementActions.click(driver,Value_Compare1);}
    public void Z2D_Set_Value_2(){ElementActions.click(driver,Value_Compare2);}*/

}