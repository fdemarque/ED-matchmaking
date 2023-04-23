public class Time{
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogador3;
    private Time anterior;
    private Time proximo; 
    private double resultPoint;

    public Jogador getJogador1(){
        return jogador1;
    }
    public Jogador getJogador2(){
        return jogador2;
    }
    public Jogador getJogador3(){
        return jogador3;
    }
    public void setJogador1(Jogador novo){
        this.jogador1 = novo;
    }
    public void setJogador2(Jogador novo){
        this.jogador2 = novo;
    }
    public void setJogador3(Jogador novo){
        this.jogador3 = novo;
    }
    public Time getAnterior(){
        return this.anterior;
     }
     
     public Time getProximo(){
        return this.proximo;
     }
     
     public void setAnterior(Time anterior){
        this.anterior = anterior;
     }
     
     public void setProximo(Time proximo){
        this.proximo = proximo;
     }
     public void setResultPoint(double valor1, double valor2, double valor3){
        this.resultPoint = valor1 + valor2 + valor3;
     }
     public double getResultPoint(){
        return this.resultPoint;
     }
     @Override 
     public String toString(){
        return jogador1 +"\n"+jogador2 +"\n"+jogador3 +"\n";
     }
}