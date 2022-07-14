package ficheiros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import cacapalavras.procurarPalavras;
import sopadeletras.formarSopaDeLetras;
import sopadeletras.inserirPalavras;

/**
 *
 * @author Milton Dantas
 * @author Sílvio Gongo
 * @author Jesus Finda
 * @author Imilio Manuel
 */
public class lerFicheiro {

    //Função para ler o ficheiro com as letras
    public static void lerFicheiroPalavras() {
        String linhaTexto, textoEntrada = "";
        Scanner ficheiro;
        String palavrasChaves[] = null;
        int contador = 0;
        try {
            ficheiro = new Scanner(new File("palavras.txt"));
            while (ficheiro.hasNext()) {
                contador++;
                int tamanhoNovo = 0;
                if (contador == 1) {
                    tamanhoNovo = Integer.parseInt(ficheiro.nextLine());
                }
                for (int i = 0; i < tamanhoNovo; i++) {
                    linhaTexto = ficheiro.nextLine();

                    if (linhaTexto.equals("")) {
                        linhaTexto = ficheiro.next();
                        int linha, coluna;
                        linha = Integer.parseInt(linhaTexto);
                        linhaTexto = ficheiro.next();
                        coluna = Integer.parseInt(linhaTexto);
                        for (int j = 0; j <= linha; j++) {
                            linhaTexto = ficheiro.nextLine();
                            textoEntrada = textoEntrada + linhaTexto;
                        }
                        linhaTexto = ficheiro.nextLine();
                        int tamanho = Integer.parseInt(linhaTexto);
                        palavrasChaves = new String[tamanho];
                        // Metodos para remover os espações
                        textoEntrada = textoEntrada.replaceAll("\\s+", "");
                        // Metodos para converter a String em minusculas
                        textoEntrada = textoEntrada.toLowerCase();
                        for (int j = 0; j < tamanho; j++) {
                            linhaTexto = ficheiro.nextLine();
                            palavrasChaves[j] = linhaTexto;
                        }

                        inserirPalavras.preencherPeloFicheiroTextoEntrada(textoEntrada);
                        formarSopaDeLetras.FicheiroPreencherCacaPalavras(linha, coluna);
                        formarSopaDeLetras.FicheroImprimirCacaPalavras(linha, coluna);
                        procurarPalavras.verificaNoCacaPalavra(palavrasChaves);
                        textoEntrada = "";
                    }
                }
            }
            ficheiro.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
