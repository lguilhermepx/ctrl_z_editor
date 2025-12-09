package editor_texto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Padrão Memento: Editor de Texto")
class EditorTextoTest {

    @Test
    @DisplayName("Fluxo Principal: Escrever, Salvar e Desfazer")
    void deveSalvarERestaurar() {
        EditorTexto editor = new EditorTexto();
        Historico historico = new Historico();

        // 1. Estado Inicial
        editor.escrever("Versão 1");
        historico.adicionarSnapshot(editor.salvar()); // Salva "Versão 1"

        // 2. Modificação
        editor.escrever(" + Versão 2");
        // Estado atual: "Versão 1 + Versão 2"

        // Verifica se escreveu certo antes de desfazer
        assertEquals("Versão 1 + Versão 2", editor.getTexto());

        // Act: Desfazer (Ctrl+Z)
        Memento backup = historico.desfazer();
        editor.restaurar(backup);

        // Assert: Deve voltar para "Versão 1"
        assertEquals("Versão 1", editor.getTexto(), "O editor falhou em restaurar o estado anterior");
    }

    @Test
    @DisplayName("Validação: Erro ao desfazer pilha vazia")
    void deveLancarErroSemHistorico() {
        Historico historico = new Historico();

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            historico.desfazer();
        });

        assertEquals("Histórico vazio! Nada para desfazer.", exception.getMessage());
    }
}