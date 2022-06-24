package ficheiros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Milton Dantas
 * @author Sílvio Gongo
 * @author Jesus Finda
 * @author Imilio Manuel
 */
public class escreverFicheiro {

    private static void gravarTexto(String texto) {
        PrintWriter escreverMensagemTexto;
        File fich = new File(".txt");
        try {
            escreverMensagemTexto = new PrintWriter(new FileWriter(fich, true));
            escreverMensagemTexto.print(texto);
            escreverMensagemTexto.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
