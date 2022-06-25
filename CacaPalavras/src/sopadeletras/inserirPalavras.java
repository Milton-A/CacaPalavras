
package sopadeletras;

import javax.swing.JOptionPane;
import ficheiros.lerFicheiro;
import java.util.ArrayList;

/**
 *
 * @author Milton Dantas
 * @author Sílvio Gongo
 * @author Jesus Finda
 * @author Imilio Manuel
 */
public class inserirPalavras {

    public static String textoEntrada;

    public static void inserirCacaPalavras(int opcaoEntrada) {

        if (opcaoEntrada == 1) {
            textoEntrada = inserirTexto();
        } else {
            textoEntrada = lerFicheiro.lerFicheiroPalavras();
        }
    }

    //Funcao para pedir ao usuario que insira o texto, elimina os espaços em branco
    public static String inserirTexto() {
        String palavrasEntrada = JOptionPane.showInputDialog("Insira as letras do Caça-Palavras");
        String palavrasSaida = palavrasEntrada.replaceAll("\\s+", "");
        palavrasSaida = palavrasSaida.toLowerCase();
        return palavrasSaida;
    }

    //Funcao para pedir ao usuario que insira o as palavras,
    public static ArrayList inserirPalavras(int tamanhoListaPalavras) {
        ArrayList listaPalavras = new ArrayList();
        String palavra;
        for (int i = 0; i < tamanhoListaPalavras; i++) {
            palavra = JOptionPane.showInputDialog("Insira a " + (i +1)+ "ª Palavra");
             listaPalavras.add(palavra);
        }
        return listaPalavras;
    }

    //Função pedir ao usuario um inteiro positivo
    public static int lerNumero(String mensagemApresentação) {
        int numero;
        String entradaNumero = JOptionPane.showInputDialog(mensagemApresentação);
        numero = Integer.parseInt(entradaNumero);
        return numero;
    }
}
