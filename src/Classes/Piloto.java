package Classes;

public class Piloto extends Pessoa {
    private String breve;

    public Piloto(String nome, String cpf, String breve) {
        super(nome, cpf);
        this.breve = breve;
    }

    public String getBreve() {
        return breve;
    }

    public void setBreve(String breve) {
        this.breve = breve;
    }

    @Override
    public String toString() {
        return super.toString() + ", Breve: " + breve;
    }
}