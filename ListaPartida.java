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
          ListaDupla cabeca = Lista.getCabeca();
          ListaDupla cauda = Lista.getcauda();
          NoDuplamente x = new NoDuplamente();
          NoDuplamente y = new NoDuplamente();
          x = cabeca.getProximo();
          y = x;
          for(int i = 0; i < 5; 1++){
            y = y.getProximo();
          }
          if(validaPointsJogo(x, y)){
            y = x;
            if(verificarRole(y)){
              Jogador[][] partida = new Jogador[1][2];
              distribuirJogadores(partida, y);
            }
          }
          x = x.getProximo();
          y = x;
        }

        }else{
          Utils.println("Quantidade de jogadores minima não atingida...");
        }
    }
    public boolean validaPointsJogo(NoDuplamente x, NoDuplamente y){
      boolean resposta = (y.getPoints() - x.getPoints()) > 1000?false:true;
      return resposta;
    }
    public boolean verificarRole(NoDuplamente y){
      int[] roles = [0,0,0,0];
      for(int i = 0; i < 5; 1++){
        switch (y.getJogador().getRole()) {
          case T:
            roles[0] += 1;
            break;
          case M:
            roles[1] += 1;
            break;
          case S:
            roles[2] += 1;
            break;
          case J:
            roles[3] += 1;
          break;
          default:
            Utils.println("Error 200");
            break;
        }
        y = y.getProximo();
      }
      for(int i : roles){
        if(i > 2){
          return false;
        }
      }
      return true;
    }
    public distribuirJogadores(Jogador[][] partida, NoDuplamente y){
      partida[0][0] = y.getJogador();
      y = y.getProximo();
      partida[1][0] = y.getJogador();
      y = y.getProximo();
      if(partida[0][0].getJogador.getRole() != y.getJogador().getRole()){
        partida[0][1] = y.getJogador();
        y = y.getProximo();
        if (partida[0][0].getJogador.getRole() != y.getJogador().getRole()) && (partida[0][1].getJogador.getRole() != y.getJogador().getRole()){
          partida[0][2] = y.getJogador();
          partida[1][1] = y.getProximo().getJogador();
          partida[1][1] = y.getProximo().getProximo().getJogador();
        }else{
          partida[1][1] = y.getJogador();
          y = y.getProximo();
          if (partida[0][0].getJogador.getRole() != y.getJogador().getRole()) && (partida[0][1].getJogador.getRole() != y.getJogador().getRole()){
            partida[0][2] = y.getJogador();
            partida[1][2] = y.getProximo().getJogador()
          }else{
            partida[1][2] = y.getJogador();
            partida[0][2] = y.getProximo().getJogador()
          }
        }
      }else{
        partida[1][1] = y.getJogador();
        partida[0][1] = y.getProximo().getJogador();
        y = y.getProximo().getProximo();
        if ((partida[0][0].getJogador.getRole() != y.getJogador().getRole()) && (partida[0][1].getJogador.getRole() != y.getJogador().getRole())){
          partida[0][2] = y.getJogador();
          partida[1][2] = y.getProximo().getJogador();
        }else{
          partida[1][2] = y.getJogador();
          partida[0][2] = y.getProximo().getJogador();
        }
      }
          // for(int i; i <  2; i++){
          //   for(int j; j < 3; i++){
          //     if(partida[i][j].getJogador.getRole() != y.getJogador().getRole()){
          //       if(partida[i][j-1].getJogador.getRole() != y.getJogador().getRole()){
          //         partida[i][j+1] = y.getJogador();
          //       }
          //     }else{
          //       partida[i+1][j] = y.getJogador();
          //     }
          //     y = y.getProximo();
          //   }
          // }
    }
}