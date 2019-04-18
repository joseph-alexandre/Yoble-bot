package Chrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class ExecutarNavegador {

    public static WebDriver driver;

    public static void main(String[] args) {

        executaOperaDriver();
        Pagina.acessarPagina(driver);
        Pagina.preencherLogin("testeJoseph@gmail.com", "teste");
        Pagina.changeImagem("C:\\Users\\Usuario\\Desktop\\Workspace\\yoble\\src\\main\\resources\\imagens\\2.png");
    }

    public static void executaChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Usuario\\Desktop\\Workspace\\yoble\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    public static void executaOperaDriver(){

        String path = "C:\\Users\\Usuario\\Desktop\\Workspace\\yoble\\ChromeDriver\\operadriver.exe";
        OperaOptions options = new OperaOptions();
        options.setBinary("C:\\Users\\Usuario\\AppData\\Local\\Programs\\Opera\\58.0.3135.127\\opera.exe");
        System.setProperty("webdriver.opera.driver",path);
        driver = new OperaDriver(options);

    }
}
