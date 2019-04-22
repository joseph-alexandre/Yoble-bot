package Application;

import Application.Bean.Historico;
import Application.Bean.Pagina;
import Application.Database.DAO.DAO;
import Application.Navegadores.Chrome;
import Application.Navegadores.Navegador;
import org.openqa.selenium.WebDriver;

public class ThreadApplication implements Runnable {

    private static String PATH = "C:\\Users\\Usuario\\Desktop\\Workspace\\yoble\\src\\main\\resources\\";
    private static String PATH_IMAGES_FOLDER = "C:\\Users\\Usuario\\Desktop\\Workspace\\yoble\\src\\main\\resources\\" + "imagens\\";
    private static String USER_EMAIL = "testeJoseph@gmail.com";
    private static String USER_PASSWORD = "teste";

    public void run() {

        Navegador chrome = new Chrome();
        WebDriver driver = ((Chrome) chrome).getDriver();
        Pagina pagina = new Pagina(driver);
        pagina.acessarPagina(driver);

        pagina.fazerLogin(USER_EMAIL, USER_PASSWORD);


        String data = pagina.pegarData();
        String hora = pagina.pegarHora();

        if (DAO.temRegistro() == false) {
            pagina.adicionarPrimeiroAvatar(PATH_IMAGES_FOLDER);
        } else {
            pagina.mudarImagem(PATH_IMAGES_FOLDER);
            Historico historico = new Historico(data, hora);
            historico.setArquivoAtual(pagina.getAvatarAtual());
            DAO.inserirHistorico(historico);
            DAO.criarHistorico(PATH + "Historico.txt");
        }


    }
}


