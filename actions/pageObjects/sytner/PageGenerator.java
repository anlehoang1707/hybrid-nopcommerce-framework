package pageObjects.sytner;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.jumppoints.*;
import pageObjects.sytner.menuitems.*;

public class PageGenerator {
    public static HomePO getHomePage(WebDriver driver) {
      return new HomePO(driver);
    };

    public static AboutUsPO getAboutUsPage(WebDriver driver) {
        return new AboutUsPO(driver);
    }

    public static NewsPO getNewsPage(WebDriver driver) {
        return new NewsPO(driver);
    }

    public static CustomerServicePO getCustomerServicePage(WebDriver driver) {
        return new CustomerServicePO(driver);
    }

    public static CareersPO getCareersPage(WebDriver driver) {
        return new CareersPO(driver);
    }

    public static FinancePO getFinancePage(WebDriver driver) {
        return new FinancePO(driver);
    }

    public static BusinessUsersPO getBusinessUsersPage(WebDriver driver) {
        return new BusinessUsersPO(driver);
    }

    public static AlpinaPO getAlpinaPage(WebDriver driver) {
        return new AlpinaPO(driver);
    }

    public static AudiPO getAudiPage(WebDriver driver) {
        return new AudiPO(driver);
    }

    public static BentleyPO getBentleyPage(WebDriver driver) {
        return new BentleyPO(driver);
    }

    public static BMWPO getBMWPage(WebDriver driver) {
        return new BMWPO(driver);
    }

    public static FerrariPO getFerrariPage(WebDriver driver) {
        return new FerrariPO(driver);
    }

    public static HondaPO getHondaPage(WebDriver driver) {
        return new HondaPO(driver);
    }

    public static JaguarPO getJaguarPage(WebDriver driver) {
        return new JaguarPO(driver);
    }

    public static LandRoverPO getLandRoverPage(WebDriver driver) {
        return new LandRoverPO(driver);
    }

    public static LamborghiniPO getLamborghiniPage(WebDriver driver) {
        return new LamborghiniPO(driver);
    }

    public static LexusPO getLexusPage(WebDriver driver) {
        return new LexusPO(driver);
    }

    public static MaseratiPO getMaseratiPage(WebDriver driver) {
        return new MaseratiPO(driver);
    }

    public static McLarenPO getMcLarenPage(WebDriver driver) {
        return new McLarenPO(driver);
    }

    public static MercedesBenzPO getMercedesBenzPage(WebDriver driver) {
        return new MercedesBenzPO(driver);
    }

    public static MINIPO getMiniPage(WebDriver driver) {
        return new MINIPO(driver);
    }

    public static PorschePO getPorschePage(WebDriver driver) {
        return new PorschePO(driver);
    }

    public static RollsRoycePO getRollsRoycePage(WebDriver driver) {
        return new RollsRoycePO(driver);
    }

    public static SEATPO getSeatPage(WebDriver driver) {
        return new SEATPO(driver);
    }

    public static SmartPO getSmartPage(WebDriver driver) {
        return new SmartPO(driver);
    }

    public static WolkswagenPO getWolkswagenPage(WebDriver driver) {
        return new WolkswagenPO(driver);
    }

    public static VolvoPO getVolvoPage(WebDriver driver) {
        return new VolvoPO(driver);
    }

    public static SytnerSelectPO getSytnerSelectPage(WebDriver driver) {
        return new SytnerSelectPO(driver);
    }

    public static GraypaulClassicCarsPO getGraypaulClassicCarsPage(WebDriver driver) {
        return new GraypaulClassicCarsPO(driver);
    }

}
