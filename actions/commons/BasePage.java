package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import pageUIs.BasePageUI;
import pageUIs.ChangePasswordPageUI;
import pageUIs.HomePageUI;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {

    public static BasePage getBasePage() {
        return new BasePage();
    }

    public void openPageUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Alert waitAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver) {
        waitAlertPresence(driver).accept();
    }

    public void cancelAlert(WebDriver driver) {
        waitAlertPresence(driver).dismiss();
    }

    public String getTextAlert(WebDriver driver) {
        return waitAlertPresence(driver).getText();
    }

    public void sendkeyToAlert(WebDriver driver, String keysToSend) {
        waitAlertPresence(driver).sendKeys(keysToSend);
    }

    public String getWindowHandle(WebDriver driver) {
        return driver.getWindowHandle();
    }

    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByXpath(locator));
    }

    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    public List<WebElement> getListElements(WebDriver driver, String locator) {
        return driver.findElements(getByXpath(locator));
    }

    public By getByXpath(String locator) {
        return By.xpath(locator);
    }

    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver,locator).click();
    }

    public void sendkeyToElement(WebDriver driver, String locator, String keysToSend) {
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(keysToSend);
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String value) {
        new Select(getElement(driver, locator)).selectByValue(value);
    }

    public WebElement getSelectedItemInDropdown(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).getFirstSelectedOption();
    }

    public boolean isDropdownMultiple(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getElement(driver, parentLocator).click();

        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                item.click();
                break;
            }
        }
    }

    public String getAttributeValue(WebDriver driver, String locator, String value) {
        return getElement(driver,locator).getAttribute(value);
    }

    public String getTextElement(WebDriver driver, String locator) {
        return getElement(driver,locator).getText();
    }

    public String getCssValue(WebDriver driver, String locator, String propertyName) {
        return getElement(driver,locator).getCssValue(propertyName);
    }

    public String getHexaColorByRgbaColor(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    public int getElementsSize(WebDriver driver, String locator) {
        return getListElements(driver,locator).size();
    }

    public void checkTheCheckboxOrRadio(WebDriver driver, String locator) {
        if (!getElement(driver,locator).isSelected()) {
           getElement(driver,locator).click();
        }
    }

    public void uncheckTheCheckbox(WebDriver driver, String locator) {
        if (getElement(driver,locator).isSelected()) {
            getElement(driver,locator).click();
        }
    }

    public boolean isControlDisplayed(WebDriver driver, String locator) {
        return getElement(driver,locator).isDisplayed();
    }

    public boolean isControlSelected(WebDriver driver, String locator) {
        return getElement(driver,locator).isSelected();
    }

    public boolean isControlEnabled(WebDriver driver, String locator) {
        return getElement(driver,locator).isEnabled();
    }

    public void switchToFrame(WebDriver driver, String locator) {
        driver.switchTo().frame(getElement(driver,locator));
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getElement(driver,locator)).doubleClick().perform();
    }

    public void moveToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getElement(driver,locator)).perform();
    }

    public void rightClickToElement(WebDriver driver, String locator) {
        new Actions(driver).contextClick(getElement(driver,locator)).perform();
    }

    public void dragAndDrop(WebDriver driver, String locator) {
        new Actions(driver).scrollToElement(getElement(driver,locator)).perform();
    }

    public void sendKeyboardToElement(WebDriver driver, String locator, Keys keysToSend) {
        new Actions(driver).sendKeys(getElement(driver,locator),keysToSend).perform();
    }

    public void hightlightElement(WebDriver driver, String locator) throws InterruptedException {
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSeconds(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
        sleepInSeconds(3);
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void scrollToElementOnDownByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
    }

    public void scrollToBottomPageByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
    }

    public String getAttributeInDOMByJS(WebDriver driver, String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                        "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getElement(driver, locator));
    }

    public void sleepInSeconds(int timeInSeconds) throws InterruptedException {
        Thread.sleep(timeInSeconds*1000);
    }

    public void waitForElementVisible(WebDriver driver, String locator,int timeInSeconds) {
        new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds)).until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    public void waitForListElementVisible(WebDriver driver, String locator,int timeInSeconds) {
        new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
    }

    public void waitForElementSelected(WebDriver driver, String locator,int timeInSeconds) {
        new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds)).until(ExpectedConditions.elementToBeSelected(getByXpath(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator,int timeInSeconds) {
        new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds)).until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }

    public void waitForElementInvisible(WebDriver driver, String locator,int timeInSeconds) {
        new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds)).until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
    }

    public void waitForListElementInvisible(WebDriver driver, String locator,int timeInSeconds) {
        new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds)).until(ExpectedConditions.invisibilityOfAllElements(getListElements(driver,locator)));
    }

    public void waitForElementPresence(WebDriver driver, String locator, int timeInSeconds) {
        new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds)).until(ExpectedConditions.presenceOfElementLocated(getByXpath(locator)));
    }

    public void waitForListElementPresence(WebDriver driver, String locator, int timeInSeconds) {
        new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(locator)));
    }

    public void waitForAlertPresence(WebDriver driver, String locator, int timeInSeconds) {
        new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds)).until(ExpectedConditions.alertIsPresent());
    }

    public AddressPageObject openAddressPage(WebDriver driver) {
        waitForElementClickable(driver,BasePageUI.ADDRESS_LINK,15);
        clickToElement(driver, BasePageUI.ADDRESS_LINK);
        return PageGenerator.getAddressPage(driver);
    }

    public BackInStockSubscriptionsPageObject openBackInStockSubscriptionsPage(WebDriver driver) {
        waitForElementClickable(driver,BasePageUI.BACK_IN_STOCK_SUBSCRIPTIONS_LINK,15);
        clickToElement(driver, BasePageUI.BACK_IN_STOCK_SUBSCRIPTIONS_LINK);
        return PageGenerator.getBackInStockSubscriptionsPage(driver);
    }

    public ChangePasswordPageObject openChangePasswordPage(WebDriver driver) {
        waitForElementClickable(driver,BasePageUI.CHANGE_PASSWORD_LINK,15);
        clickToElement(driver, BasePageUI.CHANGE_PASSWORD_LINK);
        return PageGenerator.getChangePasswordPage(driver);
    }

    public DownloadableProductsPageObject openDownloadableProductsPage(WebDriver driver) {
        waitForElementClickable(driver,BasePageUI.DOWNLOADABLE_PRODUCTS_LINK,15);
        clickToElement(driver, BasePageUI.DOWNLOADABLE_PRODUCTS_LINK);
        return PageGenerator.getDownloadableProductsPage(driver);
    }

    public MyProductReviewsPageObject openMyProductReviewsPage(WebDriver driver) {
        waitForElementClickable(driver,BasePageUI.MY_PRODUCT_REVIEWS_LINK,15);
        clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEWS_LINK);
        return PageGenerator.getMyProductReviewsPage(driver);
    }

    public OrdersPageObject openOrdersPage(WebDriver driver) {
        waitForElementClickable(driver,BasePageUI.ORDERS_LINK,15);
        clickToElement(driver, BasePageUI.ORDERS_LINK);
        return PageGenerator.getOrdersPage(driver);
    }

    public RewardPointsPageObject openRewardPointsPage(WebDriver driver) {
        waitForElementClickable(driver,BasePageUI.REWARD_POINTS_LINK,15);
        clickToElement(driver, BasePageUI.REWARD_POINTS_LINK);
        return PageGenerator.getRewardPointsPage(driver);
    }






}
