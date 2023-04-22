public class NoPartida{
    private Jogador[][] partidas;
    private NoPartida anterior;
    private NoPartida proximo; 
    
    public void setPartida(Jogador[][] partidas){
       this.partidas = partidas;
    }
    
    public Jogador[][] getPartidas(){
       return this.partidas;
    }
    
    public NoPartida getAnterior(){
       return this.anterior;
    }
    
    public NoPartida getProximo(){
       return this.proximo;
    }
    
    public void setAnterior(NoPartida anterior){
       this.anterior = anterior;
    }
    
    public void setProximo(NoPartida proximo){
       this.proximo = proximo;
    }

   }