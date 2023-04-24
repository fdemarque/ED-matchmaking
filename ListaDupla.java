public class ListaDupla{
   private NoDuplamente cabeca;
   private NoDuplamente cauda;
   private int tamanho;
   
   public ListaDupla(){
      tamanho = 0;
      this.cabeca = new NoDuplamente();
      this.cauda = new NoDuplamente();

      this.cabeca.setProximo(cauda);
      this.cauda.setAnterior(cabeca);
   }

   public int getTamanho(){
      return this.tamanho;
   }
   
   public void setTamanho(int tamanho){
      this.tamanho += tamanho;
   }
   public NoDuplamente getCabeca(){
      return this.cabeca;
   };
   public NoDuplamente getCauda(){
      return this.cauda;
   };
   
   public void add(Jogador novoJogador){
      NoDuplamente novoNo = new NoDuplamente();
      novoNo.setPoints(novoJogador.getPontuacaoHabilidade());
      novoNo.setJogador(novoJogador);
      novoNo.setAnterior(cabeca);
      novoNo.setProximo(cabeca.getProximo());
      organizarLista(novoNo);
      tamanho++;
   }

   public void exibirTodos(){
      for(NoDuplamente atual = cabeca.getProximo(); atual != cauda; atual = atual.getProximo()){
      System.out.println(atual.getJogador());
      }
   }

   public void organizarLista(NoDuplamente novoNo){
      NoDuplamente anterior = novoNo.getAnterior();
      NoDuplamente proximo = novoNo.getProximo();
      if(conferirProxAnt(anterior, proximo, novoNo) == true){
         for(int atual = 1; atual != tamanho+1; atual++){
            if(anterior == cabeca && proximo.getPoints() > novoNo.getPoints()){
               addComecoLista(novoNo);
               break;
            }else if(novoNo.getPoints() < proximo.getPoints() && novoNo.getPoints() >= anterior.getPoints()){
               anterior.setProximo(novoNo);
               proximo.setAnterior(novoNo);
               break;
            }else if(anterior != cabeca && proximo == cauda){
               cauda.getAnterior().setProximo(novoNo);
               cauda.setAnterior(novoNo);
               break;
            }else{
               anterior = proximo;
               proximo = proximo.getProximo();
               novoNo.setProximo(proximo);
               novoNo.setAnterior(anterior);
            }
         }
      }else{
         addComecoLista(novoNo);
      }
   }

   public void addComecoLista(NoDuplamente novoNo){
      cabeca.getProximo().setAnterior(novoNo);
      cabeca.setProximo(novoNo);
   }
   
   public boolean conferirProxAnt(NoDuplamente anterior, NoDuplamente proximo, NoDuplamente novoNo){
       if(anterior == cabeca && proximo == cauda){
         return false;
       }else{
         return true;
       }
   }
   public void removeXY(NoDuplamente x, NoDuplamente y){
      x.getAnterior().setProximo(y.getProximo());
      y.getProximo().setAnterior(x.getAnterior());
   }
}