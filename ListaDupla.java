public class ListaDupla{
   private NoDuplamente cabeca;
   private NoDuplamente cauda;
   private int tamanho;
   
   public ListaDupla(){
      tamanho = 0;
      cabeca = new NoDuplamente();
      cauda = new NoDuplamente();
      
      cabeca.setProximo(cauda);
      cauda.setAnterior(cabeca);
   }
   
   public void add(Jogador novoJogador){
   // AQUI começa a brincadeira. instancio o novo nó e passo as primeiras referencias
   // que é a cabeca e a cauda os pontos e meu objeto
      NoDuplamente novoNo = new NoDuplamente();
      novoNo.setPoints(novoJogador.getPontuacaoHabilidade());
      novoNo.setJogador(novoJogador);
      novoNo.setAnterior(cabeca);
      novoNo.setProximo(cabeca.getProximo());
      //aqui eu chamo um método para organizar esse meu novo nó 
      organizarLista(novoJogador,novoNo);
      tamanho++;
   }
   
   public void exibirTodos(){
      NoDuplamente atual = cabeca;
      for(int i = 0; i != tamanho; i++){
      atual = atual.getProximo();
      System.out.println(atual.getJogador());
      }
   }
   public void organizarLista(Jogador novo, NoDuplamente novoNo){
      //instancio o anterior e o proximo em variáveis para facilitar o manuseio  
      NoDuplamente anterior = novoNo.getAnterior();
      NoDuplamente proximo = novoNo.getProximo();
      //esse metodo dentro do if confere pra saber se o No ;e o primeiro da lista
      if(conferirProxAnt(anterior, proximo, novoNo) == true){
         int  validador = 0;
         do{
         //aqui ;e o if pra solocar ele em primeiro, tendo outro maior que ele a frente
            if(anterior == cabeca && proximo.getPoints() > novoNo.getPoints()){
               cabeca.getProximo().setAnterior(novoNo);
               cabeca.setProximo(novoNo);
               validador = 1;
         //aqui coloca ele no meio dos dois
            }else if(novoNo.getPoints() < proximo.getPoints() && novoNo.getPoints() > anterior.getPoints()){
               proximo.setAnterior(novoNo);
               anterior.setProximo(novoNo);
               validador = 1;
         // aqui, se caso o anterior for igual e o proximo for maior ele o adiciona aqui
            }else if(novoNo.getPoints() < proximo.getPoints() && novoNo.getPoints() == anterior.getPoints()){
               proximo.setAnterior(novoNo);
               anterior.setProximo(novoNo);
               validador = 1;
         // se ele for o ultimo da lista e não tiver pegado nenhuma regra
            }else if(anterior != cabeca && proximo == cauda){
               cauda.getAnterior().setProximo(novoNo);
               cauda.setAnterior(novoNo);
               validador = 1;
         // aqui se nenhum acontecer, ele anda com o proximo e com o anterior
            }else{
               anterior = proximo;
               proximo = proximo.getProximo();
            }
         }while(validador == 0);
      }   
   }
   
   public boolean conferirProxAnt(NoDuplamente anterior, NoDuplamente proximo, NoDuplamente novoNo){
       if(anterior == cabeca && proximo == cauda){
         cabeca.getProximo().setAnterior(novoNo);
         cabeca.setProximo(novoNo);
         return false;
       }else{
         return true;
       }
   }
   
  /* public NoDuplamente getAt(int indiceProcurado){
      if(indiceProcurado > tamanho){
         System.out.println("Voce sabe contar");
         return cabeca;
      }else{
         int indicePercorrido = 0;
         NoDuplamente atual = cabeca;
         while(indicePercorrido != indiceProcurado){
            atual = atual.getProximo();
            indicePercorrido++;
         }
         return atual;
      }
    }

  
   
   public void addLast(double valor){
      NoDuplamente novoNo = new NoDuplamente();
      novoNo.setValor(valor);
      novoNo.setProximo(cauda);
      novoNo.setAnterior(cauda.getAnterior());
      
      cauda.getAnterior().setProximo(novoNo);
      cauda.setAnterior(novoNo);
      tamanho++;
   }
   
   public NoDuplamente getAt(int indiceProcurado){
      if(indiceProcurado > tamanho){
         System.out.println("Voce sabe contar");
         return cabeca;
      }else{
         int indicePercorrido = 0;
         NoDuplamente atual = cabeca;
         while(indicePercorrido < indiceProcurado){
            atual = atual.getProximo();
            indicePercorrido++;
         }
         return atual;
      }
   }
   
   //Retorna o indice em que o valor se encontra, caso não exista retorna -1
   // 2,7,0,-2
   //for int i =0; i < n; i++

   public int find(double valorProcurado){
      int contador = 0;
      for(NoDuplamente atual = cabeca; atual != cauda; atual = atual.getProximo()){
         if(atual.getValor() == valorProcurado){
            return contador;
         }
         contador++;
      }
      return -1;
   }
   
   public int findWithIndex(double valorProcurado){
      NoDuplamente atual = cabeca;
      for(int i = 0; i <= tamanho; i++){
         if(atual.getValor() == valorProcurado){
            return i;
         }
         atual = atual.getProximo();
      }
      return -1;
   }
   
   public void addAt(int indiceProcurado, double valor){
      if(indiceProcurado > tamanho+1){
         System.out.println("Voce sabe contar");
      } //A partir daqui posso adicionar
      else if(tamanho == 0){
         addFirst(valor);
      }else if(indiceProcurado == tamanho+1){
         addLast(valor);
      }else{
         int indicePercorrido = 0;
         NoDuplamente atual = cabeca;
         while(indicePercorrido < indiceProcurado-1){
            atual = atual.getProximo();
            indicePercorrido++;
         }
      
         NoDuplamente novo = new NoDuplamente();
         novo.setValor(valor);
         atual.getProximo().setAnterior(novo);
         novo.setAnterior(atual);
         novo.setProximo(atual.getProximo());
         atual.setProximo(novo);
         tamanho++;
      }
   }
   
   public void removeLast(){
      removeAt(tamanho);
   }
   
   public void removeFirst(){
      removeAt(1);
   }
   
   public void printAll(){
      for(int i = 1; i < tamanho; i++){
         printAt(i);
      }
   }
   
   public void printAt(int index){
      NoDuplamente atual = getAt(index);
      System.out.println(atual.getValor());
   }
   
   public void removeAt(int index){
      if(index > tamanho){
         System.out.println("Erro");
      }else{
         NoDuplamente aRemover = getAt(index);
         aRemover.getAnterior().setProximo(aRemover.getProximo());
         aRemover.getProximo().setAnterior(aRemover.getAnterior());
         tamanho--;
      }
   }
   public double getTotal(){
      double total = 0;
      for(NoDuplamente atual = cabeca.getProximo(); atual != cauda ;atual = atual.getProximo()){
         total+= atual.getValor();
      }
      return total;
   }*/
   
}