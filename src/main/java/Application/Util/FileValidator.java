package Application.Util;

import java.io.File;

public class FileValidator {

    private static String PATH_IMAGES_FOLDER = "C:\\Users\\Usuario\\Desktop\\Workspace\\yoble\\src\\main\\resources\\" + "imagens\\";

    public static boolean verificaExistenciaArquivo(String path){
        File arquivo = new File(path);
        if (arquivo.exists()){
            return true;
        }
        return false;
    }
    public static void proximoAvatar(){

    }

    public static int getQuantidadeArquivos(String path){
        File file = new File(PATH_IMAGES_FOLDER);
        int count = file.listFiles().length;
        return count;
    }

    public static void main(String[] args) {

        System.out.println(getQuantidadeArquivos(PATH_IMAGES_FOLDER));

    }


}
