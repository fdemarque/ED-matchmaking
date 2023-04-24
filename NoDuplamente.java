public class NoDuplamente{
   private double points;
   private Jogador jogador;
   private NoDuplamente anterior;
   private NoDuplamente proximo;
   
   public void setPoints(double points){
      this.points = points;
   }
   
   public double getPoints(){
      return this.points;
   }
   
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