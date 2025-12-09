package editor_texto;

public class EditorTexto {

    private String texto;

    public EditorTexto() {
        this.texto = "";
    }

    public void escrever(String novoTexto) {
        this.texto += novoTexto;
    }

    public String getTexto() {
        return this.texto;
    }

    // cria o snapshot
    public Memento salvar() {
        return new Memento(this.texto);
    }

    // restaura o snapshot
    public void restaurar(Memento memento) {
        this.texto = memento.getEstadoSalvo();
    }
}