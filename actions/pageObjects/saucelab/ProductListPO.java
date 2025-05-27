package pageObjects.saucelab;

import commons.BasePage;
import io.qameta.allure.Step;
import jdk.jfr.Registered;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.saucelab.ProductListPUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductListPO extends BasePage {
    private WebDriver driver;

    public ProductListPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to Sort Product Name Asc Dropdown option")
    public void clickToSortByProductNameAsc() {
        waitForElementClickable(driver, ProductListPUI.SORT_DROPDOWN);
        selectItemInDropdown(driver,ProductListPUI.SORT_DROPDOWN,"az");
    }

    @Step("Verify Products are sorted asc by name")
    public boolean isProductNameDataSortedAsc() {
        ArrayList<String> arrayList = new ArrayList<>();

        List<WebElement> elementList = getListElements(driver,ProductListPUI.PRODUCT_NAME);


        for (WebElement element: elementList) {
            arrayList.add(element.getText());
        }

        for (String name: arrayList) {
            System.out.println(name);
        }

        ArrayList<String> sortedList = new ArrayList<>();

        for (String child: arrayList) {
            sortedList.add(child);
        }

        Collections.sort(sortedList);

        for(String name: sortedList) {
            System.out.println(name);
        }

        return sortedList.equals(arrayList);
    }

    @Step("Click to Sort Product Name Dsc Dropdown option")
    public void clickToSortProductNameDsc() {
        waitForElementClickable(driver, ProductListPUI.SORT_DROPDOWN);
        selectItemInDropdown(driver,ProductListPUI.SORT_DROPDOWN,"za");
    }

    @Step("Verify Products are sorted dsc by name")
    public boolean isProductNameDataSortedDsc() {
        ArrayList<String> arrayList = new ArrayList<>();

        List<WebElement> elementList = getListElements(driver, ProductListPUI.PRODUCT_NAME);

        for (WebElement element: elementList) {
            arrayList.add(element.getText());
        }

        List<String> sortedList = new ArrayList<>();

        for (String child: arrayList) {
            sortedList.add(child);
        }

        Collections.sort(sortedList);
        Collections.reverse(sortedList);

        return sortedList.equals(arrayList);
    }

    @Step("Click to Sort Product Price Asc Dropdown option")
    public void clickToSortPriceAsc() {
        waitForElementClickable(driver, ProductListPUI.SORT_DROPDOWN);
        selectItemInDropdown(driver,ProductListPUI.SORT_DROPDOWN,"lohi");
    }

    @Step("Verify Products are sorted asc by price")
    public boolean isProductPriceDataSortedAsc() {
        ArrayList<Float> arrayList = new ArrayList<>();

        List<WebElement> elementList = getListElements(driver, ProductListPUI.PRODUCT_PRICE);

        for (WebElement element: elementList) {
            arrayList.add(Float.parseFloat(element.getText().replace("$","").trim()));
        }

        ArrayList<Float> sortedList = new ArrayList<>();

        for (Float child: arrayList) {
            sortedList.add(child);
        }

        Collections.sort(sortedList);

        return sortedList.equals(arrayList);
    }

    @Step("Click to Sort Product Price Dsc Dropdown option")
    public void clickToSortPriveDsc() {
        waitForElementClickable(driver, ProductListPUI.SORT_DROPDOWN);
        selectItemInDropdown(driver,ProductListPUI.SORT_DROPDOWN,"hilo");
    }

    @Step("Verify Products are sorted dsc by price")
    public boolean isProductPriceDataSortedDsc() {
        ArrayList<Float> arrayList = new ArrayList<>();

        List<WebElement> elementList = getListElements(driver, ProductListPUI.PRODUCT_PRICE);

        for (WebElement element: elementList) {
            arrayList.add(Float.parseFloat(element.getText().replace("$","").trim()));
        }

        ArrayList<Float> sortedList = new ArrayList<>();

        for (Float child: arrayList) {
            sortedList.add(child);
        }

        Collections.sort(sortedList);
        Collections.reverse(sortedList);

        return sortedList.equals(arrayList);
    }

}
