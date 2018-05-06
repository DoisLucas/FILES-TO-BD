package Beans;

import java.io.File;

/**
 *
 * @author plocabral
 */
public class Sistema {

    public static final String NomeDoUsuario = System.getProperty("user.name");
    
    //Automatico
    public static final String CaminhoAreaDeTrabalho = "C:/Users/" + NomeDoUsuario + "/Documents/TXTtoBDLOG/";
    
    //Manual
    //public static final String CaminhoAreaDeTrabalho = "C:/Users/SeuUserAqui/Desktop/FILEtoBD/";
    
    public String NomeDoArquivo = "FILEtoBD0.txt";
    public File Arquivo = new File(CaminhoAreaDeTrabalho + NomeDoArquivo);

    private Sistema() {

    }

    public String getNomeDoArquivo() {
        return NomeDoArquivo;
    }

    public void setNomeDoArquivo(String NomeDoArquivo) {
        this.NomeDoArquivo = NomeDoArquivo;
    }

    public static Sistema getInstance() {
        return SistemaHolder.INSTANCE;

    }

    private static class SistemaHolder {

        private static final Sistema INSTANCE = new Sistema();
    }

    public File getArquivo() {
        return Arquivo;
    }

    public void setArquivo(File Arquivo) {
        this.Arquivo = Arquivo;
    }

}
