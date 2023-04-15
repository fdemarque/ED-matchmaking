public class Jogador {
    private String ID;
    private double PontuacaoHabilidade;
    private double PontuacaoComportamento;
    private String role;

    public Jogador() {
        credenciaisJogador();
    }

    //peguei da MatchManager



    public String getID() {
        return ID;
    }

    public double getPontuacaoHabilidade() {
        return PontuacaoHabilidade;
    }

    public String getRole() {
        return role;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPontuacaoHabilidade(double PontuacaoHabilidade) {
        this.PontuacaoHabilidade = PontuacaoHabilidade;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public void credenciaisJogador(){
        Utils.print("Olá, bem vindo ao O jogo, digite suas credenciais de jogador para começar uma partida:\n");
        Utils.print("Digite seu ID: ");
        this.ID = Utils.scanLine();
        Utils.print("Role: ");
        this.role = Utils.scanLine();
        Utils.print("Pontuação de Habilidade: ");
        this.PontuacaoHabilidade = Utils.scanDouble();
        Utils.print("Pontuação de comportamento: ");
        this.PontuacaoComportamento = Utils.scanDouble();
    }
    @Override
        public String toString() {
            return "\nID: " + ID + ",\nRole: " + role + ",\nHabilidade: " + PontuacaoHabilidade + ",\nComportamento: " + PontuacaoComportamento + "\n";
        }

}
