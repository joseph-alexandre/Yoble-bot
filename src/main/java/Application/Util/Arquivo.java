package Application.Util;

import java.io.File;

public class Arquivo {

    private static String PATH_IMAGES_FOLDER = "C:\\Users\\Usuario\\Desktop\\Workspace\\yoble\\src\\main\\resources\\" + "imagens\\";
    private static String PATH_TESTE_FOLDER = "C:\\Users\\Usuario\\Desktop\\Batata\\";

    public static boolean verificaExistenciaArquivo(String path){
        File arquivo = new File(path);
        if (arquivo.exists()){
            return true;
        }
        return false;
    }


    public static int getQuantidadeArquivos(String path){
        File file = new File(PATH_IMAGES_FOLDER);
        int count = file.listFiles().length;
        return count;
    }

    public static String getArquivoSemExtensao(String path){
        File file = new File(path);
        String arquivo = file.getName().substring(0,1);
        return arquivo;
    }

}
