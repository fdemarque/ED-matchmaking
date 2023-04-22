public class ListaPartida{
    private NoPartida cabeca;
    private NoPartida cauda;
    private Jogador[][] partida = new Jogador[2][3];
    private int tamanho;

    public ListaPartida(){
      tamanho = 0;
      cabeca = new NoPartida();
      cauda = new NoPartida();
      cabeca.setProximo(cauda);
      cauda.setAnterior(cabeca);
    }
    public void inicarPartida(ListaDupla lista,ListaPartida Partidas){  
        if(lista.getTamanho() >= 6){
          NoDuplamente cabeca = lista.getCabeca();
          NoDuplamente cauda = lista.getCauda();
          NoDuplamente x = new NoDuplamente();
          NoDuplamente y = new NoDuplamente();
          x = cabeca.getProximo();
          y = x;
          for(int i = 0; i < 5; i++){
            y = y.getProximo();
          }
          while(y != cabeca){
            if(validaPointsJogo(x, y)){
              if(verificarRole(y)){
                Jogador[][] partida = new Jogador[1][2];
                distribuirJogadores(partida, y);
                //add a partida a lista de partidas.
                add(Partidas, partida);
                //arancar jogadores da lista de jogadores principais
                x.getAnterior().setProximo(y.getProximo());
                y.getProximo().setAnterior(x.getAnterior());
                break;
              }
            }else{
              x = x.getProximo();
              y = y.getProximo();
            }
          }
        }else{
          Utils.println("Quantidade de jogadores minima não atingida...");
        }
    }
    public void add(ListaPartida listaDePartidas, Jogador[][] partidas){
      NoPartida novoNo = new NoPartida();
      novoNo.setPartida(partidas);
      cabeca.getProximo().setAnterior(novoNo);
      cabeca.setProximo(novoNo);

    }
    public boolean validaPointsJogo(NoDuplamente x, NoDuplamente y){
      boolean resposta = (y.getPoints() - x.getPoints()) > 1000?false:true;
      return resposta;
    }
    public boolean verificarRole(NoDuplamente y){
      int[] roles =  new int[4];
      for(int i = 0; i < 5; i++){
        switch (y.getJogador().getRole()) {
          case "T":
            roles[0] += 1;
            break;
          case "M":
            roles[1] += 1;
            break;
          case "S":
            roles[2] += 1;
            break;
          case "J":
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
    public Jogador[][] distribuirJogadores(Jogador[][] partida, NoDuplamente y){
      partida[0][0] = y.getJogador();
      y = y.getProximo();
      partida[1][0] = y.getJogador();
      y = y.getProximo();
      if(primeiraValidacaoDistribuirJogadores(partida, y)){
        if(partida[0][0].getRole() != y.getJogador().getRole() && partida[0][1].getRole() != y.getJogador().getRole()){
          partida[0][2] = y.getJogador();
          partida[1][2] = y.getProximo().getJogador();
        }else{
          partida[1][2] = y.getJogador();
          partida[0][2] = y.getProximo().getJogador();
        }
      }
      return partida;
    }
    public boolean primeiraValidacaoDistribuirJogadores(Jogador[][] partida, NoDuplamente y){
      while(partida[0][1].getRole() != y.getJogador().getRole()){
        if(partida[0][0].getRole() != y.getJogador().getRole()){
          partida[0][1] = y.getJogador();
          if(partida[1][0].getRole() != y.getProximo().getJogador().getRole()){
           partida[1][1] = y.getProximo().getJogador();
           y = y.getProximo().getProximo();
           return true;
          }else{
           partida[0][2] = y.getProximo().getJogador();
           partida[1][1] = y.getProximo().getProximo().getJogador();
           partida[1][2] = y.getProximo().getProximo().getProximo().getJogador();
           return false;
          }
       }else{
         partida[1][1] = y.getJogador();
         y = y.getProximo();
       }
      }
      return true;
    }
}
    
      // if(partida[0][0].getRole() != y.getJogador().getRole()){
      //   partida[0][1] = y.getJogador();
      //   y = y.getProximo();
      //   if (partida[0][0].getRole() != y.getJogador().getRole()) && (partida[0][1].getRole() != y.getJogador().getRole()){
      //     partida[0][2] = y.getJogador();
      //     partida[1][1] = y.getProximo().getJogador();
      //     partida[1][2] = y.getProximo().getProximo().getJogador();
      //   }else{
      //     partida[1][1] = y.getJogador();
      //     y = y.getProximo();
      //     if (partida[0][0].getJogador.getRole() != y.getJogador().getRole()) && (partida[0][1].getJogador.getRole() != y.getJogador().getRole()){
      //       partida[0][2] = y.getJogador();
      //       partida[1][2] = y.getProximo().getJogador()
      //     }else{
      //       partida[1][2] = y.getJogador();
      //       partida[0][2] = y.getProximo().getJogador()
      //     }
      //   }
      // }else{
      //   partida[1][1] = y.getJogador();
      //   partida[0][1] = y.getProximo().getJogador();
      //   y = y.getProximo().getProximo();
      //   if ((partida[0][0].getRole() != y.getJogador().getRole()) && (partida[0][1].getRole() != y.getJogador().getRole())){
      //     partida[0][2] = y.getJogador();
      //     partida[1][2] = y.getProximo().getJogador();
      //   }else{
      //     partida[1][2] = y.getJogador();
      //     partida[0][2] = y.getProximo().getJogador();
      //   }
      // }
