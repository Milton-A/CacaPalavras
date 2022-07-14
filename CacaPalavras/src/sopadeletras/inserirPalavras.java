package sopadeletras;

import javax.swing.JOptionPane;
import ficheiros.lerFicheiro;
import java.util.ArrayList;
import static sopadeletras.formarSopaDeLetras.colunaMatriz;
import static sopadeletras.formarSopaDeLetras.linhaMatriz;

/**
 *
 * @author Milton Dantas
 * @author Sílvio Gongo
 * @author Jesus Finda
 * @author Imilio Manuel
 */
public class inserirPalavras {

    public static String textoEntrada;

    public static void preencherPeloFicheiroTextoEntrada(String textoEntradaFicheiro) {
        textoEntrada = textoEntradaFicheiro;
    }

    public static void inserirCacaPalavras(int opcaoEntrada) {

        if (opcaoEntrada == 1) {
            textoEntrada = inserirTexto();
        } else {

        }
    }

    //Funcao para pedir ao usuario que insira o texto, elimina os espaços em branco
    public static String inserirTexto() {
        do {
            linhaMatriz = inserirPalavras.lerNumero("Insira o numero de linhas da Caça-Palavras");
            colunaMatriz = inserirPalavras.lerNumero("Insira o numero de colunas do Caça-Palavras");
            if (linhaMatriz < 0 || colunaMatriz < 0) {
                JOptionPane.showMessageDialog(null, "O tamaho digitado não permite criar uma matriz\nInsira novo tamnho da Matriz!", "Atenção", JOptionPane.ERROR_MESSAGE);
            }
        } while (linhaMatriz < 0 || colunaMatriz < 0);
        String palavrasEntrada = "";
        for (int i = 0; i < linhaMatriz; i++) {
            palavrasEntrada = palavrasEntrada + JOptionPane.showInputDialog("Insira a" + (i + 1) + "ª linha do Caça-Palavras");
        }
        String palavrasSaida = palavrasEntrada.replaceAll("\\s+", "");

        palavrasSaida = palavrasSaida.toLowerCase();
        return palavrasSaida;
    }

    //Funcao para pedir ao usuario que insira o as palavras,
    public static String[] inserirPalavras(int tamanhoListaPalavras) {
        String[] listaPalavras = new String[tamanhoListaPalavras];
        String palavra;
        for (int i = 0; i < tamanhoListaPalavras; i++) {
            palavra = JOptionPane.showInputDialog("Insira a " + (i + 1) + "ª Palavra");
            palavra = palavra.trim();
            listaPalavras[i] = palavra;
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
