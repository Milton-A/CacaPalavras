
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
  private static int coluna=formarSopaDeLetras.colunaMatriz;
    private static int linha=formarSopaDeLetras.linhaMatriz;
    char cacaPalavra[][]=formarSopaDeLetras.cacaPalavraMatriz; 
     private static int  tamanhoDoVetor;
     private static int  contador=0;
    private String isEqual;
    private int x=0;
    public int linhadoElementoQueConsta;
    public int colunadoElementoQueConsta;
    public void palavrasChaves(String listaPalavras[]){
          for (int i = 0; i < listaPalavras.length; i++) {
                palavrasChaves[i]=listaPalavras[i];
          }
    }
    public  void setTamanho(int valor){
        tamanhoDoVetor=valor;
    }
    private String palavrasChaves[]=new String[tamanhoDoVetor];

    public void limparIsEqual(){
        isEqual=""; 
    }
    public void tamnhoQueSeraArmazenado(int k){
              for (int i = 0; i < linha; i++) {
               for (int j = 0; j < coluna; j++) {
                   if(cacaPalavra[i][j]==palavrasChaves[k].charAt(0))
                    contador++;
               }
        }
    }   
    private int posicoesDasLetra[][]= new int[contador][contador];
    private void armazenarAsPosicoes(int k){
        contador=0;
        for (int i = 0; i < linha; i++) {
               for (int j = 0; j < coluna; j++) {
                   if(cacaPalavra[i][j]==palavrasChaves[k].charAt(0))
                     posicoesDasLetra[x][contador++]=  i;
                   posicoesDasLetra[x++][contador]=  j;
                   contador=0;
               }
        }


    }
    public void verificaNoCacaPalavra(){
        for (int i = 0; i < tamanhoDoVetor; i++) {
                this.tamnhoQueSeraArmazenado(i);
                this.armazenarAsPosicoes(i);
            for (int j = 0; j < this.posicoesDasLetra.length; j++) {
               verificarHorizontalEsquerda(palavrasChaves[i],j);
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

        }
     }
     private void verificarHorizontalDireita(String chave, int i){
        if((chave.length()-2)+posicoesDasLetra[i][0]<=this.linha){
               for (int k =posicoesDasLetra[i][0] ; k <= (chave.length()-2)+posicoesDasLetra[i][0]; k++) {
                   isEqual=""+cacaPalavra[k][posicoesDasLetra[i][1]];
               }
               if(isEqual.equalsIgnoreCase(chave)){
                   if(this.colunadoElementoQueConsta<posicoesDasLetra[i][1]&&this.linhadoElementoQueConsta<posicoesDasLetra[i][0]){
                       this.colunadoElementoQueConsta=posicoesDasLetra[i][1];
                       this.linhadoElementoQueConsta=posicoesDasLetra[i][0];
                   }
               }
           }
     }
    private void verificarVerticaCima(String chave, int i){
     if((chave.length()-2)+posicoesDasLetra[i][1]<=this.coluna){
            for (int k =posicoesDasLetra[i][1] ; k <= (chave.length()-2)+posicoesDasLetra[i][1]; k++) {
                isEqual=""+cacaPalavra[posicoesDasLetra[i][0]][k];
            }
            if(isEqual.equalsIgnoreCase(chave)){
                if(this.colunadoElementoQueConsta<posicoesDasLetra[i][1]&&this.linhadoElementoQueConsta<posicoesDasLetra[i][0]){
                    this.colunadoElementoQueConsta=posicoesDasLetra[i][1];
                    this.linhadoElementoQueConsta=posicoesDasLetra[i][0];
                }
            }
        }
     }

     private void verificarVerticalBaixo(String chave, int i){
            if((chave.length()-2)-posicoesDasLetra[i][1]<=this.coluna){
            for (int k =posicoesDasLetra[i][1] ; k <= (chave.length()-2)-posicoesDasLetra[i][1]; k++) {
                isEqual=""+cacaPalavra[posicoesDasLetra[i][0]][k];
            }
            if(isEqual.equalsIgnoreCase(chave)){
                if(this.colunadoElementoQueConsta<posicoesDasLetra[i][1]&&this.linhadoElementoQueConsta<posicoesDasLetra[i][0]){
                    this.colunadoElementoQueConsta=posicoesDasLetra[i][1];
                    this.linhadoElementoQueConsta=posicoesDasLetra[i][0];
                }
            }
        }
     }

     private void verificarObliquaDireitaCima(String chave, int i){
      if((chave.length()-2)-posicoesDasLetra[i][0]<=this.linha&&(chave.length()-2)-posicoesDasLetra[i][0]<=this.coluna){
            for (int k =posicoesDasLetra[i][0] ;k <= (chave.length()-2)+posicoesDasLetra[i][0]&&posicoesDasLetra[i][0]-k<=this.linha&&posicoesDasLetra[i][0]-k<=this.coluna; k++) {
                isEqual=""+cacaPalavra[posicoesDasLetra[i][0]+k][posicoesDasLetra[i][1]+k];
            }
            if(isEqual.equalsIgnoreCase(chave)){
                if(this.colunadoElementoQueConsta<posicoesDasLetra[i][1]&&this.linhadoElementoQueConsta<posicoesDasLetra[i][0]){
                    this.colunadoElementoQueConsta=posicoesDasLetra[i][1];
                    this.linhadoElementoQueConsta=posicoesDasLetra[i][0];
                }
            }
        }
     }
     private void verificarObliquaDireitaBaixo(String chave, int i){
      if((chave.length()-2)-posicoesDasLetra[i][0]<=this.linha&&(chave.length()-2)+posicoesDasLetra[i][0]<=this.coluna){
            for (int k =posicoesDasLetra[i][0] ;k <= (chave.length()-2)+posicoesDasLetra[i][0]&&posicoesDasLetra[i][0]-k<=this.linha&&posicoesDasLetra[i][0]+k<=this.coluna; k++) {

                    isEqual=""+cacaPalavra[posicoesDasLetra[i][0]-k<0? k-posicoesDasLetra[i][0]:posicoesDasLetra[i][0]-k ][posicoesDasLetra[i][1]+k];
            }
            if(isEqual.equalsIgnoreCase(chave)){
                if(this.colunadoElementoQueConsta<posicoesDasLetra[i][1]&&this.linhadoElementoQueConsta<posicoesDasLetra[i][0]){
                    this.colunadoElementoQueConsta=posicoesDasLetra[i][1];
                    this.linhadoElementoQueConsta=posicoesDasLetra[i][0];
                }
            }
        }
     }

     private void verificarObliquaEsquerdaCima(String chave, int i){
      if((chave.length()-2)-posicoesDasLetra[i][0]<=this.linha&&(chave.length()-2)-posicoesDasLetra[i][0]<=this.coluna){
            for (int k =posicoesDasLetra[i][0] ;k <= (chave.length()-2)+posicoesDasLetra[i][0]&&posicoesDasLetra[i][0]-k<=this.linha&&posicoesDasLetra[i][0]-k<=this.coluna; k++) {
                isEqual=""+cacaPalavra[posicoesDasLetra[i][0]+k][posicoesDasLetra[i][1]-k<0? k-posicoesDasLetra[i][1]:posicoesDasLetra[i][1]-k ];
            }
            if(isEqual.equalsIgnoreCase(chave)){
                if(this.colunadoElementoQueConsta<posicoesDasLetra[i][1]&&this.linhadoElementoQueConsta<posicoesDasLetra[i][0]){
                    this.colunadoElementoQueConsta=posicoesDasLetra[i][1];
                    this.linhadoElementoQueConsta=posicoesDasLetra[i][0];
                }
            }
        }
     }

     private void verificarObliquaEsquerdaBaixo(String chave,int i){
         if((chave.length()-2)+posicoesDasLetra[i][0]<=this.linha&&(chave.length()-2)+posicoesDasLetra[i][0]<=this.coluna){
            for (int k =posicoesDasLetra[i][0] ;k <= (chave.length()-2)+posicoesDasLetra[i][0]&&k+posicoesDasLetra[i][0]<=this.linha&&k+posicoesDasLetra[i][0]<=this.coluna; k++) {
                isEqual=""+cacaPalavra[posicoesDasLetra[i][0]+k][posicoesDasLetra[i][1]+k];
            }
            if(isEqual.equalsIgnoreCase(chave)){
                if(this.colunadoElementoQueConsta<posicoesDasLetra[i][1]&&this.linhadoElementoQueConsta<posicoesDasLetra[i][0]){
                    this.colunadoElementoQueConsta=posicoesDasLetra[i][1];
                    this.linhadoElementoQueConsta=posicoesDasLetra[i][0];
                }
            }
        }
     }
    private void verificarHorizontalEsquerda(String chave, int i){
          if((chave.length()-2)-posicoesDasLetra[i][0]<=this.linha){
            for (int k =posicoesDasLetra[i][0] ; k <= (chave.length()-2)-posicoesDasLetra[i][0]; k++) {
                isEqual=""+cacaPalavra[k][posicoesDasLetra[i][1]];
            }
            if(isEqual.equalsIgnoreCase(chave)){
                if(this.colunadoElementoQueConsta<posicoesDasLetra[i][1]&&this.linhadoElementoQueConsta<posicoesDasLetra[i][0]){
                    this.colunadoElementoQueConsta=posicoesDasLetra[i][1];
                    this.linhadoElementoQueConsta=posicoesDasLetra[i][0];
                }
            }
        }
    }
}