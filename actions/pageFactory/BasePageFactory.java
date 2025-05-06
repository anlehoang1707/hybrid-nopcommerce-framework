package pageFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePageFactory {

    public static BasePageFactory getBasePage() {
        return new BasePageFactory();
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

    public void clickToElement(WebElement element) {
        element.click();
    }

    public void sendkeyToElement(WebElement element, String keysToSend) {
        element.sendKeys(keysToSend);
    }

    public void selectItemInDropdown(WebElement element, String value) {
        new Select(element).selectByValue(value);
    }

    public WebElement getSelectedItemInDropdown(WebElement element) {
        return new Select(element).getFirstSelectedOption();
    }

    public boolean isDropdownMultiple(WebElement element) {
        return new Select(element).isMultiple();
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

    public String getAttributeValue(WebElement element, String value) {
        return element.getAttribute(value);
    }

    public String getTextElement(WebElement element) {
        return element.getText();
    }

    public String getCssValue(WebElement element, String propertyName) {
        return element.getCssValue(propertyName);
    }

    public String getHexaColorByRgbaColor(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    public int getElementsSize(List<WebElement> elements) {
        return elements.size();
    }

    public void checkTheCheckboxOrRadio(WebElement element) {
        if (!element.isSelected()) {
           element.click();
        }
    }

    public void uncheckTheCheckbox(WebElement element) {
        if (element.isSelected()) {
            element.click();
        }
    }

    public boolean isControlDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public boolean isControlSelected(WebElement element) {
        return element.isSelected();
    }

    public boolean isControlEnabled(WebElement element) {
        return element.isEnabled();
    }

    public void switchToFrame(WebDriver driver, WebElement element) {
        driver.switchTo().frame(element);
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void doubleClickToElement(WebDriver driver, WebElement element) {
        new Actions(driver).moveToElement(element).doubleClick().perform();
    }

    public void moveToElement(WebDriver driver, WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }

    public void rightClickToElement(WebDriver driver, WebElement element) {
        new Actions(driver).contextClick(element).perform();
    }

    public void dragAndDrop(WebDriver driver,WebElement element) {
        new Actions(driver).scrollToElement(element).perform();
    }

    public void sendKeyboardToElement(WebDriver driver, WebElement element, Keys keysToSend) {
        new Actions(driver).sendKeys(element,keysToSend).perform();
    }

    public void hightlightElement(WebDriver driver, WebElement element) throws InterruptedException {
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSeconds(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, WebElement element) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        sleepInSeconds(3);
    }

    public void scrollToElementOnTopByJS(WebDriver driver,WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public void scrollToElementOnDownByJS(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public void scrollToBottomPageByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void setAttributeInDOM(WebDriver driver, WebElement element, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", element);
    }

    public void removeAttributeInDOM(WebDriver driver, WebElement element, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
    }

    public void sendkeyToElementByJS(WebDriver driver, WebElement element, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
    }

    public String getAttributeInDOMByJS(WebDriver driver, WebElement element, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", element);
    }

    public String getElementValidationMessage(WebDriver driver, WebElement element) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", element);
    }

    public boolean isImageLoaded(WebDriver driver, WebElement element) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                        "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                element);
    }

    public void sleepInSeconds(int timeInSeconds) throws InterruptedException {
        Thread.sleep(timeInSeconds*1000);
    }

    public void waitForElementVisible(WebDriver driver,WebElement element,int timeInSeconds) {
        new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds)).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForListElementVisible(WebDriver driver, WebElement element,int timeInSeconds) {
        new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds)).until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void waitForElementSelected(WebDriver driver, WebElement element,int timeInSeconds) {
        new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds)).until(ExpectedConditions.elementToBeSelected(element));
    }

    public void waitForElementClickable(WebDriver driver, WebElement element,int timeInSeconds) {
        new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementInvisible(WebDriver driver, WebElement element,int timeInSeconds) {
        new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds)).until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForListElementInvisible(WebDriver driver, WebElement element,int timeInSeconds) {
        new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds)).until(ExpectedConditions.invisibilityOfAllElements(element));
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






}
