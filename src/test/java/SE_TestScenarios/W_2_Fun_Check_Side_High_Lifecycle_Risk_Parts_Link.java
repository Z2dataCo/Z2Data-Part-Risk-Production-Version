package SE_TestScenarios;

import Com.PartRisk.Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class W_2_Fun_Check_Side_High_Lifecycle_Risk_Parts_Link extends Test_Base {
    Data_Management_Page DManagementObj;
    Landing_Page LandObj;
    Dashboard_Page DashboardObj;
    Reports_Page ReportObj;
    Obsolescence_Page Obsolescence_Obj;

    @Test(priority = 23)
    @Severity(SeverityLevel.NORMAL)
    @Description("Check that side panel of Obsolete Parts in 3 Years shows parts that have forecast up to 3 years")
    public void Check_Side_Panel_High_Risk() throws InterruptedException {
        LandObj = new Landing_Page(driver);
        DashboardObj = new Dashboard_Page(driver);
        ReportObj = new Reports_Page(driver);
        DManagementObj = new Data_Management_Page(driver);
        Obsolescence_Obj = new Obsolescence_Page(driver);

        LandObj.Z2D_Open_Data_Management();
        Wait_Element_Visible(DManagementObj.Search_Text_Input);
        DManagementObj.Z2D_Search(Z2DataFolderName);
        Thread.sleep(3000);
        DManagementObj.SetFile();
        Thread.sleep(1000);
        DManagementObj.Z2D_Open_BOM();
        Thread.sleep(2000);
        if (!(" TAP_BOM_Proud_Test" == driver.getPageSource())) {
            DManagementObj.Z2D_Move_To_Prod_BOM(driver);
        } else {
            DManagementObj.Z2D_Click_on_BOM();
        }
        DashboardObj.Z2D_Open_Reports();
        ReportObj.Z2D_Open_Obsolescence();
        ReportObj.Z2D_Open_High_LifeCycle();

        if ("High Lifecycle Risk Parts" == driver.getPageSource()) {
            if (Obsolescence_Obj.Last.isEnabled())
                Obsolescence_Obj.Z2D_Open_High_LifeCycle();

        } else {

        }
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        Obsolescence_Obj.Z2D_Get_Last_Page();
        int CountOfTable = Obsolescence_Obj.Table_Size.size();
        int Count = Integer.parseInt(Obsolescence_Obj.Fixed_Number.getText());
        int CountPagination = Integer.parseInt(Obsolescence_Obj.Next_Page.getText());
        int CountPage = CountPagination - 1;
        int SubTotal = CountOfTable * CountPage;
        int LastPage = Count - SubTotal;
        int AllOfRow = LastPage + SubTotal;
        //System.out.println(AllOfRow);
        //System.out.println(Count);
        Assert.assertEquals(Count, AllOfRow);
        Thread.sleep(2000);
        boolean staleElement1 = true;
        while (staleElement1) {
            try {
                Obsolescence_Obj.Z2D_NRND_Parts();
                staleElement1 = false;
            } catch (Exception e) {
                staleElement1 = true;
            }
        }
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        int CountOfTable0 = Obsolescence_Obj.Table_Size.size();
        int Count0 = Integer.parseInt(Obsolescence_Obj.Fixed_Number.getText());
        int CountPagination0 = Integer.parseInt(Obsolescence_Obj.Next_Page.getText());
        int CountPage0 = CountPagination0 - 1;
        int SubTotal0 = CountOfTable0 * CountPage0;
        int LastPage0 = Count0 - SubTotal0;
        int AllOfRow0 = LastPage0 + SubTotal0;
        //System.out.println(AllOfRow0);
        //System.out.println(Count0);
        Assert.assertEquals(Count0, AllOfRow0);
        Switch_Tabs();
    }


}




