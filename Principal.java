public class Principal{
    public static void main(String[] args){
        
        ListaDupla Lista = new ListaDupla();
        int opcaoEscolhida = 0;
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
                  Lista.add(novoJogador);
                  break;
               case 2:
                  Lista.exibirTodos();
                  break;
               case 3:
                
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
