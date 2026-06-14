package domain.eventmanagement.aggregate;

import java.util.ArrayList;
import java.util.List;

public class Evento {
    private final String nome;
    private final int lotacaoTotal;
    private final List<Setor> setores = new ArrayList<>();

    public Evento(String nome, int lotacaoTotal) {
        this.nome = nome;
        this.lotacaoTotal = lotacaoTotal;
    }

    public void adicionarSetor(Setor setor) {
        int somaAtual = setores.stream()
                .mapToInt(Setor::capacidade).sum();

        if (somaAtual + setor.capacidade() > lotacaoTotal) {
            throw new CapacidadeExcedidaException(
                    somaAtual + setor.capacidade(), lotacaoTotal
            );
        }
        setores.add(setor);
    }
}