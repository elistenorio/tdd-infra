package domain.eventmanagement.refactor;

public class CapacidadeExcedidaException extends RuntimeException {
    public CapacidadeExcedidaException(int soma, int lotacaoTotal) {
        super("CAPACIDADE_EXCEDIDA: A soma dos setores (" + soma +
                ") excede a lotação total (" + lotacaoTotal + ")");
    }
}
