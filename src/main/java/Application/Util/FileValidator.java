package Application.Util;

import java.io.File;

public class FileValidator {


    public static boolean verificaExistenciaArquivo(String pathArquivo){
        File arquivo = new File(pathArquivo);
        if (arquivo.exists()){
            return true;
        }
        return false;
    }


}
