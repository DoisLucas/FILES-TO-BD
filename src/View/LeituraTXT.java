package View;

import Beans.Sistema;
import static Beans.Sistema.CaminhoAreaDeTrabalho;
import java.io.File;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author plocabral
 */
public class LeituraTXT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        if(!Sistema.getInstance().getArquivo().exists()){
            File Arquivo = new File(CaminhoAreaDeTrabalho + "TxtToBDLOG.txt");
            Arquivo.createNewFile();
        }
        
        Menu m = new Menu();
        m.setVisible(true);

    }
}
