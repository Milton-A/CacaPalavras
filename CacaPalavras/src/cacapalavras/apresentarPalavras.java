package cacapalavras;
import ficheiros.escreverFicheiro;

/**
 *
 * @author Milton Dantas
 * @author Sílvio Gongo
 * @author Jesus Finda
 * @author Imilio Manuel
 */
public class apresentarPalavras {

    public static void imprimirSaidasString() {
        String posicoesSaida = procurarPalavras.apresentarSaidas();  
        escreverFicheiro.gravarTextoString(posicoesSaida);
    }
}
