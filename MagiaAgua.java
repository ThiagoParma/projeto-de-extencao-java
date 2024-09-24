public class MagiaAgua extends Magia {
    private int profundidade;

    public MagiaAgua(String nome, int poder, int profundidade) {
        super(nome, poder);
        this.profundidade = profundidade;
    }

    @Override
    public void aplicar() {
        System.out.println("Aplicando magia de água com profundidade: " + profundidade);
    }
}
