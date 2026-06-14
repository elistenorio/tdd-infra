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
        validarCapacidade(setor);
        setores.add(setor);
    }

    private void validarCapacidade(Setor setor) {
        int somaAtual = capacidadeOcupada();
        if (somaAtual + setor.capacidade() > lotacaoTotal) {
            throw new CapacidadeExcedidaException(
                    somaAtual + setor.capacidade(), lotacaoTotal
            );
        }
    }

    public int capacidadeOcupada() {
        return setores.stream().mapToInt(Setor::capacidade).sum();
    }

    public int capacidadeRestante() {
        return lotacaoTotal - capacidadeOcupada();
    }
}