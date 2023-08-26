package ru.ibs.appline.framework.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.appline.framework.utils.enums.Enums;
import ru.appline.framework.utils.listeners.MyAllureListener;
import ru.ibs.appline.framework.basetestsclass.BaseTests;

@ExtendWith(MyAllureListener.class)
public class TrainingApplinePageObjectAllureTest extends BaseTests {

    @Test()
    @Tag("Test_PageObjectAllure_1")
    public void testPageObjectAllure() {
        String departureCity = "Энгельс";
        String arrivalCity = "Москва";
        String departureDate = "10.11.2023";
        String returnDate = "10.12.2023";
        String organisationName = "(Хром) Призрачная Организация Охотников";
        String checkboxValue = "Заказ билетов";
        String mainMenuButton = "Расходы";
        webSite.getLoginPage()
                .authorisation()
                .checkMainPageTitle()
                .clickButtonOfMainMenu(mainMenuButton)
                .selectBusinessTripModuleInCostsBlock()
                .clickCreateBusinessTripButton()
                .checkCreateBusinessTripTitle()
                .chooseInternalDevelopmentDepartment()
                .clickOpenListButton()
                .chooseOrganisation(organisationName)
                .selectTasksCheckBox(checkboxValue)
                .fillTravelFields(Enums.DEPARTURE_CITY.getValue(), departureCity)
                .fillTravelFields(Enums.ARRIVAL_CITY.getValue(), arrivalCity)
                .fillTravelFields(Enums.DEPARTURE_DATE.getValue(), departureDate)
                .fillTravelFields(Enums.RETURN_DATE.getValue(), returnDate)
                .checkAllFieldsFilled(organisationName)
                .checkAllFieldsFilled(checkboxValue)
                .checkAllFieldsFilled(departureCity)
                .checkAllFieldsFilled(arrivalCity)
                .checkAllFieldsFilled(departureDate)
                .checkAllFieldsFilled(returnDate)
                .clickSaveAndCloseButton()
                .checkErrorMessage("Список командируемых сотрудников не может быть пустым");
    }
}
