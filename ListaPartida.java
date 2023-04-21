public class ListaPartida{
    private NoDuplamente cabeca;
    private NoDuplamente cauda;
    private int tamanho;

    public class ListaPartida(){
      tamanho = 0;
      cabeca = new NoDuplamente();
      cauda = new NoDuplamente();

      cabeca.setProximo(cauda);
      cauda.setAnterior(cabeca);
    }

    public void inicarPartida(ListaDupla Lista){
        if(Lista.getTamanho >= 6){
          //Tentar criar uma partida
        }else{
          Utils.println("Quantidade de jogadores minima não atingida...");
        }
    }
}