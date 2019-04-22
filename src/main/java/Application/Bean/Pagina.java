package Application.Bean;

import Application.Database.DAO.DAO;
import Application.Util.Arquivo;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;

import javax.swing.*;
import java.io.File;
import java.util.Calendar;


public class Pagina {

    private String avatarAtual;
    private static WebDriver driver;

    public Pagina(WebDriver driver) {
        this.driver = driver;
    }

    public Pagina() {
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
            int i = 0;
            File arq = new File(path);
            File arquivos[] = arq.listFiles();
            while (i != arquivos.length) {
                int arquivoPosicao = Integer.parseInt(Arquivo.getArquivoSemExtensao(DAO.getAvatarAtual()));
                String nome = arquivos[arquivoPosicao + i].getName();
                driver.findElement(By.xpath("//input[@name='photo']")).sendKeys(path + nome);
                setAvatarAtual(nome);
                System.out.println("Avatar atual: " + nome);
                i++;
                break;
            }
            System.out.println(i);
            if (i >= arq.listFiles().length) {
                System.out.println("Não há mais avatares a serem trocados.");
            }


            driver.findElement(By.xpath("//input[@type='submit']")).click();
            System.out.println("Avatar trocado.");
        } catch (InvalidArgumentException e) {
            JOptionPane.showMessageDialog(null, "Arquivo incorreto.");
        }
    }

    public String pegarData() {
        Calendar date = Calendar.getInstance();
        String data = date.get(Calendar.DAY_OF_MONTH) + "/" + (date.get(Calendar.MONTH) + 1) + "/" + date.get(Calendar.YEAR);
        return data;
    }

    public String pegarHora() {
        Calendar date = Calendar.getInstance();
        String hora = date.get(Calendar.HOUR_OF_DAY) + ":" + date.get(Calendar.MINUTE);
        return hora;
    }

    public String getAvatarAtual() {
        return avatarAtual;
    }

    public void setAvatarAtual(String avatarAtual) {
        this.avatarAtual = avatarAtual;
    }

    public void adicionarPrimeiroAvatar(String path){
        driver.findElement(By.xpath("//p[1]")).click();
        File arq = new File(path);
        File arquivos[] = arq.listFiles();
        DAO.inserirPrimeiroAvatar(pegarData(), pegarHora(), arquivos[0].getName());
        driver.findElement(By.xpath("//input[@name='photo']")).sendKeys(path + arquivos[0].getName());
        setAvatarAtual(arquivos[0].getName());
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        System.out.println("Avatar trocado.");
        System.out.println("Avatar atual: " + arquivos[0].getName());
    }
    public static void main(String[] args) {

    }
}

