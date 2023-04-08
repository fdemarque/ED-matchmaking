import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MatchmakingAlgorithm {
    
    // Classe jogador
    private static class Jogador {
        int id;
        String role;
        int pontuacaoHabilidade;
        int pontuacaoComportamento;
        
        public Jogador(int id, String role, int pontuacaoHabilidade, int pontuacaoComportamento) {
            this.id = id;
            this.role = role;
            this.pontuacaoHabilidade = pontuacaoHabilidade;
            this.pontuacaoComportamento = pontuacaoComportamento;
        }
        @Override
        public String toString() {
            return "ID: " + id + ", Role: " + role + ", Habilidade: " + pontuacaoHabilidade + ", Comportamento: " + pontuacaoComportamento;
        }
    }
    
    // Classe time
    private static class Time {
        List<Jogador> jogadores;
        
        public Time() {
            this.jogadores = new ArrayList<>();
        }
        
        public int getPontuacaoHabilidade() {
            int somaHabilidade = 0;
            for (Jogador jogador : jogadores) {
                somaHabilidade += jogador.pontuacaoHabilidade;
            }
            return somaHabilidade;
        }
        
        public boolean temRole(String role) {
            for (Jogador jogador : jogadores) {
                if (jogador.role.equals(role)) {
                    return true;
                }
            }
            return false;
        }
        
        public void adicionarJogador(Jogador jogador) {
            jogadores.add(jogador);
        }
        
        public boolean estaCheio() {
            return jogadores.size() == 3;
        }
        
        public boolean estaEquilibrado(Time outroTime) {
            int diferencaPontuacao = Math.abs(getPontuacaoHabilidade() - outroTime.getPontuacaoHabilidade());
            return diferencaPontuacao <= 10;
        }
        
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (Jogador jogador : jogadores) {
                sb.append(jogador.id + " ");
            }
            sb.append("]");
            return sb.toString();
        }
    }
}