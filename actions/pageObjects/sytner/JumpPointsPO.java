package pageObjects.sytner;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.sytner.JumpPointsPUI;
import pageUIs.sytner.MenuItemsPUI;

public class JumpPointsPO extends BasePage {
    private WebDriver driver;
    public JumpPointsPO(WebDriver driver) {
        this.driver = driver;
    }

    public JumpPointsPO openPageByBrandName(WebDriver driver, String brandName) throws InterruptedException {
        waitForElementClickable(driver, JumpPointsPUI.DYNAMIC_MENU_ITEM_LINK_BY_BRAND_NAME,brandName);
        clickToElementByJS(driver, JumpPointsPUI.DYNAMIC_MENU_ITEM_LINK_BY_BRAND_NAME,brandName);
        switch (brandName) {
            case "Alpina":
                return PageGenerator.getAlpinaPage(driver);
            case "Audi":
                return PageGenerator.getAudiPage(driver);
            case "Bentley":
                return PageGenerator.getBentleyPage(driver);
            case "BMW":
                return PageGenerator.getBMWPage(driver);
            case "Ferrari":
                return PageGenerator.getFerrariPage(driver);
            case "Honda":
                return PageGenerator.getHondaPage(driver);
            case "Jaguar":
                return PageGenerator.getJaguarPage(driver);
            case "Land Rover":
                return PageGenerator.getLandRoverPage(driver);
            case "Lamborghini":
                return PageGenerator.getLamborghiniPage(driver);
            case "Lexus":
                return PageGenerator.getLexusPage(driver);
            case "Maserati":
                return PageGenerator.getMaseratiPage(driver);
            case "McLaren":
                return PageGenerator.getMcLarenPage(driver);
            case "Mercedes Benz":
                return PageGenerator.getMercedesBenzPage(driver);
            case "Mini":
                return PageGenerator.getMiniPage(driver);
            case "Porsche":
                return PageGenerator.getPorschePage(driver);
            case "Rolls Royce":
                return PageGenerator.getRollsRoycePage(driver);
            case "Seat":
                return PageGenerator.getSeatPage(driver);
            case "Smart":
                return PageGenerator.getSmartPage(driver);
            case "Wolkswagen":
                return PageGenerator.getWolkswagenPage(driver);
            case "Volvo":
                return PageGenerator.getVolvoPage(driver);
            case "Sytner Select":
                return PageGenerator.getSytnerSelectPage(driver);
            case "Graypaul Classic Cars":
                return PageGenerator.getGraypaulClassicCarsPage(driver);
            default:
                throw new RuntimeException("Unknown brand: " + brandName);
        }

    }
    }
