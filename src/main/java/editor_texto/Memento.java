package editor_texto;

// Vulga cápsula do tempo
public class Memento {

    private final String estadoTexto;

    public Memento(String estadoTexto) {
        this.estadoTexto = estadoTexto;
    }

    public String getEstadoSalvo() {
        return estadoTexto;
    }
}