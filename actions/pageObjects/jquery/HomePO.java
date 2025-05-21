package pageObjects.jquery;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.HomePageUI;

import java.util.ArrayList;
import java.util.List;

public class HomePO extends BasePage {
    private WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Wait for Page Button number {0} is clickable")
    public void waitForPageButtonClickable(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_PAGE_BUTTON_LINK, pageNumber);
    }

    @Step("Click to Page Button number {0}")
    public void clickToPageButton(String pageNumber) {
        clickToElement(driver,HomePageUI.DYNAMIC_PAGE_BUTTON_LINK, pageNumber);
    }

    @Step("Check Selected Page Button number {0} is Active")
    public boolean isPageButtonActive(String pageNumber) {
        return getAttributeValue(driver,HomePageUI.DYNAMIC_PAGE_BUTTON_LINK,"class",pageNumber).endsWith("active");
    }

    @Step("Enter to {0} Header with value {1}")
    public void enterToTextBoxByHeaderName(String headerName, String valueToSend) {
        sendkeyToElement(driver,HomePageUI.DYNAMIC_HEADER_SEARCH_TEXT_BOX,valueToSend,headerName);
    }

    @Step("Click to Load Data Button")
    public void clickToLoadDataButton() {
        waitForElementClickable(driver,HomePageUI.LOAD_DATA_BUTTON);
        clickToElement(driver,HomePageUI.LOAD_DATA_BUTTON);
    }

    @Step("Input {2} value to row index {0} and column name {1}")
    public void sendkeyToCellByRowIndexAndColumnName(String rowIndex, String columnName, String valueToSendkey) {
        int columnIndexNumber = getElementsSize(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER,columnName) + 1;

        String columnIndex = String.valueOf(columnIndexNumber);

        sendkeyToElement(driver,HomePageUI.DYNAMIC_INPUT_BY_ROW_AND_COLUMN_INDEX,valueToSendkey,rowIndex,columnIndex);
    }

    @Step("Select item with text is {2} in row index {0} and column name {1}")
    public void selectToDropdownByIndex(String rowIndex, String columnName, String itemVisibleText) {
        int columnIndexNumber = getElementsSize(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER,columnName) + 1;

        String columnIndex = String.valueOf(columnIndexNumber);

        selectItemInDropdown(driver,HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX,itemVisibleText,rowIndex, columnIndex);
    }

    @Step("Check or Uncheck Check Box in row index {0} and column name {1}")
    public void checkToCheckboxByIndex(String rowIndex, String columnName, boolean checkOrUncheck) {
        int columnIndexNumber = getElementsSize(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER,columnName) + 1;

        String columnIndex = String.valueOf(columnIndexNumber);

        if (checkOrUncheck) {
            checkTheCheckboxOrRadio(driver,HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX,rowIndex,columnIndex);
        } else {
            uncheckTheCheckbox(driver,HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX,rowIndex,columnIndex);
        };
    }

    @Step("Click to {1} Button  in row index {0}")
    public void clickToButtonByIndex(String rowIndex, String actionTitle) {
        clickToElement(driver,HomePageUI.DYNAMIC_ACTION_BY_ROW_INDEX_AND_ACTION_TITLE,rowIndex,actionTitle);
    }

    @Step("Get all values of column name {0}")
    public List<String> getAllValueOfColumnByColumnName(String columnName) {
        List<String> allValue = new ArrayList<String>();

        int columnIndexNumber = getElementsSize(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER,columnName) + 1;

        String columnIndex = String.valueOf(columnIndexNumber);

        List<WebElement> rowList = getListElements(driver,HomePageUI.ROW_DATA_BY_COLUMN_INDEX,columnIndex);

        for (WebElement row: rowList) {
            String element = row.getText();
            allValue.add(element);
        }

        System.out.println(allValue);

        return allValue;
    }
}
