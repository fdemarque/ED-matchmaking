public class Jogador {
    private int ID;
    private int rating;
    private String role;

    public Jogador(int ID, int rating, String role) {
        this.ID = ID;
        this.rating = rating;
        this.role = role;
    }

    //peguei da MatchManager

    @Override
    public String toString() {
        return "ID: " + id + ", Role: " + role + ", Habilidade: " + rating;
    }

    public int getID() {
        return ID;
    }

    public int getRating() {
        return rating;
    }

    public String getRole() {
        return role;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public void credenciaisJogador(){
        Utils.print("Olá, bem vindo ao O jogo, digite suas credenciais de jogador para começar uma partida:\n");
        Utils.print("Habilidade: ");
        setRating(Utils.scanLine());
        Utils.print("Role: ");
        setRole(Utils.scanLine();)
    }
}
