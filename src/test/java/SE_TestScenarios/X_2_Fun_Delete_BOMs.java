package SE_TestScenarios;

import Com.PartRisk.Pages.Data_Management_Page;
import Com.PartRisk.Pages.Delete_BOM_Page;
import Com.PartRisk.Pages.Landing_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.Test;

public class X_2_Fun_Delete_BOMs extends Test_Base {

    Data_Management_Page DManagementObj;
    Landing_Page LandObj;
    Delete_BOM_Page DeleteOBJ;

    @Test(priority = 24)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deleting Created BOMs")
    public void Delete_BOMs() throws InterruptedException {

        LandObj = new Landing_Page(driver);
        DManagementObj = new Data_Management_Page(driver);
        DeleteOBJ = new Delete_BOM_Page(driver);

        LandObj.Z2D_Open_Data_Management();
        Wait_Element_Clickable(DManagementObj.Search_Text_Input);
        DManagementObj.Z2D_Type_Folder_Name(Z2DataFolderName);
        boolean staleElement = true;
        while (staleElement) {
            try {
                DManagementObj.Z2D_Select_Folder();
                staleElement = false;
            } catch (StaleElementReferenceException e) {
                staleElement = true;
            }
        }
        DeleteOBJ.Z2D_Click_on_Check_Box();
        int Rows_Size = DeleteOBJ.BOMs_Table.size();
        //System.out.println("Number of Tables Row : " + Rows_Size);
        Wait_Element_Visible(DeleteOBJ.Table_Body);
        DeleteOBJ.Z2D_Deleting_BOMs(driver);
        //System.out.println("All testing BOMs have been deleted successfully except : (TAP_Bom_Proud_Test)");
    }
}

