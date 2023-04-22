public class Principal{
    public static void main(String[] args){
        
        ListaDupla lista = new ListaDupla();
        ListaPartida Partidas = new ListaPartida();
        int opcaoEscolhida = 0;
        //Ler o arquivo adiconar jogadores ma lista
        lista = Arquivo.addJogadoresArquivo(lista);
       do{
         opcaoEscolhida = 0;
         Utils.println("---- MATCHMAKING MENU -----");
         Utils.println("1 - Adicionar jogador");
         Utils.println("2 - Ver jogadores em espera");
         Utils.println("3 - Ver partidas em andamento");
         Utils.println("4 - Sair");
         opcaoEscolhida = Utils.scanInt();
         switch (opcaoEscolhida) {
               case 1:
                  Jogador novoJogador = new Jogador();
                  lista.add(novoJogador);
                  break;
               case 2:
                  lista.exibirTodos();
                  break;
               case 3:
                  Partidas.inicarPartida(lista, Partidas);
                  break;
               case 4:
                  Utils.println("Obrigado por jogar O jogo.");
                  break;
               
               default:
                  Utils.println("Opcao errada.");
                  break;
        }
      }while( opcaoEscolhida != 4 );
      Utils.print("FIM");
   } 
  }       
