public class NoPartida{
    private Time time1;
    private Time time2;
    private NoPartida anterior;
    private NoPartida proximo; 
    
    public void setTime1(Time time1){
       this.time1 = time1;
    }
    public void setTime2(Time time2){
       this.time2 = time2;
    }
    public Time getTime1(){
       return this.time1;
    }
    public Time getTime2(){
       return this.time2;
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
    @Override
      public String toString() {
         return "\nTime 1 - Habilidade"+ time1.getResultPoint() + "\n"+ time1 +"\n\n" + "\nTime 2 - Habilidade" + time2.getResultPoint() + "\n"+ time2 +"\n\n";
  }
   }