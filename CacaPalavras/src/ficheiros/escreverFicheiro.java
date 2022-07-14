package ficheiros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Milton Dantas
 * @author Sílvio Gongo
 * @author Jesus Finda
 * @author Imilio Manuel
 */
public class escreverFicheiro {

     public static void gravarTextoString(String coordenadasSaida) {
        PrintWriter escreverMensagemTexto;
        DateTimeFormatter dia = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        
        String nomeFicheiro = dia.format(LocalDateTime.now());
        nomeFicheiro = nomeFicheiro.replaceAll("/", "_");
        nomeFicheiro = nomeFicheiro.replaceAll(":", "_");

        File fich = new File(nomeFicheiro + ".txt");
        try {
            escreverMensagemTexto = new PrintWriter(new FileWriter(fich, true));
            escreverMensagemTexto.println(coordenadasSaida );
            escreverMensagemTexto.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
