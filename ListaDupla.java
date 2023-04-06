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
   
   public void add(Class valor){
      NoDuplamente novoNo = new NoDuplamente();
      novoNo.setValor(valor);
      novoNo.setAnterior(cabeca);
      novoNo.setProximo(cabeca.getProximo());
      
      cabeca.getProximo().setAnterior(novoNo);
      cabeca.setProximo(novoNo);
      tamanho++;
   }
   
  
   
   /*public void addLast(double valor){
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