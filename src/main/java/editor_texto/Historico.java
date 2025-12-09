package editor_texto;

import java.util.Stack;

public class Historico {

    private final Stack<Memento> pilha = new Stack<>();

    public void adicionarSnapshot(Memento m) {
        pilha.push(m);
    }

    public Memento desfazer() {
        if (pilha.isEmpty()) {
            throw new IllegalStateException("Histórico vazio! Nada para desfazer.");
        }
        return pilha.pop();
    }
}