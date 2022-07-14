package sopadeletras;

import cacapalavras.procurarPalavras;

/**
 *
 * @author Milton Dantas
 * @author Sílvio Gongo
 * @author Jesus Finda
 * @author Imilio Manuel
 */
public class formarSopaDeLetras {

    public static int linhaMatriz, colunaMatriz, numeroPalavras;
    public static char[][] cacaPalavraMatriz;

    public static void preencherCacaPalavras() {
        cacaPalavraMatriz = criarCacaPalavras();
    }

    public static void FicheiroPreencherCacaPalavras(int linha, int coluna) {
        cacaPalavraMatriz = FicheiroCriarCacaPalavras(linha, coluna);
          linhaMatriz = linha;
        colunaMatriz = coluna;
    }

    public static char[][] FicheiroCriarCacaPalavras(int linha, int coluna) {
        linhaMatriz = linha;
        colunaMatriz = coluna;
        int indiceLetra = 0;

        // Ler o tamnha da matriz(Caça-Palavras)
        char[][] cacaPalavrasTabela = new char[linha][coluna];

        //Metodo para preencher o caça-Palavras
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                cacaPalavrasTabela[i][j] = inserirPalavras.textoEntrada.charAt(indiceLetra);
                indiceLetra++;
            }
        }
        return cacaPalavrasTabela;
    }

    public static char[][] criarCacaPalavras() {
        int indiceLetra = 0;

        // Ler o tamnha da matriz(Caça-Palavras)
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

    public static void FicheroImprimirCacaPalavras(int linha, int coluna) {
        String strCacaPalavras = "";
        procurarPalavras.coluna = coluna;
        procurarPalavras.linha = linha;
        // inserir a matriz do cacapalavras em uma string
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                if (j != 0) {
                    strCacaPalavras = strCacaPalavras + " " + cacaPalavraMatriz[i][j];
                } else {
                    strCacaPalavras = strCacaPalavras + cacaPalavraMatriz[i][j];
                }
            }
            strCacaPalavras = strCacaPalavras + "\n";
        }
    }

    public static void imprimirCacaPalavras() {
        preencherCacaPalavras();
        String strCacaPalavras = "";
        procurarPalavras.coluna=colunaMatriz;
        procurarPalavras.linha=linhaMatriz;
        // inserir a matriz do cacapalavras em uma string
        for (int i = 0; i < linhaMatriz; i++) {
            for (int j = 0; j < colunaMatriz; j++) {
                if (j != 0) {
                    strCacaPalavras = strCacaPalavras + " " + cacaPalavraMatriz[i][j];
                } else {
                    strCacaPalavras = strCacaPalavras + cacaPalavraMatriz[i][j];
                }
            }
            strCacaPalavras = strCacaPalavras + "\n";
        }
        //metodo para pedir o numero de palavras que serão procurados, e garantir que atende as condicoes de 1<= k <=20
        do {
            numeroPalavras = inserirPalavras.lerNumero("==== Caça-Palavras =====\n"
                    + strCacaPalavras
                    + "\n\n"
                    + "\t Insira o numero de palavras para procurar\n");
        } while (numeroPalavras > 20 && numeroPalavras < 1);

        String[] listaPalavras = new String[numeroPalavras];
        // inserir as palavras que serão procuradas
        listaPalavras = inserirPalavras.inserirPalavras(numeroPalavras);

        //metodo para procurar as palavras no caça palavras
        procurarPalavras.verificaNoCacaPalavra(listaPalavras);

    }
}