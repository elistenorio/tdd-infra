package domain.eventmanagement.green;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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