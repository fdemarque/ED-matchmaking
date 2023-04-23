public class ListaPartida{
    private NoPartida cabeca;
    private NoPartida cauda;
    private Jogador[][] partida = new Jogador[2][3];
    private int tamanho;

    public ListaPartida(){
      this.tamanho = 0;
      cabeca = new NoPartida();
      cauda = new NoPartida();
      cabeca.setProximo(cauda);
      cauda.setAnterior(cabeca);
    }
    public void iniciarPartida(ListaDupla lista,ListaPartida Partidas){  
        if(lista.getTamanho() >= 6){
          NoDuplamente cabeca = lista.getCabeca();
          NoDuplamente cauda = lista.getCauda();
          NoDuplamente x = cabeca.getProximo();
          NoDuplamente y = x;
          for(int i = 0; i < 6; i++){
            y = y.getProximo();
          }
          while(y != cauda){
            if(validaPointsJogo(x, y)){
              y = x;
              if(verificarRole(y)){
                //Jogador[][] partida = new Jogador[2][3];
                distribuirJogadores(y);
                //add a partida a lista de partidas.
                //add(partida);
                //arancar jogadores da lista de jogadores principais
                x.getAnterior().setProximo(y.getProximo());
                y.getProximo().setAnterior(x.getAnterior());
                break;
              }else{
                x = x.getProximo();
                y = x;
                for(int i = 0; i < 6; i++){
                y = y.getProximo();
                }
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
    public void add(Time time1, Time time2){
      NoPartida novoNo = new NoPartida();
      novoNo.setTime1(time1);
      novoNo.setTime2(time2);
      novoNo.setAnterior(cabeca);
      novoNo.setProximo(cabeca.getProximo());
      cabeca.getProximo().setAnterior(novoNo);
      cabeca.setProximo(novoNo);
      tamanho++;
    }
    public boolean validaPointsJogo(NoDuplamente x, NoDuplamente y){
      boolean resposta = (y.getPoints() - x.getPoints()) > 1000?false:true;
      return resposta;
    }
    public boolean verificarRole(NoDuplamente y){
      int[] roles =  new int[5];
      y = y.getAnterior();
      for(int i = 0; i < 6; i++){
        y = y.getProximo();
        switch (y.getJogador().getRole()) {
          case "tanker":
            roles[0] += 1;
            break;
          case "mago":
            roles[1] += 1;
            break;
          case "carregador":
            roles[2] += 1;
            break;
          case "suporte":
            roles[3] += 1;
          break;
          default:
            Utils.println("nao comparou role");
            roles[4] += 1;
            break;
        }
      }
      for(int i : roles){
        if(i > 2){
          return false;
        }
      }
      return true;
    }
    public void distribuirJogadores(NoDuplamente y){
      Time time1 = new Time();
      Time  time2 = new Time();
      time1.setJogador1(y.getJogador());
      y = y.getProximo();
      time2.setJogador1(y.getJogador());
      y = y.getProximo();
      if(primeiraValidacaoDistribuirJogadores(time1, time2, y)){
            if(time1.getJogador1().getRole() != y.getJogador().getRole() && time1.getJogador2().getRole() != y.getJogador().getRole()){
              time1.setJogador3(y.getJogador());
              time2.setJogador3(y.getProximo().getJogador());
            }else{
              time2.setJogador3(y.getJogador());
              time1.setJogador3(y.getProximo().getJogador());
            }
      }
      time1.setResultPoint(time1.getJogador1().getPontuacaoHabilidade(), time1.getJogador2().getPontuacaoHabilidade(), time1.getJogador3().getPontuacaoHabilidade());
      time2.setResultPoint(time2.getJogador1().getPontuacaoHabilidade(), time2.getJogador2().getPontuacaoHabilidade(), time2.getJogador3().getPontuacaoHabilidade());
      add(time1, time2);
    }
    public boolean primeiraValidacaoDistribuirJogadores(Time time1, Time time2, NoDuplamente y){
        while(time1.getJogador2() != y.getJogador()){
          if(time1.getJogador1().getRole() != y.getJogador().getRole()){
            time1.setJogador2(y.getJogador());
            y = y.getProximo();
            if(time2.getJogador1().getRole() != y.getJogador().getRole()){
              time2.setJogador2(y.getJogador());
              y = y.getProximo();
             return true;
            }else{
              time1.setJogador3(y.getJogador());
              time2.setJogador2(y.getProximo().getJogador());
              time2.setJogador3(y.getProximo().getProximo().getJogador());
             return false;
            }
         }else{
          time2.setJogador2(y.getJogador());
           y = y.getProximo();
         }
        }
        return true;
      }
    // public Jogador[][] distribuirJogadores(Jogador[][] partida, NoDuplamente y){
    //   partida[0][0] = y.getJogador();
    //   y = y.getProximo();
    //   partida[1][0] = y.getJogador();
    //   y = y.getProximo();
    //   if(primeiraValidacaoDistribuirJogadores(partida, y)){
    //     if(partida[0][0].getRole() != y.getJogador().getRole() && partida[0][1].getRole() != y.getJogador().getRole()){
    //       partida[0][2] = y.getJogador();
    //       partida[1][2] = y.getProximo().getJogador();
    //     }else{
    //       partida[1][2] = y.getJogador();
    //       partida[0][2] = y.getProximo().getJogador();
    //     }
    //   }
    //   return partida;
    // }
    // public boolean primeiraValidacaoDistribuirJogadores(Jogador[][] partida, NoDuplamente y){
    //   while(partida[0][1] != y.getJogador()){
    //     if(partida[0][0].getRole() != y.getJogador().getRole()){
    //       partida[0][1] = y.getJogador();
    //       y = y.getProximo();
    //       if(partida[1][0].getRole() != y.getJogador().getRole()){
    //        partida[1][1] = y.getJogador();
    //        y = y.getProximo();
    //        return true;
    //       }else{
    //        partida[0][2] = y.getJogador();
    //        partida[1][1] = y.getProximo().getJogador();
    //        partida[1][2] = y.getProximo().getProximo().getJogador();
    //        return false;
    //       }
    //    }else{
    //      partida[1][1] = y.getJogador();
    //      y = y.getProximo();
    //    }
    //   }
    //   return true;
    // }
    public void exibirPartidas(){
      int index = 1;
      for(NoPartida atual = cabeca.getProximo(); atual != cauda; atual = atual.getProximo()){
      Utils.println("Partida "+index+"\n");
      System.out.println(atual.getPartidas());
      }
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
