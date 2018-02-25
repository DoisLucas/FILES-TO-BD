/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.File;

/**
 *
 * @author plocabral
 */
public class Sistema {

    public static final String NomeDoUsuario = System.getProperty("user.name");
    //public static final String CaminhoAreaDeTrabalho = "C:/Users/" + NomeDoUsuario + "/Documents/";
    public static final String CaminhoAreaDeTrabalho = "C:/Users/Pichau/Documents/";
    public static File Arquivo = new File(CaminhoAreaDeTrabalho + "TxtToBDLOG.txt");

    private Sistema() {
        
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
