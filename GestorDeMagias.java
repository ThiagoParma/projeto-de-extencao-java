import java.util.ArrayList;
import java.util.List;

public class GestorDeMagias {
    private List<Magia> magias = new ArrayList<>();

    public void adicionarMagia(Magia magia) {
        magias.add(magia);
    }

    public void usarMagia(String nome) throws MagiaNaoEncontradaException {
        for (Magia magia : magias) {
            if (magia.descrever().contains(nome)) {
                magia.aplicar();
                return;
            }
        }
        throw new MagiaNaoEncontradaException("Magia não encontrada: " + nome);
    }

    public void listarMagias() {
        for (Magia magia : magias) {
            System.out.println(magia.descrever());
        }
    }
}
