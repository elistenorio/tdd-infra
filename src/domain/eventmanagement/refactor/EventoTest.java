package domain.eventmanagement.refactor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EventoTest {

    @Test
    void deveLancarExcecaoQuandoCapacidadeDoSetorExcedeLotacaoTotal() {
        // Arrange
        Evento evento = new Evento("Show de Verão", 1000);
        evento.adicionarSetor(new Setor("Pista", 800));

        assertThrows(
                CapacidadeExcedidaException.class,
                () -> evento.adicionarSetor(new Setor("Camarote", 300))
        );
    }

    @Test
    void deveAdicionarSetorQuandoCapacidadeNaoExcedeLotacaoTotal() {
        Evento evento = new Evento("Show de Verão", 1000);
        evento.adicionarSetor(new Setor("Pista", 600));

        assertDoesNotThrow(
                () -> evento.adicionarSetor(new Setor("VIP", 400))
        );
    }
}