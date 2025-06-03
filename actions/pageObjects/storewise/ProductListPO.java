package pageObjects.storewise;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.storewise.ProductListPUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductListPO extends BasePage {
    private WebDriver driver;

    public ProductListPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToSortPriceAsc() {
        waitForElementClickable(driver, ProductListPUI.SORT_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, ProductListPUI.SORT_DROPDOWN_PARENT,ProductListPUI.SORT_DROPDOWN_CHILD,"Price low-high");
    }

    public boolean isProductPriceDataSortedAsc() {
        List<Float> arrayList = new ArrayList<>();

        List<WebElement> elementList = getListElements(driver,ProductListPUI.PRODUCT_PRICE);

        for (WebElement element: elementList) {
            arrayList.add(Float.parseFloat(element.getText().replace("₪","").trim()));
        }

        List<Float> sortedList = new ArrayList<>();

        for (Float child: arrayList) {
            sortedList.add(child);
        }

        Collections.sort(sortedList);
        return sortedList.equals(arrayList);
    }

    public void clickToSortPriceDesc() {
        waitForElementClickable(driver, ProductListPUI.SORT_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, ProductListPUI.SORT_DROPDOWN_PARENT,ProductListPUI.SORT_DROPDOWN_CHILD,"Price high-low");
    }

    public boolean isProductPriceDataSortedDesc() {
        List<Float> arrayList = new ArrayList<>();

        List<WebElement> elementList = getListElements(driver,ProductListPUI.PRODUCT_PRICE);

        for (WebElement element: elementList) {
            arrayList.add(Float.parseFloat(element.getText().replace("₪","").trim()));
        }

        List<Float> sortedList = new ArrayList<>();

        for (Float child: arrayList) {
            sortedList.add(child);
        }

        Collections.sort(sortedList);
        Collections.reverse(sortedList);
        return sortedList.equals(arrayList);
    }

}

