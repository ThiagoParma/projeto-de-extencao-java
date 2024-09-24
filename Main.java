public class Main {
    public static void main(String[] args) {
        GestorDeMagias gestor = new GestorDeMagias();
        gestor.adicionarMagia(new MagiaFogo("Explosão Flamejante", 50, 10));
        gestor.adicionarMagia(new MagiaAgua("Onda Tsunami", 40, 15));

        gestor.listarMagias();

        try {
            gestor.usarMagia("Explosão Flamejante");
            gestor.usarMagia("Tornado");
        } catch (MagiaNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }
    }
}
