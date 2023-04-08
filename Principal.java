public class Principal{
    public static void main(String[] args){
        
        ListaDupla Lista = new ListaDupla();
       while(true){
         int opcaoEscolhida = 0;
         Utils.printComEnter("---- MATCHMAKING MENU -----");
         Utils.printComEnter("1 - Adicionar jogador");
         Utils.printComEnter("2 - Ver jogadores em espera");
         Utils.printComEnter("3 - Ver partidas em andamento");
         Utils.printComEnter("4 - Sair");
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
                  break;
               
               default:
                  Utils.printComEnter("Opcao errada.");
                  break;
        }

      }
   } 
        
}
