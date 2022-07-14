package jogo;

import javax.swing.JOptionPane;
import sopadeletras.*;
import ficheiros.lerFicheiro;

/**
 *
 * @author Milton-A
 */
public class main {

    public static void main(String[] args) {

        String strOpcao;
        int menuOpcao, menuOpcaoFicheiro, numeroCacaPalavras, controlador = 0;

        JOptionPane.showMessageDialog(null, "Bem-Vindo ao Caça-Palavras");
        do {
            strOpcao = JOptionPane.showInputDialog(""
                    + "=======  Caça Palavras =======\n"
                    + "1 - Inserir Palavras via tecladp\n"
                    + "2 - Carregar palavras do ficheiro\n"
                    + "0 - Parar");
            menuOpcao = Integer.parseInt(strOpcao);

            switch (menuOpcao) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    strOpcao = JOptionPane.showInputDialog("Insira o numero de Caça Palavras");
                    numeroCacaPalavras = Integer.parseInt(strOpcao);
                    for (int i = 1; i <= numeroCacaPalavras; i++) {
                        inserirPalavras.inserirCacaPalavras(menuOpcao);
                        formarSopaDeLetras.imprimirCacaPalavras();
                    }
                    controlador = 1;
                    System.out.println("Jogo Terminado...");
                    menuOpcao=0;
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "**Primeiro! \nCriar um (palavras.txt) no directorio do projecto \n"
                            + "Escrever as palavras no ficheiro\n"
                            + "E depois salvar");

                    strOpcao = JOptionPane.showInputDialog(""
                            + "=======  Carregar palavras do ficheiro =======\n\n"
                            + "\t\t 1 - Tudo Pronto!\n"
                            + "\t\t 2 - Voltar ");
                    menuOpcaoFicheiro = Integer.parseInt(strOpcao);
                    if (menuOpcaoFicheiro == 1) {
                        lerFicheiro.lerFicheiroPalavras();
                        controlador = 1;
                        System.out.println("Jogo Terminado...");
                        menuOpcao=0;
                    } else if (menuOpcaoFicheiro != 2) {
                        JOptionPane.showMessageDialog(null, "Opção Errada! Voltando para o inicio...", "Atenção", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Errada!", "Atenção", JOptionPane.ERROR_MESSAGE);
            }
        } while (menuOpcao != 0);
        if (controlador == 1) {
            cacapalavras.apresentarPalavras.imprimirSaidasString();
        }
    }
}
