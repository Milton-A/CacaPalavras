package cacapalavras;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import sopadeletras.formarSopaDeLetras;

/**
 *
 * @author Milton Dantas
 * @author Sílvio Gongo
 * @author Jesus Finda
 * @author Imilio Manuel
 */
public class procurarPalavras {

    private static int coluna = formarSopaDeLetras.colunaMatriz;
    private static int linha = formarSopaDeLetras.linhaMatriz;
    static char cacaPalavra[][] = formarSopaDeLetras.cacaPalavraMatriz;
    private static int tamanhoDoVetor = formarSopaDeLetras.listaPalavras.toArray().length;
    private static int tamanhoDoVetorDoPosicoesDasLetra = 0;
    private static int contador = 0;
    private static String isEqual = "";
    private static int x = 0;
    public static int linhadoElementoQueConsta = -1;
    public static int colunadoElementoQueConsta = -1;

    public static void palavrasChaves(ArrayList<String> listaPalavras) {
        for (String palavra : listaPalavras) {
            palavrasChaves[contador++] = palavra;
        }
        contador = 0;
    }

    public static void setTamanho(int valor) {
        tamanhoDoVetor = valor;
    }
    private static String palavrasChaves[] = new String[tamanhoDoVetor];

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
    private static int posicoesDasLetra[][];

