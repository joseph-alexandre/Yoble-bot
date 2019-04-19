package Application.Navegadores;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome extends Navegador {

    private static final String CHROME_DRIVER_PATH = "C:\\Users\\Usuario\\Desktop\\Workspace\\yoble\\src\\main\\resources\\drivers\\chromedriver.exe";
    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROME_BINARY =  "C:\\Program Files (x86)\\Google\\ApplicationView\\ApplicationView\\chrome.exe";
    private WebDriver driver;

    public Chrome(WebDriver driver) {
        this.driver = driver;
        executarNavegador();
    }

    public Chrome() {
        executarNavegador();
    }

    public void executarNavegador() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary(CHROME_BINARY);
        System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
        driver = new ChromeDriver(options);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
