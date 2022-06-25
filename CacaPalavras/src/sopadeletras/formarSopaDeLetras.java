package sopadeletras;

import cacapalavras.procurarPalavras;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Milton Dantas
 * @author Sílvio Gongo
 * @author Jesus Finda
 * @author Imilio Manuel
 */
public class formarSopaDeLetras {

    public static int linhaMatriz, colunaMatriz;
    public static char[][] cacaPalavraMatriz = criarCacaPalavras();
    public static int numeroPalavras;
    public static ArrayList <String> listaPalavras = new ArrayList();
    public static char[][] criarCacaPalavras() {

        int numeroLetras = inserirPalavras.textoEntrada.length();
        int indiceLetra = 0;

        // Ler o tamnha da matriz(Caça-Palavras)
        do {
            linhaMatriz = inserirPalavras.lerNumero("Insira o numero de linhas da Caça-Palavras");
            colunaMatriz = inserirPalavras.lerNumero("Insira o numero de colunas do Caça-Palavras");
            if ((linhaMatriz * colunaMatriz) > numeroLetras) {
                JOptionPane.showMessageDialog(null, "Numero de Letras Insuficeinte\nInsira novo tamnho da Matriz!", "Atenção", JOptionPane.ERROR_MESSAGE);
            }
        } while ((linhaMatriz * colunaMatriz) > numeroLetras);

        char[][] cacaPalavrasTabela = new char[linhaMatriz][colunaMatriz];

        //Metodo para preencher o caça-Palavras
        for (int i = 0; i < linhaMatriz; i++) {
            for (int j = 0; j < colunaMatriz; j++) {
                cacaPalavrasTabela[i][j] = inserirPalavras.textoEntrada.charAt(indiceLetra);
                indiceLetra++;
            }
        }
        return cacaPalavrasTabela;
    }

    public static void imprimirCacaPalavras() {
        String strCacaPalavras = "", strNumerodePalavras;
        for (int i = 0; i < linhaMatriz; i++) {
            for (int j = 0; j < colunaMatriz; j++) {
                strCacaPalavras = strCacaPalavras + "" + cacaPalavraMatriz[i][j];
            }
            strCacaPalavras = strCacaPalavras + "\n";
        }
        strNumerodePalavras = JOptionPane.showInputDialog("==== Caça-Palavras =====\n"
                + strCacaPalavras
                + "\n\n"
                + "\t Insira o numero de Letras para procurar\n");
        numeroPalavras = Integer.parseInt(strNumerodePalavras);
        listaPalavras = inserirPalavras.inserirPalavras(numeroPalavras);
        procurarPalavras.palavrasChaves(listaPalavras);
        procurarPalavras.verificaNoCacaPalavra();
     //  JOptionPane.showMessageDialog(null, "==== Localização =====\n"
       //         + procurarPalavras.linhadoElementoQueConsta + " " + procurarPalavras.colunadoElementoQueConsta);

    }
}
