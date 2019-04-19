package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;


public class Pagina {


    private static WebDriver driver;

    public Pagina(WebDriver driver) {
        this.driver = driver;
    }

    public void acessarPagina(WebDriver driver) {
        String url;
        url = "http://yoble.com.br";
        driver.get(url);
    }

    public void fazerLogin(String email, String senha) {
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(senha);
        driver.findElement(By.cssSelector("input.btn.btn-success.btn-sm")).click();
    }

    public void mudarImagem(String path) {

        try {
            driver.findElement(By.xpath("//p[1]")).click();
            driver.findElement(By.xpath("//input[@name='photo']")).sendKeys(path);
            driver.findElement(By.xpath("//input[@type='submit']")).click();
        } catch (InvalidArgumentException e) {
            System.out.println("O arquivo não existe.");
        }
    }

    public String pegarData(){
        Calendar date =  Calendar.getInstance();
        String data = date.get(Calendar.DAY_OF_MONTH) + "/" + (date.get(Calendar.MONTH) + 1) + "/" + date.get(Calendar.YEAR);
        return data;
    }

    public String pegarHora(){
        Calendar date =  Calendar.getInstance();
        String hora = date.get(Calendar.HOUR_OF_DAY) + ":" + date.get(Calendar.MINUTE);
        return hora;
    }




}

