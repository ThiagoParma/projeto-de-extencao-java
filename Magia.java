public abstract class Magia {
    protected String nome;
    protected int poder;

    public Magia(String nome, int poder) {
        this.nome = nome;
        this.poder = poder;
    }

    public abstract void aplicar();

    public String descrever() {
        return "Magia: " + nome + ", Poder: " + poder;
    }
}
