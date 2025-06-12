package factoryBrowser;

public class BrowserNotSupportedException extends IllegalStateException{
    private static final long serialVersionULD = 1L;

    public BrowserNotSupportedException(String browser) {
        super(String.format("Browser not supported: %s",browser));
    }

}
