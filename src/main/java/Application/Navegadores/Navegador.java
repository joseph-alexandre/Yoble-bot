package Application.Navegadores;

import org.openqa.selenium.WebDriver;

public abstract class Navegador {
    private WebDriver driver;
    private String DRIVER_PATH;
    private String DRIVER;
    public abstract void executarNavegador();

}
