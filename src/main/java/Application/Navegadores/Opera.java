package Application.Navegadores;

import Application.Navegadores.Navegador;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class Opera extends Navegador {

    private static final String OPERA_DRIVER_PATH = "C:\\Users\\Usuario\\Desktop\\Workspace\\yoble\\src\\main\\resources\\drivers\\operadriver.exe";
    private static final String OPERA_BINARY = "C:\\Users\\Usuario\\AppData\\Local\\Programs\\Opera\\58.0.3135.127\\opera.exe";
    private static final String OPERA_DRIVER = "webdriver.opera.driver";
    private WebDriver driver;

    public Opera(WebDriver driver) {
        this.driver = driver;
        executarNavegador();
    }

    public Opera() {
        executarNavegador();
    }

    public void executarNavegador() {
        OperaOptions options = new OperaOptions();
        options.setBinary(OPERA_BINARY);
        System.setProperty(OPERA_DRIVER, OPERA_DRIVER_PATH);
        driver = new OperaDriver(options);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
