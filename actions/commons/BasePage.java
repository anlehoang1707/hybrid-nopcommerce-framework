package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import pageObjects.users.sidebar.*;
import pageUIs.users.UserBasePageUI;

import javax.management.RuntimeErrorException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage() {
    }

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
        return driver.findElement(getByLocator(locator));
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
        return driver.findElements(getByLocator(locator));
    }

    public By getByXpath(String locator) {
        return By.xpath(locator);
    }

    public By getByLocator(String prefixlocator) {
        if (prefixlocator.toUpperCase().startsWith("ID")) {
            return By.id(prefixlocator.substring(3));
        }
        else if (prefixlocator.toUpperCase().startsWith("CLASS")) {
            return By.className(prefixlocator.substring(6));
        }
        else if (prefixlocator.toUpperCase().startsWith("NAME")) {
            return By.name(prefixlocator.substring(5));
        }
        else if (prefixlocator.toUpperCase().startsWith("CSS")) {
            return By.cssSelector(prefixlocator.substring(4));
        }
        else if (prefixlocator.toUpperCase().startsWith("XPATH")) {
            return By.xpath(prefixlocator.substring(6));
        } else {
             throw new RuntimeException("Please input valid locator!");
        }

    }


    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, String locator, String restParameter) {
        getElement(driver, castRestParameter(locator,restParameter)).click();
    }

    public void sendkeyToElement(WebDriver driver, String locator, String keysToSend) {
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(keysToSend);
    }

    public void sendkeyToElement(WebDriver driver, String locator, String keysToSend, String restParameter) {
        getElement(driver, castRestParameter(locator,restParameter)).clear();
        getElement(driver, castRestParameter(locator,restParameter)).sendKeys(keysToSend);
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String value) {
        new Select(getElement(driver, locator)).selectByValue(value);
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String value,String restParameter) {
        new Select(getElement(driver, castRestParameter(locator, restParameter))).selectByValue(value);
    }

    public WebElement getSelectedItemInDropdown(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).getFirstSelectedOption();
    }

    public WebElement getSelectedItemInDropdown(WebDriver driver, String locator,String restParameter) {
        return new Select(getElement(driver, castRestParameter(locator,restParameter))).getFirstSelectedOption();
    }

    public boolean isDropdownMultiple(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getElement(driver, parentLocator).click();

        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                item.click();
                break;
            }
        }
    }

    public String getAttributeValue(WebDriver driver, String locator, String value) {
        return getElement(driver, locator).getAttribute(value);
    }

    public String getAttributeValue(WebDriver driver, String locator, String value,String restParameter) {
        return getElement(driver, castRestParameter(locator,restParameter)).getAttribute(value);
    }

    public String getTextElement(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }

    public String getTextElement(WebDriver driver, String locator, String restParameter) {
        return getElement(driver, castRestParameter(locator, restParameter)).getText();
    }

    public String getCssValue(WebDriver driver, String locator, String propertyName) {
        return getElement(driver, locator).getCssValue(propertyName);
    }

    public String getHexaColorByRgbaColor(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    public int getElementsSize(WebDriver driver, String locator) {
        return getListElements(driver, locator).size();
    }

    public int getElementsSize(WebDriver driver, String locator,String restParameter) {
        return getListElements(driver, castRestParameter(locator,restParameter)).size();
    }

    public void checkTheCheckboxOrRadio(WebDriver driver, String locator) {
        if (!getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }


    public void checkTheCheckboxOrRadio(WebDriver driver, String locator, String restParameter) {
        if (!getElement(driver, castRestParameter(locator, restParameter)).isSelected()) {
            getElement(driver, castRestParameter(locator, restParameter)).click();
        }
    }

    public void uncheckTheCheckbox(WebDriver driver, String locator) {
        if (getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }

    public boolean isControlDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    public boolean isControlDisplayed(WebDriver driver, String locator,String restParameter) {
        return getElement(driver, castRestParameter(locator, restParameter)).isDisplayed();
    }

    public boolean isControlSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    public boolean isControlEnabled(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }

    public void switchToFrame(WebDriver driver, String locator) {
        driver.switchTo().frame(getElement(driver, locator));
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getElement(driver, locator)).doubleClick().perform();
    }

    public void moveToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getElement(driver, locator)).perform();
    }

    public void rightClickToElement(WebDriver driver, String locator) {
        new Actions(driver).contextClick(getElement(driver, locator)).perform();
    }

    public void dragAndDrop(WebDriver driver, String locator) {
        new Actions(driver).scrollToElement(getElement(driver, locator)).perform();
    }

    public void sendKeyboardToElement(WebDriver driver, String locator, Keys keysToSend) {
        new Actions(driver).sendKeys(getElement(driver, locator), keysToSend).perform();
    }

    public void hightlightElement(WebDriver driver, String locator) throws InterruptedException {
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSeconds(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void hightlightElement(WebDriver driver, String locator,String restParameter) throws InterruptedException {
        WebElement element = getElement(driver, castRestParameter(locator,restParameter));
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSeconds(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
        sleepInSeconds(3);
    }

    public void clickToElementByJS(WebDriver driver, String locator,String restParameter) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, castRestParameter(locator,restParameter)));
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
        Thread.sleep(timeInSeconds * 1000);
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForListElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
    }

    public void waitForListElementVisible(WebDriver driver, String locator,String restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(castRestParameter(locator,restParameter))));
    }

    public void waitForElementSelected(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(castRestParameter(locator,restParameter))));
    }

    public void waitForElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForListElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfAllElements(getListElements(driver, locator)));
    }

    public void waitForListElementInvisible(WebDriver driver, String locator,String restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfAllElements(getListElements(driver, castRestParameter(locator,restParameter))));
    }

    public void waitForElementPresence(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
    }

    public void waitForListElementPresence(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(locator)));
    }

    public void waitForAlertPresence(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.alertIsPresent());
    }

    // For Level_07_Switch_Page_Object
    public UserAddressPO openAddressPage(WebDriver driver) {
        waitForElementClickable(driver, UserBasePageUI.ADDRESS_LINK);
        clickToElement(driver, UserBasePageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }

    public UserBackInStockSubscriptionsPO openBackInStockSubscriptionsPage(WebDriver driver) {
        waitForElementClickable(driver, UserBasePageUI.BACK_IN_STOCK_SUBSCRIPTIONS_LINK);
        clickToElement(driver, UserBasePageUI.BACK_IN_STOCK_SUBSCRIPTIONS_LINK);
        return PageGenerator.getUserBackInStockSubscriptionsPage(driver);
    }

    public UserChangePasswordPO openChangePasswordPage(WebDriver driver) {
        waitForElementClickable(driver, UserBasePageUI.CHANGE_PASSWORD_LINK);
        clickToElement(driver, UserBasePageUI.CHANGE_PASSWORD_LINK);
        return PageGenerator.getUserChangePasswordPage(driver);
    }

    public UserDownloadableProductsPO openDownloadableProductsPage(WebDriver driver) {
        waitForElementClickable(driver, UserBasePageUI.DOWNLOADABLE_PRODUCTS_LINK);
        clickToElement(driver, UserBasePageUI.DOWNLOADABLE_PRODUCTS_LINK);
        return PageGenerator.getUserDownloadableProductsPage(driver);
    }

    public UserMyProductReviewsPO openMyProductReviewsPage(WebDriver driver) {
        waitForElementClickable(driver, UserBasePageUI.MY_PRODUCT_REVIEWS_LINK);
        clickToElement(driver, UserBasePageUI.MY_PRODUCT_REVIEWS_LINK);
        return PageGenerator.getUserMyProductReviewsPage(driver);
    }

    public UserOrdersPO openOrdersPage(WebDriver driver) {
        waitForElementClickable(driver, UserBasePageUI.ORDERS_LINK);
        clickToElement(driver, UserBasePageUI.ORDERS_LINK);
        return PageGenerator.getUserOrdersPage(driver);
    }

    public UserRewardPointsPO openRewardPointsPage(WebDriver driver) {
        waitForElementClickable(driver, UserBasePageUI.REWARD_POINTS_LINK);
        clickToElement(driver, UserBasePageUI.REWARD_POINTS_LINK);
        return PageGenerator.getUserRewardPointsPage(driver);

    }

    public String castRestParameter(String locator, String... restParameter) {
        return String.format(locator, (Object[]) restParameter);
    }

}
