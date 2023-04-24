public class Jogador {
    private int ID;
    private double PontuacaoHabilidade;
    private String role;

    public Jogador() {
        credenciaisJogador();
    }

    public Jogador(int id, String role, double points){
        this.ID = id;
        this.PontuacaoHabilidade = points;
        this.role = role;
    }

    public int getID() {
        return ID;
    }

    public double getPontuacaoHabilidade() {
        return PontuacaoHabilidade;
    }

    public String getRole() {
        return role;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPontuacaoHabilidade(double PontuacaoHabilidade) {
        this.PontuacaoHabilidade = PontuacaoHabilidade;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String validarRole(String role) {
        String roleFormatada = role.replaceAll("\\s+", "");
        char primeiraLetra = Character.toUpperCase(roleFormatada.charAt(0));
        switch (primeiraLetra) {
            case 'T':
                roleFormatada = "tanker";
                break;
            case 'M':
                roleFormatada = "mago";
                break;
            case 'C':
                roleFormatada = "carregador";
                break;
            case 'S':
                roleFormatada = "suporte";
                break;
            default:
                roleFormatada = "errado";
                break;
        }
        return roleFormatada;
    }

    public void credenciaisJogador(){
        Utils.print("Olá, bem vindo ao MATCHMAKING , digite suas credenciais de jogador para começar uma partida:\n");
        Utils.print("Digite seu ID: ");
        this.ID = Utils.scanInt();
        String roleFormatada = "";
        do{
            Utils.print("Role(carregador, tanker, suporte ou mago): ");
            this.role = Utils.scanLine();
            roleFormatada = validarRole(this.role);
        }while(roleFormatada == "errado");
        this.role = roleFormatada;
        Utils.print("Pontuação de Habilidade: ");
        this.PontuacaoHabilidade = Utils.scanDouble();
    }

    @Override
        public String toString() {
            return "ID: " + ID + "- Role: " + role + " - Habilidade: " + PontuacaoHabilidade;
        }

}