    private static void armazenarAsPosicoes(int k) {
        contador = 0;
        x = 0;
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                if (cacaPalavra[i][j] == palavrasChaves[k].charAt(0)) {
                    JOptionPane.showMessageDialog(null, "==== Contador =====\n"
                            + " " + tamanhoDoVetorDoPosicoesDasLetra + " " + contador + " " + x);
                    posicoesDasLetra[x][1] = j;
                    posicoesDasLetra[x][0] = i;
                    x++;

                }

            }

        }
    }

    public static void verificaNoCacaPalavra() {
        /*JOptionPane.showMessageDialog(null, "==== Localização =====\n"
               + linhadoElementoQueConsta + " " + colunadoElementoQueConsta);
              JOptionPane.showMessageDialog(null, "==== Localização =====\n"+
                         palavrasChaves[0]);*/
        for (int i = 0; i < tamanhoDoVetor; i++) {
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
      JOptionPane.showMessageDialog(null, "==== Localização =====\n"
                  + linhadoElementoQueConsta+"" + colunadoElementoQueConsta);
        colunadoElementoQueConsta=linhadoElementoQueConsta=-1;

        }
       

    }

    private static void verificarHorizontalDireita(String chave, int i) {
               int posicacaoDaLetraNaColuna ;
        posicacaoDaLetraNaColuna  = (chave.length() - 2) + posicoesDasLetra[i][0];
        if (posicacaoDaLetraNaColuna  < 0) 
            posicacaoDaLetraNaColuna *= (-1);
   
        if (posicacaoDaLetraNaColuna  <= coluna) {
            for (int k = posicoesDasLetra[i][1]; k <= posicacaoDaLetraNaColuna ; k++) {
                isEqual = isEqual + "" + cacaPalavra[posicoesDasLetra[i][0]][k];

            }
        }

        if (isEqual.equalsIgnoreCase(chave)) {
                if (colunadoElementoQueConsta < posicoesDasLetra[i][1] || linhadoElementoQueConsta < posicoesDasLetra[i][0]|| linhadoElementoQueConsta==-1&&colunadoElementoQueConsta==-1) {
                colunadoElementoQueConsta = posicoesDasLetra[i][1];
                linhadoElementoQueConsta = posicoesDasLetra[i][0];
                   
            }

        }
    }

    private static void verificarVerticaCima(String chave, int i) {
         int posicacaoDaLetraNaLinha;
        posicacaoDaLetraNaLinha = (chave.length() - 2) + posicoesDasLetra[i][0];
        if (posicacaoDaLetraNaLinha <= 0) 
            posicacaoDaLetraNaLinha *= (-1);
        if (posicacaoDaLetraNaLinha < linha) {
            for (int k = posicoesDasLetra[i][0]; k <= posicacaoDaLetraNaLinha ; k++) {
                isEqual = isEqual + "" + cacaPalavra[k][posicoesDasLetra[i][1]];
            }
            if (isEqual.equalsIgnoreCase(chave)) {
                if (colunadoElementoQueConsta < posicoesDasLetra[i][1] && linhadoElementoQueConsta < posicoesDasLetra[i][0]) {
                    colunadoElementoQueConsta = posicoesDasLetra[i][1];
                    linhadoElementoQueConsta = posicoesDasLetra[i][0];
                }
            }
        }
    }

    private static void verificarVerticalBaixo(String chave, int i) {
        int posicacaoDaLetraNaLinha;
        posicacaoDaLetraNaLinha = (chave.length() - 2) - posicoesDasLetra[i][0];
        if (posicacaoDaLetraNaLinha < 0) 
            posicacaoDaLetraNaLinha *= (-1);
        if ( posicacaoDaLetraNaLinha <= linha) {
            for (int k = posicoesDasLetra[i][1]; k <=  posicacaoDaLetraNaLinha; k++) {
                isEqual = isEqual + "" + cacaPalavra[k][posicoesDasLetra[i][1]];
                 
            }
            JOptionPane.showMessageDialog(null, "==== Localização =====\n"
                  + isEqual);
            if (isEqual.equalsIgnoreCase(chave)) {
                if (colunadoElementoQueConsta < posicoesDasLetra[i][1] || linhadoElementoQueConsta < posicoesDasLetra[i][0]|| linhadoElementoQueConsta==-1&&colunadoElementoQueConsta==-1) {
                    colunadoElementoQueConsta = posicoesDasLetra[i][1];
                    linhadoElementoQueConsta = posicoesDasLetra[i][0];
                }
            }
        }
    }

    private static void verificarObliquaDireitaCima(String chave, int i) {
        contador = 0;
         int posicacaoDaLetraNaLinha,valorColuna,valorLinha, posicacaoDaLetraNaColuna;
        posicacaoDaLetraNaLinha = (chave.length() - 2) + posicoesDasLetra[i][0];
        posicacaoDaLetraNaColuna = (chave.length() - 2) - posicoesDasLetra[i][1];
        if (posicacaoDaLetraNaLinha < 0) 
            posicacaoDaLetraNaLinha *= (-1);
        if ((chave.length() - 2) - posicoesDasLetra[i][1] < 0) 
            posicacaoDaLetraNaColuna  *= (-1);
        if ( posicacaoDaLetraNaLinha < linha && posicacaoDaLetraNaColuna < coluna) {
            for (int k = posicoesDasLetra[i][0]; k <= (chave.length() - 2) + posicoesDasLetra[i][0] && posicacaoDaLetraNaLinha <= linha && posicacaoDaLetraNaColuna <= coluna; k++) {
               if (posicoesDasLetra[i][0] + 1 == k) {
                    contador++;
                }
                    valorLinha = contador + posicoesDasLetra[i][0];
                if (posicoesDasLetra[i][1] - contador < 0) {
                    valorColuna = contador - posicoesDasLetra[i][1];
                } else {
                    valorColuna = posicoesDasLetra[i][1] - contador;
                }

                isEqual = isEqual + "" + cacaPalavra[valorLinha][valorColuna];
            }
            if (isEqual.equalsIgnoreCase(chave)) {
                if (colunadoElementoQueConsta < posicoesDasLetra[i][1] || linhadoElementoQueConsta < posicoesDasLetra[i][0]|| linhadoElementoQueConsta==-1&&colunadoElementoQueConsta==-1) {
                    colunadoElementoQueConsta = posicoesDasLetra[i][1];
                    linhadoElementoQueConsta = posicoesDasLetra[i][0];
                }
            }
        }
    }

    private static void verificarObliquaDireitaBaixo(String chave, int i) {
        contador = 0;
        int valorLinha, valorColuna;
        int posicacaoDaLetraNaLinha, posicacaoDaLetraNaColuna;
        posicacaoDaLetraNaLinha = (chave.length() - 2)- posicoesDasLetra[i][0];
        posicacaoDaLetraNaColuna = (chave.length() - 2) + posicoesDasLetra[i][1];
        if ((chave.length() - 2) - posicoesDasLetra[i][0] < 0) 
            posicacaoDaLetraNaLinha  *= (-1);;
        if (posicacaoDaLetraNaLinha  < linha && posicacaoDaLetraNaColuna < coluna) {
            for (int k = posicoesDasLetra[i][0]; k <= (chave.length() - 2) + posicoesDasLetra[i][0] && posicacaoDaLetraNaLinha <= linha && posicacaoDaLetraNaColuna <= coluna; k++) {
                 if (posicoesDasLetra[i][0] + 1 == k) {
                    contador++;
                }
                    valorColuna = contador + posicoesDasLetra[i][1];
                if (posicoesDasLetra[i][0] - contador < 0) {
                    valorLinha = contador - posicoesDasLetra[i][0];
                } else {
                    valorLinha = posicoesDasLetra[i][0] - contador;
                }

                isEqual = isEqual + "" + cacaPalavra[valorLinha][valorColuna];
            }
            if (isEqual.equalsIgnoreCase(chave)) {
                if (colunadoElementoQueConsta < posicoesDasLetra[i][1] || linhadoElementoQueConsta < posicoesDasLetra[i][0]|| linhadoElementoQueConsta==-1&&colunadoElementoQueConsta==-1) {
                    colunadoElementoQueConsta = posicoesDasLetra[i][1];
                    linhadoElementoQueConsta = posicoesDasLetra[i][0];
                }
            }
        }
    }

    private static void verificarObliquaEsquerdaCima(String chave, int i) {
        int valorLinha, valorColuna;
        contador = 0;
        int posicacaoDaLetraNaLinha, posicacaoDaLetraNaColuna;
        posicacaoDaLetraNaLinha = (chave.length() - 2) - posicoesDasLetra[i][0];
        posicacaoDaLetraNaColuna = (chave.length() - 2) - posicoesDasLetra[i][1];
        if (posicacaoDaLetraNaLinha < 0) 
            posicacaoDaLetraNaLinha *= (-1);
        if ((chave.length() - 2) - posicoesDasLetra[i][1] < 0) 
            posicacaoDaLetraNaColuna  *= (-1);
        if (posicacaoDaLetraNaLinha< linha && posicacaoDaLetraNaColuna < coluna) {
            for (int k = posicoesDasLetra[i][0]; k <= posicacaoDaLetraNaLinha && posicacaoDaLetraNaLinha < linha && posicacaoDaLetraNaColuna < coluna; k++) {
                if (posicoesDasLetra[i][0] + 1 == k) {
                    contador++;
                }
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

                isEqual = isEqual + "" + cacaPalavra[valorLinha][valorColuna];
            }
            if (isEqual.equalsIgnoreCase(chave)) {
                if (colunadoElementoQueConsta < posicoesDasLetra[i][1] || linhadoElementoQueConsta < posicoesDasLetra[i][0]|| linhadoElementoQueConsta==-1&&colunadoElementoQueConsta==-1) {
                    colunadoElementoQueConsta = posicoesDasLetra[i][1];
                    linhadoElementoQueConsta = posicoesDasLetra[i][0];
                }
                
            }
        }
    }

    private static void verificarObliquaEsquerdaBaixo(String chave, int i) {
        contador = 0;
        
        if ((chave.length() - 2) + posicoesDasLetra[i][0] < linha && (chave.length() - 2) + posicoesDasLetra[i][1] < coluna) {
            for (int k = posicoesDasLetra[i][0]; k <= (chave.length() - 2) + posicoesDasLetra[i][0]; k++) {
                if (posicoesDasLetra[i][0] + 1 == k) {
                    contador++;
                }
                isEqual = isEqual + "" + cacaPalavra[posicoesDasLetra[i][0] + contador][posicoesDasLetra[i][1] + contador];
            }
            if (isEqual.equalsIgnoreCase(chave)) {
                if (colunadoElementoQueConsta < posicoesDasLetra[i][1] || linhadoElementoQueConsta < posicoesDasLetra[i][0]|| linhadoElementoQueConsta==-1&&colunadoElementoQueConsta==-1) {
                    colunadoElementoQueConsta = posicoesDasLetra[i][1];
                    linhadoElementoQueConsta = posicoesDasLetra[i][0];
                }
            }
        }
    }

    private static void verificarHorizontalEsquerda(String chave, int i) {
        int posicacaoDaLetraNaColuna ;
        posicacaoDaLetraNaColuna  = (chave.length() - 2) - posicoesDasLetra[i][0];
        if (posicacaoDaLetraNaColuna  < 0) 
            posicacaoDaLetraNaColuna *= (-1);
        if (posicacaoDaLetraNaColuna <= coluna) {
            for (int k = posicoesDasLetra[i][1]; k >= 0; k--) {
                isEqual = isEqual + "" + cacaPalavra[posicoesDasLetra[i][0]][k];
            }
            if (isEqual.equalsIgnoreCase(chave)) {
                if (colunadoElementoQueConsta < posicoesDasLetra[i][1] || linhadoElementoQueConsta < posicoesDasLetra[i][0]|| linhadoElementoQueConsta==-1&&colunadoElementoQueConsta==-1) {
                    colunadoElementoQueConsta = posicoesDasLetra[i][1];
                    linhadoElementoQueConsta = posicoesDasLetra[i][0];
                }
            }
        }
    }
}
