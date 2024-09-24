public class MagiaFogo extends Magia {
    private int intensidade;

    public MagiaFogo(String nome, int poder, int intensidade) {
        super(nome, poder);
        this.intensidade = intensidade;
    }

    @Override
    public void aplicar() {
        System.out.println("Aplicando magia de fogo com intensidade: " + intensidade);
    }
}
