public class NoPartida{
    private Jogador[][] partidas;
    private NoDuplamente anterior;
    private NoDuplamente proximo; 
    
    public void setPartidas(Jogador[][] partidas){
       this.partidas = partidas;
    }
    
    public Jogador[][] setPartidas(){
       return this.partidas;
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