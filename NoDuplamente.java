public class NoDuplamente{
   private Jogador jogador;
   private NoDuplamente anterior;
   private NoDuplamente proximo;
   
  public void setJogador(Jogador jogador){
      this.jogador = jogador;
   }
   
   public Jogador getJogador(){
      return this.jogador;
   }
   
   public NoDuplamente getAnterior(){
      return this.anterior;
   }
   
   public NoDuplamente getProximo(){
      return this.proximo;
   }
   
   public void setAnterior(NoDuplamente anterior){
      this.anterior = anterior;
   }
   
   public void setProximo(NoDuplamente proximo){
      this.proximo = proximo;
   }
   
}