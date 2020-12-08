package SE_TestScenarios;

import Com.PartRisk.Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Z_2_Fun_All_Obsolescence extends Test_Base {
    Data_Management_Page DManagementObj;
    Reports_Page ReportObj;
    Landing_Page LandObj;
    Obsolescence_Page ObsolescenceObj;
    Dashboard_Page DashboardObj;

    @Test(priority = 28)
    @Severity(SeverityLevel.NORMAL)
    @Description("Check that side panel of All Obsolescence PCNs shows all PCNs on the BOM")
    public void All_ObsolescencePage() throws InterruptedException {
        LandObj = new Landing_Page(driver);
        DashboardObj = new Dashboard_Page(driver);
        ReportObj = new Reports_Page(driver);
        DManagementObj = new Data_Management_Page(driver);
        ObsolescenceObj = new Obsolescence_Page(driver);

        LandObj.Z2D_Open_Data_Management();
        Wait_Element_Visible(DManagementObj.Search_Text_Input);
        DManagementObj.Z2D_Search(Z2DataFolderName);
        boolean staleElement = true;
        while (staleElement) {
            try {
                DManagementObj.SetFile();
                staleElement = false;
            } catch (StaleElementReferenceException e) {
                staleElement = true;
            }
        }
        if (!(" TAP_BOM_Proud_Test" == driver.getPageSource())) {
            DManagementObj.Z2D_Move_To_Prod_BOM(driver);
        } else {
            DManagementObj.Z2D_Click_on_BOM();
        }
        DashboardObj.Z2D_Open_Reports();
        ObsolescenceObj.Z2D_Product_Change();
        ObsolescenceObj.Z2D_All_Obsolescence();
        Thread.sleep(3000);
        ObsolescenceObj.Z2D_Get_Last_Page_for_All_Obs();
        int CountOfTable = ObsolescenceObj.Table_Size.size();
        int Count = Integer.parseInt(ObsolescenceObj.Fixed_Number_for_All_Obs.getText());
        int CountPagination = Integer.parseInt(ObsolescenceObj.Next_Page.getText());
        int CountPage = CountPagination - 1;
        int SubTotal = CountOfTable * CountPage;
        int LastPage = Count - SubTotal;
        int AllOfRow = LastPage + SubTotal;
        //System.out.println("Actual Result  " + AllOfRow);
        //System.out.println("Expected Result  " + Count);
        Assert.assertEquals(Count, AllOfRow);
        Thread.sleep(3000);
        ObsolescenceObj.Z2D_Table_of_Data(driver);
        ObsolescenceObj.Z2D_Close_Slide();

    }

}
