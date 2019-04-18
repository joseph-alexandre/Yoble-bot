package Chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static Chrome.ExecutarChrome.driver;

public class Pagina {


    public static void acessarPagina(WebDriver driver){
        String url;
        String titulo;
        url = "file:///C:/Users/Usuario/Desktop/welcome.html";
        driver.get(url);
    }

    public static void preencherLogin(String email, String senha){

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(senha);
        driver.findElement(By.cssSelector("input.btn.btn-success.btn-sm")).click();
    }

    public static void changeImagem(String path) {
        driver.findElement(By.xpath("//p[1]")).click();
        driver.findElement(By.xpath("//input[@name='photo']")).sendKeys(path);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }


    }

