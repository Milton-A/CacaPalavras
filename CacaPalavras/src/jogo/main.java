package jogo;

import javax.swing.JOptionPane;
import sopadeletras.*;

/**
 *
 * @author Milton-A
 */
public class main {

    public static void main(String[] args) {

        String strOpcao;
        JOptionPane.showMessageDialog(null, "Bem-Vindo ao Caça-Palavras");
        int menuOpcao, menuOpcaoFicheiro;
        do {
            strOpcao = JOptionPane.showInputDialog(""
                    + "=======  Caça Palavras =======\n"
                    + "1 - Inserir Palavras\n"
                    + "2 - Carregar palavras do ficheiro\n");
            menuOpcao = Integer.parseInt(strOpcao);

            switch (menuOpcao) {
                case 1:
                    inserirPalavras.inserirCacaPalavras(menuOpcao);
                    jogar();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "**Primeiro! \nCriar um (palavras.txt) no ambiente de trabalho\n"
                            + "Escrever as palavras no ficheiro\n"
                            + "E depois salvar");
                    do {
                        strOpcao = JOptionPane.showInputDialog(""
                                + "=======  Carregar palavras do ficheiro =======\n\n"
                                + "\t\t 1 - OK\n"
                                + "\t\t 2 - Voltar ");
                        menuOpcaoFicheiro = Integer.parseInt(strOpcao);

                        if (menuOpcaoFicheiro == 1) {
                            inserirPalavras.inserirCacaPalavras(menuOpcao);
                            jogar();
                        } else if (menuOpcaoFicheiro != 2) {
                            JOptionPane.showMessageDialog(null, "Opção Errada!", "Atenção", JOptionPane.ERROR_MESSAGE);
                        }
                    } while (menuOpcaoFicheiro != 2);
                    break;

                default:
                    throw new AssertionError();
            }

        } while (menuOpcao != 0);
    }

    private static void jogar() {
        String strOpcao;
        int menuOpcao;
        do {
            strOpcao = JOptionPane.showInputDialog(""
                    + "1 - Jogar\n"
                    + "2 - Voltar\n");
            menuOpcao = Integer.parseInt(strOpcao);
            switch (menuOpcao) {
                case 1:
                    formarSopaDeLetras.imprimirCacaPalavras();
                    
                    break;
                case 2:
                    
                    break;

                default:
                    throw new AssertionError();
            }

        } while (menuOpcao != 0);
    }
}
