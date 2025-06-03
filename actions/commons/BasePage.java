package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.nopcommerce.PageGenerator;
import pageObjects.nopcommerce.users.sidebar.*;
import pageUIs.nopcommerce.BasePageUI;
import pageUIs.nopcommerce.users.UserBasePageUI;
import pageUIs.orangeHRM.BasePUI;
import pageUIs.sytner.JumpPointsPUI;

import java.time.Duration;
import java.util.Date;
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

    public String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
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

    public WebElement getElement(WebDriver driver, String locator, String... restParameter) {
        return driver.findElement(getByLocator(castRestParameter(locator,restParameter)));
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

    public List<WebElement> getListElements(WebDriver driver, String locator, String... restParameter) {
        return driver.findElements(getByLocator(castRestParameter(locator,restParameter)));
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

    public void clickToElement(WebDriver driver, String locator, String... restParameter) {
        getElement(driver, castRestParameter(locator,restParameter)).click();
    }

    public void sendkeyToElement(WebDriver driver, String locator, String keysToSend) {
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(keysToSend);
    }

    public void sendkeyToElement(WebDriver driver, String locator, String keysToSend, String... restParameter) {
        getElement(driver, castRestParameter(locator,restParameter)).clear();
        getElement(driver, castRestParameter(locator,restParameter)).sendKeys(keysToSend);
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String value) {
        new Select(getElement(driver, locator)).selectByValue(value);
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String value,String... restParameter) {
        new Select(getElement(driver, castRestParameter(locator, restParameter))).selectByValue(value);
    }

    public WebElement getSelectedItemInDropdown(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).getFirstSelectedOption();
    }

    public WebElement getSelectedItemInDropdown(WebDriver driver, String locator,String... restParameter) {
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

    public String getAttributeValue(WebDriver driver, String locator, String value,String... restParameter) {
        return getElement(driver, castRestParameter(locator,restParameter)).getAttribute(value);
    }

    public String getTextElement(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }

    public String getTextElement(WebDriver driver, String locator, String... restParameter) {
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

    public int getElementsSize(WebDriver driver, String locator,String... restParameter) {
        return getListElements(driver, castRestParameter(locator,restParameter)).size();
    }

    public void checkTheCheckboxOrRadio(WebDriver driver, String locator) {
        if (!getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }


    public void checkTheCheckboxOrRadio(WebDriver driver, String locator, String... restParameter) {
        if (!getElement(driver, castRestParameter(locator, restParameter)).isSelected()) {
            getElement(driver, castRestParameter(locator, restParameter)).click();
        }
    }

    public void uncheckTheCheckbox(WebDriver driver, String locator) {
        if (getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }

    public void uncheckTheCheckbox(WebDriver driver, String locator,String... restParameter) {
        if (getElement(driver, castRestParameter(locator,restParameter)).isSelected()) {
            getElement(driver, castRestParameter(locator,restParameter)).click();
        }
    }

    public boolean isControlDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    public boolean isControlDisplayed(WebDriver driver, String locator,String... restParameter) {
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

    public void hightlightElement(WebDriver driver, String locator,String... restParameter) throws InterruptedException {
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

    public void clickToElementByJS(WebDriver driver, String locator,String... restParameter) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, castRestParameter(locator,restParameter)));
        sleepInSeconds(3);
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String locator,String... restParameter) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, castRestParameter(locator,restParameter)));
    }


    public void scrollToElementOnDownByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
    }

    public void scrollToElementOnDownByJS(WebDriver driver, String locator,String... restParameter) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, castRestParameter(locator,restParameter)));
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

    public void waitForListElementVisible(WebDriver driver, String locator,String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(castRestParameter(locator,restParameter))));
    }

    public void waitForElementSelected(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(castRestParameter(locator,restParameter))));
    }

    public void waitForElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForListElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfAllElements(getListElements(driver, locator)));
    }

    public void waitForListElementInvisible(WebDriver driver, String locator,String... restParameter) {
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

    public void overrideGlobalTimeout(WebDriver driver, long timeout) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    public boolean isElementUndisplayed(WebDriver driver, String locator) {
        System.out.println("START time =" + new Date().toString());
        List<WebElement> elements = getListElements(driver, locator);
        try {
            if (elements.size() == 0) {
                System.out.println("Element is not in DOM");
                System.out.println("END time =" + new Date().toString());
                return true;
            } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
                System.out.println("Element is in DOM but not Displayed");
                return true;
            } else {
                System.out.println("Element is in DOM and visible");
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void sendkeyToTextboxByID(WebDriver driver, String textboxID, String keysToSend) {
        sendkeyToElement(driver, BasePageUI.TEXTBOX_BY_ID,keysToSend,textboxID);
    }


    public void waitForRadioByIDToClick(WebDriver driver, String radioID) {
        waitForElementClickable(driver,BasePageUI.RADIO_BY_ID,radioID);
    }

    public void checkRadioByID(WebDriver driver, String radioID) {
        checkTheCheckboxOrRadio(driver,BasePageUI.RADIO_BY_ID,radioID);
    }

    public void clickToButtonByText(WebDriver driver, String buttonText) {
        clickToElement(driver,BasePageUI.BUTTON_BY_TEXT,buttonText);
    }

    public void clickToLinkByClass(WebDriver driver, String linkClass) {
        clickToElement(driver,BasePageUI.LINK_BY_CLASS,linkClass);
    }

    public void waitForElementVisible(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castRestParameter(locator,restParameter))));
    }

    public void waitForLinkByClassToClick(WebDriver driver, String linkClass) {
        waitForElementVisible(driver,BasePageUI.LINK_BY_CLASS,linkClass);
    }

    public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
        String filePath = GlobalConstants.UPLOAD_PATH;
        String fullFileName = "";

        for (String file: fileNames) {
            fullFileName += filePath + file + "\n";
        }

        fullFileName = fullFileName.trim();

        getElement(driver,BasePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
    }


    //OrangeHRM

    public boolean waitForAllLoadingIconsInvisible(WebDriver driver) {
        return new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfAllElements(getListElements(driver, BasePUI.LOADING_ICON)));
    }

    public void sendKeyToTextBoxByLabelText(WebDriver driver, String labelText, String keysToSend) {
        waitForElementVisible(driver, BasePUI.TEXTBOX_BY_LABEL,labelText);
        sendkeyToElement(driver,BasePUI.TEXTBOX_BY_LABEL,keysToSend,labelText);
    }

    public void clickToAddButtonByContainerText(WebDriver driver, String containerText) {
        waitForElementVisible(driver,BasePUI.ADD_BUTTON_BY_CONTAINER_TEXT,containerText);
        clickToElement(driver,BasePUI.ADD_BUTTON_BY_CONTAINER_TEXT,containerText);
    }

    public boolean isDisplayedSuccessMessage(WebDriver driver) {
        WebElement successMessage = new WebDriverWait(driver,Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOf(getElement(driver,BasePUI.SUCCESS_MESSSAGE)));
        return successMessage.isDisplayed();
    }

    public void clickToSaveButtonByContainerText(WebDriver driver, String containerText) {
        waitForElementVisible(driver, BasePUI.SAVE_BUTTON_BY_CONTAINER_TEXT,containerText);
        clickToElement(driver,BasePUI.SAVE_BUTTON_BY_CONTAINER_TEXT,containerText);
    }

    public void selectItemInCustomDropdownByLabelText(WebDriver driver, String labelText, String expectedItem) {
        WebElement parentElement = getElement(driver,BasePUI.DROPDOWN_PARENT_LOCATOR_BY_LABEL_TEXT,labelText);
        String childItemLocator = BasePUI.DROPDOWN_CHILD_LOCATOR_BY_LABEL_TEXT;

        parentElement.click();

        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(castRestParameter(childItemLocator,labelText))));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                item.click();
                break;
            }
        }
    }


    // BankGuru 99
    public void sendKeyToTextBoxByTdText (WebDriver driver, String tdText, String keysToSend) {
        waitForElementVisible(driver, pageUIs.bankguru99.BasePUI.DYNAMIC_TEXTBOX_BY_TD,tdText);
        sendkeyToElement(driver, pageUIs.bankguru99.BasePUI.DYNAMIC_TEXTBOX_BY_TD,keysToSend,tdText);
    }

    // Sytner
    public boolean isBrandIconDisplayed (WebDriver driver, String brandName){
        return isControlDisplayed(driver, JumpPointsPUI.DYNAMIC_BRAND_NAME_ICON,brandName);
    }
}
