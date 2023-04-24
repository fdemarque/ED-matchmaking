 import java.io.File;
 import java.io.FileNotFoundException;
 import java.util.Scanner;
 import java.io.FileWriter;
 import java.io.IOException;
 
 public class Arquivo {
     public static ListaDupla addJogadoresArquivo(ListaDupla ListaJogadores) {
         ListaDupla Lista = ListaJogadores;
         try {
             Scanner scanner = new Scanner(new File("jogadores.usu"));
             while (scanner.hasNextLine()) {
                 String linha = scanner.nextLine();
                 String[] partes = linha.split(";");
                 int numero = Integer.parseInt(partes[0]);
                 String tipo = partes[1];
                 Double pontuacao = Double.parseDouble(partes[2]);
                 Jogador jogador = new Jogador(numero, tipo, pontuacao);
                 Lista.add(jogador);
                 ListaJogadores.setTamanho(1);
             }
             scanner.close();
         } catch (FileNotFoundException e) {
             System.out.println("Arquivo não encontrado.");
         }
         return Lista;
     }
     public static void salvarJogador(Jogador jogador) {
        try {
            FileWriter writer = new FileWriter("jogadores.usu", true);
            writer.write(jogador.getID() + ";" + jogador.getRole() + ";" + jogador.getPontuacaoHabilidade() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}