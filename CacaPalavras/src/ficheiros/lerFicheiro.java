package ficheiros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Milton Dantas
 * @author Sílvio Gongo
 * @author Jesus Finda
 * @author Imilio Manuel
 */
public class lerFicheiro {
    
    //Função para ler o ficheiro com as letras
    public static String lerFicheiroPalavras() {
        String linhaTexto, textoEntrada="";
        FileReader ficheiroReader;
        BufferedReader ficheiroBuffered;
        
        try {
            ficheiroReader = new FileReader("palavras.txt");
            ficheiroBuffered = new BufferedReader(ficheiroReader);
            linhaTexto = ficheiroBuffered.readLine();

            while (linhaTexto != null) {
                textoEntrada=textoEntrada+linhaTexto;
                linhaTexto = ficheiroBuffered.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        // Metodos para remover os espações
        textoEntrada = textoEntrada.replaceAll("\\s+", "");
        // Metodos para converter a String em minusculas
        textoEntrada = textoEntrada.toLowerCase();
        return textoEntrada;
    }
    
}
