public class ListaTime{
    private Time cabeca;
    private Time cauda;
    private int tamanho;
    
    public ListaDupla(){
       tamanho = 0;
       this.cabeca = new NoDuplamente();
       this.cauda = new NoDuplamente();
       this.cabeca.setProximo(cauda);
    }
 
    public int getTamanho(){
       return this.tamanho;
    }
    
    public void setTamanho(int tamanho){
       this.tamanho += tamanho;
    }
    public Time getCabeca(){
       return this.cabeca;
    };
    public Time getCauda(){
       return this.cauda;
    };
}