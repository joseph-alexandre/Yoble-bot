package Application;

import Application.Bean.Historico;
import Application.Bean.Pagina;
import Application.Database.DAO.DAO;
import Application.Navegadores.Navegador;
import Application.Navegadores.Opera;
import Application.Util.FileValidator;
import org.openqa.selenium.WebDriver;

import javax.swing.*;

public class ThreadApplication implements Runnable{

    private static String PATH = "C:\\Users\\Usuario\\Desktop\\Workspace\\yoble\\src\\main\\resources\\";
    private static String PATH_IMAGES_FOLDER = "C:\\Users\\Usuario\\Desktop\\Workspace\\yoble\\src\\main\\resources\\" + "imagens\\";
    private static String USER_EMAIL = "testeJoseph@gmail.com";
    private static String USER_PASSWORD = "teste";
    private static String EXTENSION_JPG = ".jpg";
    private static String EXTENSION_JPEG = ".jpeg";
    private static String EXTENSION_PNG = ".png";

    public void run() {

        Navegador opera = new Opera();
        WebDriver driver = ((Opera) opera).getDriver();
        Pagina pagina = new Pagina(driver);
        pagina.acessarPagina(driver);

        pagina.fazerLogin(USER_EMAIL, USER_PASSWORD);

        boolean controle = true;
        while (controle) {
            String choice = JOptionPane.showInputDialog("Informe o nome do arquivo.");

            if (FileValidator.verificaExistenciaArquivo(PATH_IMAGES_FOLDER + choice + EXTENSION_PNG) == true) {
                pagina.mudarImagem(PATH_IMAGES_FOLDER + choice + EXTENSION_PNG);
                String data = pagina.pegarData();
                String hora = pagina.pegarHora();
                Historico historico = new Historico(data, hora);
                DAO.inserirHistorico(historico);
                DAO.criarHistorico(PATH + "Historico.txt");
                controle = false;
            } else {
                JOptionPane.showMessageDialog(null, "Arquivo não encontrado.");
            }

        }
    }

}
