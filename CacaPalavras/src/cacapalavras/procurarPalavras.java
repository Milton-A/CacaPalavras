package cacapalavras;

import sopadeletras.formarSopaDeLetras;

/**
 *
 * @author Milton Dantas
 * @author Sílvio Gongo
 * @author Jesus Finda
 * @author Imilio Manuel
 */
public class procurarPalavras {

    public static int coluna = formarSopaDeLetras.colunaMatriz;
    public static int linha = formarSopaDeLetras.linhaMatriz;
    static char cacaPalavra[][];
    private static int tamanhoDoVetorDoPosicoesDasLetra = 0;
    private static int contador = 0;
    private static String isEqual = "", coordenadasSaida = "";
    private static int x = 0;
    private static String palavrasChaves[];
    private static int posicoesDasLetra[][];

    public static int linhaDoElementoQueConsta = -1;
    public static int colunaDoElementoQueConsta = -1;

    public static void palavraChaves(String[] listaPalavras) {
        palavrasChaves = listaPalavras;
        cacaPalavra = formarSopaDeLetras.cacaPalavraMatriz;
        contador = 0;
    }

    public static void limparIsEqual() {
        isEqual = "";
    }

    public static void tamnhoQueSeraArmazenado(int k) {
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                if (cacaPalavra[i][j] == palavrasChaves[k].charAt(0)) {
                    tamanhoDoVetorDoPosicoesDasLetra++;
                }
            }
        }
    }

    private static void armazenarAsPosicoes(int k) {
        contador = 0;
        x = 0;
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                if (cacaPalavra[i][j] == palavrasChaves[k].charAt(0)) {
                    posicoesDasLetra[x][1] = j;
                    posicoesDasLetra[x][0] = i;
                    x++;
                }
            }
        }
    }

    public static void verificaNoCacaPalavra(String[] listaPalavras) {
        String posicoes = "";
        palavraChaves(listaPalavras);
        int i = 0;
        for (i = 0; i < palavrasChaves.length; i++) {
            tamnhoQueSeraArmazenado(i);
            posicoesDasLetra = new int[tamanhoDoVetorDoPosicoesDasLetra][2];
            armazenarAsPosicoes(i);

            for (int j = 0; j < tamanhoDoVetorDoPosicoesDasLetra; j++) {
                verificarHorizontalEsquerda(palavrasChaves[i], j);
                limparIsEqual();
                verificarHorizontalDireita(palavrasChaves[i], j);
                limparIsEqual();
                verificarVerticaCima(palavrasChaves[i], j);
                limparIsEqual();
                verificarVerticalBaixo(palavrasChaves[i], j);
                limparIsEqual();
                verificarObliquaDireitaCima(palavrasChaves[i], j);
                limparIsEqual();
                verificarObliquaDireitaBaixo(palavrasChaves[i], j);
                limparIsEqual();
                verificarObliquaEsquerdaCima(palavrasChaves[i], j);
                limparIsEqual();
                verificarObliquaEsquerdaBaixo(palavrasChaves[i], j);
            }
            if (linhaDoElementoQueConsta != -1 && colunaDoElementoQueConsta != -1) {
                posicoes = (linhaDoElementoQueConsta + 1) + " " + (1 + colunaDoElementoQueConsta) + "\n";
                coordenadasSaida = coordenadasSaida + posicoes;
            }
            colunaDoElementoQueConsta = linhaDoElementoQueConsta = -1;
            if (i + 1 == palavrasChaves.length) {
                coordenadasSaida = coordenadasSaida + "\n";
            }
        }

    }

    public static String apresentarSaidas() {
        return coordenadasSaida;
    }

    private static void verificarHorizontalDireita(String chave, int i) {
        int posicacaoDaLetraNaColuna;
        posicacaoDaLetraNaColuna = (chave.length() - 1) + posicoesDasLetra[i][1];
        if (posicacaoDaLetraNaColuna < 0) {
            posicacaoDaLetraNaColuna *= (-1);
        }
        if (posicacaoDaLetraNaColuna < coluna) {
            for (int k = posicoesDasLetra[i][1]; k <= posicacaoDaLetraNaColuna; k++) {
                isEqual = isEqual + "" + cacaPalavra[posicoesDasLetra[i][0]][k];

            }
        }

        if (isEqual.equalsIgnoreCase(chave)) {
            if (colunaDoElementoQueConsta < posicoesDasLetra[i][1] && linhaDoElementoQueConsta < posicoesDasLetra[i][0] || linhaDoElementoQueConsta == -1 && colunaDoElementoQueConsta == -1) {
                colunaDoElementoQueConsta = posicoesDasLetra[i][1];
                linhaDoElementoQueConsta = posicoesDasLetra[i][0];

            }

        }
    }

    private static void verificarVerticaCima(String chave, int i) {
        int posicacaoDaLetraNaLinha;
        posicacaoDaLetraNaLinha = (chave.length() - 1) - posicoesDasLetra[i][0];
        if (posicacaoDaLetraNaLinha <= 0) {
            posicacaoDaLetraNaLinha *= (-1);
        }
        if (posicacaoDaLetraNaLinha < linha) {
            for (int k = posicoesDasLetra[i][0]; k >= posicacaoDaLetraNaLinha; k--) {
                isEqual = isEqual + "" + cacaPalavra[k][posicoesDasLetra[i][1]];
            }
            if (isEqual.equalsIgnoreCase(chave)) {
                if (colunaDoElementoQueConsta < posicoesDasLetra[i][1] && linhaDoElementoQueConsta < posicoesDasLetra[i][0] || linhaDoElementoQueConsta == -1 && colunaDoElementoQueConsta == -1) {
                    colunaDoElementoQueConsta = posicoesDasLetra[i][1];
                    linhaDoElementoQueConsta = posicoesDasLetra[i][0];

                }
            }
        }
    }

    private static void verificarVerticalBaixo(String chave, int i) {
        int posicacaoDaLetraNaLinha;
        posicacaoDaLetraNaLinha = (chave.length() - 1) + posicoesDasLetra[i][0];
        if (posicacaoDaLetraNaLinha < 0) {
            posicacaoDaLetraNaLinha *= (-1);
        }
        if (posicacaoDaLetraNaLinha < linha) {
            for (int k = posicoesDasLetra[i][0]; k <= posicacaoDaLetraNaLinha; k++) {
                isEqual = isEqual + "" + cacaPalavra[k][posicoesDasLetra[i][1]];

            }

            if (isEqual.equalsIgnoreCase(chave)) {
                if (colunaDoElementoQueConsta < posicoesDasLetra[i][1] && linhaDoElementoQueConsta < posicoesDasLetra[i][0] || linhaDoElementoQueConsta == -1 && colunaDoElementoQueConsta == -1) {
                    colunaDoElementoQueConsta = posicoesDasLetra[i][1];
                    linhaDoElementoQueConsta = posicoesDasLetra[i][0];

                }
            }
        }
    }

    private static void verificarObliquaDireitaCima(String chave, int i) {
        contador = 0;
        int posicacaoDaLetraNaLinha, valorColuna, valorLinha, posicacaoDaLetraNaColuna;
        posicacaoDaLetraNaLinha = (chave.length() - 1) - posicoesDasLetra[i][0];
        posicacaoDaLetraNaColuna = (chave.length() - 1) + posicoesDasLetra[i][1];
        if (posicacaoDaLetraNaColuna < 0) {
            posicacaoDaLetraNaLinha *= (-1);
        }

        if (posicacaoDaLetraNaLinha < linha && posicacaoDaLetraNaColuna < coluna) {
            for (int k = posicoesDasLetra[i][1]; k <= posicacaoDaLetraNaColuna; k++) {
                valorColuna = contador + posicoesDasLetra[i][1];
                if (posicoesDasLetra[i][0] - contador < 0) {
                    valorLinha = contador - posicoesDasLetra[i][0];
                } else {
                    valorLinha = posicoesDasLetra[i][0] - contador;
                }
                contador++;
                isEqual = isEqual + "" + cacaPalavra[valorLinha][valorColuna];
            }

            if (isEqual.equalsIgnoreCase(chave)) {
                if (colunaDoElementoQueConsta < posicoesDasLetra[i][1] && linhaDoElementoQueConsta < posicoesDasLetra[i][0] || linhaDoElementoQueConsta == -1 && colunaDoElementoQueConsta == -1) {
                    colunaDoElementoQueConsta = posicoesDasLetra[i][1];
                    linhaDoElementoQueConsta = posicoesDasLetra[i][0];

                }
            }
        }
    }

    private static void verificarObliquaDireitaBaixo(String chave, int i) {
        contador = 0;
        int valorLinha, valorColuna;
        int posicacaoDaLetraNaLinha, posicacaoDaLetraNaColuna;
        posicacaoDaLetraNaLinha = (chave.length() - 1) + posicoesDasLetra[i][0];
        posicacaoDaLetraNaColuna = (chave.length() - 1) - posicoesDasLetra[i][1];
        if ((chave.length() - 1) - posicoesDasLetra[i][1] < 0) {
            posicacaoDaLetraNaColuna *= (-1);
        }
        if (posicacaoDaLetraNaLinha < linha && posicacaoDaLetraNaColuna < coluna) {
            for (int k = posicoesDasLetra[i][0]; k <= posicacaoDaLetraNaLinha; k++) {
                valorLinha = contador + posicoesDasLetra[i][0];
                if (posicoesDasLetra[i][1] - contador < 0) {
                    valorColuna = contador - posicoesDasLetra[i][1];
                } else {
                    valorColuna = posicoesDasLetra[i][1] - contador;
                }
                contador++;
                isEqual = isEqual + "" + cacaPalavra[valorLinha][valorColuna];
            }

            if (isEqual.equalsIgnoreCase(chave)) {
                if (colunaDoElementoQueConsta < posicoesDasLetra[i][1] && linhaDoElementoQueConsta < posicoesDasLetra[i][0] || linhaDoElementoQueConsta == -1 && colunaDoElementoQueConsta == -1) {
                    colunaDoElementoQueConsta = posicoesDasLetra[i][1];
                    linhaDoElementoQueConsta = posicoesDasLetra[i][0];

                }
            }
        }
    }

    private static void verificarObliquaEsquerdaCima(String chave, int i) {
        int valorLinha, valorColuna;
        contador = 0;
        int posicacaoDaLetraNaLinha, posicacaoDaLetraNaColuna;
        posicacaoDaLetraNaLinha = (chave.length() - 1) - posicoesDasLetra[i][0];
        posicacaoDaLetraNaColuna = (chave.length() - 1) - posicoesDasLetra[i][1];
        if (posicacaoDaLetraNaLinha < 0) {
            posicacaoDaLetraNaLinha *= (-1);
        }
        if ((chave.length() - 2) - posicoesDasLetra[i][1] < 0) {
            posicacaoDaLetraNaColuna *= (-1);
        }
        if (posicacaoDaLetraNaLinha < linha && posicacaoDaLetraNaColuna < coluna) {
            for (int k = posicacaoDaLetraNaLinha; k <= posicoesDasLetra[i][0]; k++) {
                if (posicoesDasLetra[i][1] - contador < 0) {
                    valorColuna = contador - posicoesDasLetra[i][1];
                } else {
                    valorColuna = posicoesDasLetra[i][1] - contador;
                }
                if (posicoesDasLetra[i][0] - contador < 0) {
                    valorLinha = contador - posicoesDasLetra[i][0];
                } else {
                    valorLinha = posicoesDasLetra[i][0] - contador;
                }
                contador++;
                isEqual = isEqual + "" + cacaPalavra[valorLinha][valorColuna];
            }
            if (isEqual.equalsIgnoreCase(chave)) {
                if (colunaDoElementoQueConsta < posicoesDasLetra[i][1] && linhaDoElementoQueConsta < posicoesDasLetra[i][0] || linhaDoElementoQueConsta == -1 && colunaDoElementoQueConsta == -1) {
                    colunaDoElementoQueConsta = posicoesDasLetra[i][1];
                    linhaDoElementoQueConsta = posicoesDasLetra[i][0];

                }

            }
        }
    }

    private static void verificarObliquaEsquerdaBaixo(String chave, int i) {
        contador = 0;

        if ((chave.length() - 1) + posicoesDasLetra[i][0] < linha && (chave.length() - 1) + posicoesDasLetra[i][1] < coluna) {
            for (int k = posicoesDasLetra[i][0]; k <= (chave.length() - 1) + posicoesDasLetra[i][0]; k++) {

                isEqual = isEqual + "" + cacaPalavra[posicoesDasLetra[i][0] + contador][posicoesDasLetra[i][1] + contador];
                contador++;
            }
            if (isEqual.equalsIgnoreCase(chave)) {
                if (colunaDoElementoQueConsta < posicoesDasLetra[i][1] && linhaDoElementoQueConsta < posicoesDasLetra[i][0] || linhaDoElementoQueConsta == -1 && colunaDoElementoQueConsta == -1) {
                    colunaDoElementoQueConsta = posicoesDasLetra[i][1];
                    linhaDoElementoQueConsta = posicoesDasLetra[i][0];

                }
            }
        }
    }

    private static void verificarHorizontalEsquerda(String chave, int i) {
        int posicacaoDaLetraNaColuna;
        posicacaoDaLetraNaColuna = (chave.length() - 1) - posicoesDasLetra[i][1];
        if (posicacaoDaLetraNaColuna < 0) {
            posicacaoDaLetraNaColuna *= (-1);
        }
        if (posicacaoDaLetraNaColuna < coluna) {
            for (int k = posicoesDasLetra[i][1]; k >= posicacaoDaLetraNaColuna; k--) {
                isEqual = isEqual + cacaPalavra[posicoesDasLetra[i][0]][k];
            }

            if (isEqual.equalsIgnoreCase(chave)) {
                if (colunaDoElementoQueConsta < posicoesDasLetra[i][1] && linhaDoElementoQueConsta < posicoesDasLetra[i][0] || linhaDoElementoQueConsta == -1 && colunaDoElementoQueConsta == -1) {
                    colunaDoElementoQueConsta = posicoesDasLetra[i][1];
                    linhaDoElementoQueConsta = posicoesDasLetra[i][0];

                }
            }
        }
    }
}
