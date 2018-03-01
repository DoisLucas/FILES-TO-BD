package View;

import Beans.Sistema;
import static Beans.Sistema.CaminhoAreaDeTrabalho;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author plocabral
 */
public class LeituraTXT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Consultando o caminho da pasta
        File pasta = new File(CaminhoAreaDeTrabalho);

        //Caso não exista, criamos a pasta
        if (!pasta.exists()) {
            pasta.mkdir();
        }

        //Comsultando o caminho do arquivo na pasta
        File file = new File(CaminhoAreaDeTrabalho + Sistema.getInstance().getNomeDoArquivo());

        //Caso o arquivo não exista, criamos o arquivo, e definimos ele no Singleton
        if (!Sistema.getInstance().getArquivo().exists()) {
            file.createNewFile();
            Sistema.getInstance().setArquivo(file);
            System.out.println("Arquivo não existente, criado: " + file.getName());
        }

        //Abrimos a pasta e passamos para um vetor de FILE todos os arquivos dessa pasta
        File[] arquivos = pasta.listFiles();

        //Variavel que irá guardar o maior arquivo e o numero dele
        int maior_numero = -1;
        File ultimo_arquivo = null;

        /*Buscando na lista os arquivos que tem maior numereção pelo nome do arquivo, fazendo um substring nele
        e atribuindo para as variaveis anteriores
         */
        for (File arquivo : arquivos) {
            if (Integer.parseInt(arquivo.getName().substring(10, 11)) > maior_numero) {
                maior_numero = Integer.parseInt(arquivo.getName().substring(10, 11));
                ultimo_arquivo = arquivo;
            }
        }

        System.out.println("Arquivo mais atual: " + ultimo_arquivo.getName());

        //Atribuindo no singleton o maior arquivo achado, e o nome
        Sistema.getInstance().setNomeDoArquivo(ultimo_arquivo.getName());
        Sistema.getInstance().setArquivo(ultimo_arquivo);

        if (ultimo_arquivo != null) {

            /*Se o tamanho do ultimo arquivo que pegamos for maior que determinado valor que definimos posteriormente,
            ele cria um novo arquivo na mesma pasta, e assim sucessivamente
            
            OBS: Foi defenido que a verificação do tamanho do arquivo LOG e o gerencimaneto não seja
            feito runtime, e sim em cada vez que o software for inicializado, questão de escolha e desempenho          
            
            .lenght retorna o tamanho em bytes, passo o valor para o metodo bytestomegabytes que retorna 
            em megabytes                    
             */
            //Caso o ultimo_arquivo seja maior que 25 megas, ele cria um novo
            if (bytetomegabytes(ultimo_arquivo.length()) >= 25) {

                System.out.println("Arquivo mais atual cheio: " + ultimo_arquivo.getName());
                System.out.println("Endereço do proximo LOG: TXTtoBDLOG" + (maior_numero + 1) + ".txt");
                Sistema.getInstance().setNomeDoArquivo("TXTtoBDLOG" + (maior_numero + 1) + ".txt");
                File new_file = new File(CaminhoAreaDeTrabalho + "TXTtoBDLOG" + (maior_numero + 1) + ".txt");
                new_file.createNewFile();

                Sistema.getInstance().setArquivo(new_file);
                Sistema.getInstance().setNomeDoArquivo(new_file.getName());

            }

        }

        //Inicializando a tela
        Menu m = new Menu();
        m.setVisible(true);

    }

    //Entrada byte, saida megabytes
    public static long bytetomegabytes(long size) {
        return (size / 1024) / 1024;
    }
}
