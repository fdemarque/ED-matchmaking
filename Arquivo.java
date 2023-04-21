import java.util.Scanner;
public class Arquivo{
    public static ListaDupla addJogadoresArquivo(ListaDupla ListaJogadores){
        ListaDupla Lista = ListaJogadores
        Scanner scanner = new Scanner(new File("jogadores.usu"));
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(";");

                int numero = Integer.parseInt(partes[0]);
                String tipo = partes[1];
                int pontuacao = Integer.parseInt(partes[2]);

                Jogador jogador = new Jogador(numero, tipo, pontuacao);
                Lista.add(novoJogador)
            }
            scanner.close();
            return Lista;
    }
}