public class Jogador {
    private int ID;
    private int rating;
    private String role;

    public Jogador(int ID, int rating, String role) {
        this.ID = ID;
        this.rating = rating;
        this.role = role;
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
}
