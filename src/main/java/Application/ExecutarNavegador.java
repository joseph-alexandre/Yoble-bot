package Application;

import Application.Bean.Historico;
import Application.Navegadores.Navegador;
import Application.Navegadores.Opera;
import Application.Database.DAO.DAO;
import org.openqa.selenium.WebDriver;

public class ExecutarNavegador {

    private static String PATH = "C:\\Users\\Usuario\\Desktop\\Workspace\\yoble\\src\\main\\resources\\";
    private static String PATH_IMAGES_FOLDER = "C:\\Users\\Usuario\\Desktop\\Workspace\\yoble\\src\\main\\resources\\" + "imagens\\";
    private static String USER_EMAIL = "testeJoseph@gmail.com";
    private static String USER_PASSWORD = "teste";

    public static void main(String[] args) {

        Navegador opera = new Opera();
        WebDriver driver = ((Opera) opera).getDriver();
        Pagina pagina = new Pagina(driver);
        pagina.acessarPagina(driver);

        pagina.fazerLogin(USER_EMAIL, USER_PASSWORD);
        pagina.mudarImagem(PATH_IMAGES_FOLDER +"1.jpg");
        String data = pagina.pegarData();
        String hora = pagina.pegarHora();
        Historico historico = new Historico(data, hora);
        DAO.inserirHistorico(historico);
        DAO.criarHistorico( PATH +"Historico.txt");

    }


}
